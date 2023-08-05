/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author brene
 */
public class GeneradorEsanblador {

    public void emsablador(Object[][] objectArray, String[] cadenas) {
        int j = 0;
        StringBuilder codigoASM = new StringBuilder();
        Object[][] aux = new Object[objectArray.length][2];
        // Encabezado del código ensamblador
        codigoASM.append(".model small\n");
        codigoASM.append(".data\n");
        // Aquí puedes agregar las definiciones de variables
        for (int i = 0; i < objectArray.length; i++) {
            if (objectArray[i][1] != null || objectArray[i][2] != null) {
                String valor1 = objectArray[i][1].toString();

                if (valor1.contains("\"")) {
                    if (objectArray[i][0].equals("print")) {
                        codigoASM.append("mensaje").append(i).append(" db 10, 13, ").append(objectArray[i][1].toString()).append(", \"$\"\n");
                    }
                } else {

                    if (objectArray[i][0].equals("IGUAL")) {
                        if (Pattern.matches(".*temp\\d.*", objectArray[i][2].toString())) {
                            aux[i][0] = objectArray[i][1];
                            aux[i][1] = 0;
                        } else {
                            for (int k = 0; k < aux.length; k++) {
                                if (objectArray[i][1].equals(aux[k][0])) {

                                    aux[k][0] = null;
                                    aux[k][1] = null;

                                } else {
                                    System.out.println(aux[k][0]);
                                    aux[i][0] = objectArray[i][1];
                                    aux[i][1] = objectArray[i][2];
                                }
                            }

                        }
                    }
                }
                String regex = "temp\\d+";
                if (objectArray[i][1].toString().matches(".*temp\\d.*")) {
                    codigoASM.append(objectArray[i][1]).append(" db ").append("0" + "\n");
                } else {
                }
            } else {

            }
        }

        for (int v = 0; v < aux.length; v++) {
            if (aux[v][0] != null || aux[v][1] != null) {

                codigoASM.append(aux[v][0]).append(" db ").append(aux[v][1] + "\n");
            } else if (aux[v][0] != null) {
                codigoASM.append(aux[v][0]).append(" db ").append("0" + "\n");
            }

        }

        codigoASM.append("salto db 10,13, \"$\"\n");

        codigoASM.append(".code\n");
        codigoASM.append("mov ax,@data\n");
        codigoASM.append("mov ds,ax \n");

        for (int i = 0; i < objectArray.length; i++) {
            if (objectArray[i][1] != null) {
                String va=objectArray  [i][0].toString();
                switch (va) {

                    case "+": {
                        codigoASM.append("mov al," + objectArray[i][2] + "\n");
                        codigoASM.append("mov bl," + objectArray[i][3] + "\n");
                        codigoASM.append("add al, bl \n");
                        codigoASM.append("mov " + objectArray[i][1] + ", al \n");
                        break;

                    }
                    case "-": {
                        codigoASM.append("mov al," + objectArray[i][2] + "\n");
                        codigoASM.append("mov bl," + objectArray[i][3] + "\n");
                        codigoASM.append("sub  al, bl \n");
                        codigoASM.append("mov " + objectArray[i][1] + ", al \n");

                        break;
                    }
                    case "print": {
                        if (objectArray[i][1] != null || objectArray[i][2] != null) {
                            String valor1 = objectArray[i][1].toString();
                            if (objectArray[i][0].equals("print")) {
                                if (valor1.contains("\"")) {
                                    codigoASM.append("mov dx,OFFSET mensaje" + i + " \n");
                                    codigoASM.append("mov ah,09 \n");
                                    codigoASM.append("int 21h \n");
                                } else if (!cadenas[j].startsWith("\"")) {
                                    codigoASM.append("mov dx,OFFSET salto \n");
                                    codigoASM.append("mov ah,09 \n");
                                    codigoASM.append("int 21h \n");                                   
                                    codigoASM.append(";mov ax,0\n");
                                    codigoASM.append("mov al," + cadenas[j] + "\n");
                                    codigoASM.append("aaa\n");
                                    codigoASM.append("mov bl,al\n");
                                    codigoASM.append("mov al,ah\n");
                                    codigoASM.append("aam \n");
                                    codigoASM.append("mov bh,ah\n");
                                    codigoASM.append("add bh,30h\n");
                                    codigoASM.append("mov dl,bh\n");
                                    codigoASM.append("mov ah,02h\n");
                                    codigoASM.append("int 21h\n");
                                    codigoASM.append("mov dl,bl\n");
                                    codigoASM.append("add dl,30h\n");
                                    codigoASM.append("mov ah,02h\n");
                                    codigoASM.append("int 21h\n");

                                }

                            }
                        }
                        j++;
                        break;
                    }
                    case "IGUAL": {
                        if (esNumeroOMarca(objectArray[i][2])) {
                            System.out.println("Hay un número en la posición : " + objectArray[i][2]);
                        } else {

                            codigoASM.append("mov al, " + objectArray[i][2] + "\n");
                            codigoASM.append("mov ah, 0 \n");
                            codigoASM.append("mov " + objectArray[i][1] + " ,al \n");;
                        }

                        break;
                    }

                }
            }

        }

        codigoASM.append("mov ah,4ch\n");
        codigoASM.append("int 21H \n");
        codigoASM.append("end \n");
        // Ruta y nombre del archivo ASM que deseas generar  mov ds,ax 
        String rutaArchivoASM = "C://dosbox//Tasm//prog.asm";

        try {
            FileWriter fileWriter = new FileWriter(rutaArchivoASM);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(codigoASM.toString());
            printWriter.close();
            System.out.println("Archivo ASM generado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al generar el archivo ASM.");
        }
    }

    public static boolean esNumeroOMarca(Object obj) {
        if (obj instanceof Number) {
            return true; // Es un número
        }
        if (obj instanceof Character) {
            char caracter = (Character) obj;
            return caracter == '~'; // Es el carácter "~"
        }
        return false;
    }

}
