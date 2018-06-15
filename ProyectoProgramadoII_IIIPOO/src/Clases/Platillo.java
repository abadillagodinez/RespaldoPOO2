
package Clases;

import java.io.Serializable;

public class Platillo implements Serializable{      //Cada clase que quiere pasar un objeto por el socket debe ser Serializable

    public Platillo() {
    }
    protected Boolean habilitado;//si esta disponible para el publico
    protected String nombre;//nombre del platillo
    protected String descripcion;
    protected byte[] imagen; //el atributo imagen 
    protected double precio;
    protected int cantPedidos;//cada vez que se pide uno esto debe de incrementear
    protected String tipoPorcion;//deecripcion del tipo de porcion ejemplo plato, taza, unidades burrito, cucharadas etc
    protected String codClave;// ID del plato, dependera si es bebida, postre, entrada o principal              creo que este esta de mas por que hicieron una clase tipoPlatillo
    protected static int cantidadPlatos;//todos los platos se aumenta desde cualquiera delos hijos
    protected int calorias;
    private double kilokcalPorGramo;
    private double gramosPorPorcion;
    //protected Historial historial = Historial.getInstance();
    protected TipoPlatillo tipoPlatillo;                      //comente estos dos porque ambos deben ser serializables
    
    public String resulSocket;                                  //agregue esto para ver si funcionaba el socket
    
    
    public Platillo(String nombre, double precio,int calorias){
        this.nombre = nombre;
        this.precio = precio;
        this.calorias = calorias;
        
    }

    public Platillo(String nombre, double precio,int calorias,int cantPedidos,String descripcion,String codClave){
        this.nombre = nombre;
        this.precio = precio;
        this.calorias = calorias;
        this.cantPedidos = cantPedidos;
        this.codClave = codClave;
        this.descripcion = descripcion;
        
        
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
    }*/

    public TipoPlatillo getTipoPlatillo() {
        return tipoPlatillo;
    }

    public void setTipoPlatillo(TipoPlatillo tipoPlatillo) {
        this.tipoPlatillo = tipoPlatillo;
    }

    public void setSocket(String p){
        this.resulSocket = p ;
    }
    public String getSocket(){
        return resulSocket;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public double getKilokcalPorGramo() {
        return kilokcalPorGramo;
    }

    public void setKilokcalPorGramo(double kilokcalPorGramo) {
        this.kilokcalPorGramo = kilokcalPorGramo;
    }

    public double getGramosPorPorcion() {
        return gramosPorPorcion;
    }

    public void setGramosPorPorcion(double gramosPorPorcion) {
        this.gramosPorPorcion = gramosPorPorcion;
    }
    
    
    
    @Override
    public String toString(){
        String s="";
        s+= "Habilitado: "+habilitado.toString()+"\t";
        s+= "Nombre: "+ nombre+"\t";
        s+= "Descripcion: "+ descripcion+"\t";
        s+= "Precio :" + String.valueOf(precio)+"\t";
        s+= "Cantidad de veces pedido: " + String.valueOf(cantPedidos)+"\t";
        s+= "Tipo de Porcion: "+ tipoPorcion+"\t";
        s+= "Codigo clave: " + codClave+"\t";
        s+= "Calorias por porcion: " + String.valueOf(calorias)+"\t";
        if(tipoPlatillo.equals(TipoPlatillo.BEB)){
            s+= "KiloCaloria por Minilitro: " + String.valueOf(kilokcalPorGramo)+"\t";
            s+= "Minilitro por porcion : "+ String.valueOf(gramosPorPorcion)+"\t"; 
        }else{
            s+= "KiloCaloria por Gramo: " + String.valueOf(kilokcalPorGramo)+"\t";
            s+= "Gramos por porcion : "+ String.valueOf(gramosPorPorcion)+"\t";  
        }
        
        return s;
    }




}