package com.example.demo.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    @NotBlank
    private String productName;

    @NotBlank
    private String color;

    @NotNull
    private Integer price;

    private Integer salePrice;

    private String categoryCode;
}