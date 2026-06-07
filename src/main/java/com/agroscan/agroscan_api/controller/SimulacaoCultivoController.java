package com.agroscan.agroscan_api.controller;

import com.agroscan.agroscan_api.dto.request.SimulacaoCultivoRequest;
import com.agroscan.agroscan_api.dto.response.SimulacaoCultivoResponse;
import com.agroscan.agroscan_api.model.SimulacaoCultivo;
import com.agroscan.agroscan_api.service.SimulacaoCultivoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/simulacoes")
public class SimulacaoCultivoController {

    private final SimulacaoCultivoService service;

    public SimulacaoCultivoController(SimulacaoCultivoService service) {
        this.service = service;
    }

    @PostMapping
    public String create(@RequestBody @Valid SimulacaoCultivoRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<SimulacaoCultivo> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public SimulacaoCultivoResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody @Valid SimulacaoCultivoRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }
}