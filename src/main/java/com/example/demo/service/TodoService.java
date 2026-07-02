package com.example.demo.service;

import com.example.demo.dto.todo.TodoRequest;
import com.example.demo.dto.todo.TodoResponse;
import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    private TodoResponse toResponse(Todo todo) {
        return TodoResponse.builder()
                .id(todo.getId())
                .subject(todo.getSubject())
                .checked(todo.getChecked())
                .build();
    }

    public List<TodoResponse> findAll() {
        return todoRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public TodoResponse findById(Long id) {
        return toResponse(todoRepository.findById(id).orElseThrow());
    }

    public TodoResponse save(TodoRequest todoRequest) {
        Todo todo = Todo.builder()
                .subject(todoRequest.getSubject())
                .checked(todoRequest.getChecked())
                .build();
        todoRepository.save(todo);
        return toResponse(todo);
    }

    public TodoResponse update(TodoRequest todoRequest, Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow();

        todo.setSubject(todoRequest.getSubject());
        todo.setChecked(todoRequest.getChecked());

        todoRepository.save(todo);
        return toResponse(todo);
    }

    public Long delete(Long id) {
        todoRepository.deleteById(id);
        return id;
    }
}