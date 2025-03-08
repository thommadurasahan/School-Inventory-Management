package com.begginers.sim.inventory.controller;

import com.begginers.sim.inventory.model.Supplier;
import com.begginers.sim.inventory.service.SupplierService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/suppliers")
@RequiredArgsConstructor
@Slf4j
public class SupplierController {

    private final SupplierService supplierService;

    @PostMapping
    public ResponseEntity<Supplier> insertSupplier(@RequestBody Supplier supplier) {
        log.info("Inserting new supplier: {}", supplier);
        Supplier savedSupplier = supplierService.saveSupplier(supplier);
        return ResponseEntity.ok(savedSupplier);
    }

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        if (suppliers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(suppliers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
        Optional<Supplier> supplier = supplierService.getSupplierById(id);
        return supplier.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable Long id, @RequestBody Supplier updatedSupplier) {
        log.info("Updating supplier with ID: {}", id);
        return supplierService.getSupplierById(id)
                .map(supplier -> {
                    supplier.setSupplierName(updatedSupplier.getSupplierName());
                    supplier.setSupplierAddress(updatedSupplier.getSupplierAddress());
                    supplier.setSupplierContactNo(updatedSupplier.getSupplierContactNo());
                    Supplier saved = supplierService.saveSupplier(supplier);
                    return ResponseEntity.ok(saved);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        log.info("Deleting supplier with ID: {}", id);
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }
}