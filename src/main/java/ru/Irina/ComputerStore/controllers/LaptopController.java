package ru.Irina.ComputerStore.controllers;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.Irina.ComputerStore.dtos.LaptopDto;
import ru.Irina.ComputerStore.entities.Laptop;
import ru.Irina.ComputerStore.mappers.LaptopConverter;
import ru.Irina.ComputerStore.services.LaptopService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/laptops")
@Tag(name = "Ноутбуки", description = "Методы работы с ноутбуками")
public class LaptopController {
    private final LaptopService laptopService;
    private final LaptopConverter laptopConverter;

    @GetMapping("/{id}")
    public LaptopDto findById(
            @Parameter(description = "идентификатор товара", required = true)
            @PathVariable Long id) {

        return laptopConverter.entityToDto(laptopService.findById(id), new LaptopDto());
    }

    @GetMapping
    public List<LaptopDto> findAll() {
        return laptopService.findAll().stream()
                .map(entity -> laptopConverter.entityToDto(entity, new LaptopDto()))
                .collect(Collectors.toList());
    }

    @PostMapping("/create_laptop")
    @ResponseStatus(HttpStatus.CREATED)
    public LaptopDto add(@RequestBody LaptopDto laptopDto) {
        Laptop laptop = laptopService.addOrUpdateProduct(laptopDto, new Laptop());
        return laptopConverter.entityToDto(laptop, new LaptopDto());
    }

    @PostMapping("/update_laptop")
    @ResponseStatus(HttpStatus.OK)
    public LaptopDto update(@RequestBody LaptopDto laptopDto) {
        Laptop laptop = laptopService.addOrUpdateProduct(laptopDto, laptopService.findById(laptopDto.getId()));
        return laptopConverter.entityToDto(laptop, new LaptopDto());
    }

}
