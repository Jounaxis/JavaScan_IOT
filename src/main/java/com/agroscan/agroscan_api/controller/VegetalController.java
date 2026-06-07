package com.agroscan.agroscan_api.controller;

import com.agroscan.agroscan_api.dto.request.VegetalRequest;
import com.agroscan.agroscan_api.model.Vegetal;
import com.agroscan.agroscan_api.service.VegetalService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Vegetal findById(@PathVariable Long id) {
        return service.findById(id);
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
