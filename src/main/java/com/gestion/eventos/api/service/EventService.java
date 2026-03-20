package com.gestion.eventos.api.service;

import com.gestion.eventos.api.domain.Category;
import com.gestion.eventos.api.domain.Event;
import com.gestion.eventos.api.domain.Speaker;
import com.gestion.eventos.api.dto.EventRequestDto;
import com.gestion.eventos.api.exception.ResourceNotFoundException;
import com.gestion.eventos.api.mapper.EventMapper;
import com.gestion.eventos.api.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService implements IEventService{

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    private final CategoryService categoryService;
    private final SpeakerService speakerService;



    @Override
    @Transactional(readOnly = true)
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    @Transactional
    public Event save(EventRequestDto requestDto) {
        Event event = eventMapper.toEntity(requestDto);

        Category category = categoryService.findById(requestDto.getCategoryId());
        event.setCategory(category);

        if(requestDto.getSpeakerIds() != null && !requestDto.getSpeakerIds().isEmpty()){
            Set<Speaker> speakers = requestDto.getSpeakerIds().stream()
                    .map(speakerService::findById)
                    .collect(Collectors.toSet());

            speakers.forEach(event::addSpeaker);
        }


        return eventRepository.save(event);
    }

    @Override
    @Transactional(readOnly = true)
    public Event findById(Long id) {
        return eventRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Evento no encontrado con id: " + id)
        );
    }

    @Override
    public Event update(Long id, EventRequestDto requestDto) {
        Event existingEvent= eventRepository.findById(id)
                .orElseThrow(
                    () -> new ResourceNotFoundException("Evento no encontrado con id: " + id)
        );
        eventMapper.updateEventFromDto(requestDto, existingEvent);

        if(!existingEvent.getCategory().getId().equals(requestDto.getCategoryId())){
            Category category = categoryService.findById(requestDto.getCategoryId());
            existingEvent.setCategory(category);
        }

        return null;
    }

    @Override
    @Transactional()
    public void deleteById(Long id) {
        Event eventToDelete= this.findById(id);
        eventRepository.delete(eventToDelete);


    }
}
