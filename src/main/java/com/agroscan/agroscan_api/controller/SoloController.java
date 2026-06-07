package com.agroscan.agroscan_api.controller;

import com.agroscan.agroscan_api.dto.request.SoloRequest;
import com.agroscan.agroscan_api.model.Solo;
import com.agroscan.agroscan_api.service.SoloService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solos")
public class SoloController {

    private final SoloService service;

    public SoloController(SoloService service) {
        this.service = service;
    }

    @PostMapping
    public String create(@RequestBody @Valid SoloRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<Solo> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Solo findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody @Valid SoloRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }
}