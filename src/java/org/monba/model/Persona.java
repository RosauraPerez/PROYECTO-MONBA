/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.monba.model;

/**
 *
 * @author perez
 */
public class Persona {
    private int id_persona;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String genero;
    private String fecha_nacimiento;
    private String rfc;
    private String curp;
    private String domicilio;
    private String codigo_postal;
    private String ciudad;
    private String estado;
    private String telefono;
    private String foto;
    private String numero_licencia;
    private String tipo_licencia;

    public Persona() {
    }

    public Persona(int id_persona, String nombre, String apellido_paterno, String apellido_materno, String genero, String fecha_nacimiento, String rfc, String curp, String domicilio, String codigo_postal, String ciudad, String estado, String telefono, String foto, String numero_licencia, String tipo_licencia) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.genero = genero;
        this.fecha_nacimiento = fecha_nacimiento;
        this.rfc = rfc;
        this.curp = curp;
        this.domicilio = domicilio;
        this.codigo_postal = codigo_postal;
        this.ciudad = ciudad;
        this.estado = estado;
        this.telefono = telefono;
        this.foto = foto;
        this.numero_licencia = numero_licencia;
        this.tipo_licencia = tipo_licencia;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNumero_licencia() {
        return numero_licencia;
    }

    public void setNumero_licencia(String numero_licencia) {
        this.numero_licencia = numero_licencia;
    }

    public String getTipo_licencia() {
        return tipo_licencia;
    }

    public void setTipo_licencia(String tipo_licencia) {
        this.tipo_licencia = tipo_licencia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("id_persona:").append(id_persona);
        sb.append(", nombre:").append(nombre);
        sb.append(", apellido_paterno:").append(apellido_paterno);
        sb.append(", apellido_materno:").append(apellido_materno);
        sb.append(", genero:").append(genero);
        sb.append(", fecha_nacimiento:").append(fecha_nacimiento);
        sb.append(", rfc:").append(rfc);
        sb.append(", curp:").append(curp);
        sb.append(", domicilio:").append(domicilio);
        sb.append(", codigo_postal:").append(codigo_postal);
        sb.append(", ciudad:").append(ciudad);
        sb.append(", estado:").append(estado);
        sb.append(", telefono:").append(telefono);
        sb.append(", foto:").append(foto);
        sb.append(", numero_licencia:").append(numero_licencia);
        sb.append(", tipo_licencia:").append(tipo_licencia);
        sb.append('}');
        return sb.toString();
    }
    
    
}
