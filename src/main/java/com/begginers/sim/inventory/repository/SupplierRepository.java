package com.begginers.sim.inventory.repository;

import com.begginers.sim.inventory.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Byte> {
}
