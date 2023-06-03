package ru.Irina.ComputerStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Irina.ComputerStore.entities.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
