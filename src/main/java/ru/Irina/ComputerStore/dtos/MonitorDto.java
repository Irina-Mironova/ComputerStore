package ru.Irina.ComputerStore.dtos;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class MonitorDto extends ProductDto {
    private float diagonal;

    public MonitorDto(Long id, String seriesNumber, String manufacturer, BigDecimal price, int quantity, float diagonal) {
        super(id, seriesNumber, manufacturer, price, quantity);
        this.diagonal = diagonal;
    }


}
