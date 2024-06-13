package org.francortiz.servicio;

import org.francortiz.modelo.CategoriaEnum;
import org.francortiz.modelo.Cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoServicio extends Exportador{

    public List<Cliente> cargarDatos(String fileName){
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");
                if (datos.length == 5) {
                    Cliente cliente = new Cliente(
                            datos[0],
                            datos[1],
                            datos[2],
                            Integer.parseInt(datos[3]),
                            CategoriaEnum.valueOf(datos[4])
                    );
                    listaClientes.add(cliente);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaClientes;
    }

    public void exportar(String fileName, List<Cliente> listaClientes) {

    }
}
