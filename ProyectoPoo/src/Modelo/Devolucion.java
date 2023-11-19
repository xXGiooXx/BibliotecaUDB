/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author JONATHAN G
 */
public class Devolucion {
    private int id_devolucion;
    private int id_prestamo;
    private String fecha_prestamo;
    private String fecha_devolucion;
    private String observacion;
    private double  mora;
    private int cantidad_devolucion;

    public Devolucion() {
    }

    public Devolucion(int id_devolucion, int id_prestamo, String fecha_prestamo, String fecha_devolucion, String observacion, double mora, int cantidad_devolucion) {
        this.id_devolucion = id_devolucion;
        this.id_prestamo = id_prestamo;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
        this.observacion = observacion;
        this.mora = mora;
        this.cantidad_devolucion = cantidad_devolucion;
    }

    public int getId_devolucion() {
        return id_devolucion;
    }

    public void setId_devolucion(int id_devolucion) {
        this.id_devolucion = id_devolucion;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public String getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(String fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public String getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(String fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public double getMora() {
        return mora;
    }

    public void setMora(double mora) {
        this.mora = mora;
    }

    public int getCantidad_devolucion() {
        return cantidad_devolucion;
    }

    public void setCantidad_devolucion(int cantidad_devolucion) {
        this.cantidad_devolucion = cantidad_devolucion;
    }

  

   
    
    
}
