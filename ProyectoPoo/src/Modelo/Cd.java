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
public class Cd {

    private int id_cd;
    private String artista;
    private String genero;
    private String duracion;
    private int num_canciones;
    private int id_material;
    private int id_categoria;
    private String codigo;
    private String titulo;
    private int unidades_disponible;

    public Cd() {
    }

    public Cd(int id_cd, String artista, String genero, String duracion, int num_canciones, int id_material, int id_categoria, String codigo, String titulo, int unidades_disponible) {
        this.id_cd = id_cd;
        this.artista = artista;
        this.genero = genero;
        this.duracion = duracion;
        this.num_canciones = num_canciones;
        this.id_material = id_material;
        this.id_categoria = id_categoria;
        this.codigo = codigo;
        this.titulo = titulo;
        this.unidades_disponible = unidades_disponible;
    }

    public int getId_cd() {
        return id_cd;
    }

    public void setId_cd(int id_cd) {
        this.id_cd = id_cd;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getNum_canciones() {
        return num_canciones;
    }

    public void setNum_canciones(int num_canciones) {
        this.num_canciones = num_canciones;
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
