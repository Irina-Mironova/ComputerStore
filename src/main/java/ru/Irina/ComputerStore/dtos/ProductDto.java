package ru.Irina.ComputerStore.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    private Long id;
    private String seriesNumber;
    private String manufacturer;
    private BigDecimal price;
    private int quantity;
}
