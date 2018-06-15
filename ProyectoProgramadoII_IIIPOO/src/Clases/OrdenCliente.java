/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.io.Serializable;
/**
 *
 * Maneja la orden del cliente
 */
public class OrdenCliente implements Serializable  {
    
    private Platillo platillo;
    private int cantidad;
    /**
     * Constructor
     * @param pl
     * @param cant 
     */
    OrdenCliente(Platillo pl,int cant){
        this.cantidad = cant;
        this.platillo = pl;
    }
    



    public void setPlatillo(Platillo pl) {
        this.platillo = pl;
    }

    public Platillo getPlatillo() {
        return platillo;
    }
    public void setCantidad(int cant) {
        this.cantidad = cant;
    }

    public int getCantidad() {
        return cantidad;
    }
}