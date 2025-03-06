package com.begginers.sim.repair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.begginers.sim.repair.model.Repair;
import com.begginers.sim.repair.repository.RepairRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RepairService {

    @Autowired
    private RepairRepository repairRepository;

    public List<Repair> getAllRepairs() {
        return repairRepository.findAll();
    }

    public Repair getRepairById(int id) {
        return repairRepository.findById(id).orElse(null);
    }

    public Repair addRepair(Repair repair) {
        return repairRepository.save(repair);
    }

    public Repair updateRepair(int id, Repair repair) {
        Optional<Repair> existingRepair = repairRepository.findById(id);
        if (existingRepair.isPresent()) {
            repair.setRepairId(id);
            return repairRepository.save(repair);
        }
        return null;
    }

    public void deleteRepair(int id) {
        repairRepository.deleteById(id);
    }
}
