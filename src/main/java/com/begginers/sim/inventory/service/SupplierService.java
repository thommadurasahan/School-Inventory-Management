package com.begginers.sim.inventory.service;

import com.begginers.sim.inventory.exception.SupplierNotFoundException;
import com.begginers.sim.inventory.model.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SupplierService {
    
    Supplier saveSupplier(Supplier supplier);

    List<Supplier> getAllSuppliers();

    Supplier getSupplierById(long id) throws SupplierNotFoundException;

    void deleteSupplier(long id) throws SupplierNotFoundException;
}