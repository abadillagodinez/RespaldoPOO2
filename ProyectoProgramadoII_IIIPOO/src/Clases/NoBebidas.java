/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Sir Than II
 */
public class NoBebidas extends Platillo {
    
    public NoBebidas() {
    }
    private double kilokcalPorGramo;
    private double gramosPorPorcion;
    private double kclasPorPieza;//si tipo de porcion==Piezas entonces ese valor se hace, si no estara en 0
    public int piezasPorPorcion;

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

    public double getKclasPorPieza() {
        return kclasPorPieza;
    }

    public void setKclasPorPieza(double kclasPorPieza) {
        this.kclasPorPieza = kclasPorPieza;
    }

    public int getPiezasPorPorcion() {
        return piezasPorPorcion;
    }

    public void setPiezasPorPorcion(int piezasPorPorcion) {
        this.piezasPorPorcion = piezasPorPorcion;
    }

    
}
