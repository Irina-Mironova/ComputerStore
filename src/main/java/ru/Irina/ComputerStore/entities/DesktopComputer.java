package ru.Irina.ComputerStore.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.Irina.ComputerStore.entities.enums.FormFactorComputer;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "desktop_computers")
public class DesktopComputer extends Product {

    @Enumerated(EnumType.STRING)
    private FormFactorComputer formFactor;
}
