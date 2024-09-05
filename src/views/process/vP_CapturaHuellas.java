package views.process;

import DAOs.PersonalDAO;
import DAOs.UserDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import libraries.lStyle;
import controllers.Camara;
import controllers.LectorHuellas;
import javax.swing.JTable;
import models.Personal;
import models.Usuario;
import views.Guardado;
import views.Error;

/**
 *
 * @author juancarloscastillocarrillo
 */
public class vP_CapturaHuellas extends javax.swing.JPanel {

    lStyle lStyle = new lStyle();
    private Camara camara;
    private LectorHuellas lector;
    private PersonalDAO personalDAO;
    private UserDAO userDAO;
    private Usuario user = Usuario.getInstance();
    private Personal personal = Personal.getInstance();
    private JTable table;
    private String RFC;

    public String getRFC() {
        return this.RFC;
    }

    public vP_CapturaHuellas() {
        initComponents();
        setDataMain();
        this.camara = new Camara();
        this.lector = new LectorHuellas(this);
        this.personalDAO = new PersonalDAO();
        this.userDAO = new UserDAO();
        try {
            int userDeleg_clv = user.getDeleg_clv();
            table = userDAO.tablaPersonalPorDelegacion(userDeleg_clv);
        } catch (Exception e) {

        }
        mostrarImagen();
        //this.fingerprintImage.setIcon(dibujarHuella(lector.crearImagenHuella(sample)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        panelGeneralData = new javax.swing.JPanel();
        titlePanelGeneralData = new javax.swing.JLabel();
        userPhoto = userPhoto = new FotoPanel();
        userName = new javax.swing.JLabel();
        userJob = new javax.swing.JLabel();
        userDepartament = new javax.swing.JLabel();
        btnCapturaHuellas = new javax.swing.JButton();
        btnCapturaHuellas1 = new javax.swing.JButton();
        seeker = new javax.swing.JTextField();
        separatorSeeker = new javax.swing.JSeparator();
        iconSeeker = new javax.swing.JLabel();
        panelGeneralData1 = new javax.swing.JPanel();
        titlePanelGeneralData1 = new javax.swing.JLabel();
        userPhoto1 = new javax.swing.JPanel();
        btnCapturaHuellas3 = new javax.swing.JButton();
        userPhoto2 = userPhoto2 = new FotoPanel();
        jSeparator1 = new javax.swing.JSeparator();
        btnPulgarDer = new javax.swing.JButton();
        btnIndiceDer = new javax.swing.JButton();
        btnMedio = new javax.swing.JButton();
        btnPulgarIzq = new javax.swing.JButton();
        btnIndiceIzq = new javax.swing.JButton();
        fingerprintImage = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        nombreComboBox = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(246, 249, 252));
        setMaximumSize(new java.awt.Dimension(1000, 600));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setPreferredSize(new java.awt.Dimension(1000, 600));

        title.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(51, 51, 51));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Captura de huellas digitales");

        panelGeneralData.setBackground(new java.awt.Color(255, 255, 255));
        panelGeneralData.setForeground(new java.awt.Color(255, 255, 255));

        titlePanelGeneralData.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        titlePanelGeneralData.setForeground(new java.awt.Color(51, 51, 51));
        titlePanelGeneralData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iUser-Dark-md.png"))); // NOI18N
        titlePanelGeneralData.setText("Información del servidor público");
        titlePanelGeneralData.setToolTipText("");
        titlePanelGeneralData.setIconTextGap(15);

        javax.swing.GroupLayout userPhotoLayout = new javax.swing.GroupLayout(userPhoto);
        userPhoto.setLayout(userPhotoLayout);
        userPhotoLayout.setHorizontalGroup(
            userPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        userPhotoLayout.setVerticalGroup(
            userPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );

        userName.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        userName.setForeground(new java.awt.Color(51, 51, 51));
        userName.setText("Nombre");
        userName.setMaximumSize(new java.awt.Dimension(275, 14));
        userName.setMinimumSize(new java.awt.Dimension(275, 14));
        userName.setPreferredSize(new java.awt.Dimension(275, 14));

        userJob.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        userJob.setForeground(new java.awt.Color(51, 51, 51));
        userJob.setText("RFC | CURP");
        userJob.setMaximumSize(new java.awt.Dimension(275, 14));
        userJob.setMinimumSize(new java.awt.Dimension(275, 14));
        userJob.setPreferredSize(new java.awt.Dimension(275, 14));

        userDepartament.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        userDepartament.setForeground(new java.awt.Color(51, 51, 51));
        userDepartament.setText("Puesto");
        userDepartament.setMaximumSize(new java.awt.Dimension(275, 14));
        userDepartament.setMinimumSize(new java.awt.Dimension(275, 14));
        userDepartament.setPreferredSize(new java.awt.Dimension(275, 14));

        btnCapturaHuellas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCapturaHuellas.setForeground(new java.awt.Color(51, 51, 51));
        btnCapturaHuellas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iCamera-Dark.png"))); // NOI18N
        btnCapturaHuellas.setText("Guardar registro completo");
        btnCapturaHuellas.setBorder(null);
        btnCapturaHuellas.setContentAreaFilled(false);
        btnCapturaHuellas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapturaHuellas.setFocusable(false);
        btnCapturaHuellas.setIconTextGap(10);
        btnCapturaHuellas.setMaximumSize(new java.awt.Dimension(190, 28));
        btnCapturaHuellas.setMinimumSize(new java.awt.Dimension(190, 28));
        btnCapturaHuellas.setOpaque(true);
        btnCapturaHuellas.setPreferredSize(new java.awt.Dimension(190, 28));
        btnCapturaHuellas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapturaHuellasActionPerformed(evt);
            }
        });

        btnCapturaHuellas1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCapturaHuellas1.setForeground(new java.awt.Color(51, 51, 51));
        btnCapturaHuellas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iFingerPrint-Dark.png"))); // NOI18N
        btnCapturaHuellas1.setText("Reemplazar huellas digitales");
        btnCapturaHuellas1.setBorder(null);
        btnCapturaHuellas1.setContentAreaFilled(false);
        btnCapturaHuellas1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapturaHuellas1.setFocusable(false);
        btnCapturaHuellas1.setIconTextGap(10);
        btnCapturaHuellas1.setMaximumSize(new java.awt.Dimension(190, 28));
        btnCapturaHuellas1.setMinimumSize(new java.awt.Dimension(190, 28));
        btnCapturaHuellas1.setOpaque(true);
        btnCapturaHuellas1.setPreferredSize(new java.awt.Dimension(190, 28));

        javax.swing.GroupLayout panelGeneralDataLayout = new javax.swing.GroupLayout(panelGeneralData);
        panelGeneralData.setLayout(panelGeneralDataLayout);
        panelGeneralDataLayout.setHorizontalGroup(
            panelGeneralDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralDataLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelGeneralDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titlePanelGeneralData, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelGeneralDataLayout.createSequentialGroup()
                        .addComponent(userPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGeneralDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGeneralDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(userJob, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(userDepartament, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelGeneralDataLayout.createSequentialGroup()
                        .addComponent(btnCapturaHuellas, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCapturaHuellas1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        panelGeneralDataLayout.setVerticalGroup(
            panelGeneralDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralDataLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(titlePanelGeneralData)
                .addGap(18, 18, 18)
                .addGroup(panelGeneralDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelGeneralDataLayout.createSequentialGroup()
                        .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userJob, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userDepartament, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGeneralDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCapturaHuellas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapturaHuellas1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        seeker.setBackground(new java.awt.Color(246, 249, 252));
        seeker.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        seeker.setBorder(null);
        seeker.setMaximumSize(new java.awt.Dimension(200, 16));
        seeker.setMinimumSize(new java.awt.Dimension(200, 16));
        seeker.setName(""); // NOI18N
        seeker.setPreferredSize(new java.awt.Dimension(200, 16));
        seeker.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                seekerKeyReleased(evt);
            }
        });

        separatorSeeker.setMaximumSize(new java.awt.Dimension(220, 5));
        separatorSeeker.setMinimumSize(new java.awt.Dimension(220, 5));
        separatorSeeker.setPreferredSize(new java.awt.Dimension(220, 5));

        iconSeeker.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        iconSeeker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iSearch-Dark.png"))); // NOI18N
        iconSeeker.setToolTipText("");

        panelGeneralData1.setBackground(new java.awt.Color(255, 255, 255));
        panelGeneralData1.setForeground(new java.awt.Color(255, 255, 255));

        titlePanelGeneralData1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        titlePanelGeneralData1.setForeground(new java.awt.Color(51, 51, 51));
        titlePanelGeneralData1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iUser-Dark-md.png"))); // NOI18N
        titlePanelGeneralData1.setText("Información a capturar");
        titlePanelGeneralData1.setToolTipText("");
        titlePanelGeneralData1.setIconTextGap(15);

        javax.swing.GroupLayout userPhoto1Layout = new javax.swing.GroupLayout(userPhoto1);
        userPhoto1.setLayout(userPhoto1Layout);
        userPhoto1Layout.setHorizontalGroup(
            userPhoto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 165, Short.MAX_VALUE)
        );
        userPhoto1Layout.setVerticalGroup(
            userPhoto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
        );

        btnCapturaHuellas3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCapturaHuellas3.setForeground(new java.awt.Color(51, 51, 51));
        btnCapturaHuellas3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iCamera-Dark.png"))); // NOI18N
        btnCapturaHuellas3.setBorder(null);
        btnCapturaHuellas3.setContentAreaFilled(false);
        btnCapturaHuellas3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapturaHuellas3.setFocusable(false);
        btnCapturaHuellas3.setIconTextGap(10);
        btnCapturaHuellas3.setMaximumSize(new java.awt.Dimension(190, 28));
        btnCapturaHuellas3.setMinimumSize(new java.awt.Dimension(190, 28));
        btnCapturaHuellas3.setOpaque(true);
        btnCapturaHuellas3.setPreferredSize(new java.awt.Dimension(190, 28));
        btnCapturaHuellas3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCapturaHuellas3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCapturaHuellas3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCapturaHuellas3MouseExited(evt);
            }
        });

        userPhoto2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        btnPulgarDer.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnPulgarDer.setForeground(new java.awt.Color(51, 51, 51));
        btnPulgarDer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iFingerPrint-Dark.png"))); // NOI18N
        btnPulgarDer.setText("Pulgar derecho");
        btnPulgarDer.setBorder(null);
        btnPulgarDer.setContentAreaFilled(false);
        btnPulgarDer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPulgarDer.setFocusable(false);
        btnPulgarDer.setIconTextGap(10);
        btnPulgarDer.setMaximumSize(new java.awt.Dimension(190, 28));
        btnPulgarDer.setMinimumSize(new java.awt.Dimension(190, 28));
        btnPulgarDer.setOpaque(true);
        btnPulgarDer.setPreferredSize(new java.awt.Dimension(190, 28));
        btnPulgarDer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPulgarDerMouseClicked(evt);
            }
        });

        btnIndiceDer.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnIndiceDer.setForeground(new java.awt.Color(51, 51, 51));
        btnIndiceDer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iFingerPrint-Dark.png"))); // NOI18N
        btnIndiceDer.setText("Índice derecho");
        btnIndiceDer.setBorder(null);
        btnIndiceDer.setContentAreaFilled(false);
        btnIndiceDer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIndiceDer.setFocusable(false);
        btnIndiceDer.setIconTextGap(10);
        btnIndiceDer.setMaximumSize(new java.awt.Dimension(190, 28));
        btnIndiceDer.setMinimumSize(new java.awt.Dimension(190, 28));
        btnIndiceDer.setOpaque(true);
        btnIndiceDer.setPreferredSize(new java.awt.Dimension(190, 28));
        btnIndiceDer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIndiceDerMouseClicked(evt);
            }
        });

        btnMedio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnMedio.setForeground(new java.awt.Color(51, 51, 51));
        btnMedio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iFingerPrint-Dark.png"))); // NOI18N
        btnMedio.setText("Medio derecho");
        btnMedio.setBorder(null);
        btnMedio.setContentAreaFilled(false);
        btnMedio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMedio.setFocusable(false);
        btnMedio.setIconTextGap(10);
        btnMedio.setMaximumSize(new java.awt.Dimension(190, 28));
        btnMedio.setMinimumSize(new java.awt.Dimension(190, 28));
        btnMedio.setOpaque(true);
        btnMedio.setPreferredSize(new java.awt.Dimension(190, 28));
        btnMedio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMedioMouseClicked(evt);
            }
        });

        btnPulgarIzq.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnPulgarIzq.setForeground(new java.awt.Color(51, 51, 51));
        btnPulgarIzq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iFingerPrint-Dark.png"))); // NOI18N
        btnPulgarIzq.setText("Pulgar izquierdo");
        btnPulgarIzq.setBorder(null);
        btnPulgarIzq.setContentAreaFilled(false);
        btnPulgarIzq.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPulgarIzq.setFocusable(false);
        btnPulgarIzq.setIconTextGap(10);
        btnPulgarIzq.setMaximumSize(new java.awt.Dimension(190, 28));
        btnPulgarIzq.setMinimumSize(new java.awt.Dimension(190, 28));
        btnPulgarIzq.setOpaque(true);
        btnPulgarIzq.setPreferredSize(new java.awt.Dimension(190, 28));
        btnPulgarIzq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPulgarIzqMouseClicked(evt);
            }
        });

        btnIndiceIzq.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnIndiceIzq.setForeground(new java.awt.Color(51, 51, 51));
        btnIndiceIzq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iFingerPrint-Dark.png"))); // NOI18N
        btnIndiceIzq.setText("Índice izquierdo");
        btnIndiceIzq.setBorder(null);
        btnIndiceIzq.setContentAreaFilled(false);
        btnIndiceIzq.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIndiceIzq.setFocusable(false);
        btnIndiceIzq.setIconTextGap(10);
        btnIndiceIzq.setMaximumSize(new java.awt.Dimension(190, 28));
        btnIndiceIzq.setMinimumSize(new java.awt.Dimension(190, 28));
        btnIndiceIzq.setOpaque(true);
        btnIndiceIzq.setPreferredSize(new java.awt.Dimension(190, 28));
        btnIndiceIzq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIndiceIzqMouseClicked(evt);
            }
        });

        fingerprintImage.setBackground(new java.awt.Color(214, 217, 223));
        fingerprintImage.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(214, 217, 223), 1, true));

        jProgressBar1.setBorder(null);

        javax.swing.GroupLayout panelGeneralData1Layout = new javax.swing.GroupLayout(panelGeneralData1);
        panelGeneralData1.setLayout(panelGeneralData1Layout);
        panelGeneralData1Layout.setHorizontalGroup(
            panelGeneralData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralData1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelGeneralData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelGeneralData1Layout.createSequentialGroup()
                        .addGroup(panelGeneralData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titlePanelGeneralData1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelGeneralData1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(userPhoto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCapturaHuellas3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(userPhoto2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelGeneralData1Layout.createSequentialGroup()
                                .addGroup(panelGeneralData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnIndiceIzq, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPulgarIzq, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnMedio, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnIndiceDer, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPulgarDer, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(57, 57, 57)
                                .addGroup(panelGeneralData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fingerprintImage, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(77, Short.MAX_VALUE))))
        );
        panelGeneralData1Layout.setVerticalGroup(
            panelGeneralData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralData1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(titlePanelGeneralData1)
                .addGroup(panelGeneralData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeneralData1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btnCapturaHuellas3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralData1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelGeneralData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userPhoto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userPhoto2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGeneralData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeneralData1Layout.createSequentialGroup()
                        .addComponent(btnPulgarDer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIndiceDer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnPulgarIzq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIndiceIzq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelGeneralData1Layout.createSequentialGroup()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(fingerprintImage, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        nombreComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona una opción..." }));
        nombreComboBox.setBorder(null);
        nombreComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(panelGeneralData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelGeneralData1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(297, 297, 297)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(iconSeeker)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(seeker, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(separatorSeeker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconSeeker)
                    .addComponent(seeker, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(separatorSeeker, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nombreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelGeneralData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelGeneralData1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
//boton para capturar la imagen de la camara
    private void btnCapturaHuellas3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapturaHuellas3MouseClicked
        capturarYMostrarImagen();
        //camara.enviarimagenAPersonalDao(personalDAO);
        guardado();

    }//GEN-LAST:event_btnCapturaHuellas3MouseClicked

    private void btnPulgarDerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPulgarDerMouseClicked
        btnPulgarDer.setBackground(lStyle.getBtnseleccionado());
        lector.seleccionarDedo("pulgar derecho");
    }//GEN-LAST:event_btnPulgarDerMouseClicked

    private void btnIndiceDerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIndiceDerMouseClicked
        btnIndiceDer.setBackground(lStyle.getBtnseleccionado());
        lector.seleccionarDedo("indice derecho");
    }//GEN-LAST:event_btnIndiceDerMouseClicked

    private void btnMedioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMedioMouseClicked
        btnMedio.setBackground(lStyle.getBtnseleccionado());
        lector.seleccionarDedo("medio");
    }//GEN-LAST:event_btnMedioMouseClicked

    private void btnPulgarIzqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPulgarIzqMouseClicked
        btnPulgarIzq.setBackground(lStyle.getBtnseleccionado());
        lector.seleccionarDedo("pulgar izquierdo");
    }//GEN-LAST:event_btnPulgarIzqMouseClicked

    private void btnIndiceIzqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIndiceIzqMouseClicked
        btnIndiceIzq.setBackground(lStyle.getBtnseleccionado());
        lector.seleccionarDedo("indice izquierdo");
    }//GEN-LAST:event_btnIndiceIzqMouseClicked

    private void btnCapturaHuellas3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapturaHuellas3MouseEntered
        btnCapturaHuellas3.setBackground(lStyle.getBtnseleccionado());
    }//GEN-LAST:event_btnCapturaHuellas3MouseEntered

    private void btnCapturaHuellas3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapturaHuellas3MouseExited
        btnCapturaHuellas3.setBackground(new Color(214, 217, 223));
    }//GEN-LAST:event_btnCapturaHuellas3MouseExited

    private void nombreComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreComboBoxActionPerformed
        String nombreCompleto = (String) nombreComboBox.getSelectedItem();
        Personal personal;
        try {
            personal = personalDAO.getPersonalByNombreCompleto(nombreCompleto);
            if (personal != null) {
                userName.setText(personal.getNombre() + " " + personal.getApePaterno() + " " + personal.getApeMaterno());
                userJob.setText(personal.getrFC() + " | " + personal.getcURP());
                userDepartament.setText(personal.getPuesto());

                //mostrar imagen
                BufferedImage img = personal.getFoto();
                ((FotoPanel) userPhoto).setImage(img);

                //limpiar la interfaz
                btnPulgarDer.setBackground(new Color(214, 217, 223));
                btnIndiceDer.setBackground(new Color(214, 217, 223));
                btnMedio.setBackground(new Color(214, 217, 223));
                btnPulgarIzq.setBackground(new Color(214, 217, 223));
                btnIndiceIzq.setBackground(new Color(214, 217, 223));

                lector.resetProgreso();
            } else {
                userName.setText("Nombre");
                userJob.setText("RFC|CURP");
                userDepartament.setText("Puesto");

            }
        } catch (IOException ex) {
            Logger.getLogger(vP_CapturaHuellas.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_nombreComboBoxActionPerformed

    private void seekerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_seekerKeyReleased
        String textoBusqueda = seeker.getText();
        if (seeker.getText() != null) {
            List<String> resultados = personalDAO.buscarApellidos(textoBusqueda, table);
            nombreComboBox.removeAllItems();
            nombreComboBox.addItem("Selecciona una opción...");
            for (String nombresCompletos : resultados) {
                nombreComboBox.addItem(nombresCompletos);
            }
        } else {
            nombreComboBox.removeAllItems();
        }
    }//GEN-LAST:event_seekerKeyReleased

    private void btnCapturaHuellasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapturaHuellasActionPerformed
        byte[] foto = null;
        try {
            foto = camara.convertBufferedImageToBytes(personal.getFoto(), "png");
            personalDAO.guardarBiometricos(foto);
            guardado();
        } catch (Exception ex) {
            error();
        }
    }//GEN-LAST:event_btnCapturaHuellasActionPerformed

    private void mostrarImagen() {
        try {
            userPhoto1.setLayout(new java.awt.BorderLayout());
            userPhoto1.add(camara.getWebcamPanel(), BorderLayout.CENTER);
            userPhoto.revalidate();
        } catch (Exception e) {
            System.err.println("error de camara " + e);
        }
    }

    private void capturarYMostrarImagen() {
        camara.capturarImagen();
        BufferedImage imagen = camara.getImage();
        if (imagen != null) {
            ((FotoPanel) userPhoto).setImage(imagen);
            ((FotoPanel) userPhoto2).setImage(imagen);
        }
    }

    public void actualizarJLabelConHuella(Image image) {
        fingerprintImage.setIcon(new ImageIcon(
                image.getScaledInstance(fingerprintImage.getWidth(), fingerprintImage.getHeight(), Image.SCALE_DEFAULT)));
        repaint();
    }

    public void actualizarBarraDeProgreso(String dedoSeleccionado, int progreso) {
        JButton buton = obtenerBotonPorDedo(dedoSeleccionado);
        switch (progreso) {
            case 0:
                jProgressBar1.setValue(0);
                break;
            case 1:
                jProgressBar1.setValue(25);
                break;
            case 2:
                jProgressBar1.setValue(50);
                break;
            case 3:
                jProgressBar1.setValue(75);
                break;
            case 4:
                jProgressBar1.setValue(100);
                buton.setBackground(lStyle.getBgSuccess());
                break;
        }

    }

    private JButton obtenerBotonPorDedo(String dedoSeleccionado) {
        switch (dedoSeleccionado) {
            case "pulgar derecho":
                return btnPulgarDer;
            case "indice derecho":
                return btnIndiceDer;
            case "medio":
                return btnMedio;
            case "pulgar izquierdo":
                return btnPulgarIzq;
            case "indice izquierdo":
                return btnIndiceIzq;
            default:
                return null; // O lanza una excepción si es un caso inesperado
        }
    }

    public void setDataMain() {

    }

    //metodo para confirmar visualmente que se guardo en base de datos
    public void guardado() {
        Guardado ok = new Guardado();
        ok.setVisible(true);
    }
    
    public void error(){
        Error err = new Error();
        err.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapturaHuellas;
    private javax.swing.JButton btnCapturaHuellas1;
    private javax.swing.JButton btnCapturaHuellas3;
    private javax.swing.JButton btnIndiceDer;
    private javax.swing.JButton btnIndiceIzq;
    private javax.swing.JButton btnMedio;
    private javax.swing.JButton btnPulgarDer;
    private javax.swing.JButton btnPulgarIzq;
    private javax.swing.JLabel fingerprintImage;
    private javax.swing.JLabel iconSeeker;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> nombreComboBox;
    private javax.swing.JPanel panelGeneralData;
    private javax.swing.JPanel panelGeneralData1;
    private javax.swing.JTextField seeker;
    private javax.swing.JSeparator separatorSeeker;
    private javax.swing.JLabel title;
    private javax.swing.JLabel titlePanelGeneralData;
    private javax.swing.JLabel titlePanelGeneralData1;
    private javax.swing.JLabel userDepartament;
    private javax.swing.JLabel userJob;
    private javax.swing.JLabel userName;
    private javax.swing.JPanel userPhoto;
    private javax.swing.JPanel userPhoto1;
    private javax.swing.JPanel userPhoto2;
    // End of variables declaration//GEN-END:variables
}
