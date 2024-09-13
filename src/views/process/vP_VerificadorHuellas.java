/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views.process;

import controllers.LectorHuella;
import java.awt.Image;
import javax.swing.ImageIcon;
import models.Personal;
import views.Error;

/**
 *
 * @author juancarloscastillocarrillo
 */
public class vP_VerificadorHuellas extends javax.swing.JPanel {

    /**
     * Creates new form vP_CapturaHuellas
     */
    private LectorHuella lector = LectorHuella.getInstance();
    private Personal personal = Personal.getInstance();

    public vP_VerificadorHuellas() {
        initComponents();
        lector.esProcesoDeVerificacion = true;
        lector.setVistaVerif(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        imagenHuella = new javax.swing.JLabel();
        tarjetaPersonal = new javax.swing.JPanel();
        fotoPersonal = fotoPersonal = new FotoPanel();
        nombre = new javax.swing.JLabel();
        curp = new javax.swing.JLabel();
        rfc = new javax.swing.JLabel();
        delegacion = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(900, 500));
        setMinimumSize(new java.awt.Dimension(900, 500));
        setPreferredSize(new java.awt.Dimension(900, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(51, 51, 51));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Verificador de huellas digitales");
        add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 888, -1));
        add(imagenHuella, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 130, 160));

        tarjetaPersonal.setBackground(new java.awt.Color(255, 255, 255));
        tarjetaPersonal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tarjetaPersonal.add(fotoPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 100, 110));

        nombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nombre.setText("Nombre:");
        tarjetaPersonal.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 190, -1));

        curp.setText("CURP: ");
        tarjetaPersonal.add(curp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        rfc.setText("RFC: ");
        tarjetaPersonal.add(rfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        delegacion.setText("Delegación: ");
        tarjetaPersonal.add(delegacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        add(tarjetaPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, 290, 360));
    }// </editor-fold>//GEN-END:initComponents

    public void actualizarJLabelConHuella(Image image) {
        imagenHuella.setIcon(new ImageIcon(
                image.getScaledInstance(imagenHuella.getWidth(), imagenHuella.getHeight(), Image.SCALE_DEFAULT)));
        repaint();
    }

    public void actualizarInfo(Personal personal) {
        if (personal != null) {
            nombre.setText("Nombre: " + personal.getNombre() + " " + personal.getApePaterno() + " " + personal.getApeMaterno());
            curp.setText("CURP: " + personal.getcURP());
            rfc.setText("RFC: " + personal.getrFC());
            ((FotoPanel)fotoPersonal).setImage(personal.getFoto());

            //seguir mostrando informacion
        } else {
            Error err = new Error("Personal no encontrado");
            err.setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel curp;
    private javax.swing.JLabel delegacion;
    private javax.swing.JPanel fotoPersonal;
    private javax.swing.JLabel imagenHuella;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel rfc;
    private javax.swing.JPanel tarjetaPersonal;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
