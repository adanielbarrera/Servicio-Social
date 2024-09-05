/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;
import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.DPFPCapturePriority;
import com.digitalpersona.onetouch.capture.event.DPFPDataAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPErrorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPErrorEvent;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.capture.event.DPFPSensorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPSensorEvent;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.verification.DPFPVerification;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class FingerprintApp extends JFrame {
    private DPFPCapture capturer;
    private JLabel deviceStatusLabel;
    private JLabel fingerprintImageLabel;
    
    private DPFPCapture Lector = DPFPGlobal.getCaptureFactory().createCapture();
    private DPFPEnrollment Reclutador = DPFPGlobal.getEnrollmentFactory().createEnrollment();
    private DPFPVerification Verificador = DPFPGlobal.getVerificationFactory().createVerification();
    private DPFPTemplate template;
    public static String TEMPLATE_PROPERTY = "template";


    public FingerprintApp() {
        initComponents();
        initFingerprintSensor();
    }
    
    

    private void initComponents() {
        JPanel panelMain = new JPanel();
        JButton activateButton = new JButton("Activate Fingerprint Reader");
        deviceStatusLabel = new JLabel("Device Status: Unknown");
        fingerprintImageLabel = new JLabel();

        activateButton.addActionListener(e -> activateFingerprintReader());

        panelMain.setLayout(new BorderLayout());
        panelMain.add(deviceStatusLabel, BorderLayout.NORTH);
        panelMain.add(fingerprintImageLabel, BorderLayout.CENTER);
        panelMain.add(activateButton, BorderLayout.SOUTH);

        add(panelMain);
        setTitle("Fingerprint App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initFingerprintSensor() {
        try {
            
            capturer.setPriority(DPFPCapturePriority.CAPTURE_PRIORITY_LOW);

            
            capturer = DPFPGlobal.getCaptureFactory().createCapture();
            capturer.addDataListener(new DPFPDataAdapter() {
                @Override
                public void dataAcquired(DPFPDataEvent e) {
                    processCapture(e.getSample());
                }
            });

            capturer.addReaderStatusListener(new DPFPReaderStatusAdapter() {
                @Override
                public void readerConnected(DPFPReaderStatusEvent e) {
                    deviceStatusLabel.setText("Device Status: Fingerprint reader connected.");
                }

                @Override
                public void readerDisconnected(DPFPReaderStatusEvent e) {
                    deviceStatusLabel.setText("Device Status: No fingerprint reader connected.");
                }
            });

            capturer.addSensorListener(new DPFPSensorAdapter() {
                @Override
                public void fingerTouched(DPFPSensorEvent e) {
                    deviceStatusLabel.setText("Fingerprint reader touched.");
                }

                @Override
                public void fingerGone(DPFPSensorEvent e) {
                    deviceStatusLabel.setText("Fingerprint reader touch removed.");
                }
            });

            capturer.startCapture();
        } catch (Exception e) {
            e.printStackTrace();
            deviceStatusLabel.setText("Error initializing fingerprint sensor: " + e.getMessage());
        }
    }

    private void activateFingerprintReader() {
        try {
            deviceStatusLabel.setText("Activating Fingerprint Reader...");
            capturer.startCapture();
            deviceStatusLabel.setText("Fingerprint Reader Activated.");
        } catch (Exception e) {
            e.printStackTrace();
            deviceStatusLabel.setText("Error activating fingerprint reader: " + e.getMessage());
        }
    }

    private void processCapture(DPFPSample sample) {
        try {
            BufferedImage image = (BufferedImage) DPFPGlobal.getSampleConversionFactory().createImage(sample);
            displayFingerprintImage(image);

            DPFPFeatureSet featureSet = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction()
                    .createFeatureSet(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);
        } catch (DPFPImageQualityException ex) {
            ex.printStackTrace();
            deviceStatusLabel.setText("Error in image quality: " + ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            deviceStatusLabel.setText("Error processing capture: " + ex.getMessage());
        }
    }

    private void displayFingerprintImage(BufferedImage image) {
        if (image != null) {
            ImageIcon icon = new ImageIcon(image);
            fingerprintImageLabel.setIcon(icon);
            fingerprintImageLabel.repaint();
        } else {
            deviceStatusLabel.setText("No image captured.");
        }
    }
    
    

    public static void main(String[] args) {
        
        System.setProperty("java.library.path", "/opt/Crossmatch/urusdk-linux/Linux/lib/x64");

/*        // Asegurar que la propiedad se establezca correctamente
        String libraryPath = System.getProperty("java.library.path");
        System.out.println("java.library.path: " + libraryPath);

        // Intentar cargar la biblioteca nativa
        try {
            System.loadLibrary("dpfj"); // Ajusta el nombre según el archivo .so que tengas
            System.out.println("Biblioteca nativa cargada correctamente.");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Error al cargar la biblioteca nativa: " + e.getMessage());
        }
        
        // Cargar las bibliotecas necesarias
        try {
            System.loadLibrary("dpfj");
            System.out.println("Biblioteca dpfj cargada correctamente.");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Error al cargar la biblioteca dpfj: " + e.getMessage());
        }

        try {
            System.loadLibrary("dpuareu_jni");
            System.out.println("Biblioteca dpuareu_jni cargada correctamente.");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Error al cargar la biblioteca dpuareu_jni: " + e.getMessage());
        }
        
*/

        SwingUtilities.invokeLater(() -> {
            new FingerprintApp().setVisible(true);
        });
    }
}