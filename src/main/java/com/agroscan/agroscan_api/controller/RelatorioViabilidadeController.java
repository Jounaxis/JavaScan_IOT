package com.agroscan.agroscan_api.controller;


import com.agroscan.agroscan_api.dto.request.RelatorioViabilidadeRequest;
import com.agroscan.agroscan_api.model.RelatorioViabilidade;
import com.agroscan.agroscan_api.service.RelatorioViabilidadeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioViabilidadeController {

    private final RelatorioViabilidadeService service;

    public RelatorioViabilidadeController(RelatorioViabilidadeService service) {
        this.service = service;
    }

    @PostMapping
    public String create(@RequestBody @Valid RelatorioViabilidadeRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<RelatorioViabilidade> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EntityModel<RelatorioViabilidade> findById(@PathVariable Long id) {
        RelatorioViabilidade relatorio = service.findById(id);

        return EntityModel.of(
                relatorio,
                linkTo(methodOn(RelatorioViabilidadeController.class).findById(id)).withSelfRel(),
                linkTo(methodOn(RelatorioViabilidadeController.class).findAll()).withRel("todos-os-relatorios")
        );
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody @Valid RelatorioViabilidadeRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }
}