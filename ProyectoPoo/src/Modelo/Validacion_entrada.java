/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author marvin.nuila
 */
public class Validacion_entrada {
 // Método auxiliar para verificar si una cadena contiene números
 public static boolean contieneNumeros(String texto) {
        for (char c : texto.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

// Método auxiliar para verificar si una cadena contiene caracteres especiales
public static boolean contieneCaracteresEspeciales(String cadena) {
    return !cadena.matches("[a-zA-Z\\s]+");
}
   
// Método para verificar si una cadena no está vacía
    public static boolean noEstaVacio(String cadena) {
        return cadena != null && !cadena.isEmpty();
    }
 public static boolean contieneSoloLetras(String texto) {
        for (char c : texto.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
 public static boolean validarRol(String rol) {
    return rol.matches("[0-9]+");
    
}
public static boolean validarNombre(String nombre) {
    return nombre.matches("[a-zA-Z ]+");
}

    
}
