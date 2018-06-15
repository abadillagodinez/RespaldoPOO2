
package Clases;

import java.io.Serializable;
/**
 * 
 * Crea los platillos
 */

public class Platillo implements Serializable{      //Cada clase que quiere pasar un objeto por el socket debe ser Serializable

    public Platillo() {
        
    }
    protected Boolean habilitado=false;//si esta disponible para el publico
    protected String nombre="";//nombre del platillo
    protected String descripcion="";
    protected byte[] imagen; //el atributo imagen 
    protected double precio=0;
    protected int cantPedidos=0;//cada vez que se pide uno esto debe de incrementear
    protected String tipoPorcion="";//deecripcion del tipo de porcion ejemplo plato, taza, unidades burrito, cucharadas etc
    protected String codClave="";// ID del plato, dependera si es bebida, postre, entrada o principal              creo que este esta de mas por que hicieron una clase tipoPlatillo
    protected static int cantidadPlatos=0;//todos los platos se aumenta desde cualquiera delos hijos
    protected int calorias=0;
    private double kilokcalPorGramo=0;
    private double gramosPorPorcion=0;
    //protected Historial historial = Historial.getInstance();
    protected TipoPlatillo tipoPlatillo;                      //comente estos dos porque ambos deben ser serializables
    
    public String resulSocket;                                  //agregue esto para ver si funcionaba el socket
    /**
     * Constructor
     * @param nombre
     * @param descripcion
     * @param precio
     * @param tipoPorcion
     * @param codClave
     * @param calorias
     * @param kcalGramo
     * @param gPorcion
     * @param tipop 
     */
    public Platillo(String nombre, String descripcion, double precio, String tipoPorcion,
            String codClave, int calorias, double kcalGramo, double gPorcion, TipoPlatillo tipop){
        this.habilitado=true;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.precio=precio;
        this.tipoPorcion=tipoPorcion;
        this.codClave=codClave;
        this.calorias= calorias;
        this.kilokcalPorGramo=kcalGramo;
        this.gramosPorPorcion=gPorcion;
        this.tipoPlatillo=tipop;
        Historial h=Historial.getInstance();
        h.cambios.add("Creando Nuevo platillo :");
        h.cambios.add(this.toString()); 
    }
    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        Historial h=Historial.getInstance();
        h.cambios.add("Platillo:"+this.getNombre());
        if(habilitado){
        h.cambios.add("Cambio a Habilitado.");
        }else{
        h.cambios.add("Cambio a DesHabilitado.");    
        }
        this.habilitado = habilitado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        Historial h=Historial.getInstance();
        h.cambios.add("Platillo:"+this.getNombre());
        h.cambios.add("Cambio de nombre a:"+ nombre);
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int cal) {
        Historial h=Historial.getInstance();
        h.cambios.add("Platillo:"+this.getNombre());
        h.cambios.add("Cambio de Calorias"+ String.valueOf(cal));
        this.calorias = cal;
    }
    public void setDescripcion(String descripcion) {
        Historial h=Historial.getInstance();
        h.cambios.add("Platillo:"+this.getNombre());
        h.cambios.add("Cambio de descripcion"+ descripcion);
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        Historial h=Historial.getInstance();
        h.cambios.add("Platillo:"+this.getNombre());
        h.cambios.add("Cambio de precio"+ String.valueOf(precio));
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
        Historial h=Historial.getInstance();
        h.cambios.add("Platillo:"+this.getNombre());
        h.cambios.add("Cambio de tipo de porcion a "+ tipoPorcion);
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

    public void setTipoPlatillo(TipoPlatillo tipoPlatillo) {//no cambia
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
        Historial h=Historial.getInstance();
        h.cambios.add("Platillo:"+this.getNombre());
        h.cambios.add("Una nueva imagen ha sido asignada a este platillo");
        this.imagen = imagen;
    }

    public double getKilokcalPorGramo() {
        return kilokcalPorGramo;
    }

    public void setKilokcalPorGramo(double kilokcalPorGramo) {//no cambia
        this.kilokcalPorGramo = kilokcalPorGramo;
    }

    public double getGramosPorPorcion() {
        return gramosPorPorcion;
    }

    public void setGramosPorPorcion(double gramosPorPorcion) {
        Historial h=Historial.getInstance();
        h.cambios.add("Platillo:"+this.getNombre());
        h.cambios.add("Cambio de gramos por porcion a "+ String.valueOf(gramosPorPorcion));
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

    public String toList(){
        String s = "";
        s += nombre + "\t";
        if(tipoPlatillo.equals(TipoPlatillo.BEB)){
            s+= String.valueOf(gramosPorPorcion)+"\t"; 
        }else{
            s+= String.valueOf(gramosPorPorcion)+"\t";
        }
        return s;
    }



}