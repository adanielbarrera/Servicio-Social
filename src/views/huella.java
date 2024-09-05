/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

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
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

/**
 *
 * @author juancarloscastillocarrillo
 */
public class huella extends javax.swing.JFrame {

    private DPFPCapture capturer;
    private DPFPSensorEvent sensorEvent;
    
    public huella() {
        initComponents();
        //activateFingerprintReader();
        initFingerprintSensor();
    }
    //Metodo que recibe la muestra obtenida del lector y devuelve la imagen de la huella
     public  Image CrearImagenHuella(DPFPSample sample) {  
	return DPFPGlobal.getSampleConversionFactory().createImage(sample);
}
     //Actualiza el icono de la label con la image de la huella obtenida
     public void DibujarHuella(Image image) {
        fingerprinterImageLabel.setIcon(new ImageIcon(
        image.getScaledInstance(fingerprinterImageLabel.getWidth(), fingerprinterImageLabel.getHeight(), Image.SCALE_DEFAULT)));
        repaint();
 }
     public void executeCommand(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    
     //metodo que procesa la captura (recibe una muestra obtenida por el lector)
    private void processCapture(DPFPSample sample) {
        try{
            
            //en teoria aqui va el codigo para inscribir y verificar la huella
            //
            //
            //
            
             Image image=CrearImagenHuella(sample);         //crea la imagen de la muestra obtenida
            DibujarHuella(image); //actualiza el icon de la huella

        }catch(Exception e){
            System.out.println("Ha habido un error: "+e.getMessage());
        }
    }
    
    private void activateFingerprintReader() {
        deviceStatusLabel.setText("Activating Fingerprint Reader...");
        executeCommand("fprintd-enroll");
        deviceStatusLabel.setText("Fingerprint Reader Activated.");
    }
    
    public void initFingerprintSensor() {
        try {
            capturer = DPFPGlobal.getCaptureFactory().createCapture();
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

            capturer.addDataListener(new DPFPDataAdapter() {
                @Override
                public void dataAcquired(DPFPDataEvent e) {
                    processCapture(e.getSample());
                }
            });
            capturer.startCapture();
        } catch (Exception e) {
            e.printStackTrace();
            deviceStatusLabel.setText("Error initializing fingerprint sensor: " + e.getMessage());
            System.err.println(e.getMessage());
        }
    }
    

    



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        captureButton = new javax.swing.JButton();
        deviceStatusLabel = new javax.swing.JLabel();
        fingerprinterImageLabel = new javax.swing.JLabel();
        startLector = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        captureButton.setText("Capturar hulla");
        captureButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                captureButtonMouseClicked(evt);
            }
        });

        startLector.setText("Prender lector");
        startLector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startLectorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(startLector, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(captureButton, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(deviceStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(fingerprinterImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fingerprinterImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(deviceStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(startLector)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(captureButton)
                .addGap(44, 44, 44))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void startLectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startLectorActionPerformed
        /*deviceStatusLabel.setText("Activating Fingerprint Reader...");
        //SystemCommandExecutor.executeCommand("fprintd-enroll");
        capturer.startCapture();
        deviceStatusLabel.setText("Fingerprint Reader Activated.");*/
        
        /*capturer.startCapture();
        System.out.println(capturer.isStarted());*/
    }//GEN-LAST:event_startLectorActionPerformed

    private void captureButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_captureButtonMouseClicked
        
    }//GEN-LAST:event_captureButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(huella.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(huella.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(huella.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(huella.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*System.setProperty("java.library.path", "/opt/Crossmatch/urusdk-linux/Linux/lib/x64/");

        try {
            Field fieldSysPath = ClassLoader.class.getDeclaredField("sys_paths");
            fieldSysPath.setAccessible(true);
            fieldSysPath.set(null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new huella().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton captureButton;
    private javax.swing.JLabel deviceStatusLabel;
    private javax.swing.JLabel fingerprinterImageLabel;
    private javax.swing.JButton startLector;
    // End of variables declaration//GEN-END:variables
}

class SystemCommandExecutor {
    public static void executeCommand(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
