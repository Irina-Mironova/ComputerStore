package ru.Irina.ComputerStore.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class DesktopComputerDto extends ProductDto {
    private String formFactor;

    public DesktopComputerDto(Long id, String seriesNumber, String manufacturer, BigDecimal price, int quantity, String formFactor) {
        super(id, seriesNumber, manufacturer, price, quantity);
        this.formFactor = formFactor;
    }
}
