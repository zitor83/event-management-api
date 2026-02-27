package com.gestion.eventos.api.dto;


import lombok.Data;


import java.time.LocalDateTime;

@Data
public class EventRequestDto {
    private String name;
    private LocalDateTime date;
    private String location;
}
