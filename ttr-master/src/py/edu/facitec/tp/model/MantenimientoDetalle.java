/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.tp.model;

/**
 *
 * @author brother
 */
public class MantenimientoDetalle {
    private int codigo;
    private int mantenimiento_codigo;
    private int servicio_codigo;
    private double precio;
    private double subtotal;
    
    private Mantenimiento mantenimiento;
    private Servicio servicios;

    public MantenimientoDetalle() {
        this.codigo = 0;
        this.mantenimiento_codigo = 0;
        this.servicio_codigo = 0;
        this.precio = 0.0;
        this.subtotal = 0.0;
        this.mantenimiento = new Mantenimiento();
        this.servicios = new Servicio();
    }

    public MantenimientoDetalle(int codigo, int mantenimiento_codigo, int servicio_codigo, double precio, double subtotal, Mantenimiento mantenimiento, Servicio servicios) {
        this.codigo = codigo;
        this.mantenimiento_codigo = mantenimiento_codigo;
        this.servicio_codigo = servicio_codigo;
        this.precio = precio;
        this.subtotal = subtotal;
        this.mantenimiento = mantenimiento;
        this.servicios = servicios;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getMantenimiento_codigo() {
        return mantenimiento_codigo;
    }

    public void setMantenimiento_codigo(int mantenimiento_codigo) {
        this.mantenimiento_codigo = mantenimiento_codigo;
    }

    public int getServicio_codigo() {
        return servicio_codigo;
    }

    public void setServicio_codigo(int servicio_codigo) {
        this.servicio_codigo = servicio_codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Mantenimiento getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Mantenimiento mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public Servicio getServicios() {
        return servicios;
    }

    public void setServicios(Servicio servicios) {
        this.servicios = servicios;
    }
    
    
    
        

}
