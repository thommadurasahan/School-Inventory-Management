package com.beginners.sim.inventory.service;

import com.beginners.sim.inventory.exception.TypeNotFoundException;
import com.beginners.sim.inventory.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeService {

    Type saveType(Type type);

    List<Type> getAllTypes();

    Page<Type> getAllTypesPaginated(int page, int size);

    Type getTypeById(Long typeId) throws TypeNotFoundException;

    void deleteType(Long typeId) throws TypeNotFoundException;
}
