package com.beginners.sim.inventory.repository;

import com.beginners.sim.inventory.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    // Custom query to find items by date
    @Query(value = "SELECT * FROM items WHERE receivedOn = :receivedOn", nativeQuery = true)
    List<Item> findItemsByDate(@Param("receivedOn") Date receivedOn);
}