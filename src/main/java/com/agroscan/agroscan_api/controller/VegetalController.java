package com.agroscan.agroscan_api.controller;

import com.agroscan.agroscan_api.dto.request.VegetalRequest;
import com.agroscan.agroscan_api.dto.response.VegetalResponse;
import com.agroscan.agroscan_api.model.Vegetal;
import com.agroscan.agroscan_api.service.VegetalService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.agroscan.agroscan_api.mapper.VegetalMapper;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/vegetais")
public class VegetalController {

    private final VegetalService service;

    public VegetalController(VegetalService service) {
        this.service = service;
    }

    @PostMapping
    public String create(@RequestBody @Valid VegetalRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<Vegetal> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EntityModel<VegetalResponse> findById(@PathVariable Long id) {
        Vegetal vegetal = service.findById(id);
        VegetalResponse response = VegetalMapper.toResponse(vegetal);

        return EntityModel.of(
                response,
                linkTo(methodOn(VegetalController.class).findById(id)).withSelfRel(),
                linkTo(methodOn(VegetalController.class).findAll()).withRel("todos-os-vegetais")
        );
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody @Valid VegetalRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
