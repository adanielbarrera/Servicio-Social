package views.process;

import libraries.lStyle;

/**
 *
 * @author juancarloscastillocarrillo
 */
public class vP_CapturaHuellas extends javax.swing.JPanel {

    lStyle lStyle = new lStyle();
    
    public vP_CapturaHuellas() {
        initComponents();
        setDataMain();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        title = new javax.swing.JLabel();
        panelGeneralData = new javax.swing.JPanel();
        titlePanelGeneralData = new javax.swing.JLabel();
        userPhoto = new javax.swing.JPanel();
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
        userPhoto2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        btnCapturaHuellas2 = new javax.swing.JButton();
        btnCapturaHuellas4 = new javax.swing.JButton();
        btnCapturaHuellas5 = new javax.swing.JButton();
        btnCapturaHuellas6 = new javax.swing.JButton();
        btnCapturaHuellas7 = new javax.swing.JButton();

        jTable1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "RFC", "CURP", "Nombre", "Puesto"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

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
        userName.setText("Juan Carlos Castillo Carrillo");
        userName.setMaximumSize(new java.awt.Dimension(275, 14));
        userName.setMinimumSize(new java.awt.Dimension(275, 14));
        userName.setPreferredSize(new java.awt.Dimension(275, 14));

        userJob.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        userJob.setForeground(new java.awt.Color(51, 51, 51));
        userJob.setText("CACJ930802AV5 | CACJ930802HMCSRN08");
        userJob.setMaximumSize(new java.awt.Dimension(275, 14));
        userJob.setMinimumSize(new java.awt.Dimension(275, 14));
        userJob.setPreferredSize(new java.awt.Dimension(275, 14));

        userDepartament.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        userDepartament.setForeground(new java.awt.Color(51, 51, 51));
        userDepartament.setText("Jefe A de Proyecto");
        userDepartament.setMaximumSize(new java.awt.Dimension(275, 14));
        userDepartament.setMinimumSize(new java.awt.Dimension(275, 14));
        userDepartament.setPreferredSize(new java.awt.Dimension(275, 14));

        btnCapturaHuellas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCapturaHuellas.setForeground(new java.awt.Color(51, 51, 51));
        btnCapturaHuellas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iCamera-Dark.png"))); // NOI18N
        btnCapturaHuellas.setText("Registro completo");
        btnCapturaHuellas.setBorder(null);
        btnCapturaHuellas.setContentAreaFilled(false);
        btnCapturaHuellas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapturaHuellas.setFocusable(false);
        btnCapturaHuellas.setIconTextGap(10);
        btnCapturaHuellas.setMaximumSize(new java.awt.Dimension(190, 28));
        btnCapturaHuellas.setMinimumSize(new java.awt.Dimension(190, 28));
        btnCapturaHuellas.setOpaque(true);
        btnCapturaHuellas.setPreferredSize(new java.awt.Dimension(190, 28));

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

        javax.swing.GroupLayout userPhoto2Layout = new javax.swing.GroupLayout(userPhoto2);
        userPhoto2.setLayout(userPhoto2Layout);
        userPhoto2Layout.setHorizontalGroup(
            userPhoto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 165, Short.MAX_VALUE)
        );
        userPhoto2Layout.setVerticalGroup(
            userPhoto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jSeparator1.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        btnCapturaHuellas2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCapturaHuellas2.setForeground(new java.awt.Color(51, 51, 51));
        btnCapturaHuellas2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iFingerPrint-Dark.png"))); // NOI18N
        btnCapturaHuellas2.setText("Pulgar derecho");
        btnCapturaHuellas2.setBorder(null);
        btnCapturaHuellas2.setContentAreaFilled(false);
        btnCapturaHuellas2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapturaHuellas2.setFocusable(false);
        btnCapturaHuellas2.setIconTextGap(10);
        btnCapturaHuellas2.setMaximumSize(new java.awt.Dimension(190, 28));
        btnCapturaHuellas2.setMinimumSize(new java.awt.Dimension(190, 28));
        btnCapturaHuellas2.setOpaque(true);
        btnCapturaHuellas2.setPreferredSize(new java.awt.Dimension(190, 28));

        btnCapturaHuellas4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCapturaHuellas4.setForeground(new java.awt.Color(51, 51, 51));
        btnCapturaHuellas4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iFingerPrint-Dark.png"))); // NOI18N
        btnCapturaHuellas4.setText("Índice derecho");
        btnCapturaHuellas4.setBorder(null);
        btnCapturaHuellas4.setContentAreaFilled(false);
        btnCapturaHuellas4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapturaHuellas4.setFocusable(false);
        btnCapturaHuellas4.setIconTextGap(10);
        btnCapturaHuellas4.setMaximumSize(new java.awt.Dimension(190, 28));
        btnCapturaHuellas4.setMinimumSize(new java.awt.Dimension(190, 28));
        btnCapturaHuellas4.setOpaque(true);
        btnCapturaHuellas4.setPreferredSize(new java.awt.Dimension(190, 28));

        btnCapturaHuellas5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCapturaHuellas5.setForeground(new java.awt.Color(51, 51, 51));
        btnCapturaHuellas5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iFingerPrint-Dark.png"))); // NOI18N
        btnCapturaHuellas5.setText("Medio derecho");
        btnCapturaHuellas5.setBorder(null);
        btnCapturaHuellas5.setContentAreaFilled(false);
        btnCapturaHuellas5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapturaHuellas5.setFocusable(false);
        btnCapturaHuellas5.setIconTextGap(10);
        btnCapturaHuellas5.setMaximumSize(new java.awt.Dimension(190, 28));
        btnCapturaHuellas5.setMinimumSize(new java.awt.Dimension(190, 28));
        btnCapturaHuellas5.setOpaque(true);
        btnCapturaHuellas5.setPreferredSize(new java.awt.Dimension(190, 28));

        btnCapturaHuellas6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCapturaHuellas6.setForeground(new java.awt.Color(51, 51, 51));
        btnCapturaHuellas6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iFingerPrint-Dark.png"))); // NOI18N
        btnCapturaHuellas6.setText("Pulgar izquierdo");
        btnCapturaHuellas6.setBorder(null);
        btnCapturaHuellas6.setContentAreaFilled(false);
        btnCapturaHuellas6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapturaHuellas6.setFocusable(false);
        btnCapturaHuellas6.setIconTextGap(10);
        btnCapturaHuellas6.setMaximumSize(new java.awt.Dimension(190, 28));
        btnCapturaHuellas6.setMinimumSize(new java.awt.Dimension(190, 28));
        btnCapturaHuellas6.setOpaque(true);
        btnCapturaHuellas6.setPreferredSize(new java.awt.Dimension(190, 28));

        btnCapturaHuellas7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCapturaHuellas7.setForeground(new java.awt.Color(51, 51, 51));
        btnCapturaHuellas7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/iFingerPrint-Dark.png"))); // NOI18N
        btnCapturaHuellas7.setText("Índice izquierdo");
        btnCapturaHuellas7.setBorder(null);
        btnCapturaHuellas7.setContentAreaFilled(false);
        btnCapturaHuellas7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapturaHuellas7.setFocusable(false);
        btnCapturaHuellas7.setIconTextGap(10);
        btnCapturaHuellas7.setMaximumSize(new java.awt.Dimension(190, 28));
        btnCapturaHuellas7.setMinimumSize(new java.awt.Dimension(190, 28));
        btnCapturaHuellas7.setOpaque(true);
        btnCapturaHuellas7.setPreferredSize(new java.awt.Dimension(190, 28));

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
                            .addComponent(btnCapturaHuellas7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCapturaHuellas6, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCapturaHuellas5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCapturaHuellas4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCapturaHuellas2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelGeneralData1Layout.createSequentialGroup()
                        .addGroup(panelGeneralData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titlePanelGeneralData1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelGeneralData1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(userPhoto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCapturaHuellas3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(userPhoto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
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
                .addComponent(btnCapturaHuellas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCapturaHuellas4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCapturaHuellas5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCapturaHuellas6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCapturaHuellas7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelGeneralData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panelGeneralData1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(741, 741, 741)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(separatorSeeker, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(iconSeeker)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(seeker, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                .addGap(153, 153, 153)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelGeneralData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelGeneralData1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setDataMain() {
        System.out.println("holi");
        btnCapturaHuellas.setBackground(lStyle.getBgInfo());
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapturaHuellas;
    private javax.swing.JButton btnCapturaHuellas1;
    private javax.swing.JButton btnCapturaHuellas2;
    private javax.swing.JButton btnCapturaHuellas3;
    private javax.swing.JButton btnCapturaHuellas4;
    private javax.swing.JButton btnCapturaHuellas5;
    private javax.swing.JButton btnCapturaHuellas6;
    private javax.swing.JButton btnCapturaHuellas7;
    private javax.swing.JLabel iconSeeker;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
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
