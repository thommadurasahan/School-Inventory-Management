package com.begginers.sim.inventory.controller;

import com.begginers.sim.inventory.model.Supply;
import com.begginers.sim.inventory.repository.SupplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/supply")
@RequiredArgsConstructor
public class SupplyController {

    private final SupplyRepository supplyRepository;

    @PostMapping
    public Supply insertSupply(@RequestBody Supply supply) {
        return supplyRepository.save(supply);
    }

    @GetMapping
    public List<Supply> getAllSupplies() {
        return supplyRepository.findAll();
    }
}
