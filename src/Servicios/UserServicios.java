/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import DAOs.UserDAO;
import models.Usuario;

/**
 *
 * @author SSM01
 */
public class UserServicios {

    private UserDAO userDAO;
    private String nombre;

    public UserServicios() {
        this.userDAO = new UserDAO();
    }

    //metodo que valida el inicio de sesion
    public boolean iniciarSesion(String user, String password) {
        return userDAO.validarCredenciales(user, password);
    }

    public Usuario buscarUsuario(String user) {
        return userDAO.buscarUsuario(user);
    }
}
