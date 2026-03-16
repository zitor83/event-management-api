package com.gestion.eventos.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SpeakerRequestDto {

    @NotBlank(message = "El nombre del ponente no puede estar vacío")
    @Size(min=3, max=200, message = "El nombre del ponente debe tener entre 3 y 200 caracteres")
    private String name;

    @NotBlank(message = "El email del ponente no puede estar vacío")
    @Email(message = "El formato del email debe ser válido")
    private String email;

    @Size(min=3, max=500, message = "La bio del ponente debe tener entre 3 y 500 caracteres")
    private String bio;

}
