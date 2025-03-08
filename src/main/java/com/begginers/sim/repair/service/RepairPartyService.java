package com.begginers.sim.repair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.begginers.sim.repair.model.RepairParty;

import java.util.List;
import java.util.Optional;

@Service
public class RepairPartyService {

    @Autowired
    private static RepairPartyRepository repairPartyRepository;
    
        public List<RepairParty> getAllRepairParties() {
            return repairPartyRepository.findAll();
        }
    
        public RepairParty getRepairPartyById(int id) {
            return repairPartyRepository.findById(id).orElse(null);
        }
    
        public static RepairParty addRepairParty(RepairParty repairParty) {
            return repairPartyRepository.save(repairParty);
    }

    public RepairParty updateRepairParty(int id, RepairParty repairParty) {
        Optional<RepairParty> existingParty = repairPartyRepository.findById(id);
        if (existingParty.isPresent()) {
            repairParty.setRepairPartyId(id);
            return repairPartyRepository.save(repairParty);
        }
        return null;
    }

    public void deleteRepairParty(int id) {
        repairPartyRepository.deleteById(id);
    }
}
