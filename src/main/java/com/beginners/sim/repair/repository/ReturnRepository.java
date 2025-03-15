package com.beginners.sim.repair.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.beginners.sim.repair.model.Return;

@Repository
public interface ReturnRepository extends JpaRepository<Return, Integer> {
    // ToDo
//  Crete a custom method, custom query
}
