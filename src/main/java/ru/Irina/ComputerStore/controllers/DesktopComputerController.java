package ru.Irina.ComputerStore.controllers;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.Irina.ComputerStore.dtos.DesktopComputerDto;
import ru.Irina.ComputerStore.entities.DesktopComputer;
import ru.Irina.ComputerStore.mappers.DesktopComputerConverter;
import ru.Irina.ComputerStore.services.DesktopComputerService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/computers")
@Tag(name = "Настольные компьютеры", description = "Методы работы с настольными компьютерами")
public class DesktopComputerController {
    private final DesktopComputerService desktopComputerService;
    private final DesktopComputerConverter desktopComputerConverter;

    @GetMapping("/{id}")
    public DesktopComputerDto findById(
            @Parameter(description = "идентификатор товара", required = true)
            @PathVariable Long id) {

        return desktopComputerConverter.entityToDto(desktopComputerService.findById(id), new DesktopComputerDto());
    }

    @GetMapping
    public List<DesktopComputerDto> findAll() {
        return desktopComputerService.findAll().stream()
                .map(entity -> desktopComputerConverter.entityToDto(entity, new DesktopComputerDto()))
                .collect(Collectors.toList());
    }

    @PostMapping("/create_desktop_computer")
    @ResponseStatus(HttpStatus.CREATED)
    public DesktopComputerDto add(@RequestBody DesktopComputerDto desktopComputerDto) {
        DesktopComputer desktopComputer = desktopComputerService.addOrUpdateProduct(desktopComputerDto, new DesktopComputer());
        return desktopComputerConverter.entityToDto(desktopComputer, new DesktopComputerDto());
    }

    @PostMapping("/update_desktop_computer")
    @ResponseStatus(HttpStatus.OK)
    public DesktopComputerDto update(@RequestBody DesktopComputerDto desktopComputerDto) {
        DesktopComputer desktopComputer = desktopComputerService.addOrUpdateProduct(desktopComputerDto, desktopComputerService.findById(desktopComputerDto.getId()));
        return desktopComputerConverter.entityToDto(desktopComputer, new DesktopComputerDto());
    }

}
