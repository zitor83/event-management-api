package com.gestion.eventos.api.controller;

import com.gestion.eventos.api.domain.Event;
import com.gestion.eventos.api.dto.EventRequestDto;
import com.gestion.eventos.api.dto.EventResponseDto;
import com.gestion.eventos.api.mapper.EventMapper;
import com.gestion.eventos.api.service.IEventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
@Tag(name="Eventos",description = "Operaciones relacionales con la gestión de eventos")
public class EventController {

    private final IEventService eventService;
    private final EventMapper eventMapper;

    @GetMapping("/problematic")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<Event>> getAllEventsProblematic() {
        List<Event> events = eventService.getAllEventsAndTheirDetailsProblematic();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/optimized-join-fetch")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<Event>> getAllEventsOptimizeWithJoinFetch() {
        List<Event> events = eventService.getAllEventsAndTheirDetailsOptimizeWithJoinFetch();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/optimized/all-details")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<Event>> getAllEventsWithAllDetails() {
        List<Event> events = eventService.findAllEventsWithAllDetailsOptimized();
        return ResponseEntity.ok(events);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<Page<EventResponseDto>> getAllEvents(

            @RequestParam(required = false) String name,
            @PageableDefault(size = 10, page = 0,sort= "name") Pageable pageable) {
        Page<EventResponseDto> events = eventService.findAll(name, pageable);

        return ResponseEntity.ok(events);
    }

    @PostMapping
    @PreAuthorize( "hasAnyRole('ADMIN')" )
    public ResponseEntity<EventResponseDto> createEvent(@Valid @RequestBody EventRequestDto requestDto) {
        Event eventSaved = eventService.save(requestDto);
        EventResponseDto responseDto = eventMapper.toResponseDto(eventSaved);

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @PreAuthorize( "hasAnyRole('ADMIN', 'USER')" )
    public ResponseEntity<EventResponseDto> getEventById(@PathVariable Long id) {
        Event event = eventService.findById(id);
        EventResponseDto responseDto = eventMapper.toResponseDto(event);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize( "hasAnyRole('ADMIN')" )
    @Operation(summary = "Actualiza un evento por su ID",description = "Modifica los datos de un evento existente en el sistema tras validar la información.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Evento encontrado exitosamente"),
                    @ApiResponse(responseCode = "404", description = "Evento no encontrado")
            }
    )
    public ResponseEntity<EventResponseDto> updateEvent(@PathVariable Long id,
                                                        @Valid @RequestBody EventRequestDto requestDto) {

        Event updatedEvent = eventService.update(id,requestDto);
        return ResponseEntity.ok(eventMapper.toResponseDto(updatedEvent));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize( "hasAnyRole('ADMIN')" )
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteById(id);
        return ResponseEntity.noContent().build();


    }

}
