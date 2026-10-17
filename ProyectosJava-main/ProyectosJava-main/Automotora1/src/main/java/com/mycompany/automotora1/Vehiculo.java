/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.automotora1;

/**
 *
 * @author tueniLK
 */
public abstract class Vehiculo {
    private String patente;
    private String modelo;
    private String marca;
    private int anio;
    private int precio;
    private boolean disponible;

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    public Vehiculo(String patente,String marca,int anio,String modelo, int precio, boolean disponible){
        this.patente=patente;
        this.anio=anio;
        this.disponible= true ;
        this.marca=marca;
        this.modelo=modelo;
        this.precio=precio;
        
    }
    public void marcarVendido(){
        this.disponible= false;
    }
    public double calculoPrecioFinal(){
    return precio;
    }
    public abstract String tipoVehiculo();
    public String modeloInfo(){
        return marca+""+modelo+" (" + anio + ") - $"+ precio;
    }
}
