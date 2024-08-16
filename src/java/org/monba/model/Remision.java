package org.monba.model;

public class Remision {
    private int id_remision;
    private String residuo;
    private float cantidad;
    private String unidad;
    private String tipo_contenedor;
    private String volumen;
    private String empresa_cliente;
    private String empresa_destino;
    private String fecha;
    private int estatus;
    private Empleado Empleado;
    private Empresa Empresa_gen;
    private Empresa Empresa_des;
    private Manifiesto Manifiesto;

    public Remision() {
        
    }

    public Remision(int id_remision, String residuo, float cantidad, String unidad, String tipo_contenedor, String volumen, String empresa_cliente, String empresa_destino, String fecha, int estatus, Empleado Empleado, Empresa Empresa_gen, Empresa Empresa_des, Manifiesto Manifiesto) {
        this.id_remision = id_remision;
        this.residuo = residuo;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.tipo_contenedor = tipo_contenedor;
        this.volumen = volumen;
        this.empresa_cliente = empresa_cliente;
        this.empresa_destino = empresa_destino;
        this.fecha = fecha;
        this.estatus = estatus;
        this.Empleado = Empleado;
        this.Empresa_gen = Empresa_gen;
        this.Empresa_des = Empresa_des;
        this.Manifiesto = Manifiesto;
    }

    public Remision(int id_remision, String residuo, float cantidad, String unidad, String tipo_contenedor, String volumen, String empresa_cliente, String empresa_destino, String fecha, int estatus, Empleado Empleado, Empresa Empresa_gen, Empresa Empresa_des) {
        this.id_remision = id_remision;
        this.residuo = residuo;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.tipo_contenedor = tipo_contenedor;
        this.volumen = volumen;
        this.empresa_cliente = empresa_cliente;
        this.empresa_destino = empresa_destino;
        this.fecha = fecha;
        this.estatus = estatus;
        this.Empleado = Empleado;
        this.Empresa_gen = Empresa_gen;
        this.Empresa_des = Empresa_des;
    }

    public Remision(String residuo, float cantidad, String unidad, String tipo_contenedor, String volumen, String empresa_cliente, String empresa_destino, String fecha, int estatus, Empleado Empleado, Empresa Empresa_gen, Empresa Empresa_des, Manifiesto Manifiesto) {
        this.residuo = residuo;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.tipo_contenedor = tipo_contenedor;
        this.volumen = volumen;
        this.empresa_cliente = empresa_cliente;
        this.empresa_destino = empresa_destino;
        this.fecha = fecha;
        this.estatus = estatus;
        this.Empleado = Empleado;
        this.Empresa_gen = Empresa_gen;
        this.Empresa_des = Empresa_des;
        this.Manifiesto = Manifiesto;
    }

    public Remision(String residuo, float cantidad, String unidad, String tipo_contenedor, String volumen, String empresa_cliente, String empresa_destino, String fecha, int estatus, Empleado Empleado, Empresa Empresa_gen, Empresa Empresa_des) {
        this.residuo = residuo;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.tipo_contenedor = tipo_contenedor;
        this.volumen = volumen;
        this.empresa_cliente = empresa_cliente;
        this.empresa_destino = empresa_destino;
        this.fecha = fecha;
        this.estatus = estatus;
        this.Empleado = Empleado;
        this.Empresa_gen = Empresa_gen;
        this.Empresa_des = Empresa_des;
    }

    public int getId_remision() {
        return id_remision;
    }

    public void setId_remision(int id_remision) {
        this.id_remision = id_remision;
    }

    public String getResiduo() {
        return residuo;
    }

    public void setResiduo(String residuo) {
        this.residuo = residuo;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getTipo_contenedor() {
        return tipo_contenedor;
    }

    public void setTipo_contenedor(String tipo_contenedor) {
        this.tipo_contenedor = tipo_contenedor;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getEmpresa_cliente() {
        return empresa_cliente;
    }

    public void setEmpresa_cliente(String empresa_cliente) {
        this.empresa_cliente = empresa_cliente;
    }

    public String getEmpresa_destino() {
        return empresa_destino;
    }

    public void setEmpresa_destino(String empresa_destino) {
        this.empresa_destino = empresa_destino;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public Empleado getEmpleado() {
        return Empleado;
    }

    public void setEmpleado(Empleado Empleado) {
        this.Empleado = Empleado;
    }

    public Empresa getEmpresa_gen() {
        return Empresa_gen;
    }

    public void setEmpresa_gen(Empresa Empresa_gen) {
        this.Empresa_gen = Empresa_gen;
    }

    public Empresa getEmpresa_des() {
        return Empresa_des;
    }

    public void setEmpresa_des(Empresa Empresa_des) {
        this.Empresa_des = Empresa_des;
    }

    public Manifiesto getManifiesto() {
        return Manifiesto;
    }

    public void setManifiesto(Manifiesto Manifiesto) {
        this.Manifiesto = Manifiesto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Remision{");
        sb.append("id_remision:").append(id_remision);
        sb.append(", residuo:").append(residuo);
        sb.append(", cantidad:").append(cantidad);
        sb.append(", unidad:").append(unidad);
        sb.append(", tipo_contenedor:").append(tipo_contenedor);
        sb.append(", volumen:").append(volumen);
        sb.append(", empresa_cliente:").append(empresa_cliente);
        sb.append(", empresa_destino:").append(empresa_destino);
        sb.append(", fecha:").append(fecha);
        sb.append(", estatus:").append(estatus);
        sb.append(", Empleado:").append(Empleado);
        sb.append(", Empresa_gen:").append(Empresa_gen);
        sb.append(", Empresa_des:").append(Empresa_des);
        sb.append(", Manifiesto:").append(Manifiesto);
        sb.append('}');
        return sb.toString();
    }

    
}