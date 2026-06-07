package com.agroscan.agroscan_api.controller;


import com.agroscan.agroscan_api.dto.request.CorpoCelesteRequest;
import com.agroscan.agroscan_api.model.CorpoCeleste;
import com.agroscan.agroscan_api.service.CorpoCelesteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;

@RestController
@RequestMapping("/corpos-celestes")
public class CorpoCelesteController {

    private final CorpoCelesteService service;

    public CorpoCelesteController(CorpoCelesteService service) {
        this.service = service;
    }

    @PostMapping
    public String create(@RequestBody @Valid CorpoCelesteRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<CorpoCeleste> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EntityModel<CorpoCeleste> findById(@PathVariable Long id) {
        CorpoCeleste corpo = service.findById(id);

        return EntityModel.of(
                corpo,
                linkTo(methodOn(CorpoCelesteController.class).findById(id)).withSelfRel(),
                linkTo(methodOn(CorpoCelesteController.class).findAll()).withRel("todos-os-corpos-celestes")
        );
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody @Valid CorpoCelesteRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }
}