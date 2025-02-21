package com.begginers.sim.inventory.repository;

import com.begginers.sim.inventory.model.Supply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplyRepository extends JpaRepository<Supply, Short> {
}
