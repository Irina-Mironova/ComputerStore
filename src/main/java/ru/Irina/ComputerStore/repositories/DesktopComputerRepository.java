package ru.Irina.ComputerStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Irina.ComputerStore.entities.DesktopComputer;

@Repository
public interface DesktopComputerRepository extends JpaRepository<DesktopComputer, Long> {
}
