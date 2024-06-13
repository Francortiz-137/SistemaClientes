package org.francortiz.servicio;

import org.francortiz.modelo.Cliente;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ExportadorCsv extends Exportador {
    @Override
    public void exportar(String fileName, List<Cliente> listaClientes) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Cliente cliente : listaClientes) {
                writer.println(cliente.getRunCliente() + "," +
                        cliente.getNombreCliente() + "," +
                        cliente.getApellidoCliente() + "," +
                        cliente.getAniosCliente() + "," +
                        cliente.getNombreCategoria());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
