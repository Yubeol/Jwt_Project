package com.example.demo.controller;

import com.example.demo.dto.todo.TodoRequest;
import com.example.demo.dto.todo.TodoResponse;
import com.example.demo.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public List<TodoResponse> findAll() {
        return todoService.findAll();
    }

    @GetMapping("/{id}")
    public TodoResponse findById(@PathVariable Long id) {
        return todoService.findById(id);
    }

    @PostMapping
    public TodoResponse save(@Valid @RequestBody TodoRequest todoRequest) {
        return todoService.save(todoRequest);
    }

    @PutMapping("/{id}")
    public TodoResponse update(@Valid @RequestBody TodoRequest todoRequest, @PathVariable Long id) {
        return todoService.update(todoRequest, id);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        return todoService.delete(id);
    }
}