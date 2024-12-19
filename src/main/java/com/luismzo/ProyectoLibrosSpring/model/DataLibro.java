package com.luismzo.ProyectoLibrosSpring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataLibro(
       @JsonAlias("title") String titulo,
       @JsonAlias("authors") List<DataAutor> autores,
       @JsonAlias("languages") List<String> lenguajes,
       @JsonAlias("download_count") Integer cantidad_descargas
) {
}
