package com.begginers.sim.repair.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.begginers.sim.repair.model.RepairParty;
import com.begginers.sim.repair.service.RepairPartyService;

import java.util.List;

@RestController
@RequestMapping("/api/repair-parties")
public class RepairPartyController {

    @Autowired
    private RepairParty repairPartyService;

    @GetMapping
    public List<RepairParty> getAllRepairParties() {
        return RepairParty.getAllRepairParties();
    }

    @GetMapping("/{id}")
    public RepairParty getRepairPartyById(@PathVariable int id) {
        return RepairParty.getRepairPartyById(id);
    }

    @PostMapping
    public RepairParty addRepairParty(@RequestBody RepairParty repairParty) {
        try {
            try {
                return RepairPartyService.addRepairParty(repairParty);
            } catch (Exception e) {
            
                e.printStackTrace();
            }
        } catch (Exception e) {
           
            e.printStackTrace();
        }
                return repairParty;
    }

    @PutMapping("/{id}")
    public RepairParty updateRepairParty(@PathVariable int id, @RequestBody RepairParty repairParty) {
        return repairPartyService.updateRepairParty(id, repairParty);
    }

    @DeleteMapping("/{id}")
    public void deleteRepairParty(@PathVariable int id) {
        repairPartyService.addRepairParty(id);
    }
}
