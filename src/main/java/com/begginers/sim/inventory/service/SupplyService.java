package com.begginers.sim.inventory.service;

import com.begginers.sim.inventory.model.Supply;
import com.begginers.sim.inventory.repository.SupplyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplyService {

    private final SupplyRepository supplyRepository;

    public SupplyService(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }

    public List<Supply> getAllSupplies() {
        return supplyRepository.findAll();
    }

    public Optional<Supply> getSupplyById(Long id) {
        return supplyRepository.findById(id);
    }

    public Supply saveSupply(Supply supply) {
        return supplyRepository.save(supply);
    }

    public void deleteSupply(Long id) {
        supplyRepository.deleteById(id);
    }
}