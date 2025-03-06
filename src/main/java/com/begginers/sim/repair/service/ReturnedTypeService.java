package com.begginers.sim.repair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.begginers.sim.repair.model.ReturnedType;
import com.begginers.sim.repair.repository.ReturnedTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReturnedTypeService {

    @Autowired
    private ReturnedTypeRepository returnedTypeRepository;

    public List<ReturnedType> getAllReturnedTypes() {
        return returnedTypeRepository.findAll();
    }

    public ReturnedType getReturnedTypeById(int id) {
        return returnedTypeRepository.findById(id).orElse(null);
    }

    public ReturnedType addReturnedType(ReturnedType returnedType) {
        return returnedTypeRepository.save(returnedType);
    }

    public ReturnedType updateReturnedType(int id, ReturnedType returnedType) {
        Optional<ReturnedType> existingReturnedType = returnedTypeRepository.findById(id);
        if (existingReturnedType.isPresent()) {
            returnedType.setReturnedTypeId(id);
            return returnedTypeRepository.save(returnedType);
        }
        return null;
    }

    public void deleteReturnedType(int id) {
        returnedTypeRepository.deleteById(id);
    }
}
