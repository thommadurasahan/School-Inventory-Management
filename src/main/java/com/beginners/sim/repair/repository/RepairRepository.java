package com.beginners.sim.repair.repository;

import com.beginners.sim.repair.model.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairRepository extends JpaRepository<Repair, Integer> {

    @Query("SELECT r FROM repair r WHERE r.repairLocation = :location AND r.sentQuantity > :minQuantity")
    List<Repair> findRepairsByLocationAndMinimumQuantity(String location, int minQuantity);
}