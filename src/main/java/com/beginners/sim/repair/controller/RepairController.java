package com.beginners.sim.repair.controller;

import com.beginners.sim.common.util.Constant;
import com.beginners.sim.repair.model.Repair;
import com.beginners.sim.repair.service.RepairService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constant.Repair_BASE_URL)
@RequiredArgsConstructor
@Slf4j
public class RepairController {
    // Todo
    //  Create util package, class Constant, hardcode values
    //  Crete base url, create a method with pagination for getAll

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
