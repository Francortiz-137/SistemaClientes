package org.francortiz.servicio;

import org.francortiz.modelo.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteServicioTest {

    ClienteServicio clienteServicio;

    @BeforeEach
    void setUp() {
        clienteServicio = new ClienteServicio();
    }

    @Test
    void agregarClienteTest() {
        Cliente cliente = new Cliente("Juan","12345678-9","Perez",0);
        clienteServicio.agregarCliente(cliente);

        assertFalse(clienteServicio.getListaClientes().isEmpty());
        assertEquals(1, clienteServicio.getListaClientes().size());
        assertTrue(clienteServicio.getListaClientes().contains(cliente));
        assertEquals(cliente, clienteServicio.getListaClientes().get(0));
    }

    @Test
    void agregarClienteNullTest() {
        clienteServicio.agregarCliente(null);
        assertTrue(clienteServicio.getListaClientes().isEmpty());
    }

    @Test
    void editarClienteTest() {
        Cliente cliente = new Cliente("Juan", "12345678-9", "Perez", 0);
        clienteServicio.agregarCliente(cliente);

        clienteServicio.editarCliente(cliente, "12345678-9", "Juan", "Gomez", 25);

        assertEquals(1, clienteServicio.getListaClientes().size());
        assertEquals(cliente, clienteServicio.getListaClientes().get(0));
        assertEquals("Gomez", clienteServicio.getListaClientes().get(0).getApellidoCliente());
        assertEquals(25, clienteServicio.getListaClientes().get(0).getAniosCliente());
    }

    @Test
    void editarClienteNullTest() {
        Cliente cliente = new Cliente("Juan", "12345678-9", "Perez", 0);
        clienteServicio.agregarCliente(cliente);

        clienteServicio.editarCliente(cliente, null,null,null,-1);

        assertEquals(1, clienteServicio.getListaClientes().size());
        assertEquals(cliente, clienteServicio.getListaClientes().get(0));
        assertNotNull(clienteServicio.getListaClientes().get(0));
    }
}