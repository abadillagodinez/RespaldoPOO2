/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author Sir Than II
 */
public class Pedido {

    public Pedido() {
    }
    
    private Date fecha;
    private String nombreCliente;
    private String sitio;
    private String direccion;
    private double valorExpress;
    private double valorEmpaque;
    private TipoPedido tipoPedido;
    

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getValorExpress() {
        return valorExpress;
    }

    public void setValorExpress(double valorExpress) {
        this.valorExpress = valorExpress;
    }

    public double getValorEmpaque() {
        return valorEmpaque;
    }

    public void setValorEmpaque(double valorEmpaque) {
        this.valorEmpaque = valorEmpaque;
    }

    public TipoPedido getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(TipoPedido tipoPedido) {
        this.tipoPedido = tipoPedido;
    }
    
    

}
