package com.gestion.eventos.api.repository;

import com.gestion.eventos.api.domain.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
        boolean existsByEmail(String email);
        Optional<Speaker> findByEmail(String email);

}
