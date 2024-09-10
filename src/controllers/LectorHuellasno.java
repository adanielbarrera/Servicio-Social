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
import java.awt.Image;
import java.util.List;
import views.process.vP_CapturaHuellas;

/**
 *
 * @author SSM01
 */
public class LectorHuellasno {

    private DPFPCapture lector;
    private vP_CapturaHuellas vCaptura;
    private DPFPEnrollment reclutador;
    private DPFPVerification verificador;
    private int progreso = 0; //controla el numero de escaneos
    private String dedoSeleccionado;
    private static boolean reclutado = false;
    private DPFPTemplate template;
    private PersonalDAO personalDAO;

    public LectorHuellasno(vP_CapturaHuellas vCaptura) {
        this.vCaptura = vCaptura;
        this.progreso = 0;
        this.personalDAO = new PersonalDAO();
        initLector();

    }

    public void initLector() {
        //lector = DPFPGlobal.getCaptureFactory().createCapture();

        try {
            lector = DPFPGlobal.getCaptureFactory().createCapture();
            reclutador = DPFPGlobal.getEnrollmentFactory().createEnrollment();
            lector.addReaderStatusListener(new DPFPReaderStatusAdapter() {
                @Override
                public void readerConnected(DPFPReaderStatusEvent e) {
                    //System.out.println("Device Status: Fingerprint reader connected.");
                }

                @Override
                public void readerDisconnected(DPFPReaderStatusEvent e) {
                    // System.out.println("Device Status: No fingerprint reader connected.");
                }
            });

            lector.addSensorListener(new DPFPSensorAdapter() {
                @Override
                public void fingerTouched(DPFPSensorEvent e) {
                    // System.out.println("Fingerprint reader touched.");
                }

                @Override
                public void fingerGone(DPFPSensorEvent e) {
                    //System.out.println("Fingerprint reader touch removed.");
                }
            });

            lector.addDataListener(new DPFPDataAdapter() {
                @Override
                public void dataAcquired(DPFPDataEvent e) {
                    imagenHuella(e.getSample());
                }
            });
            lector.startCapture();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error initializing fingerprint sensor: " + e.getMessage());
            System.err.println(e.getMessage());
        };
    }

    public void imagenHuella(DPFPSample sample) {
        try {
            Image imagen = crearImagenHuella(sample);
            vCaptura.actualizarJLabelConHuella(imagen);
            if (reclutado) {
                //proceso de verificacion
               // verificarHuella(sample);
            } else {
                //proceso de enrollment
                procesarEnrollment(sample);
            }
        } catch (Exception e) {
            System.out.println("Ojo aqui: " + e);
        }
    }

    public Image crearImagenHuella(DPFPSample sample) {
        return DPFPGlobal.getSampleConversionFactory().createImage(sample);
    }

    public void enroll(DPFPSample sample) {

        try {
            //agrega la muestra al proeso de enrollment
            reclutador.addFeatures(DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction().createFeatureSet(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT));

            //incrementa el progreso
            progreso++;
            System.out.println("Huella escaneada. Progreso: " + progreso + "/4");

            if (progreso > 4) {
                System.out.println("Enrollment completado con exito");
                reclutado = true;

                //resetea el progreso para un nuevo enrollment
                progreso = 0;
                reclutador.clear();

                //platilla resultante de la  reclutacion
                template = reclutador.getTemplate();
                personalDAO.agregarHuella(dedoSeleccionado, template);
            }
        } catch (DPFPImageQualityException e) {
            System.err.println("error de calidad de imagen: " + e.getMessage());
        }
    }

    public void resetProgreso() {
        this.progreso = 0;
        reclutador.clear();
    }

    public void iniciarEnrollment() {
        this.progreso = 0;
    }

    public void procesarEnrollment(DPFPSample sample) {
        try {
            enroll(sample); //procesa la muestra y actualiza el progreso dentro del metodo
            vCaptura.actualizarBarraDeProgreso(dedoSeleccionado, progreso);
        } catch (Exception e) {
            System.out.println("error durante el proceso de enrollmenr: " );
            e.printStackTrace();
        }
    }

// Método para seleccionar el dedo y reiniciar el progreso
    public void seleccionarDedo(String dedo) {
        this.dedoSeleccionado = dedo;
        resetProgreso();
        vCaptura.actualizarBarraDeProgreso(dedoSeleccionado, progreso);
        System.out.println("Dedo seleccionado: " + dedoSeleccionado);
    }
/*
    private void verificarHuella(DPFPSample sample) {
        try {
            //extrae la platilla de la muestra
            DPFPFeatureSet features = DPFPGlobal.getFeatureExtractionFactory()
                    .createFeatureExtraction()
                    .createFeatureSet(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

            //recuperar todas las platillas de la base de datos
            List<DPFPTemplate> platillasAlmacenadas = personalDAO.obtenerTodasLasPlatillas();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/
}
