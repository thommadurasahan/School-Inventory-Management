package com.begginers.sim.inventory.controller;

import com.begginers.sim.inventory.model.Supply;
import com.begginers.sim.inventory.service.SupplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/supplies")
@RequiredArgsConstructor
@Slf4j
public class SupplyController {

    private final SupplyService supplyService;

    @PostMapping
    public ResponseEntity<Supply> createSupply(@RequestBody Supply supply) {
        log.info("Creating new supply: {}", supply);
        Supply savedSupply = supplyService.saveSupply(supply);
        return ResponseEntity.ok(savedSupply);
    }

    @GetMapping
    public ResponseEntity<List<Supply>> getAllSupplies() {
        List<Supply> supplies = supplyService.getAllSupplies();
        if (supplies.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(supplies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supply> getSupplyById(@PathVariable Long id) {
        Optional<Supply> supply = supplyService.getSupplyById(id);
        return supply.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supply> updateSupply(@PathVariable Long id, @RequestBody Supply updatedSupply) {
        log.info("Updating supply with ID: {}", id);
        return supplyService.getSupplyById(id)
                .map(supply -> {
                    // Update supply fields based on your Supply model
                    Supply saved = supplyService.saveSupply(updatedSupply);
                    return ResponseEntity.ok(saved);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupply(@PathVariable Long id) {
        log.info("Deleting supply with ID: {}", id);
        supplyService.deleteSupply(id);
        return ResponseEntity.noContent().build();
    }
}