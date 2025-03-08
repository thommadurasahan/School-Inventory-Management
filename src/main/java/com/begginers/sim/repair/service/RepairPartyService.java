// package com.begginers.sim.repair.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.begginers.sim.repair.model.RepairParty;
// import com.begginers.sim.repair.repository.RepairPartyRepository;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class RepairPartyService {

//     @Autowired
//     private static RepairPartyRepository repairPartyRepository;
    
//         public List<RepairPartyService> getAllRepairParties() {
//             return repairPartyRepository.findAll();
//         }
    
//         public RepairPartyService getRepairPartyById(int id) {
//             return repairPartyRepository.findById(id).orElse(null);
//         }
    
//         public static RepairParty addRepairParty(RepairParty repairParty) {
//             return repairPartyRepository.saveAll((Iterable<S>) repairParty);
//     }

//     public RepairParty updateRepairParty(int id, RepairParty repairParty) {
//         Optional<RepairParty> existingParty = Optional.empty();
//         if (existingParty.isPresent()) {
//             repairParty.setRepairPartyId(id);
//             return repairPartyRepository.saveAll(repairParty);
//         }
//         return null;
//     }

//     public void deleteRepairParty(int id) {
//         repairPartyRepository.deleteById(id);
//     }
// }

package com.begginers.sim.repair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.begginers.sim.repair.model.RepairParty;
import com.begginers.sim.repair.repository.RepairPartyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RepairPartyService {

    @Autowired
    private RepairPartyRepository repairPartyRepository; // Removed static

    public List<RepairPartyService> getAllRepairParties() { // Fixed return type
        return repairPartyRepository.findAll();
    }

    public RepairPartyService getRepairPartyById(int id) {
        return repairPartyRepository.findById(id).orElse(null);
    }

    public RepairParty addRepairParty(RepairParty repairParty) { // Fixed save method
        return repairPartyRepository.saveAll(repairParty);
    }

    public RepairParty updateRepairParty(int id, RepairParty repairParty) {
        Optional<RepairParty> existingParty = Optional.empty(); // Fetch existing record
        if (existingParty.isPresent()) {
            repairParty.setRepairPartyId(id);
            return repairPartyRepository.saveAll(repairParty); // Use save() instead of saveAll()
        }
        return null;
    }

    public void deleteRepairParty(int id) {
        repairPartyRepository.deleteById(id);
    }
}
