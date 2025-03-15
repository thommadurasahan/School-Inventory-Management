package com.beginners.sim.inventory.repository;

import com.beginners.sim.inventory.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    // ToDo
    //  Crete a custom method with native query
}