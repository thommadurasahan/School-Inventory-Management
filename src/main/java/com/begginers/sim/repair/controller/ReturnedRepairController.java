package com.begginers.sim.repair.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.begginers.sim.repair.model.ReturnedRepair;
import com.begginers.sim.repair.service.ReturnedRepairService;

import java.util.List;

@RestController
@RequestMapping("/api/returned-repairs")
public class ReturnedRepairController {

    @Autowired
    private ReturnedRepairService returnedRepairService;

    @GetMapping
    public List<ReturnedRepair> getAllReturnedRepairs() {
        return returnedRepairService.getAllReturnedRepairs();
    }

    @GetMapping("/{id}")
    public ReturnedRepair getReturnedRepairById(@PathVariable int id) {
        return returnedRepairService.getReturnedRepairById(id);
    }

    @PostMapping
    public ReturnedRepair addReturnedRepair(@RequestBody ReturnedRepair returnedRepair) {
        return returnedRepairService.addReturnedRepair(returnedRepair);
    }

    @PutMapping("/{id}")
    public ReturnedRepair updateReturnedRepair(@PathVariable int id, @RequestBody ReturnedRepair returnedRepair) {
        return returnedRepairService.updateReturnedRepair(id, returnedRepair);
    }

    @DeleteMapping("/{id}")
    public void deleteReturnedRepair(@PathVariable int id) {
        returnedRepairService.deleteReturnedRepair(id);
    }
}
