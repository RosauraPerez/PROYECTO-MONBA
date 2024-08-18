package org.monba.model;

public class Manifiesto {
    private int id_manifiesto;
    private String num_manifiesto;
    private String nombre_manifiesto;
    private byte[] pdf_manifiesto;
    private String fecha_embarque;
    private String fecha_recepcion;

    public Manifiesto() {
        
    }

    public Manifiesto(int id_manifiesto, String num_manifiesto, String nombre_manifiesto, byte[] pdf_manifiesto, String fecha_embarque, String fecha_recepcion) {
        this.id_manifiesto = id_manifiesto;
        this.num_manifiesto = num_manifiesto;
        this.nombre_manifiesto = nombre_manifiesto;
        this.pdf_manifiesto = pdf_manifiesto;
        this.fecha_embarque = fecha_embarque;
        this.fecha_recepcion = fecha_recepcion;
    }

    public Manifiesto(String num_manifiesto, String nombre_manifiesto, byte[] pdf_manifiesto, String fecha_embarque, String fecha_recepcion) {
        this.num_manifiesto = num_manifiesto;
        this.nombre_manifiesto = nombre_manifiesto;
        this.pdf_manifiesto = pdf_manifiesto;
        this.fecha_embarque = fecha_embarque;
        this.fecha_recepcion = fecha_recepcion;
    }

    public int getId_manifiesto() {
        return id_manifiesto;
    }

    public void setId_manifiesto(int id_manifiesto) {
        this.id_manifiesto = id_manifiesto;
    }

    public String getNum_manifiesto() {
        return num_manifiesto;
    }

    public void setNum_manifiesto(String num_manifiesto) {
        this.num_manifiesto = num_manifiesto;
    }

    public String getNombre_manifiesto() {
        return nombre_manifiesto;
    }

    public void setNombre_manifiesto(String nombre_manifiesto) {
        this.nombre_manifiesto = nombre_manifiesto;
    }

    public byte[] getPdf_manifiesto() {
        return pdf_manifiesto;
    }

    public void setPdf_manifiesto(byte[] pdf_manifiesto) {
        this.pdf_manifiesto = pdf_manifiesto;
    }

    public String getFecha_embarque() {
        return fecha_embarque;
    }

    public void setFecha_embarque(String fecha_embarque) {
        this.fecha_embarque = fecha_embarque;
    }

    public String getFecha_recepcion() {
        return fecha_recepcion;
    }

    public void setFecha_recepcion(String fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Manifiesto{");
        sb.append("id_manifiesto:").append(id_manifiesto);
        sb.append(", num_manifiesto:").append(num_manifiesto);
        sb.append(", nombre_manifiesto:").append(nombre_manifiesto);
        sb.append(", pdf_manifiesto:").append(pdf_manifiesto);
        sb.append(", fecha_embarque:").append(fecha_embarque);
        sb.append(", fecha_recepcion:").append(fecha_recepcion);
        sb.append('}');
        return sb.toString();
    }
}