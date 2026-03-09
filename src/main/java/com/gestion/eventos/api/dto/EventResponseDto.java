package com.gestion.eventos.api.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.gestion.eventos.api.domain.Category;
import com.gestion.eventos.api.domain.Speaker;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


@Data
@JsonPropertyOrder({"id", "name", "location", "date"}) // Especifica el orden de las propiedades en la respuesta JSON
public class EventResponseDto {
    private Long id;
    private String name;
    private String location;
    private LocalDate date;
    private Category category;
    private List<SpeakerDto> speakerDtos;
}
