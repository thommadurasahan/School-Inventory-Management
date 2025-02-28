package com.begginers.sim.inventory.controller;

import com.begginers.sim.inventory.model.Item;
import com.begginers.sim.inventory.model.Supplier;
import com.begginers.sim.inventory.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/supplier")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierRepository supplierRepository;

    @PostMapping
    public Supplier insertSupplier(@RequestBody Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @PutMapping
    public Supplier updateSupplier(@PathVariable byte supplierId, @RequestBody Supplier updatedSupplier) {
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

