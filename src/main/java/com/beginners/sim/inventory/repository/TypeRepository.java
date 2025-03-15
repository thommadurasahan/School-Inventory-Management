package com.beginners.sim.inventory.repository;

import com.beginners.sim.inventory.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
    // ToDo
    //  Crete a custom method, custom query
}
