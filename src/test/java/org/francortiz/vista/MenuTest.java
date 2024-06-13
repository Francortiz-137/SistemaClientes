package org.francortiz.vista;

import org.francortiz.modelo.CategoriaEnum;
import org.francortiz.modelo.Cliente;
import org.francortiz.servicio.ClienteServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    private ClienteServicio clienteServicio;

    @BeforeEach
    public void setUp() {
        clienteServicio = new ClienteServicio();
    }

    @Test
    void listarClientesTest() {
        List<Cliente> clientes = clienteServicio.getListaClientes();
        assertNotNull(clientes);
        assertFalse(clientes.isEmpty());
    }

    @Test
    void agregarClienteTest() {
        clienteServicio.agregarCliente("12345678-9", "Juan", "Pérez", 5);
        assertEquals(1, clienteServicio.getListaClientes().size());
        Cliente cliente = clienteServicio.getListaClientes().get(0);
        assertEquals("12345678-9", cliente.getRunCliente());
        assertEquals("Juan", cliente.getNombreCliente());
        assertEquals("Pérez", cliente.getApellidoCliente());
        assertEquals(5, cliente.getAniosCliente());
        assertEquals(CategoriaEnum.ACTIVO, cliente.getNombreCategoria());
    }

    @Test
    public void agregarClienteNullTest() {
        clienteServicio.agregarCliente(null, null, null, 0);
        assertEquals(1, clienteServicio.getListaClientes().size());
        Cliente cliente = clienteServicio.getListaClientes().get(0);
        assertNull(cliente.getRunCliente());
        assertNull(cliente.getNombreCliente());
        assertNull(cliente.getApellidoCliente());
        assertEquals(0, cliente.getAniosCliente());
        assertNull(cliente.getNombreCategoria());
    }

    @Test
    void editarClienteTest() {
        Cliente cliente = clienteServicio.editarCliente("12345678-9","98765432-1","Pedro","Lopez",10);
        assertEquals("98765432-1",cliente.getRunCliente());
        assertEquals("Pedro",cliente.getNombreCliente());
        assertEquals("Lopez",cliente.getApellidoCliente());
        assertEquals(10,cliente.getAniosCliente());
    }

    @Test
    void editarClienteNullTest() {
        Cliente cliente = clienteServicio.editarCliente("12345678-9",null,null,null,0);
        assertNull(cliente.getRunCliente());
        assertNull(cliente.getNombreCliente());
        assertNull(cliente.getApellidoCliente());
        assertEquals(0,cliente.getAniosCliente());
    }

    @Test
    void cargarDatosTest() {

    }

    @Test
    void exportarDatos() {

    }

}