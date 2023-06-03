package ru.Irina.ComputerStore.mappers;

import org.springframework.stereotype.Component;
import ru.Irina.ComputerStore.dtos.ProductDto;
import ru.Irina.ComputerStore.entities.Product;

@Component
public class ProductConverter extends BaseConverter<Product, ProductDto> {

    @Override
    protected void addProductSpecificFields(ProductDto productDto, Product product) {

    }
}
