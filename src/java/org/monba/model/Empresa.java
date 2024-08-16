package org.monba.model;

public class Empresa {
    private int id_empresa;
    private String nombre;
    private String domicilio;
    private String colonia;
    private String codigo_postal;
    private String ciudad;
    private String estado;
    private String numero_autorizacion;
    private String telefono;
    private String correo;
    private String rfc;
    private String director;
    private String rol;
    private int estatus;

    public Empresa() {
        
    }

    public Empresa(int id_empresa, String nombre, String domicilio, String colonia, String codigo_postal, String ciudad, String estado, String num_autorizacion, String telefono, String correo, String rfc, String director, String rol, int estatus) {
        this.id_empresa = id_empresa;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.colonia = colonia;
        this.codigo_postal = codigo_postal;
        this.ciudad = ciudad;
        this.estado = estado;
        this.numero_autorizacion = num_autorizacion;
        this.telefono = telefono;
        this.correo = correo;
        this.rfc = rfc;
        this.director = director;
        this.rol = rol;
        this.estatus = estatus;
    }

    public Empresa(String nombre, String domicilio, String colonia, String codigo_postal, String ciudad, String estado, String num_autorizacion, String telefono, String correo, String rfc, String director, String rol, int estatus) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.colonia = colonia;
        this.codigo_postal = codigo_postal;
        this.ciudad = ciudad;
        this.estado = estado;
        this.numero_autorizacion = num_autorizacion;
        this.telefono = telefono;
        this.correo = correo;
        this.rfc = rfc;
        this.director = director;
        this.rol = rol;
        this.estatus = estatus;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
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

    public String getNum_autorizacion() {
        return numero_autorizacion;
    }

    public void setNum_autorizacion(String num_autorizacion) {
        this.numero_autorizacion = num_autorizacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empresa{");
        sb.append("id_empresa:").append(id_empresa);
        sb.append(", nombre:").append(nombre);
        sb.append(", domicilio:").append(domicilio);
        sb.append(", colonia:").append(colonia);
        sb.append(", codigo_postal:").append(codigo_postal);
        sb.append(", ciudad:").append(ciudad);
        sb.append(", estado:").append(estado);
        sb.append(", num_autorizacion:").append(numero_autorizacion);
        sb.append(", telefono:").append(telefono);
        sb.append(", correo:").append(correo);
        sb.append(", rfc:").append(rfc);
        sb.append(", director:").append(director);
        sb.append(", rol:").append(rol);
        sb.append(", estatus:").append(estatus);
        sb.append('}');
        return sb.toString();
    }

    
}
