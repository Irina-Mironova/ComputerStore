package ru.Irina.ComputerStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Irina.ComputerStore.entities.HardDisk;

@Repository
public interface HardDiskRepository extends JpaRepository<HardDisk, Long> {
}
