package com.beginners.sim.repair.controller;

import com.beginners.sim.repair.model.RepairParty;
import com.beginners.sim.repair.service.RepairPartyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repair-parties")
@RequiredArgsConstructor
@Slf4j
public class RepairPartyController {
    // Todo
    //  Create util package, class Constant, hardcode values
    //  Crete base url, create a method with pagination for getAll

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
