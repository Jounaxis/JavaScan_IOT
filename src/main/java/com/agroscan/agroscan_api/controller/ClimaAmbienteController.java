package com.agroscan.agroscan_api.controller;

import com.agroscan.agroscan_api.dto.request.ClimaAmbienteRequest;
import com.agroscan.agroscan_api.model.ClimaAmbiente;
import com.agroscan.agroscan_api.service.ClimaAmbienteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;

@RestController
@RequestMapping("/climas")
public class ClimaAmbienteController {

    private final ClimaAmbienteService service;

    public ClimaAmbienteController(ClimaAmbienteService service) {
        this.service = service;
    }

    @PostMapping
    public String create(@RequestBody @Valid ClimaAmbienteRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<ClimaAmbiente> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EntityModel<ClimaAmbiente> findById(@PathVariable Long id) {
        ClimaAmbiente clima = service.findById(id);

        return EntityModel.of(
                clima,
                linkTo(methodOn(ClimaAmbienteController.class).findById(id)).withSelfRel(),
                linkTo(methodOn(ClimaAmbienteController.class).findAll()).withRel("todos-os-climas")
        );
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody @Valid ClimaAmbienteRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }
}