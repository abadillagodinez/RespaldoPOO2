/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;
import java.io.Serializable;
/**
 *
 * Maneja los pedidos 
 */
public class Pedido implements Serializable  {

    public Pedido() {
    }
    
    private Date fecha;
    private String nombreCliente;
    private String sitio;
    private String direccion;
    public static double valorExpress;
    public static double valorEmpaque;
    private String tipoPedido;  //lo puse string no enum por mientras
    private OrdenCliente[] platillos;
    public String resulSocket;
    /**
     * Constructor
     * @param nombreCliente
     * @param sitio
     * @param direccion
     * @param valorExpress
     * @param valorEmpaque
     * @param tipo
     * @param platillos 
     */
    public Pedido(String nombreCliente,String sitio,String direccion,double valorExpress,double valorEmpaque,String tipo,OrdenCliente[] platillos){
        this.nombreCliente= nombreCliente;
        this.sitio = sitio;
        this.direccion = direccion;
        //this.valorExpress = valorExpress;
        //this.valorEmpaque = valorEmpaque;
        this.tipoPedido = tipo;
        this.platillos = platillos;
        
        
    }
    
    public void setSocket(String p){
        this.resulSocket = p ;
    }
    public String getSocket(){
        return resulSocket;
    }
    
    
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
    public OrdenCliente[] getPlatillos() {
        return platillos;
    }

    public void setPlatillos(OrdenCliente[] platillo) {
        this.platillos = platillo;
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


    public double getValorEmpaque() {
        return valorEmpaque;
    }


    /*
    public TipoPedido getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(TipoPedido tipoPedido) {
        this.tipoPedido = tipoPedido;
    }
    
    */

    public static void setValorExpress(double valorExpress) {
        Historial h=Historial.getInstance();
        h.cambios.add("Valor de costo express cambiado a:"+String.valueOf(valorExpress));
        Pedido.valorExpress = valorExpress;
    }

    public static void setValorEmpaque(double valorEmpaque) {
        Historial h=Historial.getInstance();
        h.cambios.add("Valor de costo empaque cambiado a:"+String.valueOf(valorEmpaque));
        Pedido.valorEmpaque = valorEmpaque;
    }

    
}
