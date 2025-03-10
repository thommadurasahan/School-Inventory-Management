package com.begginers.sim.repair.controller;

import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.begginers.sim.repair.model.Repair;
import com.begginers.sim.repair.service.RepairService;

import java.util.List;

@RestController
@RequestMapping("/api/repairs")
@RequiredArgsConstructor
public class RepairController {
    // Todo
    //  Create util package, class Constant, hardcode values
    //  Crete base url, create a method with pagination for getAll

    @Autowired
    private RepairService repairService;

    @GetMapping
    public List<Repair> getAllRepairs() {
        return repairService.getAllRepairs();
    }

    @GetMapping("/{id}")
    public Repair getRepairById(@PathVariable int id) {
        return repairService.getRepairById(id);
    }

    @PostMapping
    public Repair addRepair(@RequestBody Repair repair) {
        return repairService.addRepair(repair);
    }

    @PutMapping("/{id}")
    public Repair updateRepair(@PathVariable int id, @RequestBody Repair repair) {
        return repairService.updateRepair(id, repair);
    }

    @DeleteMapping("/{id}")
    public void deleteRepair(@PathVariable int id) {
        repairService.deleteRepair(id);
    }
}
