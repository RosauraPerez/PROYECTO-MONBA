/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.monba.model;

/**
 *
 * @author perez
 */
public class Usuario {
    private int id_usuario;
    private String nombre_usuario;
    private String contrasenia;
    private String rol;
    private String token;

    public Usuario() {
    }

    public Usuario(int id_usuario, String nombre_usuario, String contrasenia, String rol, String token) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.token = token;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{");
        sb.append("id_usuario:").append(id_usuario);
        sb.append(", nombre_usuario:").append(nombre_usuario);
        sb.append(", contrasenia:").append(contrasenia);
        sb.append(", rol:").append(rol);
        sb.append(", token:").append(token);
        sb.append('}');
        return sb.toString();
    }
    
    
}
