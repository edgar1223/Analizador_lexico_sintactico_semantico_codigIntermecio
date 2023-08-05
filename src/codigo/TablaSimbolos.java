
package codigo;
import java.lang.reflect.Array;
import java.util.Vector;
import javax.swing.JOptionPane;
import codigo.Simbolos;

public class TablaSimbolos {
    private static Vector tabla = new Vector();
    private static boolean correcto = true;
    
    public TablaSimbolos(){

    }
    public static void limpiar(){
        tabla.clear();
    }
    
    public static boolean crearEntrada(String nombre, String tipo){
    String subStr;
    Simbolos e = TablaSimbolos.busca(nombre);
    if (e==null)
    {
        e = new Simbolos(nombre, tipo);
        tabla.add(e);
        return true;
    } else {
        JOptionPane.showMessageDialog(null, "Variable repetida "+e );
        Cuadrupla.limpiar();
        limpiar();
        return false;
    }
    }
    
    public static String getTipo(String nombre) {
    Simbolos e = TablaSimbolos.busca(nombre);
    if (e == null){
    }
    return e.getTipo();
    }
    
    public static String getValor(String nombre) {
    Simbolos e = TablaSimbolos.busca(nombre);
    if (e == null){ }
    return e.getValor();
    }
    
    public static Simbolos busca(String nombre){
    Simbolos e = null;
    int i = 0;
    
    while ( i < tabla.size() ){
        e = (Simbolos) tabla.elementAt(i);
        if (e.getNombre().equals(nombre)){
            
        break;
        }
    e = null;
    i++;
    }
    return e;
    }
    
    public static Vector getTabla(){
    
        return tabla;
    }
    
    public static void Imprimir(){
    
        for (int i = 0; i<tabla.size(); i++){ System.out.println(tabla.elementAt(i).toString());}
    }
    
    public static void setValor(String pnombre, String pval){
         Simbolos e = null;
         int i=0 ;
         while (i<tabla.size()){
            e = (Simbolos) tabla.elementAt(i);
        
            if (e.getNombre().equals(pnombre)){
                 if(validacion(e, pval)){
                e.setValor(pval);
                tabla.set(i, e);
                
                 }
                break;
            }
            e= null;
            i++;
         }
        }
        
    public static boolean validacion(Simbolos e, String val){
        boolean a = true;
        String tipo = e.getTipo();
        boolean noes = val != null && val.matches("^[a-zA-Z]*$"); 
        if(noes){
        if(tipo.equals("INTEGER")){
            if (Integer.parseInt(val) % 1 == 0) {
                a = true;
            } else {
                a = false;
                      JOptionPane.showMessageDialog(null, "ERROR: el valor de "+e.getNombre() + " debe ser un numero entero." );
         }
        }
        else if(tipo.equals("CHAR")){
        
        }
        else if(tipo.equals("FLOAT")){
        
        }
        }
        
        return a;
    }
    public static void validar(String [] sent){
        for(int i = 0; i< sent.length; i++){
        String b = "int";
        if( b.equals(sent[i])){
            JOptionPane.showMessageDialog(null, "ERROR: el valor de "+sent[i+1]+ " debe ser un numero entero o debe tener un valor." );
            TablaSimbolos.limpiar();
            Cuadrupla.limpiar();
        }
        if( "char".equals(sent[i])){
            JOptionPane.showMessageDialog(null, "ERROR: el valor de "+sent[i+1]+ " debe ser un caracter entre comillas (')." );
            TablaSimbolos.limpiar();
            Cuadrupla.limpiar();
        }  
        
        if( "float".equals(sent[i])){
            JOptionPane.showMessageDialog(null, "ERROR: el valor de "+sent[i+1]+ " debe ser un numero con decimales (ej: 1.1). O debe de de definirse" );
            TablaSimbolos.limpiar();
            Cuadrupla.limpiar();
        } if(":".equals(sent[i])){TablaSimbolos.limpiar(); Cuadrupla.limpiar();}
        
        }
    }
    
    public static boolean comprobarExistencia(String nombre){
    boolean bol = true;
        String subStr;
    Simbolos e = TablaSimbolos.busca(nombre);
    if (e==null)
    {
        bol = false;
        JOptionPane.showMessageDialog(null, "Variable no definida en este punto: "+nombre );
    } else {
        bol = true;
    }
         return bol;
        }
    
    public static boolean comprobarTipos(String a, String b, String c){
    boolean bol = true;
    Simbolos e1 = TablaSimbolos.busca(a);
    Simbolos e2 = TablaSimbolos.busca(b);
    Simbolos e3 = TablaSimbolos.busca(c);
    Simbolos [] eso = {e1, e2, e3};
    String [] tipos = {e1.getTipo(), e2.getTipo(), e3.getTipo()};
    if(tipos[0].equals("CHAR")){
         //revisar los simbolos
    if(!tipos[1].equals(tipos[0]) && !tipos[2].equals(tipos[0])){
    bol = false;
            JOptionPane.showMessageDialog(null, "La variable: "+eso[1].getNombre() + " y "+ eso[2].getNombre() + " no se puede asignar a un caracter." );
    }
    else if(!tipos[1].equals(tipos[0])){
    bol = false;
            JOptionPane.showMessageDialog(null, "La variable: "+eso[1].nombre + " no se puede asignar a un caracter." );
    } else if(!tipos[2].equals(tipos[0])){
    bol = false;
            JOptionPane.showMessageDialog(null, "La variable: "+eso[2].nombre + " no se puede asignar a un caracter." );
    }
    
    } else {
    for(int i = 1; i<tipos.length; i++){
    if(!tipos[i].equals(tipos[0])){
    bol = false;
            JOptionPane.showMessageDialog(null, "La variable: "+eso[i].nombre + " debe ser " + tipos[0] );
    }
    }}
    
    return bol;
    }
        
        public static Object[][] getElementos(){
            Object[][] elemenArreg = new Object[10][3];
            for (int i =0; i<tabla.size();i++)
            {
             Simbolos obj = (Simbolos) tabla.elementAt(i);
             elemenArreg[i][0] = obj.getNombre();
             elemenArreg[i][1] = obj.getValor();
             elemenArreg[i][2] = obj.getTipo();
            }
            return elemenArreg;
        }
        
    public static boolean mensajeCorrecto(){
        return correcto;
    
    }
            
}
