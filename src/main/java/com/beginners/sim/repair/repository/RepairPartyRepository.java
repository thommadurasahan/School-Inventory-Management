package com.beginners.sim.repair.repository;

import com.beginners.sim.repair.model.RepairParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairPartyRepository extends JpaRepository<RepairParty, Integer> {
    // ToDo
//  Crete a custom method, custom query
}
