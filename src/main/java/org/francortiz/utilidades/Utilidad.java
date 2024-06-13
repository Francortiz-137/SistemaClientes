package org.francortiz.utilidades;

import org.francortiz.modelo.CategoriaEnum;

public class Utilidad {
    public static void limpiarPantalla() {
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

}
