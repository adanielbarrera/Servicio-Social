/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.*;

/**
 *
 * @author SSM01
 */
public class Confirmacion extends JDialog {

    private boolean confirmado = false;

    public Confirmacion(Frame parent) {
        super(parent, "Confirmar Accion", true); //modal
        
        FlatLightLaf.setup();
        this.setUndecorated(true);
        this.setSize(300,100);
        this.setBackground(new Color(255,255,255));

        //Configuracion del panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel("¿Estas seguro de querer continuar?"), BorderLayout.CENTER);
        

        //botones
        JButton btnSi = new JButton("Si");
        JButton btnNo = new JButton("No");

        btnSi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmado = true;
                dispose();
            }
        });
        btnNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmado = false;
                dispose();
            }
        });

        JPanel botonesPanel = new JPanel();
        botonesPanel.add(btnSi);
        botonesPanel.add(btnNo);

        panel.add(botonesPanel, BorderLayout.SOUTH);

        setContentPane(panel);
        //pack();
        setLocationRelativeTo(parent);
    }

    public boolean isConfirmed() {
        return confirmado;
    }
}
