package org.mahiiru.common;

public enum UseCasesOptions {
    OPTION_1("1)Mostrar todos los libros disponibles."),
    EXIT("0)Terminar programa.");

    private final String description;


    UseCasesOptions(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
