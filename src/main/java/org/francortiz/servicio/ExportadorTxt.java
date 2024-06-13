package org.francortiz.servicio;

import org.francortiz.modelo.Cliente;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ExportadorTxt extends Exportador {
    @Override
    public void exportar(String fileName, List<Cliente> listaClientes) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Cliente cliente : listaClientes) {
                writer.println("RUN: " + cliente.getRunCliente());
                writer.println("Nombre: " + cliente.getNombreCliente());
                writer.println("Apellido: " + cliente.getApellidoCliente());
                writer.println("Años como Cliente: " + cliente.getAniosCliente());
                writer.println("Categoría: " + cliente.getNombreCategoria());
                writer.println("-----------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
