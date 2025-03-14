package com.begginers.sim.repair.service;

import com.begginers.sim.repair.model.Return;
import com.begginers.sim.repair.repository.ReturnRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReturnService {
    // TODO
    //  Change the class to interface, include only method signatures here
    //  Create a new class ReturnServiceImpl, implement it from the Service class and move all code to the Impl class

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
