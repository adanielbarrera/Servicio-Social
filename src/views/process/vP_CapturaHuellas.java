package views.process;

import DAOs.PersonalDAO;
import DAOs.UserDAO;
import Exceptions.FotoException;
import Exceptions.HuellaException;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import libraries.lStyle;
import controllers.Camara;
import controllers.LectorHuella;
import javax.imageio.ImageIO;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
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
    private LectorHuella lector;
    private PersonalDAO personalDAO;
    private UserDAO userDAO;
    private Usuario user = Usuario.getInstance();
    private Personal personal = Personal.getInstance();
    private JTable table;
    private String RFC;
    TableRowSorter<TableModel> sorter;

    public String getRFC() {
        return this.RFC;
    }

    public vP_CapturaHuellas() {
        FlatLightLaf.setup();
        this.camara = new Camara();
        this.lector = LectorHuella.getInstance();
        lector.setVistaCaptura(this);
        this.personalDAO = new PersonalDAO();
        this.userDAO = new UserDAO();
        try {
            int userDeleg_clv = user.getDeleg_clv();
            table = userDAO.tablaPersonalPorDelegacion(userDeleg_clv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        setDataMain();
        lector.esProcesoDeVerificacion = false;
        mostrarImagen();
        //this.fingerprintImage.setIcon(dibujarHuella(lector.crearImagenHuella(sample)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        seeker = new javax.swing.JTextField();
        separatorSeeker = new javax.swing.JSeparator();
        iconSeeker = new javax.swing.JLabel();
        refresh = new javax.swing.JButton();
        panelPersonal = new javax.swing.JPanel();
        panelGeneralData = new javax.swing.JPanel();
        titlePanelGeneralData = new javax.swing.JLabel();
        userPhoto = userPhoto = new FotoPanel();
        userName = new javax.swing.JLabel();
        userJob = new javax.swing.JLabel();
        userDepartament = new javax.swing.JLabel();
        statusPersonal = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        panelGeneralData1 = new javax.swing.JPanel();
        titlePanelGeneralData1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panelTomarFoto = new javax.swing.JPanel();
        userPhoto1 = new javax.swing.JPanel();
        btnCapturaHuellas3 = new javax.swing.JButton();
        userPhoto2 = userPhoto2 = new FotoPanel();
        jPanel1 = new javax.swing.JPanel();
        fingerprintImage = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        btnPulgarDerecho = new javax.swing.JButton();
        btnIndiceDerecho = new javax.swing.JButton();
        btnMedio = new javax.swing.JButton();
        btnPulgarIzquierdo = new javax.swing.JButton();
        btnIndiceIzquierdo = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        back = new javax.swing.JButton();

        setBackground(new java.awt.Color(246, 249, 252));
        setMaximumSize(new java.awt.Dimension(1000, 600));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setPreferredSize(new java.awt.Dimension(1000, 600));

        title.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(51, 51, 51));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Captura de huellas digitales");

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

        refresh.setForeground(new java.awt.Color(51, 51, 51));
        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iRefresh-Dark.png"))); // NOI18N
        refresh.setBorder(null);
        refresh.setContentAreaFilled(false);
        refresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        panelPersonal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        statusPersonal.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        statusPersonal.setForeground(new java.awt.Color(51, 51, 51));
        statusPersonal.setText("Para empezar seleccione personal...");

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iFingerPrint-Dark.png"))); // NOI18N
        btnActualizar.setText("Reemplazar huellas digitales");
        btnActualizar.setBorder(null);
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

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
                            .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statusPersonal)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralDataLayout.createSequentialGroup()
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)))
                .addContainerGap(7, Short.MAX_VALUE))
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
                        .addComponent(userDepartament, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(statusPersonal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        panelPersonal.add(panelGeneralData, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 420, -1));

        panelGeneralData1.setBackground(new java.awt.Color(255, 255, 255));
        panelGeneralData1.setForeground(new java.awt.Color(255, 255, 255));

        titlePanelGeneralData1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        titlePanelGeneralData1.setForeground(new java.awt.Color(51, 51, 51));
        titlePanelGeneralData1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iUser-Dark-md.png"))); // NOI18N
        titlePanelGeneralData1.setText("Información a capturar");
        titlePanelGeneralData1.setToolTipText("");
        titlePanelGeneralData1.setIconTextGap(15);

        jSeparator1.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        panelTomarFoto.setBackground(new java.awt.Color(255, 255, 255));
        panelTomarFoto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout userPhoto1Layout = new javax.swing.GroupLayout(userPhoto1);
        userPhoto1.setLayout(userPhoto1Layout);
        userPhoto1Layout.setHorizontalGroup(
            userPhoto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        userPhoto1Layout.setVerticalGroup(
            userPhoto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
        );

        panelTomarFoto.add(userPhoto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 120, -1));

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
        panelTomarFoto.add(btnCapturaHuellas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 30, -1));

        userPhoto2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelTomarFoto.add(userPhoto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 123, 122));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fingerprintImage.setBackground(new java.awt.Color(214, 217, 223));
        fingerprintImage.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(214, 217, 223), 1, true));
        jPanel1.add(fingerprintImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 163, 163));

        jProgressBar1.setBorder(null);
        jPanel1.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 163, -1));

        btnPulgarDerecho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iFingerPrint-Dark.png"))); // NOI18N
        btnPulgarDerecho.setText("Pulgar derecho");
        btnPulgarDerecho.setBorder(null);
        btnPulgarDerecho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPulgarDerecho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPulgarDerechoMouseClicked(evt);
            }
        });
        jPanel1.add(btnPulgarDerecho, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 30));

        btnIndiceDerecho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iFingerPrint-Dark.png"))); // NOI18N
        btnIndiceDerecho.setText("Índice derecho");
        btnIndiceDerecho.setBorder(null);
        btnIndiceDerecho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIndiceDerecho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIndiceDerechoMouseClicked(evt);
            }
        });
        jPanel1.add(btnIndiceDerecho, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 190, 30));

        btnMedio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iFingerPrint-Dark.png"))); // NOI18N
        btnMedio.setText("Medio");
        btnMedio.setBorder(null);
        btnMedio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMedio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMedioMouseClicked(evt);
            }
        });
        jPanel1.add(btnMedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 190, 30));

        btnPulgarIzquierdo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iFingerPrint-Dark.png"))); // NOI18N
        btnPulgarIzquierdo.setText("Pulgar izquierdo");
        btnPulgarIzquierdo.setBorder(null);
        btnPulgarIzquierdo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPulgarIzquierdo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPulgarIzquierdoMouseClicked(evt);
            }
        });
        jPanel1.add(btnPulgarIzquierdo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 190, 30));

        btnIndiceIzquierdo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iFingerPrint-Dark.png"))); // NOI18N
        btnIndiceIzquierdo.setText("Índice izquierdo");
        btnIndiceIzquierdo.setBorder(null);
        btnIndiceIzquierdo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIndiceIzquierdo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIndiceIzquierdoMouseClicked(evt);
            }
        });
        jPanel1.add(btnIndiceIzquierdo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 190, 30));

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iUserAdd-Dark.png"))); // NOI18N
        btnRegistrar.setText("Guardar registro completo");
        btnRegistrar.setBorder(null);
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 200, 30));

        javax.swing.GroupLayout panelGeneralData1Layout = new javax.swing.GroupLayout(panelGeneralData1);
        panelGeneralData1.setLayout(panelGeneralData1Layout);
        panelGeneralData1Layout.setHorizontalGroup(
            panelGeneralData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralData1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
            .addGroup(panelGeneralData1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelGeneralData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeneralData1Layout.createSequentialGroup()
                        .addComponent(panelTomarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelGeneralData1Layout.createSequentialGroup()
                        .addComponent(titlePanelGeneralData1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panelGeneralData1Layout.setVerticalGroup(
            panelGeneralData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralData1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(titlePanelGeneralData1)
                .addGap(18, 18, 18)
                .addComponent(panelTomarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        panelPersonal.add(panelGeneralData1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 520, 450));

        jScrollPane1.setBorder(null);

        jTable1.setModel(table.getModel());
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        panelPersonal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 470));

        back.setBackground(new java.awt.Color(246, 249, 252));
        back.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        back.setForeground(new java.awt.Color(102, 102, 102));
        back.setText("<");
        back.setBorder(null);
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backMouseExited(evt);
            }
        });
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(654, 654, 654)
                .addComponent(refresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(iconSeeker)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seeker, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(separatorSeeker, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 102, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 969, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iconSeeker)
                            .addComponent(seeker, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addComponent(separatorSeeker, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(refresh))
                .addGap(28, 28, 28)
                .addComponent(back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );
    }// </editor-fold>//GEN-END:initComponents
//boton para capturar la imagen de la camara
    private void btnCapturaHuellas3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapturaHuellas3MouseClicked
        capturarYMostrarImagen();
    }//GEN-LAST:event_btnCapturaHuellas3MouseClicked

    private void btnCapturaHuellas3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapturaHuellas3MouseEntered
        btnCapturaHuellas3.setBackground(lStyle.getBtnseleccionado());
    }//GEN-LAST:event_btnCapturaHuellas3MouseEntered

    private void btnCapturaHuellas3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapturaHuellas3MouseExited
        btnCapturaHuellas3.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnCapturaHuellas3MouseExited

    private void seekerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_seekerKeyReleased
        String textoBusqueda = seeker.getText();
        //codigo para buscar
        if (textoBusqueda.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            // Aquí hacemos el filtrado sobre las columnas de nombre (0), apellido (1) y apellido materno (2)
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + textoBusqueda, 0, 1, 2));
        }
    }//GEN-LAST:event_seekerKeyReleased

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        table = userDAO.tablaPersonalPorDelegacion(user.getDeleg_clv());
        jTable1.setModel(table.getModel());
    }//GEN-LAST:event_refreshActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada != -1) { // Verifica que una fila esté realmente seleccionada
            // Obtener el modelo de la tabla
            int filaModelo = jTable1.convertRowIndexToModel(filaSeleccionada);
            TableModel modelo = jTable1.getModel();

            // Obtener el valor de la columna específica, por ejemplo, nombre (columna 0) y apellido (columna 1)
            String nombreCompleto = modelo.getValueAt(filaModelo, 0).toString() + " " + modelo.getValueAt(filaModelo, 1) + " " + modelo.getValueAt(filaModelo, 2);
            try {
                personal = personalDAO.getPersonalByNombreCompleto(nombreCompleto);
            } catch (IOException ex) {
                error(ex.getMessage());
            }
            //Codigo para cambiar lo que hay en el panel
            desplegarPersonal();
            back.setVisible(true);
            jScrollPane1.setVisible(false);
            panelGeneralData.setVisible(true);
        } else {
            System.out.println("No hay ninguna fila seleccionada.");
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        proceso("busqueda");
        back.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseEntered
        back.setBackground(new Color(246, 249, 252));
        back.setForeground(Color.BLUE);
    }//GEN-LAST:event_backMouseEntered

    private void backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseExited
        back.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_backMouseExited

    private void btnPulgarDerechoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPulgarDerechoMouseClicked
        btnPulgarDerecho.setBackground(lStyle.getBtnseleccionado());
        lector.iniciarEnrollmentPorDedo("indice derecho");
    }//GEN-LAST:event_btnPulgarDerechoMouseClicked

    private void btnIndiceDerechoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIndiceDerechoMouseClicked
        btnIndiceDerecho.setBackground(lStyle.getBtnseleccionado());
        lector.iniciarEnrollmentPorDedo("indice derecho");
    }//GEN-LAST:event_btnIndiceDerechoMouseClicked

    private void btnMedioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMedioMouseClicked
        btnMedio.setBackground(lStyle.getBtnseleccionado());
        lector.iniciarEnrollmentPorDedo("medio");
    }//GEN-LAST:event_btnMedioMouseClicked

    private void btnPulgarIzquierdoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPulgarIzquierdoMouseClicked
        btnPulgarIzquierdo.setBackground(lStyle.getBtnseleccionado());
        lector.iniciarEnrollmentPorDedo("pulgar izquierdo");
    }//GEN-LAST:event_btnPulgarIzquierdoMouseClicked

    private void btnIndiceIzquierdoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIndiceIzquierdoMouseClicked
        btnIndiceIzquierdo.setBackground(lStyle.getBtnseleccionado());
        lector.iniciarEnrollmentPorDedo("indice izquierdo");
    }//GEN-LAST:event_btnIndiceIzquierdoMouseClicked

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (!personalDAO.tieneBiometria(personal.getrFC())) {
            //el personal no tiene nda registrado
            byte[] foto = null;
            try {
                foto = camara.convertBufferedImageToBytes(personal.getFoto(), "png");
                personalDAO.guardarBiometricos(foto);
                limpiarUI();
                guardado();
            } catch (IOException | HuellaException | FotoException e) {
                error(e.getMessage());
            }
        } else {
            //el personal solova a actualizar las huellas
            try {
                personalDAO.reemplazarHuellas(personal);
                guardado();
                limpiarUI();
            } catch (HuellaException | IOException e) {
                error(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        btnPulgarDerecho.setEnabled(true);
        btnIndiceDerecho.setEnabled(true);
        btnMedio.setEnabled(true);
        btnPulgarIzquierdo.setEnabled(true);
        btnIndiceIzquierdo.setEnabled(true);
        btnRegistrar.setEnabled(true);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void mostrarImagen() {
        try {
            userPhoto1.setLayout(new java.awt.BorderLayout());
            userPhoto1.add(camara.getWebcamPanel(), BorderLayout.CENTER);
            userPhoto.revalidate();
        } catch (Exception e) {
            System.err.println("Error de camara " + e);
        }
    }

    private void capturarYMostrarImagen() {
        camara.capturarImagen();
        BufferedImage imagen = camara.getImage();
        if (imagen != null) {
            ((FotoPanel) userPhoto2).setImage(imagen);
            personal.setFoto(imagen);
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
                return btnPulgarDerecho;
            case "indice derecho":
                return btnIndiceDerecho;
            case "medio":
                return btnMedio;
            case "pulgar izquierdo":
                return btnPulgarIzquierdo;
            case "indice izquierdo":
                return btnIndiceIzquierdo;
            default:
                return null; // O lanza una excepción si es un caso inesperado
        }
    }

    public void setDataMain() {
        panelGeneralData1.setVisible(false);
        panelGeneralData.setVisible(false);
        sorter = new TableRowSorter<>(jTable1.getModel());
        jTable1.setRowSorter(sorter);

    }

    //metodo para confirmar visualmente que se guardo en base de datos
    public void guardado() {
        Guardado ok = new Guardado();
        ok.setVisible(true);
    }

    public void error(String mensaje) {
        Error err = new Error(mensaje);
        err.setVisible(true);
    }

    public void limpiarUI() throws IOException {
        btnPulgarDerecho.setBackground(new Color(214, 217, 223));
        btnIndiceDerecho.setBackground(new Color(214, 217, 223));
        btnMedio.setBackground(new Color(214, 217, 223));
        btnPulgarIzquierdo.setBackground(new Color(214, 217, 223));
        btnIndiceIzquierdo.setBackground(new Color(214, 217, 223));
    }

    private void desplegarPersonal() {
        //desplegar informacion del personal
        String nombreCompleto = personal.getNombre() + " " + personal.getApePaterno() + " " + personal.getApeMaterno();
        userName.setText(nombreCompleto);
        userJob.setText(personal.getrFC() + " | " + personal.getcURP());
        userDepartament.setText(personal.getPuesto());

        //mostrar status del personal
        if (personalDAO.tieneRegistro(personal.getrFC())) {
            if (personalDAO.tieneBiometria(personal.getrFC())) {

                //si el personal tiene biometria enronces actualizar la instancia de personal
                personalDAO.getBiometria(personal);
                if (personal.getFoto() != null) {
                    ((FotoPanel) userPhoto).setImage(personal.getFoto());
                } else {
                    try {
                        ((FotoPanel) userPhoto).setImage(ImageIO.read(getClass().getResource("/resources/icon/defaultPhoto.jpg")));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //el personal tiene registro en la base de datos y tiene biometria
                proceso("actualizacion");
            } else {
                //el personal tienen registro en la base de datos pero no tiene biometria
                proceso("registro");
            }
        } else {
            //el personal no tiene registro en la base de datos
            personalDAO.registrarPersonal(personal);
            proceso("registro");
        }
    }

    public void proceso(String opcion) {
        switch (opcion) {
            case "registro":
                statusPersonal.setText("Sin registro biometrico");
                statusPersonal.setForeground(lStyle.getTxtWarning());
                btnRegistrar.setEnabled(true);
                btnActualizar.setEnabled(false);
                panelGeneralData1.setVisible(true);
                panelTomarFoto.setVisible(true);
                seeker.setVisible(false);
                iconSeeker.setVisible(false);
                refresh.setVisible(false);
                separatorSeeker.setVisible(false);

                try {
                    ((FotoPanel) userPhoto).setImage(ImageIO.read(getClass().getResource("/resources/icon/defaultPhoto.jpg")));
                } catch (IOException ex) {
                    Logger.getLogger(vP_CapturaHuellas.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;

            case "actualizacion":
                statusPersonal.setText("El personal tiene registro completo");
                statusPersonal.setForeground(lStyle.getTxtSuccess());
                btnRegistrar.setEnabled(false);
                btnActualizar.setEnabled(true);
                panelGeneralData1.setVisible(true);
                panelTomarFoto.setVisible(false);
                seeker.setVisible(false);
                iconSeeker.setVisible(false);
                refresh.setVisible(false);
                separatorSeeker.setVisible(false);
                btnPulgarDerecho.setEnabled(false);
                btnIndiceDerecho.setEnabled(false);
                btnMedio.setEnabled(false);
                btnPulgarIzquierdo.setEnabled(false);
                btnIndiceIzquierdo.setEnabled(false);
                break;
            case "busqueda":
                jScrollPane1.setVisible(true);
                panelGeneralData.setVisible(false);
                panelGeneralData1.setVisible(false);
                seeker.setVisible(true);
                iconSeeker.setVisible(true);
                refresh.setVisible(true);
                separatorSeeker.setVisible(true);
                break;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCapturaHuellas3;
    private javax.swing.JButton btnIndiceDerecho;
    private javax.swing.JButton btnIndiceIzquierdo;
    private javax.swing.JButton btnMedio;
    private javax.swing.JButton btnPulgarDerecho;
    private javax.swing.JButton btnPulgarIzquierdo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel fingerprintImage;
    private javax.swing.JLabel iconSeeker;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panelGeneralData;
    private javax.swing.JPanel panelGeneralData1;
    private javax.swing.JPanel panelPersonal;
    private javax.swing.JPanel panelTomarFoto;
    private javax.swing.JButton refresh;
    private javax.swing.JTextField seeker;
    private javax.swing.JSeparator separatorSeeker;
    private javax.swing.JLabel statusPersonal;
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
