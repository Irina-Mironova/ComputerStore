package ru.Irina.ComputerStore.mappers;

import org.springframework.stereotype.Component;
import ru.Irina.ComputerStore.dtos.DesktopComputerDto;
import ru.Irina.ComputerStore.entities.DesktopComputer;

@Component
public class DesktopComputerConverter extends BaseConverter<DesktopComputer, DesktopComputerDto> {

    @Override
    protected void addProductSpecificFields(DesktopComputerDto desktopComputerDto, DesktopComputer desktopComputer) {
        desktopComputerDto.setFormFactor(desktopComputer.getFormFactor().name());
    }
}
