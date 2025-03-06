package com.begginers.sim.repair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.begginers.sim.repair.model.Return;
import com.begginers.sim.repair.repository.ReturnRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReturnService {

    @Autowired
    private ReturnRepository returnRepository;

    public List<Return> getAllReturns() {
        return returnRepository.findAll();
    }

    public Return getReturnById(int id) {
        return returnRepository.findById(id).orElse(null);
    }

    public Return addReturn(Return returnObj) {
        return returnRepository.save(returnObj);
    }

    public Return updateReturn(int id, Return returnObj) {
        Optional<Return> existingReturn = returnRepository.findById(id);
        if (existingReturn.isPresent()) {
            returnObj.setReturnId(id);
            return returnRepository.save(returnObj);
        }
        return null;
    }

    public void deleteReturn(int id) {
        returnRepository.deleteById(id);
    }
}
