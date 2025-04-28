package com.beginners.sim.service;

import com.beginners.sim.model.Repair;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RepairService {
    Page<Repair> getAllRepairs(Pageable pageable);

    Repair getRepairById(int id);

    Repair addRepair(Repair repair);

    Repair updateRepair(int id, Repair repair);

    void deleteRepair(int id);
}