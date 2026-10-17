/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.automotora1;

/**
 *
 * @author tueniLK
 */
public class Venta {
    private String nombre;
    private String rut;
    private double comisionAcumulada;
    
    public Venta(String nombre, String rut, double comisionAcumulada){
        this.comisionAcumulada=comisionAcumulada;
        this.nombre=nombre;
        this.rut=rut;
    }
    public void registrarComision(double montoVenta){
        this.comisionAcumulada += montoVenta *0.03;
    }
}
