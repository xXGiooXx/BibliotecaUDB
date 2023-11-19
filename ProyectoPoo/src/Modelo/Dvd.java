/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author grupo 5
 */
public class Dvd {

    private int id_dvd;
    private String genero;
    private String director;
    private String duracion;
    private int id_material;
    private int id_categoria;
    private String codigo;
    private String titulo;
    private int unidades_disponible;

    public Dvd() {
    }

    public Dvd(int id_dvd, String genero, String director, String duracion, int id_material, int id_categoria, String codigo, String titulo, int unidades_disponible) {
        this.id_dvd = id_dvd;
        this.genero = genero;
        this.director = director;
        this.duracion = duracion;
        this.id_material = id_material;
        this.id_categoria = id_categoria;
        this.codigo = codigo;
        this.titulo = titulo;
        this.unidades_disponible = unidades_disponible;
    }

    public int getId_dvd() {
        return id_dvd;
    }

    public void setId_dvd(int id_dvd) {
        this.id_dvd = id_dvd;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
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
