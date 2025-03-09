package com.begginers.sim.inventory.service;

import com.begginers.sim.inventory.model.Type;
import com.begginers.sim.inventory.repository.TypeRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TypeService {
    // TODO
    //  Change the class to interface, include only method signatures here
    //  Create a new class TypeServiceImpl, implement it from the Service class and move all code to the Impl class

    private final TypeRepository typeRepository;

    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    public Optional<Type> getTypeById(Long id) {
        return typeRepository.findById(id);
    }

    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }
}
