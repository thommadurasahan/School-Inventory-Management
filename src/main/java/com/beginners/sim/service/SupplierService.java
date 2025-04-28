package com.beginners.sim.service;

import com.beginners.sim.exception.SupplierNotFoundException;
import com.beginners.sim.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SupplierService {

    Supplier saveSupplier(Supplier supplier);

    List<Supplier> getAllSuppliers();

    Page<Supplier> getAllSuppliersPaginated(int page, int size);

    Supplier getSupplierById(long supplierId) throws SupplierNotFoundException;

    void deleteSupplier(long supplierId) throws SupplierNotFoundException;
}