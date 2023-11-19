/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
/**
 *
 * @author Carlos Hernandez
 */
public class Revista {

    private int id_revista;
    private String editorial;
    private int periodicidad;
    private String fecha_publicacion;
    private int id_material;
    private int id_categoria;
    private String codigo;
    private String titulo;
    private int unidades_disponible;

    public Revista() {
    }

    public Revista(int id_revista, String editorial, int periodicidad, String fecha_publicacion, int id_material, int id_categoria, String codigo, String titulo, int unidades_disponible) {
        this.id_revista = id_revista;
        this.editorial = editorial;
        this.periodicidad = periodicidad;
        this.fecha_publicacion = fecha_publicacion;
        this.id_material = id_material;
        this.id_categoria = id_categoria;
        this.codigo = codigo;
        this.titulo = titulo;
        this.unidades_disponible = unidades_disponible;
    }

    public int getId_revista() {
        return id_revista;
    }

    public void setId_revista(int id_revista) {
        this.id_revista = id_revista;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(int periodicidad) {
        this.periodicidad = periodicidad;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public int getId_material() {
        return id_material;
    }

    public void setId_material(int id_material) {
        this.id_material = id_material;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getUnidades_disponible() {
        return unidades_disponible;
    }

    public void setUnidades_disponible(int unidades_disponible) {
        this.unidades_disponible = unidades_disponible;
    }

   
}
