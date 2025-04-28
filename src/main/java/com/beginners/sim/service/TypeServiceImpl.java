package com.beginners.sim.service;

import com.beginners.sim.exception.TypeNotFoundException;
import com.beginners.sim.model.Type;
import com.beginners.sim.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;

    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    @Override
    public Page<Type> getAllTypesPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return typeRepository.findAll(pageable);
    }

    @Override
    public Type getTypeById(Long typeId) throws TypeNotFoundException {
        return typeRepository.findById(typeId)
                .orElseThrow(() -> new TypeNotFoundException("Type not found with ID: " + typeId));
    }

    @Override
    public void deleteType(Long typeId) throws TypeNotFoundException {
        if (!typeRepository.existsById(typeId)) {
            throw new TypeNotFoundException("Type not found with typeId: " + typeId);
        }
        typeRepository.deleteById(typeId);
    }
}
