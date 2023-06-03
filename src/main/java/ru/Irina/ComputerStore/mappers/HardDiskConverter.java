package ru.Irina.ComputerStore.mappers;

import org.springframework.stereotype.Component;
import ru.Irina.ComputerStore.dtos.HardDiskDto;
import ru.Irina.ComputerStore.entities.HardDisk;

@Component
public class HardDiskConverter extends BaseConverter<HardDisk, HardDiskDto> {


    @Override
    protected void addProductSpecificFields(HardDiskDto hardDiskDto, HardDisk hardDisk) {
        hardDiskDto.setCapacity(hardDisk.getCapacity());
    }
}
