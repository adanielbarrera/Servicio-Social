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
    private BufferedImage foto;

    public static Personal getInstance(){
        if(instance == null){
            instance = new Personal();
        }
        return instance;
    }
    public Personal() {
    }
    
    
    

    public Personal(String nombre, String apePaterno, String apeMaterno, String rFC, String cURP, String puesto, BufferedImage foto) {
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.rFC = rFC;
        this.cURP = cURP;
        this.puesto = puesto;
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
    
    
    
}
