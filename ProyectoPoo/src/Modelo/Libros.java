/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Carlos Hernandez
 */
public class Libros {

    private int id_libro;
    private String autor;
    private int num_paginas;
    private String editorial;
    private int isbn;
    private int anio_publicacion;       
    private int id_material;
    private int id_categoria;
    private String codigo;
    private String titulo;
    private int unidades_disponible;
    
public Libros() {

}

    public Libros(int id_libro, String autor, int num_paginas, String editorial, int isbn, int anio_publicacion, int id_material, int id_categoria, String codigo, String titulo, int unidades_disponible) {
        this.id_libro = id_libro;
        this.autor = autor;
        this.num_paginas = num_paginas;
        this.editorial = editorial;
        this.isbn = isbn;
        this.anio_publicacion = anio_publicacion;
        this.id_material = id_material;
        this.id_categoria = id_categoria;
        this.codigo = codigo;
        this.titulo = titulo;
        this.unidades_disponible = unidades_disponible;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNum_paginas() {
        return num_paginas;
    }

    public void setNum_paginas(int num_paginas) {
        this.num_paginas = num_paginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getAnio_publicacion() {
        return anio_publicacion;
    }

    public void setAnio_publicacion(int anio_publicacion) {
        this.anio_publicacion = anio_publicacion;
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

    
    