/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.monba.model;

/**
 *
 * @author perez
 */
public class Empleado {
    private int id_empleado;
    private String codigo;
    private String fecha_ingreso;
    private String puesto;
    private String correo_electronico;
    private int estatus;
    private String comentario;
    private String nombre_expediente;
    private String expediente;
    private String nombre_nomina;
    private String pdf_nomina;
    private String nombre_alta;
    private String pdf_alta;
    private String nombre_vacaciones;
    private String pdf_vacaciones;
    private String tipo_vehiculo;
    private String num_placa;
    private Persona Persona;
    private Usuario Usuario;

    public Empleado() {
    }

    public Empleado(int id_empleado, String codigo, String fecha_ingreso, String puesto, String correo_electronico, int estatus, String comentario, String nombre_expediente, String expediente, String nombre_nomina, String pdf_nomina, String nombre_alta, String pdf_alta, String nombre_vacaciones, String pdf_vacaciones, String tipo_vehiculo, String num_placa, Persona Persona, Usuario Usuario) {
        this.id_empleado = id_empleado;
        this.codigo = codigo;
        this.fecha_ingreso = fecha_ingreso;
        this.puesto = puesto;
        this.correo_electronico = correo_electronico;
        this.estatus = estatus;
        this.comentario = comentario;
        this.nombre_expediente = nombre_expediente;
        this.expediente = expediente;
        this.nombre_nomina = nombre_nomina;
        this.pdf_nomina = pdf_nomina;
        this.nombre_alta = nombre_alta;
        this.pdf_alta = pdf_alta;
        this.nombre_vacaciones = nombre_vacaciones;
        this.pdf_vacaciones = pdf_vacaciones;
        this.tipo_vehiculo = tipo_vehiculo;
        this.num_placa = num_placa;
        this.Persona = Persona;
        this.Usuario = Usuario;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getNombre_expediente() {
        return nombre_expediente;
    }

    public void setNombre_expediente(String nombre_expediente) {
        this.nombre_expediente = nombre_expediente;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public String getNombre_nomina() {
        return nombre_nomina;
    }

    public void setNombre_nomina(String nombre_nomina) {
        this.nombre_nomina = nombre_nomina;
    }

    public String getPdf_nomina() {
        return pdf_nomina;
    }

    public void setPdf_nomina(String pdf_nomina) {
        this.pdf_nomina = pdf_nomina;
    }

    public String getNombre_alta() {
        return nombre_alta;
    }

    public void setNombre_alta(String nombre_alta) {
        this.nombre_alta = nombre_alta;
    }

    public String getPdf_alta() {
        return pdf_alta;
    }

    public void setPdf_alta(String pdf_alta) {
        this.pdf_alta = pdf_alta;
    }

    public String getNombre_vacaciones() {
        return nombre_vacaciones;
    }

    public void setNombre_vacaciones(String nombre_vacaciones) {
        this.nombre_vacaciones = nombre_vacaciones;
    }

    public String getPdf_vacaciones() {
        return pdf_vacaciones;
    }

    public void setPdf_vacaciones(String pdf_vacaciones) {
        this.pdf_vacaciones = pdf_vacaciones;
    }

    public String getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setTipo_vehiculo(String tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }

    public String getNum_placa() {
        return num_placa;
    }

    public void setNum_placa(String num_placa) {
        this.num_placa = num_placa;
    }

    public Persona getPersona() {
        return Persona;
    }

    public void setPersona(Persona Persona) {
        this.Persona = Persona;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    
}
