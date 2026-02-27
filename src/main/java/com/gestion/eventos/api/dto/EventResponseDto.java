package com.gestion.eventos.api.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventResponseDto {
    private Long id;

    private String name;
    private String location;
    private LocalDateTime date;
}
