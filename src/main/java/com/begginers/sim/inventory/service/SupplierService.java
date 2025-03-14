package com.begginers.sim.inventory.service;

import com.begginers.sim.inventory.exception.SupplierNotFoundException;
import com.begginers.sim.inventory.model.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SupplierService {
    // TODO
    //  Change the class to interface, include only method signatures here
    //  Create a new class SupplierServiceImpl, implement it from the Service class and move all code to the Impl class

    Supplier saveSupplier(Supplier supplier);

    List<Supplier> getAllSuppliers();

    Supplier getSupplierById(long id) throws SupplierNotFoundException;

    void deleteSupplier(long id) throws SupplierNotFoundException;
}