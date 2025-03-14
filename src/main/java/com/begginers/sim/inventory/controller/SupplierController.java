package com.begginers.sim.inventory.controller;

import com.begginers.sim.inventory.exception.SupplierNotFoundException;
import com.begginers.sim.inventory.model.Supplier;
import com.begginers.sim.inventory.service.SupplierService;
import com.begginers.sim.util.Constant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constant.SUPPLIER_BASE_URL)
@RequiredArgsConstructor
@Slf4j
public class SupplierController {
    // TODO
    //  Change the class to interface, include only method signatures here
    //  Create a new class SupplierServiceImpl, implement it from the Service class and move all code to the Impl class

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
        try {
            Supplier supplier = supplierService.getSupplierById(id);
            return ResponseEntity.ok(supplier);
        } catch (SupplierNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable Long id, @RequestBody Supplier updatedSupplier) {
        log.info("Updating supplier with ID: {}", id);
        try {
            Supplier supplier = supplierService.getSupplierById(id);
            supplier.setSupplierName(updatedSupplier.getSupplierName());
            supplier.setSupplierAddress(updatedSupplier.getSupplierAddress());
            supplier.setSupplierContactNo(updatedSupplier.getSupplierContactNo());
            Supplier saved = supplierService.saveSupplier(supplier);
            return ResponseEntity.ok(saved);
        } catch (SupplierNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        log.info("Deleting supplier with ID: {}", id);
        try {
            supplierService.deleteSupplier(id);
            return ResponseEntity.noContent().build();
        } catch (SupplierNotFoundException e) {
            return ResponseEntity.noContent().build();
        }
    }
}