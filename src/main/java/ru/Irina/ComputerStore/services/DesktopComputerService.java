package ru.Irina.ComputerStore.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.Irina.ComputerStore.dtos.DesktopComputerDto;
import ru.Irina.ComputerStore.entities.DesktopComputer;
import ru.Irina.ComputerStore.entities.enums.FormFactorComputer;

@Service
public class DesktopComputerService extends BaseService<DesktopComputer, DesktopComputerDto, Long> {

    public DesktopComputerService(ManufacturerService manufacturerService, ProductService productService,
                                  JpaRepository<DesktopComputer, Long> repository) {
        super(manufacturerService, productService, repository);
    }

    @Override
    protected void saveProductSpecificFields(DesktopComputerDto desktopComputerDto, DesktopComputer desktopComputer) {
        desktopComputer.setFormFactor(FormFactorComputer.fromString(desktopComputerDto.getFormFactor()));
    }
}
