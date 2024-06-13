package org.francortiz.servicio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.francortiz.modelo.CategoriaEnum;
import org.francortiz.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class ClienteServicio {
    List<Cliente> listaClientes;

    public ClienteServicio() {
        this.listaClientes = new ArrayList<Cliente>();
    }

    public void retornoListarClientes(){
        listaClientes.forEach(System.out::println);
    }

    public void agregarCliente(Cliente cliente){
        listaClientes.add(cliente);
    }

    public Cliente editarCliente(String runAntiguo, String run, String nombre, String apellido, int anios){
        for (Cliente cliente : listaClientes) {
            if (cliente.getRunCliente().equals(runAntiguo)) {
                cliente.setRunCliente(run);
                cliente.setNombreCliente(nombre);
                cliente.setApellidoCliente(apellido);
                cliente.setAniosCliente(anios);
                return cliente;
            }
        }
        return null;
    }

    public Cliente editarCliente(Cliente cliente, CategoriaEnum categoriaEnum) {
        cliente.setNombreCategoria(categoriaEnum);
        return cliente;
    }

    public void agregarCliente(String run, String nombre, String apellido, int anios) {
        listaClientes.add(new Cliente(run, nombre, apellido, anios));
    }

    public Cliente getClienteByRun(String run) {
        return listaClientes.stream().filter(e -> e.getRunCliente().equals(run)).findFirst().orElse(null);
    }


}
