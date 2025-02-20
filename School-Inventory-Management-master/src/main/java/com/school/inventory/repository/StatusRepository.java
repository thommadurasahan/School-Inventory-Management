package com.school.inventory.repository;

import com.school.inventory.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Byte> {
    // Add custom query methods if needed
}
