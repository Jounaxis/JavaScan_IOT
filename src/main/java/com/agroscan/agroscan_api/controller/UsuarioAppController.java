package com.agroscan.agroscan_api.controller;


import com.agroscan.agroscan_api.dto.request.UsuarioAppRequest;
import com.agroscan.agroscan_api.model.UsuarioApp;
import com.agroscan.agroscan_api.service.UsuarioAppService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioAppController {

    private final UsuarioAppService service;

    public UsuarioAppController(UsuarioAppService service) {
        this.service = service;
    }

    @PostMapping
    public String create(@RequestBody @Valid UsuarioAppRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<UsuarioApp> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public UsuarioApp findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody @Valid UsuarioAppRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
