/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b_modelos;

/**
 *
 * @author juan-jolo
 */
public class categorias_prod {

    /**
     * @return the id_categoria
     */
    public int getId_categoria() {
        return id_categoria;
    }

    /**
     * @param id_categoria the id_categoria to set
     */
    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    /**
     * @return the nombre_cat
     */
    public String getNombre_cat() {
        return nombre_cat;
    }

    /**
     * @param nombre_cat the nombre_cat to set
     */
    public void setNombre_cat(String nombre_cat) {
        this.nombre_cat = nombre_cat;
    }
    private int id_categoria;
    private String nombre_cat;

    public categorias_prod(int id_categoria, String nombre_cat) {
        this.id_categoria = id_categoria;
        this.nombre_cat = nombre_cat;
    }
    
    
}
