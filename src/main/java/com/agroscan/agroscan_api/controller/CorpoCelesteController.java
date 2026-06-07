package com.agroscan.agroscan_api.controller;


import com.agroscan.agroscan_api.dto.request.CorpoCelesteRequest;
import com.agroscan.agroscan_api.model.CorpoCeleste;
import com.agroscan.agroscan_api.service.CorpoCelesteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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
    public CorpoCeleste findById(@PathVariable Long id) {
        return service.findById(id);
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