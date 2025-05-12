package com.example.cinedeloitte.controller;

import com.example.cinedeloitte.model.dto.ReservaRequestDTO;
import com.example.cinedeloitte.model.dto.ReservaResponseDTO;
import com.example.cinedeloitte.service.ReservaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<ReservaResponseDTO> create(@RequestBody @Valid ReservaRequestDTO dto) {
        return ResponseEntity.status(201).body(reservaService.create(dto));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ReservaResponseDTO>> findAll() {
        return ResponseEntity.ok(reservaService.findAll());
    }

    @GetMapping("/futuras")
    public ResponseEntity<List<ReservaResponseDTO>> findReservasFuturas() {
        return ResponseEntity.ok(reservaService.findReservasFuturas());
    }

    @GetMapping("/sala/{salaId}")
    public ResponseEntity<List<ReservaResponseDTO>> findBySala(@PathVariable Long salaId) {
        return ResponseEntity.ok(reservaService.findBySala(salaId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancel(@PathVariable Long id) {
        reservaService.cancel(id);
        return ResponseEntity.noContent().build();
    }
}
