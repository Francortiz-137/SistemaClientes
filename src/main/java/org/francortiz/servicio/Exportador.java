package org.francortiz.servicio;

import org.francortiz.modelo.Cliente;

import java.util.List;

public abstract class Exportador {

    public void exportar(String filename, List<Cliente> clientes) {}
}
