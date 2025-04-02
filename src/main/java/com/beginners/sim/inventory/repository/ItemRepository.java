package com.beginners.sim.inventory.repository;

import com.beginners.sim.inventory.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // Custom query to find items by date
    @Query(value = "SELECT * FROM item WHERE received_on = :receivedOn", nativeQuery = true)
    List<Item> findItemsByDate(@Param("receivedOn") Date receivedOn);
}