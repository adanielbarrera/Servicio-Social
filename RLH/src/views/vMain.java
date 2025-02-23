package views;

import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import java.awt.Color;
import libraries.lStyle;
import views.process.vP_CapturaHuellas;
import views.process.vP_Home;
import views.process.vP_VerificadorHuellas;

/**
 *
 * @author juancarloscastillocarrillo
 */
public class vMain extends javax.swing.JFrame {

    lStyle lStyle = new lStyle();
    
    public DPFPCapture capturer;
    
    int xMouse;
    int yMouse;
    
    public vMain() {
        initComponents();
        setDataMain();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        iconClose = new javax.swing.JLabel();
        iconMinimizar = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        userPhoto = new javax.swing.JPanel();
        userName = new javax.swing.JLabel();
        userPosition = new javax.swing.JLabel();
        userSite = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        btnCapture = new javax.swing.JButton();
        btnVerify = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        labelVersion = new javax.swing.JLabel();
        labelAuthor = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        iconClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/close.png"))); // NOI18N
        iconClose.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        iconClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconCloseMouseClicked(evt);
            }
        });

        iconMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/minimize.png"))); // NOI18N
        iconMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        iconMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconMinimizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap(1198, Short.MAX_VALUE)
                .addComponent(iconMinimizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconClose)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconClose)
                    .addComponent(iconMinimizar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        background.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 30));

        menu.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout userPhotoLayout = new javax.swing.GroupLayout(userPhoto);
        userPhoto.setLayout(userPhotoLayout);
        userPhotoLayout.setHorizontalGroup(
            userPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );
        userPhotoLayout.setVerticalGroup(
            userPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 109, Short.MAX_VALUE)
        );

        userName.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        userName.setForeground(new java.awt.Color(255, 255, 255));
        userName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userName.setText("Juan Carlos Castillo Carrillo");
        userName.setToolTipText("");

        userPosition.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        userPosition.setForeground(new java.awt.Color(255, 255, 255));
        userPosition.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userPosition.setText("Jefe A de Proyecto");

        userSite.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        userSite.setForeground(new java.awt.Color(255, 255, 255));
        userSite.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userSite.setText("Oficina Central");

        btnHome.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iHome-Light.png"))); // NOI18N
        btnHome.setText("Inicio");
        btnHome.setToolTipText("");
        btnHome.setBorder(null);
        btnHome.setBorderPainted(false);
        btnHome.setContentAreaFilled(false);
        btnHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHome.setFocusable(false);
        btnHome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHome.setIconTextGap(15);
        btnHome.setOpaque(true);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnCapture.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCapture.setForeground(new java.awt.Color(255, 255, 255));
        btnCapture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iUserAdd-Light.png"))); // NOI18N
        btnCapture.setText("Captura de huellas");
        btnCapture.setToolTipText("");
        btnCapture.setBorder(null);
        btnCapture.setBorderPainted(false);
        btnCapture.setContentAreaFilled(false);
        btnCapture.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapture.setFocusable(false);
        btnCapture.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCapture.setIconTextGap(15);
        btnCapture.setOpaque(true);
        btnCapture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaptureActionPerformed(evt);
            }
        });

        btnVerify.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnVerify.setForeground(new java.awt.Color(255, 255, 255));
        btnVerify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iFingerPrint-Light.png"))); // NOI18N
        btnVerify.setText("Verificador de huellas");
        btnVerify.setToolTipText("");
        btnVerify.setBorder(null);
        btnVerify.setBorderPainted(false);
        btnVerify.setContentAreaFilled(false);
        btnVerify.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerify.setFocusable(false);
        btnVerify.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVerify.setIconTextGap(15);
        btnVerify.setOpaque(true);
        btnVerify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerifyActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iLogout-Light.png"))); // NOI18N
        btnLogout.setText("Cerrar sesión");
        btnLogout.setToolTipText("");
        btnLogout.setBorder(null);
        btnLogout.setBorderPainted(false);
        btnLogout.setContentAreaFilled(false);
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.setFocusable(false);
        btnLogout.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLogout.setIconTextGap(15);
        btnLogout.setOpaque(true);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        labelVersion.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        labelVersion.setForeground(new java.awt.Color(255, 255, 255));
        labelVersion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelVersion.setText("Versión 2.0 | © 2024");

        labelAuthor.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        labelAuthor.setForeground(new java.awt.Color(255, 255, 255));
        labelAuthor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAuthor.setText("Dirección de Tecnologías de la Información");
        labelAuthor.setToolTipText("");

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userPosition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(userPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addComponent(userSite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerify, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapture, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
            .addComponent(labelAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelVersion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(userPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userPosition)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userSite)
                .addGap(46, 46, 46)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCapture, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerify, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                .addComponent(labelVersion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelAuthor)
                .addGap(8, 8, 8))
        );

        background.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 630));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        background.add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 1000, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void iconCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_iconCloseMouseClicked

    private void iconMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconMinimizarMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_iconMinimizarMouseClicked

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        activeModule("home");
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnCaptureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaptureActionPerformed
        activeModule("capture");
    }//GEN-LAST:event_btnCaptureActionPerformed

    private void btnVerifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerifyActionPerformed
        activeModule("verify");
    }//GEN-LAST:event_btnVerifyActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        System.out.println("aquiiiii se sale");
    }//GEN-LAST:event_btnLogoutActionPerformed

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
            java.util.logging.Logger.getLogger(vMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vMain().setVisible(true);
            }
        });
    }
    
    public void setDataMain() {       
        
        header.setBackground(new Color(255, 255, 255, 50));
        menu.setBackground(lStyle.getBgDgfPrincipal());
        
        btnHome.setBackground(lStyle.getBgDgfPrincipal());
        btnCapture.setBackground(lStyle.getBgDgfPrincipal());
        btnVerify.setBackground(lStyle.getBgDgfPrincipal());
        btnLogout.setBackground(lStyle.getBgDgfPrincipal());
        
        btnHome.setForeground(lStyle.getTxtWhite());
        btnCapture.setForeground(lStyle.getTxtWhite());
        btnVerify.setForeground(lStyle.getTxtWhite());
        btnLogout.setForeground(lStyle.getTxtWhite());

        activeModule("capture");
    }
    
    public void activeModule(String module) {
        
        mainPanel.removeAll();
        
        switch(module) {
            case "home":
                vM_FingerReagerConnected();
                vP_Home vP_Home = new vP_Home(capturer);
                vP_Home.setSize(mainPanel.getSize());
                vP_Home.setLocation(0, 0);
                mainPanel.add(vP_Home);
            break;
            
            case "capture":
                vP_CapturaHuellas vP_CapturaHuellas = new vP_CapturaHuellas();
                vP_CapturaHuellas.setSize(mainPanel.getSize());
                vP_CapturaHuellas.setLocation(0, 0);
                mainPanel.add(vP_CapturaHuellas);
            break;
            
            case "verify":
                vP_VerificadorHuellas vP_VerificadorHuellas = new vP_VerificadorHuellas();
                vP_VerificadorHuellas.setSize(mainPanel.getSize());
                vP_VerificadorHuellas.setLocation(0, 0);
                mainPanel.add(vP_VerificadorHuellas);
            break;
        }
        
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    public void vM_FingerReagerConnected() {
        try {
            if(capturer == null) {
                this.capturer = DPFPGlobal.getCaptureFactory().createCapture();
                
                this.capturer.addReaderStatusListener(new DPFPReaderStatusAdapter() {
                    @Override
                    public void readerConnected(DPFPReaderStatusEvent e) {
                        System.out.println("Lector inicializado");
                    }

                    @Override
                    public void readerDisconnected(DPFPReaderStatusEvent e) {
                        System.out.println("No se detecto ningun lector");
                    }
                });
                capturer.startCapture();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del lector: " + e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnCapture;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnVerify;
    private javax.swing.JPanel header;
    private javax.swing.JLabel iconClose;
    private javax.swing.JLabel iconMinimizar;
    private javax.swing.JLabel labelAuthor;
    private javax.swing.JLabel labelVersion;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel userName;
    private javax.swing.JPanel userPhoto;
    private javax.swing.JLabel userPosition;
    private javax.swing.JLabel userSite;
    // End of variables declaration//GEN-END:variables
}
