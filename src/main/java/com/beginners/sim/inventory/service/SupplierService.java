package com.beginners.sim.inventory.service;

import com.beginners.sim.inventory.exception.SupplierNotFoundException;
import com.beginners.sim.inventory.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SupplierService {

    Supplier saveSupplier(Supplier supplier);

    List<Supplier> getAllSuppliers();

    Page<Supplier> getAllSuppliersPaginated(int page, int size);

    Supplier getSupplierById(long id) throws SupplierNotFoundException;

    void deleteSupplier(long id) throws SupplierNotFoundException;
}