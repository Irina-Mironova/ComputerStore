package ru.Irina.ComputerStore.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.Irina.ComputerStore.dtos.LaptopDto;
import ru.Irina.ComputerStore.entities.Laptop;
import ru.Irina.ComputerStore.exceptions.IllegalArgException;

@Service
public class LaptopService extends BaseService<Laptop, LaptopDto, Long> {

    public LaptopService(ManufacturerService manufacturerService, ProductService productService,
                         JpaRepository<Laptop, Long> repository) {
        super(manufacturerService, productService, repository);
    }

    @Override
    protected void saveProductSpecificFields(LaptopDto laptopDto, Laptop laptop) {
        checkDiagonal(laptopDto.getDiagonal());
        laptop.setDiagonal(laptopDto.getDiagonal());
    }

    private void checkDiagonal(int diagonal) {
        if (diagonal != 13 && diagonal != 14 && diagonal != 15 && diagonal != 17) {
            throw new IllegalArgException("Wrong laptop diagonal");
        }
    }
}
