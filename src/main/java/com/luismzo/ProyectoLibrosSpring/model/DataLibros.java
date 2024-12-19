package com.luismzo.ProyectoLibrosSpring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DataLibros(
        @JsonAlias("results") List<DataLibro> libros
) {
}
