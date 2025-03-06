package com.begginers.sim.repair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.begginers.sim.repair.model.ReturnedRepair;
import com.begginers.sim.repair.repository.ReturnedRepairRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReturnedRepairService {

    @Autowired
    private ReturnedRepairRepository returnedRepairRepository;

    public List<ReturnedRepair> getAllReturnedRepairs() {
        return returnedRepairRepository.findAll();
    }

    public ReturnedRepair getReturnedRepairById(int id) {
        return returnedRepairRepository.findById(id).orElse(null);
    }

    public ReturnedRepair addReturnedRepair(ReturnedRepair returnedRepair) {
        return returnedRepairRepository.save(returnedRepair);
    }

    public ReturnedRepair updateReturnedRepair(int id, ReturnedRepair returnedRepair) {
        Optional<ReturnedRepair> existingReturnedRepair = returnedRepairRepository.findById(id);
        if (existingReturnedRepair.isPresent()) {
            returnedRepair.setReturnedRepairId(id);
            return returnedRepairRepository.save(returnedRepair);
        }
        return null;
    }

    public void deleteReturnedRepair(int id) {
        returnedRepairRepository.deleteById(id);
    }
}
