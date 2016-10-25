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
public class Servicio {
    private int codigo;
    private String nombre;
    private String descripcion;
    private double valor_unitario;
    private boolean estado;

    public Servicio() {
        this.codigo = 0;
        this.nombre = "";
        this.descripcion = "";
        this.valor_unitario = 0.0;
        this.estado = false;
    }

    public Servicio(int codigo, String nombre, String descripcion, double valor_unitario, boolean estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor_unitario = valor_unitario;
        this.estado = estado;
    }
    
    public Servicio( String nombre, String descripcion, double valor_unitario, boolean estado) {
        
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor_unitario = valor_unitario;
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
    
    
}
