package com.gestion.eventos.api.service;

import com.gestion.eventos.api.domain.Speaker;
import com.gestion.eventos.api.dto.SpeakerRequestDto;

public interface SpeakerService {
    Speaker save(SpeakerRequestDto requestDto);
    Speaker findById(Long id);
    Speaker update(Long id, SpeakerRequestDto requestDto);
    void deleteById(Long id);
}
