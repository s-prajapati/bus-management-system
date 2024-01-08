package com.example.BusManagementProject.repository;

import com.example.BusManagementProject.model.Bus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {

    @Transactional
    void deleteByRegNumber(String regNumber);

    Optional<Bus> findBusByRegNumber(String regNumber);
}
