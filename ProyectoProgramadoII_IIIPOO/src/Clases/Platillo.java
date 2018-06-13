
package Clases;

import java.io.Serializable;

public class Platillo implements Serializable{      //Cada clase que quiere pasar un objeto por el socket debe ser Serializable

    public Platillo() {
    }
    protected Boolean habilitado;//si esta disponible para el publico
    protected String nombre;//nombre del platillo
    protected String descripcion;
    private String imagen; //el atributo imagen 
    protected double precio;
    protected int cantPedidos;//cada vez que se pide uno esto debe de incrementear
    protected String tipoPorcion;//deecripcion del tipo de porcion ejemplo plato, taza, unidades burrito, cucharadas etc
    protected String codClave;// ID del plato, dependera si es bebida, postre, entrada o principal              creo que este esta de mas por que hicieron una clase tipoPlatillo
    protected static int cantidadPlatos;//todos los platos se aumenta desde cualquiera delos hijos
    private int calorias;
    //protected Historial historial = Historial.getInstance();
    //protected TipoPlatillo tipoPlatillo;                      //comente estos dos porque ambos deben ser serializables
    
    public String resulSocket;                                  //agregue esto para ver si funcionaba el socket

    public Platillo(String nombre, double precio,int calorias){
        this.nombre = nombre;
        this.precio = precio;
        this.calorias = calorias;
        
        
    }
    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
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

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int cal) {
        this.calorias = cal;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantPedidos() {
        return cantPedidos;
    }

    public void setCantPedidos(int cantPedidos) {
        this.cantPedidos = cantPedidos;
    }

    public String getTipoPorcion() {
        return tipoPorcion;
    }

    public void setTipoPorcion(String tipoPorcion) {
        this.tipoPorcion = tipoPorcion;
    }

    public String getCodClave() {
        return codClave;
    }

    public void setCodClave(String codClave) {
        this.codClave = codClave;
    }

    public static int getCantidadPlatos() {
        return cantidadPlatos;
    }

    public static void setCantidadPlatos(int cantidadPlatos) {
        Platillo.cantidadPlatos = cantidadPlatos;
    }
/*
    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }

    public TipoPlatillo getTipoPlatillo() {
        return tipoPlatillo;
    }

    public void setTipoPlatillo(TipoPlatillo tipoPlatillo) {
        this.tipoPlatillo = tipoPlatillo;
    }
*/
    public void setSocket(String p){
        this.resulSocket = p ;
    }
    public String getSocket(){
        return resulSocket;
    }
    
    
    




}