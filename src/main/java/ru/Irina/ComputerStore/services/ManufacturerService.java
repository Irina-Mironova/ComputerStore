package ru.Irina.ComputerStore.services;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.Irina.ComputerStore.entities.Manufacturer;
import ru.Irina.ComputerStore.exceptions.ResourceNotFoundException;
import ru.Irina.ComputerStore.repositories.ManufacturerRepository;

@Service
@Data
public class ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;

    public Manufacturer findByTitle(String title) {
        return manufacturerRepository.findByTitle(title).orElseThrow(() ->
                new ResourceNotFoundException("Manufacturer not found"));
    }
}
