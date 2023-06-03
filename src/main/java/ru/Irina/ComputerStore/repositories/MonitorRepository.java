package ru.Irina.ComputerStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Irina.ComputerStore.entities.Monitor;

@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Long> {
}
