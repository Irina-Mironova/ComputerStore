package ru.Irina.ComputerStore.controllers;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.Irina.ComputerStore.dtos.MonitorDto;
import ru.Irina.ComputerStore.entities.Monitor;
import ru.Irina.ComputerStore.mappers.MonitorConverter;
import ru.Irina.ComputerStore.services.MonitorService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/monitors")
@Tag(name = "Мониторы", description = "Методы работы с мониторами")
public class MonitorController {
    private final MonitorService monitorService;
    private final MonitorConverter monitorConverter;

    @GetMapping("/{id}")
    public MonitorDto findById(
            @Parameter(description = "идентификатор товара", required = true)
            @PathVariable Long id) {

        return monitorConverter.entityToDto(monitorService.findById(id), new MonitorDto());
    }

    @GetMapping
    public List<MonitorDto> findAll() {
        return monitorService.findAll().stream()
                .map(entity -> monitorConverter.entityToDto(entity, new MonitorDto()))
                .collect(Collectors.toList());
    }

    @PostMapping("/create_monitor")
    @ResponseStatus(HttpStatus.CREATED)
    public MonitorDto add(@RequestBody MonitorDto monitorDto) {
        Monitor monitor = monitorService.addOrUpdateProduct(monitorDto, new Monitor());
        return monitorConverter.entityToDto(monitor, new MonitorDto());
    }

    @PostMapping("/update_monitor")
    @ResponseStatus(HttpStatus.OK)
    public MonitorDto update(@RequestBody MonitorDto monitorDto) {
        Monitor monitor = monitorService.addOrUpdateProduct(monitorDto, monitorService.findById(monitorDto.getId()));
        return monitorConverter.entityToDto(monitor, new MonitorDto());
    }

}
