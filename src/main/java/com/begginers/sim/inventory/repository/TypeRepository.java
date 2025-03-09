package com.begginers.sim.inventory.repository;

import com.begginers.sim.inventory.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
    // ToDo
//  Crete a custom method, custom query
}
