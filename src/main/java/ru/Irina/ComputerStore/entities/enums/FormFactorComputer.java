package ru.Irina.ComputerStore.entities.enums;

import ru.Irina.ComputerStore.exceptions.IllegalArgException;

import java.util.Locale;

public enum FormFactorComputer {
    DESKTOP,
    MONOBLOCK,
    NETTOP;

    public static FormFactorComputer fromString(String formFactor) {
        for (FormFactorComputer type : values()) {
            if (type.name().equals(formFactor.toUpperCase(Locale.ROOT))) {
                return type;
            }
        }
        throw new IllegalArgException("Unknown form_factor for desktop computers");
    }

}
