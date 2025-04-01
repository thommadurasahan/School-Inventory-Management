package com.beginners.sim.repair.service;

import com.beginners.sim.repair.exception.RepairNotFoundException;
import com.beginners.sim.repair.model.Repair;
import com.beginners.sim.repair.repository.RepairRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RepairServiceImpl implements RepairService {

    private final RepairRepository repairRepository;

    @Override
    public Page<Repair> getAllRepairs(Pageable pageable) {
        log.info("Fetching all repairs with pagination: {}", pageable);
        return repairRepository.findAll(pageable);
    }

    @Override
    public Repair getRepairById(int id) {
        log.info("Fetching repair with ID: {}", id);
        return repairRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Repair with ID {} not found", id);
                    return new RepairNotFoundException(id);
                });
    }

    @Override
    public Repair addRepair(Repair repair) {
        log.info("Adding new repair: {}", repair);
        Repair savedRepair = repairRepository.save(repair);
        log.info("Successfully added repair with ID: {}", savedRepair.getRepairId());
        return savedRepair;
    }

    @Override
    public Repair updateRepair(int id, Repair repair) {
        log.info("Updating repair with ID: {}", id);
        Optional<Repair> existingRepair = repairRepository.findById(id);
        if (existingRepair.isPresent()) {
            repair.setRepairId(id); // Ensure the ID is set to maintain consistency
            Repair updatedRepair = repairRepository.save(repair);
            log.info("Successfully updated repair with ID: {}", id);
            return updatedRepair;
        } else {
            log.error("Cannot update - Repair with ID {} not found", id);
            throw new RepairNotFoundException(id);
        }
    }

    @Override
    public void deleteRepair(int id) {
        log.info("Attempting to delete repair with ID: {}", id);
        if (!repairRepository.existsById(id)) {
            log.error("Cannot delete - Repair with ID {} not found", id);
            throw new RepairNotFoundException(id);
        }
        repairRepository.deleteById(id);
        log.info("Successfully deleted repair with ID: {}", id);
    }
}