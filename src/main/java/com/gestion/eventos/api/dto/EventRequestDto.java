package com.gestion.eventos.api.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


import java.time.LocalDate;


@Data
public class EventRequestDto {
    @NotBlank(message = "El nombre del evento no puede estar vacío")
    @Size(min=3, max=100, message = "El nombre del evento debe tener entre 3 y 100 caracteres")
    private String name;

    @NotNull(message = "La fecha del evento no puede ser nula")
    private LocalDate date;

    @NotBlank(message = "La ubicación del evento no puede estar vacía")
    @Size(min=3, max=100, message = "La ubicación del evento debe tener entre 3 y 100 caracteres")
    private String location;
}
