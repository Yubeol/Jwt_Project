package com.example.demo.controller;

import com.example.demo.dto.sales.SalesRequest;
import com.example.demo.dto.sales.SalesResponse;
import com.example.demo.service.SalesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SalesController {

    private final SalesService salesService;

    @GetMapping
    public List<SalesResponse> findAll() {
        return salesService.findAll();
    }

    @GetMapping("/{id}")
    public SalesResponse findById(@PathVariable Long id) {
        return salesService.findById(id);
    }

    @PostMapping
    public SalesResponse save(@Valid @RequestBody SalesRequest salesRequest) {
        return salesService.save(salesRequest);
    }

    @PutMapping("/{id}")
    public SalesResponse update(@Valid @RequestBody SalesRequest salesRequest, @PathVariable Long id) {
        return salesService.update(salesRequest, id);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        return salesService.delete(id);
    }
}