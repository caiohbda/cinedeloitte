package com.example.cinedeloitte.repository;

import com.example.cinedeloitte.model.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala, Long> {
    boolean existsByNome(String nome);
}
