package com.beginners.sim.service;

import com.beginners.sim.exception.SupplierNotFoundException;
import com.beginners.sim.model.Supplier;
import com.beginners.sim.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    @Override
    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Page<Supplier> getAllSuppliersPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return supplierRepository.findAll(pageable);
    }

    @Override
    public Supplier getSupplierById(long supplierId) throws SupplierNotFoundException {
        return supplierRepository.findById(supplierId)
                .orElseThrow(() -> new SupplierNotFoundException("Supplier not found withID: " + supplierId));
    }

    @Override
    public void deleteSupplier(long supplierId) throws SupplierNotFoundException {
        if (!supplierRepository.existsById(supplierId)) {
            throw new SupplierNotFoundException("Supplier not found with id: " + supplierId);
        }
        supplierRepository.deleteById(supplierId);
    }
}
