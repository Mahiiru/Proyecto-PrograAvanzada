package org.mahiiru.common;

public enum UseCasesOptions {
    OPTION_1("1)Mostrar todos los libros disponibles."),
    OPTION_2("2)Mostrar todos los clientes."),
    OPTION_3("3)Ingresar nuevo cliente."),
    OPTION_4("4)Mostrar listado de archivos de ventas."),
    OPTION_5("5)Mostrar un archivo de venta ingresando el nombre del archivo."),
    OPTION_6("6)Realizar nueva venta seleccionando cliente y libros."),
    EXIT("0)Terminar programa.");

    private final String description;


    UseCasesOptions(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
