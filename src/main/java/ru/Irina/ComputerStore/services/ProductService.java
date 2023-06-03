package ru.Irina.ComputerStore.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.Irina.ComputerStore.entities.*;
import ru.Irina.ComputerStore.repositories.ProductRepository;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product save(Product product) {
        productRepository.save(product);

        return product;
    }

}
