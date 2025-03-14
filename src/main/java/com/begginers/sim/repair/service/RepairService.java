package com.begginers.sim.repair.service;

import com.begginers.sim.repair.model.Repair;
import com.begginers.sim.repair.repository.RepairRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RepairService {
    // TODO
    //  Change the class to interface, include only method signatures here
    //  Create a new class RepairServiceImpl, implement it from the Service class and move all code to the Impl class

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
