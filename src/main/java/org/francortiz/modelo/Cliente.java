package org.francortiz.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {
    private String nombreCliente;
    private String runCliente;
    private String apellidoCliente;
    private int aniosCliente;
    private CategoriaEnum nombreCategoria = CategoriaEnum.INACTIVO;

    public Cliente(String nombreCliente, String runCliente, String apellidoCliente, int aniosCliente) {
        this.nombreCliente = nombreCliente;
        this.runCliente = runCliente;
        this.apellidoCliente = apellidoCliente;
        this.aniosCliente = aniosCliente;
    }

    public CategoriaEnum alternarEstado() {
        if (this.nombreCategoria == CategoriaEnum.ACTIVO) {
            return CategoriaEnum.INACTIVO;
        } else {
            return CategoriaEnum.ACTIVO;
        }
    }
}
