package com.beginners.sim.inventory.repository;

import com.beginners.sim.inventory.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    // ToDo
//  Crete a custom method, custom query
}
