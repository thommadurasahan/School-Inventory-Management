package com.beginners.sim.inventory.controller;

import com.beginners.sim.common.util.Constant;
import com.beginners.sim.inventory.exception.SupplierNotFoundException;
import com.beginners.sim.inventory.model.Supplier;
import com.beginners.sim.inventory.service.SupplierService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(Constant.SUPPLIER_BASE_URL)
@RequiredArgsConstructor
@Slf4j
public class SupplierController {

    private final SupplierService supplierService;

    @PostMapping("/add-supplier")
    public ResponseEntity<Supplier> insertSupplier(@RequestBody Map<String, Object> supplierData) {
        log.info("Inserting new supplier: {}", supplierData);

        // Extract data from the request
        String supplierName = (String) supplierData.get("supplierName");
        String supplierAddress = (String) supplierData.get("supplierAddress");
        int contactNo = Integer.parseInt(supplierData.get("contactNo").toString());
        Date supplierAddedOn = new Date();

        // Create and save the Item
        Supplier supplier = new Supplier();
        supplier.setSupplierName(supplierName);
        supplier.setSupplierAddress(supplierAddress);
        supplier.setSupplierContactNo(contactNo);
        supplier.setSupplierAddedOn(supplierAddedOn);

        Supplier savedSupplier = supplierService.saveSupplier(supplier);
        return ResponseEntity.ok(savedSupplier);
    }

    @GetMapping("/view-suppliers")
    public ResponseEntity<Map<String, Object>> getAllSuppliers() {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        if (suppliers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        Map<String, Object> response = new HashMap<>();
        response.put("suppliers", suppliers);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/view-paginated-suppliers")
    public ResponseEntity<Map<String, Object>> getAllSuppliersPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        log.info("Getting paginated suppliers with page: {} and size: {}", page, size);

        Page<Supplier> pageSuppliers = supplierService.getAllSuppliersPaginated(page, size);
        List<Supplier> suppliers = pageSuppliers.getContent();

        if (suppliers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        Map<String, Object> response = new HashMap<>();
        response.put("suppliers", suppliers);
        response.put("currentPage", pageSuppliers.getNumber());
        response.put("totalSuppliers", pageSuppliers.getTotalElements());
        response.put("totalPages", pageSuppliers.getTotalPages());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/view-supplier-by-id/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
        try {
            Supplier supplier = supplierService.getSupplierById(id);
            return ResponseEntity.ok(supplier);
        } catch (SupplierNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update-supplier-by-id/{id}")
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

    @DeleteMapping("/delete-supplier-by-id/{id}")
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