package com.begginers.sim.inventory.service;

import com.begginers.sim.inventory.exception.TypeNotFoundException;
import com.begginers.sim.inventory.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeService {

    Type saveType(Type type);

    List<Type> getAllTypes();

    Page<Type> getAllTypesPaginated(int page, int size);

    Type getTypeById(Long id) throws TypeNotFoundException;

    void deleteType(Long id) throws TypeNotFoundException;
}
