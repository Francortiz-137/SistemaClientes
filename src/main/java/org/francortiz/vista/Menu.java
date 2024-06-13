package org.francortiz.vista;

import org.francortiz.modelo.CategoriaEnum;
import org.francortiz.modelo.Cliente;
import org.francortiz.servicio.*;
import org.francortiz.utilidades.Utilidad;

import java.util.Scanner;

public class Menu {

    private ClienteServicio clienteServicio;
    private ArchivoServicio archivoServicio;
    private String fileName = "Clientes";
    private final String fileName1 = "DBClientes.csv";
    private Scanner scanner;
    private static final String PATH = "src/main/java/org/francortiz/archivos/";

    public Menu() {
        clienteServicio = new ClienteServicio();
        archivoServicio = new ArchivoServicio();
        iniciarMenu();
    }

    public void iniciarMenu(){
        scanner = new Scanner(System.in);
        String opcion;
        do {
            System.out.println("\nMenú Inicial");
            System.out.println("1. Listar Clientes");
            System.out.println("2. Agregar Cliente");
            System.out.println("3. Editar Cliente");
            System.out.println("4. Cargar Datos");
            System.out.println("5. Exportar Datos");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");

            opcion = scanner.nextLine();

            Utilidad.limpiarPantalla();
            switch (opcion) {
                case "1":
                    listarClientes();
                    break;
                case "2":
                    agregarCliente();
                    break;
                case "3":
                    editarCliente();
                    break;
                case "4":
                    importarDatos();
                    break;
                case "5":
                    exportarDatos();
                    break;
                case "6":
                    terminarPrograma();
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        } while (!opcion.equals("6"));
        scanner.close();
    }

    public void listarClientes() {
        if(clienteServicio.getListaClientes().isEmpty())
            System.out.println("No hay clientes registrados");
        else
            clienteServicio.getListaClientes().forEach(
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

    public void agregarCliente() {
        System.out.println("-------------Crear Cliente-------------");
        scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del cliente: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese el RUN del cliente: ");
        String run = scanner.nextLine();
        System.out.print("Ingrese los años como cliente: ");
        String aniosString = scanner.nextLine();
        try{
            int anios;
            anios = Integer.parseInt(aniosString);
            clienteServicio.agregarCliente(nombre,run,apellido,anios);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }

    public void editarCliente() {
        System.out.println("-------------Editar Cliente-------------\n");
        scanner = new Scanner(System.in);

        System.out.println("Seleccione qué desea hacer:");
        System.out.println("1.-Cambiar el estado del Cliente");
        System.out.println("2.-Editar los datos ingresados del Cliente\n");
        System.out.println("Ingrese opcion:");
        System.out.println("----------------------------------------");
        String opcion = scanner.nextLine();

        System.out.println("Ingrese el RUN del cliente que desa buscar: ");
        String run = scanner.nextLine();
        if (opcion.equals("1")) {
            System.out.println("-----Actualizando estado del Cliente----");
            Cliente cliente = clienteServicio.getClienteByRun(run);
            System.out.println("El estado actual es: " + cliente.getNombreCategoria());
            System.out.println("1.-Si desea cambiar el estado del Cliente a " + cliente.alternarEstado());
            System.out.println("2.-Si desea mantener el estado del cliente en " + cliente.getNombreCategoria());
            System.out.println("Ingrese opcion:");
            System.out.println("-----------------------------------------");
            String estado = scanner.nextLine();
            System.out.println("\n-----Actualizando estado del Cliente----");
            if (estado.equals("1")) {
                clienteServicio.editarCliente(clienteServicio.getClienteByRun(run),cliente.alternarEstado());
            } else if (estado.equals("2")) {
                System.out.println("El estado se mantuvo " + cliente.getNombreCategoria());
            } else {
                System.out.println("Opcion no valida");
            }
        } else if (opcion.equals("2")) {
            Cliente cliente = clienteServicio.getClienteByRun(run);
            System.out.println("----Actualizando datos del Cliente-----\n");
            System.out.println("1.- El RUN del Cliente es: " + run);
            System.out.println("2.- El Nombre del Cliente es: " + cliente.getNombreCliente());
            System.out.println("3.- El Apellido del Cliente es: " + cliente.getApellidoCliente());
            System.out.println("4.- Los años como Cliente son: " + cliente.getAniosCliente() + " años");
            System.out.println("Ingrese opcion a editar de los datos del cliente:\n");
            String opcionEditar = scanner.nextLine();
            System.out.println("-----------------------------------------");

            switch (opcionEditar) {
                case "1": editarRun(cliente); break;
                case "2": editarNombre(cliente); break;
                case "3": editarApellido(cliente); break;
                case "4": editarAnios(cliente); break;
                default: System.out.println("Ingrese una opcion valida"); break;
            }
        }else {
            System.out.println("Ingrese una opcion valida");
        }
    }

    private void editarRun(Cliente cliente) {
        scanner = new Scanner(System.in);
        System.out.println("----------------------------------------");
        System.out.println("1.- Ingrese el nuevo RUN del Cliente: ");
        String newRun = scanner.nextLine();
        cliente.setRunCliente(newRun);
    }

    private void editarNombre(Cliente cliente) {
        scanner = new Scanner(System.in);
        System.out.println("----------------------------------------");
        System.out.println("2.- Ingrese el nuevo Nombre del Cliente: ");
        String newNombre = scanner.nextLine();
        cliente.setNombreCliente(newNombre);
    }

    private void editarApellido(Cliente cliente) {
        scanner = new Scanner(System.in);
        System.out.println("----------------------------------------");
        System.out.println("3.- Ingrese el nuevo Apellido del Cliente: ");
        String newApellido = scanner.nextLine();
        cliente.setApellidoCliente(newApellido);
    }

    private void editarAnios(Cliente cliente) {
        scanner = new Scanner(System.in);
        System.out.println("----------------------------------------");
        System.out.println("1.- Ingrese los años del Cliente: ");
        String newAnios = scanner.nextLine();
        try {
            cliente.setAniosCliente(Integer.parseInt(newAnios));
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }

    public void importarDatos() {
        scanner = new Scanner(System.in);
        System.out.println("---------Cargar Datos en Linux o Mac-----------\n" +
                "Ingresa la ruta en donde se encuentra el archivo DBClientes.csv:\n" +
                "home/usuario/Desktop\n" +
                "-----------------------------------------------\n"
                );
        archivoServicio = new ArchivoServicio();
        System.out.println("Ingrese el nombre del archivo: ");
        String nombre = scanner.nextLine();
        clienteServicio.setListaClientes(archivoServicio.cargarDatos(PATH+nombre));
        System.out.println("Datos cargados correctamente en la lista");
    }

    public void exportarDatos() {
        System.out.println("Como desea exportar los datos?... (0 = csv,1 = txt)");
        scanner = new Scanner(System.in);
        String formato = scanner.nextLine();
        if (formato.equals("0")) {
            Exportador exportarCsv = new ExportadorCsv();
            exportarCsv.exportar(PATH+this.fileName1,clienteServicio.getListaClientes());
        } else if (formato.equals("1")) {
            Exportador exportarTxt = new ExportadorTxt();
            exportarTxt.exportar(PATH+this.fileName+".txt",clienteServicio.getListaClientes());
        }else{
            System.out.println("Por favor ingrese un valor valido (0 | 1)");
            return;
        }
        System.out.println("Exportando datos de clientes...");

    }

    public void terminarPrograma() {
        System.out.println("Saliendo de la aplicación...");
        scanner.close();
        System.exit(0);
    }
}
