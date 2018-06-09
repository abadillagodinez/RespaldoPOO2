/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Sir Than II
 */
public class Historial {//singleton

    private static Historial unicoHistorial=null;
    private Date fecha;//dia de hoy, tener en cuenta para el la introduccion al historial
    private ArrayList<String> cambios;

    private Historial() {
        fecha=Calendar.getInstance().getTime();
        cambios= new ArrayList<>();
    }
    
    public synchronized static Historial getInstance(){
        if(unicoHistorial==null){
            unicoHistorial=new Historial(); 
        }
        return unicoHistorial;
    }

    public static Historial getUnicoHistorial() {
        return unicoHistorial;
    }

    public static void setUnicoHistorial(Historial unicoHistorial) {
        Historial.unicoHistorial = unicoHistorial;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ArrayList<String> getCambios() {
        return cambios;
    }

    public void setCambios(ArrayList<String> cambios) {
        this.cambios = cambios;
    }
    
    

}

