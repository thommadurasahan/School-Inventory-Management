package com.begginers.sim.inventory.service;

import com.begginers.sim.inventory.exception.TypeNotFoundException;
import com.begginers.sim.inventory.model.Type;
import com.begginers.sim.inventory.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;
    
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    public Type getTypeById(Long id) throws TypeNotFoundException {
        return typeRepository.findById(id)
                .orElseThrow(() -> new TypeNotFoundException("Type not found with ID: " + id));
    }

    public void deleteType(Long id) throws TypeNotFoundException {
        if (!typeRepository.existsById(id)) {
            throw new TypeNotFoundException("Type not found with id: " + id);
        }
        typeRepository.deleteById(id);
    }
}
