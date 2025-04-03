package com.beginners.sim.repair.controller;

import com.beginners.sim.common.util.Constant;
import com.beginners.sim.repair.model.Repair;
import com.beginners.sim.repair.service.RepairService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping(Constant.Repair_BASE_URL)
public class RepairController {

    private static final Logger log = LoggerFactory.getLogger(RepairController.class);

    private final RepairService repairService;

    public RepairController(RepairService repairService) {
        this.repairService = repairService;
    }

    @GetMapping
    public Page<Repair> getAllRepairs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        log.info("Fetching repairs with page: {} and size: {}", page, size);
        return repairService.getAllRepairs(pageable);
    }

    @GetMapping("/{id}")
    public Repair getRepairById(@PathVariable int id) {
        log.info("Fetching repair with ID: {}", id);
        return repairService.getRepairById(id);
    }

    @PostMapping
    public Repair addRepair(@RequestBody Repair repair) {
        log.info("Adding new repair: {}", repair);
        return repairService.addRepair(repair);
    }

    @PutMapping("/{id}")
    public Repair updateRepair(@PathVariable int id, @RequestBody Repair repair) {
        log.info("Updating repair with ID: {}", id);
        return repairService.updateRepair(id, repair);
    }

    @DeleteMapping("/{id}")
    public void deleteRepair(@PathVariable int id) {
        log.info("Deleting repair with ID: {}", id);
        repairService.deleteRepair(id);
    }
}