package com.beginners.sim.repository;

import com.beginners.sim.model.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairRepository extends JpaRepository<Repair, Integer> {

    @Query("SELECT r FROM Repair r WHERE r.repairLocation = :location AND r.sentQuantity > :minQuantity")
    List<Repair> findRepairsByLocationAndMinimumQuantity(String location, int minQuantity);
}