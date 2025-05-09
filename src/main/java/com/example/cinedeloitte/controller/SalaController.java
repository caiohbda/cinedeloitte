package com.example.cinedeloitte.controller;

import com.example.cinedeloitte.model.dto.SalaRequestDTO;
import com.example.cinedeloitte.model.dto.SalaResponseDTO;
import com.example.cinedeloitte.service.SalaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/salas")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @PostMapping
    public ResponseEntity<SalaResponseDTO> create(@RequestBody @Valid SalaRequestDTO dto) {
        return ResponseEntity.status(201).body(salaService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<SalaResponseDTO>> findAll() {
        return ResponseEntity.ok(salaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(salaService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalaResponseDTO> update(@PathVariable Long id, @RequestBody @Valid SalaRequestDTO dto) {
        return ResponseEntity.ok(salaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        salaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
