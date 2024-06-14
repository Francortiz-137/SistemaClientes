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

    public void ListarClientes(){
        listaClientes.forEach(
                cliente -> {
                    System.out.println("-------------Datos del Cliente-------------\n");
                    System.out.println("RUN del Cliente: " + cliente.getRunCliente());
                    System.out.println("Nombre del Cliente: " + cliente.getNombreCliente());
                    System.out.println("Apellido del Cliente: " + cliente.getApellidoCliente());
                    System.out.println("Años como Cliente: " + cliente.getAniosCliente() + " año(s)");
                    System.out.println("Categoria del Cliente: " + cliente.getNombreCategoria());
                    System.out.println("\n-------------------------------------------");
                }
        );
    }

    public void agregarCliente(Cliente cliente){
        if (cliente != null)
            listaClientes.add(cliente);
    }

    public Cliente editarCliente(Cliente cliente, String run, String nombre, String apellido, int anios){
        int index = listaClientes.indexOf(cliente);

        if(run != null && !run.isEmpty())
            cliente.setRunCliente(run);
        if(nombre != null && !nombre.isEmpty())
            cliente.setNombreCliente(nombre);
        if(apellido != null && !apellido.isEmpty())
            cliente.setApellidoCliente(apellido);
        if(anios > 0)
            cliente.setAniosCliente(anios);

        listaClientes.set(index, cliente);
        return cliente;
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
