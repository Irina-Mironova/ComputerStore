package ru.Irina.ComputerStore.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seriesNumber;

    @ManyToOne
    @JoinColumn(name = "manufacturer_Id")
    private Manufacturer manufacturer;

    private BigDecimal price;
    private int quantity;

    public Long getId() {
        return id;
    }

    public String getSeriesNumber() {
        return seriesNumber;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
