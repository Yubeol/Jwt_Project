package com.example.demo.service;

import com.example.demo.dto.sales.SalesRequest;
import com.example.demo.dto.sales.SalesResponse;
import com.example.demo.entity.Sales;
import com.example.demo.repository.SalesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesService {

    private final SalesRepository salesRepository;

    private SalesResponse toResponse(Sales sales) {
        return SalesResponse.builder()
                .id(sales.getId())
                .userId(sales.getUserId())
                .productId(sales.getProductId())
                .quantity(sales.getQuantity())
                .discountRate(sales.getDiscountRate())
                .totalPrice(sales.getTotalPrice())
                .createdAt(sales.getCreatedAt())
                .build();
    }

    public List<SalesResponse> findAll() {
        return salesRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public SalesResponse findById(Long id) {
        return toResponse(salesRepository.findById(id).orElseThrow());
    }

    public SalesResponse save(SalesRequest salesRequest) {
        Sales sales = Sales.builder()
                .userId(salesRequest.getUserId())
                .productId(salesRequest.getProductId())
                .quantity(salesRequest.getQuantity())
                .discountRate(salesRequest.getDiscountRate())
                .totalPrice(salesRequest.getTotalPrice())
                .createdAt(LocalDateTime.now())
                .build();
        salesRepository.save(sales);
        return toResponse(sales);
    }

    public SalesResponse update(SalesRequest salesRequest, Long id) {
        Sales sales = salesRepository.findById(id).orElseThrow();

        sales.setUserId(salesRequest.getUserId());
        sales.setProductId(salesRequest.getProductId());
        sales.setQuantity(salesRequest.getQuantity());
        sales.setDiscountRate(salesRequest.getDiscountRate());
        sales.setTotalPrice(salesRequest.getTotalPrice());

        salesRepository.save(sales);
        return toResponse(sales);
    }

    public Long delete(Long id) {
        salesRepository.deleteById(id);
        return id;
    }
}