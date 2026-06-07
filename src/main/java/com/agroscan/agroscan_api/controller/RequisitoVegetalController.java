package com.agroscan.agroscan_api.controller;

import com.agroscan.agroscan_api.dto.request.RequisitoVegetalRequest;
import com.agroscan.agroscan_api.model.RequisitoVegetal;
import com.agroscan.agroscan_api.service.RequisitoVegetalService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;

@RestController
@RequestMapping("/requisitos-vegetais")
public class RequisitoVegetalController {

    private final RequisitoVegetalService service;

    public RequisitoVegetalController(RequisitoVegetalService service) {
        this.service = service;
    }

    @PostMapping
    public String create(@RequestBody @Valid RequisitoVegetalRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<RequisitoVegetal> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EntityModel<RequisitoVegetal> findById(@PathVariable Long id) {
        RequisitoVegetal requisito = service.findById(id);

        return EntityModel.of(
                requisito,
                linkTo(methodOn(RequisitoVegetalController.class).findById(id)).withSelfRel(),
                linkTo(methodOn(RequisitoVegetalController.class).findAll()).withRel("todos-os-requisitos-vegetais")
        );
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody @Valid RequisitoVegetalRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }
}