/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;


public class Simbolos {
    
    String nombre, valor, tipo;
    
    public String toString(){
        
        return "| " + nombre + " | " + valor +" | " + tipo +  "|" ;                   
    
    }
    public Simbolos (String pnombre, String ptipo){
        nombre = pnombre;
        tipo = ptipo;
    }
    public void setNombre (String pnombre){
    nombre = pnombre;    
    }
    public String getNombre(){
    return nombre;
    }
    
    public void setValor( String pvalor)
    {
        this.valor = pvalor;
    }
   
    public String getValor(){
        return valor;
    }   
    
    public String getTipo(){
        return tipo;
    }   
   
}
