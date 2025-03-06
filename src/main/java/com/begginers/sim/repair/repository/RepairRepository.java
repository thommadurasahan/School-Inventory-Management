package com.begginers.sim.repair.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.begginers.sim.repair.model.Repair;

@Repository
public interface RepairRepository extends JpaRepository<Repair, Integer> {
}
