package com.beginners.sim.repair.controller;

import com.beginners.sim.common.util.Constant;
import com.beginners.sim.repair.model.Repair;
import com.beginners.sim.repair.service.RepairService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping(Constant.Repair_BASE_URL)
@RequiredArgsConstructor
@Slf4j
public class RepairController {

    private final RepairService repairService;

    @GetMapping
    public Page<Repair> getAllRepairs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repairService.getAllRepairs(pageable);
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