package ru.Irina.ComputerStore.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.Irina.ComputerStore.dtos.HardDiskDto;
import ru.Irina.ComputerStore.entities.HardDisk;

@Service
public class HardDiskService extends BaseService<HardDisk, HardDiskDto, Long> {

    public HardDiskService(ManufacturerService manufacturerService, ProductService productService,
                           JpaRepository<HardDisk, Long> repository) {
        super(manufacturerService, productService, repository);
    }

    @Override
    protected void saveProductSpecificFields(HardDiskDto hardDiskDto, HardDisk hardDisk) {
        hardDisk.setCapacity(hardDiskDto.getCapacity());
    }
}
