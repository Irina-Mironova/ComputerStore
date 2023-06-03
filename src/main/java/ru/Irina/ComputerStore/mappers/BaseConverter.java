package ru.Irina.ComputerStore.mappers;

import org.springframework.stereotype.Component;
import ru.Irina.ComputerStore.dtos.ProductDto;
import ru.Irina.ComputerStore.entities.Product;


@Component
public abstract class BaseConverter<E extends Product, D extends ProductDto> {

    public D entityToDto(E entity, D dto) {
        dto.setId(entity.getId());
        dto.setSeriesNumber(entity.getSeriesNumber());
        dto.setManufacturer(entity.getManufacturer().getTitle());
        dto.setPrice(entity.getPrice());
        dto.setQuantity(entity.getQuantity());

        addProductSpecificFields(dto, entity);

        return dto;
    }

    ;

    protected abstract void addProductSpecificFields(D productDto, E product);
}
