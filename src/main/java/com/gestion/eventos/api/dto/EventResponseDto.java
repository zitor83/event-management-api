package com.gestion.eventos.api.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.LocalDate;


@Data
@JsonPropertyOrder({"id", "name", "location", "date"}) // Especifica el orden de las propiedades en la respuesta JSON
public class EventResponseDto {
    private Long id;
    private String name;
    private String location;
    private LocalDate date;
}
