package com.beginners.sim.repair.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.beginners.sim.repair.model.Repair;

@Repository
public interface RepairRepository extends JpaRepository<Repair, Integer> {
    // ToDo
//  Crete a custom method, custom query
}
