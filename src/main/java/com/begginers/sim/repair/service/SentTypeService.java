package com.begginers.sim.repair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.begginers.sim.repair.model.SentType;
import com.begginers.sim.repair.repository.SentTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SentTypeService {

    @Autowired
    private SentTypeRepository sentTypeRepository;

    public List<SentType> getAllSentTypes() {
        return sentTypeRepository.findAll();
    }

    public SentType getSentTypeById(int id) {
        return sentTypeRepository.findById(id).orElse(null);
    }

    public SentType addSentType(SentType sentType) {
        return sentTypeRepository.save(sentType);
    }

    public SentType updateSentType(int id, SentType sentType) {
        Optional<SentType> existingSentType = sentTypeRepository.findById(id);
        if (existingSentType.isPresent()) {
            sentType.setSentTypeId(id);
            return sentTypeRepository.save(sentType);
        }
        return null;
    }

    public void deleteSentType(int id) {
        sentTypeRepository.deleteById(id);
    }
}
