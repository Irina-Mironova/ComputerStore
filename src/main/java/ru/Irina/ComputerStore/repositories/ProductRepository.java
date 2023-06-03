package ru.Irina.ComputerStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Irina.ComputerStore.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
