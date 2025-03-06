package com.begginers.sim.repair.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairPartyRepository extends JpaRepository<RepairPartyService, Integer> {
}
