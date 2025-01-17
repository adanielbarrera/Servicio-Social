/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import DAOs.PersonalDAO;
import Exceptions.HuellaException;
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
import java.util.List;
import java.util.Map;
import models.Personal;
import views.process.vP_CapturaHuellas;
import views.process.vP_VerificadorHuellas;
import views.Error;

/**
 *
 * @author SSM01
 */
public class LectorHuella {

    private static LectorHuella instancia;
    public DPFPCapture reader;
    private DPFPEnrollment reclutador;
    private DPFPVerification verificador;
    private vP_CapturaHuellas vCaptura;
    private DPFPTemplate template;
    private PersonalDAO personalDAO = new PersonalDAO();
    private String dedoSeleccionado;
    private int progreso;
    private vP_VerificadorHuellas verif;
    public boolean esProcesoDeVerificacion = false;
    public boolean encontrado = false;

    private LectorHuella() {
        inicializarComponentes();
    }

    public static LectorHuella getInstance() {
        if (instancia == null) {
            instancia = new LectorHuella();
        }
        return instancia;
    }

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
                try {
                    procesarMuestra(dpfpde.getSample());
                } catch (HuellaException ex) {
                    Error err = new Error(ex.getMessage());
                    err.setVisible(true);
                }
            }
        }
        );
    }

    public void procesarMuestra(DPFPSample sample) throws HuellaException {
        Image imagenHuella = crearImagenHuella(sample);
        if (esProcesoDeVerificacion) {
            verificarHuella(sample);
            verif.actualizarJLabelConHuella(imagenHuella);
        } else {
            procesarEnrollment(sample);
            vCaptura.actualizarJLabelConHuella(imagenHuella);
        }
    }

    private Image crearImagenHuella(DPFPSample sample) {
        return DPFPGlobal.getSampleConversionFactory().createImage(sample);
    }

    public void iniciarEnrollmentPorDedo(String dedo) {
        this.dedoSeleccionado = dedo;
        this.progreso = 0;
        reclutador.clear();
        vCaptura.actualizarBarraDeProgreso(dedo, progreso);
        System.out.println("Dedo seleccionado para enrollment: " + dedoSeleccionado);
    }

    public void procesarEnrollment(DPFPSample sample) throws HuellaException {
        try {
            DPFPFeatureSet features = extraerFeatures(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);
            reclutador.addFeatures(features);
            actualizarProgresoEnrollment();

            if (progreso >= 4) {
                System.out.println("Alcanzaste 4");
                template = reclutador.getTemplate();
                System.out.println("template actualizada");
                System.out.println("guardar huella del dedo " + dedoSeleccionado);
                personalDAO.agregarHuella(dedoSeleccionado, template);
                System.out.println("Enrollment completado y huella guardada en el map");
                resetEnrollment();
            } else {
                System.out.println("siga capturando");
            }
        } catch (DPFPImageQualityException e) {
            throw new HuellaException("Verificar lectura de un solo dedo");
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

    private void resetEnrollment() {
        progreso = 0;
        reclutador.clear();
    }

    private void verificarHuella(DPFPSample sample) {
        Personal personal = null;
        try {
            DPFPFeatureSet features = extraerFeatures(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);
            Map<Integer, List<DPFPTemplate>> plantillasAlmacenadas = personalDAO.obtenerTodasLasPlatillas();
            for (Map.Entry<Integer, List<DPFPTemplate>> entry : plantillasAlmacenadas.entrySet()) {
                encontrado = false;
                int id = entry.getKey();
                List<DPFPTemplate> plantillas = entry.getValue();

                // Itera sobre todas las plantillas almacenadas para este ID
                for (DPFPTemplate plantilla : plantillas) {
                    DPFPVerificationResult resultado = verificador.verify(features, plantilla);

                    if (resultado.isVerified()) {
                        System.out.println("Huella verificada exitosamente");
                        personal = personalDAO.getPersonalByID(id);
                        verif.actualizarInfo(personal);
                        encontrado = true;
                        return; // Si la huella coincide, termina el proceso de verificación
                    }
                }
            }
            if (!encontrado) {
                verif.actualizarInfo(null);
                System.out.println("Huella no coincide con ninguna plantilla almacenada");
            }
        } catch (Exception e) {
            manejarError("Error durante la verficacion de huella", e);
        }
    }

    public void manejarError(String mensaje, Exception e) {
        System.err.println(mensaje + e.getMessage());
        e.printStackTrace();
    }

    public void setDedoSeleccionado(String dedoSeleccionado) {
        this.dedoSeleccionado = dedoSeleccionado;
    }

    public void setVistaCaptura(vP_CapturaHuellas captura) {
        this.vCaptura = captura;
    }

    public void setVistaVerif(vP_VerificadorHuellas verif) {
        this.verif = verif;
    }

    public boolean isStarted() {
        return reader.isStarted();
    }
}
