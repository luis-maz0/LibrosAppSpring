package com.luismzo.ProyectoLibrosSpring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataAutor(
       @JsonAlias("birth_year") Integer fechaNacimiento,
       @JsonAlias("death_year") Integer fechaMuerte,
       @JsonAlias("name") String nombre
) {
}
