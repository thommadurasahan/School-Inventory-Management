package com.begginers.sim.repair.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.begginers.sim.repair.model.Return;

@Repository
public interface ReturnRepository extends JpaRepository<Return, Integer> {
}
