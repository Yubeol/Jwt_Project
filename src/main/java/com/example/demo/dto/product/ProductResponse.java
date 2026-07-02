package com.example.demo.dto.product;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private Long id;
    private String productName;
    private String color;
    private Integer price;
    private Integer salePrice;
    private String categoryCode;
}