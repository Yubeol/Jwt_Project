package com.example.demo.dto.todo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoRequest {
    @NotBlank
    private String subject;

    @NotNull
    private Boolean checked;
}