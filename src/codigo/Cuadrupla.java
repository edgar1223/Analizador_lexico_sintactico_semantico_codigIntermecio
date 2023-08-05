/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.util.Vector;

/**
 *
 * @author 100025782
 */
public class Cuadrupla {
    private static Vector tabla = new Vector();
    
    public Cuadrupla(){}
    
    public static void limpiar(){
    tabla.clear();
    }
    
    public static void insertarAsignacion(String resultado, String Op1){
        String fin = "IGUAL "+resultado+" "+Op1 +" ~";
        tabla.add(fin);
    }
    
    public static void insertarOperacion(String Op, String res, String Op1, String Op2){
        String fin = Op+" " +res +" "+Op1+" "+Op2;
        tabla.add(fin);
    }
    
    public static void declarar(String res){
        String fin = "~ "+res +" null ~";
        tabla.add(fin);
    }
    
    public static void imprimirCSalto(String res){
        String fin = "print "+res +" ~ ~";
        tabla.add(fin);
    }
    
    public static Object[][] regresarElementos(){
            Object[][] elemenArreg = new Object[30][4];
            for (int i =0; i<tabla.size();i++)
            {
                
             String res = (String) tabla.elementAt(i);
             String [] fin = res.split(" ");
             elemenArreg[i][0] = fin[0];
             elemenArreg[i][1] = fin[1];
             elemenArreg[i][2] = fin[2];
             elemenArreg[i][3] = fin[3];
            }
            return elemenArreg;
    }
    
    public static Vector getTabla(){
    return tabla;
    }
}