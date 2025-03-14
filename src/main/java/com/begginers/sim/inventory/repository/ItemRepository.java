package com.begginers.sim.inventory.repository;

import com.begginers.sim.inventory.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    // ToDo
//  Crete a custom method with native query
}