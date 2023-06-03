package ru.Irina.ComputerStore.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class LaptopDto extends ProductDto{
    private int diagonal;

    public LaptopDto(Long id, String seriesNumber, String manufacturer, BigDecimal price, int quantity, int diagonal) {
        super(id, seriesNumber, manufacturer, price, quantity);
        this.diagonal = diagonal;
    }
}
