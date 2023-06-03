package ru.Irina.ComputerStore.controllers;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.Irina.ComputerStore.dtos.HardDiskDto;
import ru.Irina.ComputerStore.entities.HardDisk;
import ru.Irina.ComputerStore.mappers.HardDiskConverter;
import ru.Irina.ComputerStore.services.HardDiskService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hard_disks")
@Tag(name = "Жесткие диски", description = "Методы работы с жесткими дисками")
public class HardDiskController {
    private final HardDiskService hardDiskService;
    private final HardDiskConverter hardDiskConverter;

    @GetMapping("/{id}")
    public HardDiskDto findById(
            @Parameter(description = "идентификатор товара", required = true)
            @PathVariable Long id) {

        return hardDiskConverter.entityToDto(hardDiskService.findById(id), new HardDiskDto());
    }

    @GetMapping
    public List<HardDiskDto> findAll() {
        return hardDiskService.findAll().stream()
                .map(entity -> hardDiskConverter.entityToDto(entity, new HardDiskDto()))
                .collect(Collectors.toList());
    }

    @PostMapping("/create_hard_disk")
    @ResponseStatus(HttpStatus.CREATED)
    public HardDiskDto add(@RequestBody HardDiskDto hardDiskDto) {
        HardDisk hardDisk = hardDiskService.addOrUpdateProduct(hardDiskDto, new HardDisk());
        return hardDiskConverter.entityToDto(hardDisk, new HardDiskDto());
    }

    @PostMapping("/update_hard_disk")
    @ResponseStatus(HttpStatus.OK)
    public HardDiskDto update(@RequestBody HardDiskDto hardDiskDto) {
        HardDisk hardDisk = hardDiskService.addOrUpdateProduct(hardDiskDto, hardDiskService.findById(hardDiskDto.getId()));
        return hardDiskConverter.entityToDto(hardDisk, new HardDiskDto());
    }

}
