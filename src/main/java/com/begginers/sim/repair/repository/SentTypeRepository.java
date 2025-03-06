package com.begginers.sim.repair.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.begginers.sim.repair.model.SentType;

@Repository
public interface SentTypeRepository extends JpaRepository<SentType, Integer> {
}
