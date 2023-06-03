package ru.Irina.ComputerStore.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class HardDiskDto extends ProductDto {
    private String capacity;

    public HardDiskDto(Long id, String seriesNumber, String manufacturer, BigDecimal price, int quantity, String capacity) {
        super(id, seriesNumber, manufacturer, price, quantity);
        this.capacity = capacity;
    }
}
