package com.begginers.sim.inventory.controller;

import com.begginers.sim.inventory.model.Item;
import com.begginers.sim.inventory.model.Type;
import com.begginers.sim.inventory.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/type")
@RequiredArgsConstructor
public class TypeController {

    private final TypeRepository typeRepository;

    @PostMapping
    public Type insertType(@RequestBody Type type) {
        return typeRepository.save(type);
    }

    @GetMapping
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    @PutMapping
    public Type updateType(@PathVariable byte typeId, @RequestBody Type updatedType) {
        return typeRepository.findById(typeId)
                .map(type -> {
                    type.setTypeName(updatedType.getTypeName());
                    return typeRepository.save(type);
                })
                .orElseThrow();
    }
}
