package com.begginers.sim.inventory.controller;

import com.begginers.sim.inventory.model.Supplier;
import com.begginers.sim.inventory.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/supplier")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierRepository supplierRepository;

    @PostMapping("/insertSupplier")
    public Supplier insertSupplier(@RequestBody Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @GetMapping("/getAllSuppliers")
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @PutMapping("/updateSupplier/{supplierId}")
    public Supplier updateSupplier(@PathVariable Long supplierId, @RequestBody Supplier updatedSupplier) {
        return supplierRepository.findById(supplierId)
                .map(supplier -> {
                    supplier.setSupplierName(updatedSupplier.getSupplierName());
                    supplier.setSupplierAddress(updatedSupplier.getSupplierAddress());
                    supplier.setSupplierContactNo(updatedSupplier.getSupplierContactNo());
                    return supplierRepository.save(supplier);
                })
                .orElseThrow();
    }
}

