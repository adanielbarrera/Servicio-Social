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
public class Usuario {

    private static Usuario instance;
    private String nombre;
    private String puesto;
    private String lugarTrabajo;
    private int deleg_clv;
    private BufferedImage fotoUsuario; //puede o no tener fot disponible

    public Usuario(String nombre, String puesto, String lugarTrabajo, int deleg_clv) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.lugarTrabajo = lugarTrabajo;
        this.deleg_clv = deleg_clv;
        this.fotoUsuario = null;
    }

    public static Usuario getInstance(String nombre, String puesto, String lugarTrabajo, int deleg_clv) {
        if (instance == null) {
            instance = new Usuario(nombre, puesto, lugarTrabajo, deleg_clv);
        }
        return instance;
    }

    public static Usuario getInstance() {
        return instance;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarTrabajo(String lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }

    public BufferedImage getFoto() {
        return fotoUsuario;
    }

    public void setFoto(BufferedImage foto) {
        this.fotoUsuario = foto;
    }

    public int getDeleg_clv() {
        return deleg_clv;
    }

    public void setDeleg_clv(int deleg_clv) {
        this.deleg_clv = deleg_clv;
    }

    public BufferedImage getFotoUsuario() {
        return fotoUsuario;
    }

    public void setFotoUsuario(BufferedImage fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }
    
    

}
