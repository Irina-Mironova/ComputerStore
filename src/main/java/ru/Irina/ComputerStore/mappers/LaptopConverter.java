package ru.Irina.ComputerStore.mappers;

import org.springframework.stereotype.Component;
import ru.Irina.ComputerStore.dtos.LaptopDto;
import ru.Irina.ComputerStore.entities.Laptop;
import ru.Irina.ComputerStore.exceptions.IllegalArgException;

@Component
public class LaptopConverter extends BaseConverter<Laptop, LaptopDto> {

    @Override
    protected void addProductSpecificFields(LaptopDto laptopDto, Laptop laptop) {
        if (laptop.getDiagonal() != 13 && laptop.getDiagonal() != 14 &&
                laptop.getDiagonal() != 15 && laptop.getDiagonal() != 17) {
            throw new IllegalArgException("Wrong laptop diagonal");
        }

        laptopDto.setDiagonal(laptop.getDiagonal());
    }

}
