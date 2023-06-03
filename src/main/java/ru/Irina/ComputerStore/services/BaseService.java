package ru.Irina.ComputerStore.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.Irina.ComputerStore.dtos.ProductDto;
import ru.Irina.ComputerStore.entities.Manufacturer;
import ru.Irina.ComputerStore.entities.Product;
import ru.Irina.ComputerStore.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public abstract class BaseService<E extends Product, D extends ProductDto, ID> {
    private final ManufacturerService manufacturerService;
    private final ProductService productService;
    protected final JpaRepository<E, ID> repository;

    public E findById(ID id) {
        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format("Product with id=%d not found", id)));
    }

    public List<E> findAll() {
        return repository.findAll();
    }

    @Transactional
    public E addOrUpdateProduct(D productDto, E product) {
        product.setSeriesNumber(productDto.getSeriesNumber());

        Manufacturer manufacturer = manufacturerService.findByTitle(productDto.getManufacturer());
        product.setManufacturer(manufacturer);

        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());

        saveProductSpecificFields(productDto, product);

        productService.save(product);

        return product;
    }

    protected abstract void saveProductSpecificFields(D productDto, E product);
}
