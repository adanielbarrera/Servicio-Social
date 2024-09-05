/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import DAOs.PersonalDAO;
import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPDataAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.capture.event.DPFPSensorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPSensorEvent;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.List;
import views.process.vP_CapturaHuellas;

/**
 *
 * @author SSM01
 */
public class LectorHuella {

    private DPFPCapture reader;
    private DPFPEnrollment reclutador;
    private DPFPVerification verificador;
    private vP_CapturaHuellas vCaptura;
    private DPFPTemplate template;
    private PersonalDAO personalDAO;
    private String dedoSeleccionado;
    private int progreso;

    public void inicializarComponentes() {
        try {
            reader = DPFPGlobal.getCaptureFactory().createCapture();
            reclutador = DPFPGlobal.getEnrollmentFactory().createEnrollment();
            verificador = DPFPGlobal.getVerificationFactory().createVerification();
            configurarListeners();
            reader.startCapture();
        } catch (Exception e) {
            manejarError("Error iniciando el lector", e);
        }
    }

    public void configurarListeners() {
        //listeners del lector
        reader.addReaderStatusListener(new DPFPReaderStatusAdapter() {

            @Override
            public void readerConnected(DPFPReaderStatusEvent e) {
                System.out.println("Fingerprint reader conectado");
            }

            @Override
            public void readerDisconnected(DPFPReaderStatusEvent e) {
                System.out.println("Fingerprint reader desconectado");
            }
        }
        );
        reader.addSensorListener(new DPFPSensorAdapter() {
            @Override
            public void imageAcquired(DPFPSensorEvent dpfpse) {
                System.out.println("imagen adquirida");
            }

            @Override
            public void fingerGone(DPFPSensorEvent dpfpse) {
                System.out.println("Dedo removido");
            }

            @Override
            public void fingerTouched(DPFPSensorEvent dpfpse) {
                System.out.println("Dedo puesto");
            }

        }
        );
        reader.addDataListener(new DPFPDataAdapter() {
            @Override
            public void dataAcquired(DPFPDataEvent dpfpde) {
                System.out.println("Adquiri datos");
            }
        }
        );
    }

    public void procesarMuestra(DPFPSample sample) {
        Image imagenHuella = crearImagenHuella(sample);
        vCaptura.actualizarJLabelConHuella(imagenHuella);

        if (esProcesoDeVerificacion()) {
            verificarHuella(sample);
        } else {
            procesarEnrollment(sample);
        }

    }

    private Image crearImagenHuella(DPFPSample sample) {
        return DPFPGlobal.getSampleConversionFactory().createImage(sample);
    }

    private boolean esProcesoDeVerificacion() {
        return template != null;
    }

    public void iniciarEnrollmentPorDedo(String dedo) {
        this.dedoSeleccionado = dedo;
        this.progreso = 0;
        reclutador.clear();
        vCaptura.actualizarBarraDeProgreso(dedo, progreso);
        System.out.println("Dedo seleccionado para enrollment: " + dedoSeleccionado);
    }

    public void procesarEnrollment(DPFPSample sample) {
        try {
            DPFPFeatureSet features = extraerFeatures(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);
            reclutador.addFeatures(features);
            actualizarProgresoEnrollment();

            if (enrollmentCompletado()) {
                template = reclutador.getTemplate();
                guardarTemplateEnBaseDeDatos();
                resetEnrollment();
            }
        } catch (DPFPImageQualityException e) {
            manejarError("Error de calidad de imagen durante el enrollment: ", e);
        }
    }

    private DPFPFeatureSet extraerFeatures(DPFPSample sample, DPFPDataPurpose puspose) throws DPFPImageQualityException {
        return DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction().createFeatureSet(sample, puspose);
    }

    private void actualizarProgresoEnrollment() {
        progreso++;
        vCaptura.actualizarBarraDeProgreso(dedoSeleccionado, progreso);
        System.out.println("Huella escaneada. Progreso: " + progreso + "/4");
    }

    private boolean enrollmentCompletado() {
        return progreso >= 4;
    }

    private void resetEnrollment() {
        progreso = 0;
        reclutador.clear();
    }

    private void guardarTemplateEnBaseDeDatos() {
        personalDAO.agregarHuella(dedoSeleccionado, template);
        System.out.println("Enrollment completado y huella guardada en el map");
    }

    private void verificarHuella(DPFPSample sample) {
        try {
            DPFPFeatureSet features = extraerFeatures(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);
            List<DPFPTemplate> plantillasAlmacenadas = personalDAO.obtenerTodasLasPlatillas();
            for (DPFPTemplate plantilla : plantillasAlmacenadas) {
                DPFPVerificationResult resultado = verificador.verify(features, plantilla);
                if(resultado.isVerified()){
                    System.out.println("Huella verificada exitosamente");
                    return;
                }
            }
            System.out.println("Huella no coincide con ninguna plantilla almacenada");
        }catch(Exception e){
            manejarError("Error durante la verficacion de huella", e);
        }
    }

    public void manejarError(String mensaje, Exception e) {
        System.err.println(mensaje + e.getMessage());
        e.printStackTrace();
    }
}
