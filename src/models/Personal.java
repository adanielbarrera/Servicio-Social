/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.awt.image.BufferedImage;

/**
 *
 * @author SSM01
 */
public class Personal {

    private static Personal instance;
    private String nombre;
    private String apePaterno;
    private String apeMaterno;
    private String rFC;
    private String cURP;
    private String puesto;
    private int id;
    private BufferedImage foto;
    private byte[] huella1;
    private byte[] huella2;
    private byte[] huella3;
    private byte[] huella4;
    private byte[] huella5;

    public static Personal getInstance() {
        if (instance == null) {
            instance = new Personal();
        }
        return instance;
    }

    public Personal() {
    }

    public Personal(String nombre, String apePaterno, String apeMaterno, String rFC, String cURP, String puesto, BufferedImage foto, int id) {
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.rFC = rFC;
        this.cURP = cURP;
        this.puesto = puesto;
        this.id = id;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public String getrFC() {
        return rFC;
    }

    public void setrFC(String rFC) {
        this.rFC = rFC;
    }

    public String getcURP() {
        return cURP;
    }

    public void setcURP(String cURP) {
        this.cURP = cURP;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public BufferedImage getFoto() {
        return foto;
    }

    public void setFoto(BufferedImage foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getHuella1() {
        return huella1;
    }

    public void setHuella1(byte[] huella1) {
        this.huella1 = huella1;
    }

    public byte[] getHuella2() {
        return huella2;
    }

    public void setHuella2(byte[] huella2) {
        this.huella2 = huella2;
    }

    public byte[] getHuella3() {
        return huella3;
    }

    public void setHuella3(byte[] huella3) {
        this.huella3 = huella3;
    }

    public byte[] getHuella4() {
        return huella4;
    }

    public void setHuella4(byte[] huella4) {
        this.huella4 = huella4;
    }

    public byte[] getHuella5() {
        return huella5;
    }

    public void setHuella5(byte[] huella5) {
        this.huella5 = huella5;
    }

}
