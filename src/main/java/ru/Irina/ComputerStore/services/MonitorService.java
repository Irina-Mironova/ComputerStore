package ru.Irina.ComputerStore.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.Irina.ComputerStore.dtos.MonitorDto;
import ru.Irina.ComputerStore.entities.Monitor;

@Service
public class MonitorService extends BaseService<Monitor, MonitorDto, Long> {

    public MonitorService(ManufacturerService manufacturerService, ProductService productService,
                          JpaRepository<Monitor, Long> repository) {
        super(manufacturerService, productService, repository);
    }

    @Override
    protected void saveProductSpecificFields(MonitorDto monitorDto, Monitor monitor) {
        monitor.setDiagonal(monitorDto.getDiagonal());
    }
}
