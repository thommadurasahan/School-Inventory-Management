package com.begginers.sim.inventory.service;

import com.begginers.sim.inventory.exception.TypeNotFoundException;
import com.begginers.sim.inventory.model.Type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeService {
    // TODO
    //  Change the class to interface, include only method signatures here
    //  Create a new class TypeServiceImpl, implement it from the Service class and move all code to the Impl class

    Type saveType(Type type);

    List<Type> getAllTypes();

    Type getTypeById(Long id) throws TypeNotFoundException;

    void deleteType(Long id) throws TypeNotFoundException;
}
