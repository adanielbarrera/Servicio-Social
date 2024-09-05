package views.process;

import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.capture.event.DPFPSensorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPSensorEvent;
import com.github.sarxos.webcam.Webcam;
import libraries.lStyle;

/**
 *
 * @author juancarloscastillocarrillo
 */
public class vP_Home extends javax.swing.JPanel {

    lStyle lStyle = new lStyle();

    private Webcam webcam;
    public DPFPCapture capturer;
    
    public vP_Home() {
        /*initComponents();
        setDataMail();*/
    }
    
    public vP_Home(DPFPCapture capturer) {
        this.capturer = capturer;
        initComponents();
        setDataMail();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        panelGeneralData = new javax.swing.JPanel();
        titlePanelGeneralData = new javax.swing.JLabel();
        userPhoto = new javax.swing.JPanel();
        userName = new javax.swing.JLabel();
        userJob = new javax.swing.JLabel();
        userDepartament = new javax.swing.JLabel();
        userSite = new javax.swing.JLabel();
        subtitle = new javax.swing.JLabel();
        panelStatusFingerReader = new javax.swing.JPanel();
        iconStatusFingerReader = new javax.swing.JLabel();
        titleStatusFingerReader = new javax.swing.JLabel();
        stausFingerReader = new javax.swing.JLabel();
        refreshFingerPrint = new javax.swing.JLabel();
        stausReader = new javax.swing.JLabel();
        panelStatusCamera = new javax.swing.JPanel();
        iconStatusCamera = new javax.swing.JLabel();
        titleStatusCamera = new javax.swing.JLabel();
        statusCamera = new javax.swing.JLabel();
        refreshCamera = new javax.swing.JLabel();

        setBackground(new java.awt.Color(246, 249, 252));
        setMaximumSize(new java.awt.Dimension(1000, 600));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setPreferredSize(new java.awt.Dimension(1000, 600));

        title.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(51, 51, 51));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Registro Lector de Huellas - RLH");

        panelGeneralData.setBackground(new java.awt.Color(255, 255, 255));
        panelGeneralData.setForeground(new java.awt.Color(255, 255, 255));

        titlePanelGeneralData.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        titlePanelGeneralData.setForeground(new java.awt.Color(51, 51, 51));
        titlePanelGeneralData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iUser-Dark-md.png"))); // NOI18N
        titlePanelGeneralData.setText("Datos personales");
        titlePanelGeneralData.setToolTipText("");
        titlePanelGeneralData.setIconTextGap(15);

        javax.swing.GroupLayout userPhotoLayout = new javax.swing.GroupLayout(userPhoto);
        userPhoto.setLayout(userPhotoLayout);
        userPhotoLayout.setHorizontalGroup(
            userPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        userPhotoLayout.setVerticalGroup(
            userPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        userName.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        userName.setForeground(new java.awt.Color(51, 51, 51));
        userName.setText("Juan Carlos Castillo Carrillo");

        userJob.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        userJob.setForeground(new java.awt.Color(51, 51, 51));
        userJob.setText("Jefe A de Proyecto");

        userDepartament.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        userDepartament.setForeground(new java.awt.Color(51, 51, 51));
        userDepartament.setText("Departamento de Mantenimiento y Soporte de Aplicaciones");

        userSite.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        userSite.setForeground(new java.awt.Color(51, 51, 51));
        userSite.setText("Oficina Central");

        javax.swing.GroupLayout panelGeneralDataLayout = new javax.swing.GroupLayout(panelGeneralData);
        panelGeneralData.setLayout(panelGeneralDataLayout);
        panelGeneralDataLayout.setHorizontalGroup(
            panelGeneralDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralDataLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelGeneralDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(titlePanelGeneralData, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelGeneralDataLayout.createSequentialGroup()
                        .addComponent(userPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelGeneralDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userJob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userDepartament, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userSite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
        );
        panelGeneralDataLayout.setVerticalGroup(
            panelGeneralDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralDataLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(titlePanelGeneralData)
                .addGap(18, 18, 18)
                .addGroup(panelGeneralDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelGeneralDataLayout.createSequentialGroup()
                        .addComponent(userName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userJob)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userDepartament)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userSite))
                    .addComponent(userPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        subtitle.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        subtitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subtitle.setText("Sistema para la captura de huellas digitales de los servidores públicos de la Dirección General de Fiscalización");

        panelStatusFingerReader.setBackground(new java.awt.Color(204, 204, 204));

        iconStatusFingerReader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iFingerPrintReader-Light-xl.png"))); // NOI18N

        titleStatusFingerReader.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        titleStatusFingerReader.setText("Lector de huellas");

        stausFingerReader.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        stausFingerReader.setText("Detectando dispositivo...");

        refreshFingerPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iRefresh-Light.png"))); // NOI18N
        refreshFingerPrint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshFingerPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshFingerPrintMouseClicked(evt);
            }
        });

        stausReader.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        javax.swing.GroupLayout panelStatusFingerReaderLayout = new javax.swing.GroupLayout(panelStatusFingerReader);
        panelStatusFingerReader.setLayout(panelStatusFingerReaderLayout);
        panelStatusFingerReaderLayout.setHorizontalGroup(
            panelStatusFingerReaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStatusFingerReaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconStatusFingerReader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelStatusFingerReaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleStatusFingerReader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stausFingerReader, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelStatusFingerReaderLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(refreshFingerPrint))
                    .addComponent(stausReader, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelStatusFingerReaderLayout.setVerticalGroup(
            panelStatusFingerReaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStatusFingerReaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelStatusFingerReaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelStatusFingerReaderLayout.createSequentialGroup()
                        .addComponent(refreshFingerPrint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(titleStatusFingerReader)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stausFingerReader)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stausReader, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addComponent(iconStatusFingerReader))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelStatusCamera.setBackground(new java.awt.Color(204, 204, 204));

        iconStatusCamera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconStatusCamera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iCamera-Light-xl.png"))); // NOI18N

        titleStatusCamera.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        titleStatusCamera.setText("Camara");

        statusCamera.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        statusCamera.setText("Detectando dispositivo...");

        refreshCamera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iRefresh-Light.png"))); // NOI18N
        refreshCamera.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshCamera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshCameraMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelStatusCameraLayout = new javax.swing.GroupLayout(panelStatusCamera);
        panelStatusCamera.setLayout(panelStatusCameraLayout);
        panelStatusCameraLayout.setHorizontalGroup(
            panelStatusCameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStatusCameraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconStatusCamera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelStatusCameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleStatusCamera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(statusCamera, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelStatusCameraLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(refreshCamera)))
                .addContainerGap())
        );
        panelStatusCameraLayout.setVerticalGroup(
            panelStatusCameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStatusCameraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelStatusCameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconStatusCamera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelStatusCameraLayout.createSequentialGroup()
                        .addComponent(refreshCamera)
                        .addGap(18, 18, 18)
                        .addComponent(titleStatusCamera)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusCamera)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(subtitle, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelStatusFingerReader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelStatusCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelGeneralData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subtitle)
                .addGap(45, 45, 45)
                .addComponent(panelGeneralData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelStatusFingerReader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelStatusCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(182, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshCameraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshCameraMouseClicked
        VPH_CameraConnected();
    }//GEN-LAST:event_refreshCameraMouseClicked

    private void refreshFingerPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshFingerPrintMouseClicked
        VPH_FingerReagerConnected();
    }//GEN-LAST:event_refreshFingerPrintMouseClicked

    public void setDataMail() {
        VPH_CameraConnected();
        VPH_FingerReagerConnected();
    }
    
    public void VPH_FingerReagerConnected() {
        
        if(this.capturer != null) {
            if(this.capturer.isStarted()) {
                stausFingerReader.setText("Dispositivo conectado");
                panelStatusFingerReader.setBackground(lStyle.getBgSuccess());
                stausReader.setText("Aqui se muestra la acción del lector");
            } else {
                stausFingerReader.setText("Lector no inicializado");
                panelStatusFingerReader.setBackground(lStyle.getBgDanger());
                stausReader.setText("Favor de validar la funcionalidad dellector");
            }
        } else {
            stausFingerReader.setText("No existe ningun dispositivo conectado");
            panelStatusFingerReader.setBackground(lStyle.getBgDanger());
            stausReader.setText("Favor de validar la conexión con el lector");
        }
        
        this.capturer.addSensorListener(new DPFPSensorAdapter() {
            @Override
            public void fingerTouched(DPFPSensorEvent e) {
                stausReader.setText("Lector presionado");
            }

            @Override
            public void fingerGone(DPFPSensorEvent e) {
                stausReader.setText("Lector sin presionar");
            }
        });
    }
   
    
    public void VPH_CameraConnected() {
        webcam = Webcam.getDefault();
        
        if(webcam != null) {
            statusCamera.setText("Dispositivo conectado");
            panelStatusCamera.setBackground(lStyle.getBgSuccess());
        } else {
            statusCamera.setText("No existe ningun dispositivo conectado");
            panelStatusCamera.setBackground(lStyle.getBgDanger());
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconStatusCamera;
    private javax.swing.JLabel iconStatusFingerReader;
    private javax.swing.JPanel panelGeneralData;
    private javax.swing.JPanel panelStatusCamera;
    private javax.swing.JPanel panelStatusFingerReader;
    private javax.swing.JLabel refreshCamera;
    private javax.swing.JLabel refreshFingerPrint;
    private javax.swing.JLabel statusCamera;
    private javax.swing.JLabel stausFingerReader;
    private javax.swing.JLabel stausReader;
    private javax.swing.JLabel subtitle;
    private javax.swing.JLabel title;
    private javax.swing.JLabel titlePanelGeneralData;
    private javax.swing.JLabel titleStatusCamera;
    private javax.swing.JLabel titleStatusFingerReader;
    private javax.swing.JLabel userDepartament;
    private javax.swing.JLabel userJob;
    private javax.swing.JLabel userName;
    private javax.swing.JPanel userPhoto;
    private javax.swing.JLabel userSite;
    // End of variables declaration//GEN-END:variables
}
