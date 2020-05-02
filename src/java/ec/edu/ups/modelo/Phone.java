/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.io.Serializable;

/**
 *
 * @author claum
 */
public class Phone implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private String numero;
    private String tipo;
    private String operadora;
    
    public Phone (){
        
    }

    public Phone(int id, String tipo, String operadora) {
        this.id = id;
        this.tipo = tipo;
        this.operadora = operadora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    @Override
    public String toString() {
        return "Telefono{" + "id=" + id + ", numero=" + numero + ", tipo=" + tipo + ", operadora=" + operadora + '}';
    }
     
    
}
