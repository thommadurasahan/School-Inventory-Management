package com.begginers.sim.inventory.service;

import com.begginers.sim.inventory.exception.SupplierNotFoundException;
import com.begginers.sim.inventory.model.Supplier;
import com.begginers.sim.inventory.repository.SupplierRepository;
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

    private SupplierRepository supplierRepository;

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
    public Supplier getSupplierById(long id) throws SupplierNotFoundException {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new SupplierNotFoundException("Supplier not found withID: " + id));
    }

    @Override
    public void deleteSupplier(long id) throws SupplierNotFoundException {
        if (!supplierRepository.existsById(id)) {
            throw new SupplierNotFoundException("Supplier not found with id: " + id);
        }
        supplierRepository.deleteById(id);
    }
}
