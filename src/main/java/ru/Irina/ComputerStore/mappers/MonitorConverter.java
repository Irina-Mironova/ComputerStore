package ru.Irina.ComputerStore.mappers;

import org.springframework.stereotype.Component;
import ru.Irina.ComputerStore.dtos.MonitorDto;
import ru.Irina.ComputerStore.entities.Monitor;

@Component
public class MonitorConverter extends BaseConverter<Monitor, MonitorDto> {

    @Override
    protected void addProductSpecificFields(MonitorDto monitorDto, Monitor monitor) {
        monitorDto.setDiagonal(monitor.getDiagonal());
    }
}
