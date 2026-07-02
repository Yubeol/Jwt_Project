package com.example.demo.dto.sales;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesResponse {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer quantity;
    private Double discountRate;
    private Integer totalPrice;
    private LocalDateTime createdAt;
}