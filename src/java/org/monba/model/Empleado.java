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
    private byte[] expediente;
    private String tipo_vehiculo;
    private String num_placa;
    private Persona Persona;
    private Usuario Usuario;

    public Empleado() {
    }

    public Empleado(int id_empleado, String codigo, String fecha_ingreso, String puesto, String correo_electronico, int estatus, String comentario, String nombre_expediente, byte[] expediente, String tipo_vehiculo, String num_placa, Persona Persona, Usuario Usuario) {
        this.id_empleado = id_empleado;
        this.codigo = codigo;
        this.fecha_ingreso = fecha_ingreso;
        this.puesto = puesto;
        this.correo_electronico = correo_electronico;
        this.estatus = estatus;
        this.comentario = comentario;
        this.nombre_expediente = nombre_expediente;
        this.expediente = expediente;
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

    public byte[] getExpediente() {
        return expediente;
    }

    public void setExpediente(byte[] expediente) {
        this.expediente = expediente;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado{");
        sb.append("id_empleado:").append(id_empleado);
        sb.append(", codigo:").append(codigo);
        sb.append(", fecha_ingreso:").append(fecha_ingreso);
        sb.append(", puesto:").append(puesto);
        sb.append(", correo_electronico:").append(correo_electronico);
        sb.append(", estatus:").append(estatus);
        sb.append(", comentario:").append(comentario);
        sb.append(", nombre_expediente:").append(nombre_expediente);
        sb.append(", expediente:").append(expediente);
        sb.append(", tipo_vehiculo:").append(tipo_vehiculo);
        sb.append(", num_placa:").append(num_placa);
        sb.append(", Persona:").append(Persona);
        sb.append(", Usuario:").append(Usuario);
        sb.append('}');
        return sb.toString();
    }
    
    
}
