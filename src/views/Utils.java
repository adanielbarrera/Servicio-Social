/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;
import java.awt.Container;
import javax.swing.*;
/**
 *
 * @author SSM01
 */
public class Utils {
    public static JFrame getFrame(JPanel panel) {
        Container parent = panel.getParent();
        while (parent != null && !(parent instanceof JFrame)) {
            parent = parent.getParent();
        }
        return (JFrame) parent;
    }
}
