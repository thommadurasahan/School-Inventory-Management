package com.begginers.sim.inventory.controller;

import com.begginers.sim.inventory.exception.TypeNotFoundException;
import com.begginers.sim.inventory.model.Type;
import com.begginers.sim.inventory.service.TypeService;
import com.begginers.sim.util.Constant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constant.TYPE_BASE_URL)
@RequiredArgsConstructor
@Slf4j
public class TypeController {
    // TODO
    //  Change the class to interface, include only method signatures here
    //  Create a new class TypeServiceImpl, implement it from the Service class and move all code to the Impl class

    private final TypeService typeService;

    @PostMapping
    public ResponseEntity<Type> createType(@RequestBody Type type) {
        log.info("Creating new type: {}", type);
        Type savedType = typeService.saveType(type);
        return ResponseEntity.ok(savedType);
    }

    @GetMapping
    public ResponseEntity<List<Type>> getAllTypes() {
        List<Type> types = typeService.getAllTypes();
        if (types.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(types);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Type> getTypeById(@PathVariable Long id) {
        try {
            Type type = typeService.getTypeById(id);
            return ResponseEntity.ok(type);
        } catch (TypeNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Type> updateType(@PathVariable Long id, @RequestBody Type updatedType) {
        log.info("Updating type with ID: {}", id);
        try {
            Type type = typeService.getTypeById(id);
            type.setTypeName(updatedType.getTypeName());
            Type saved = typeService.saveType(type);
            return ResponseEntity.ok(saved);
        } catch (TypeNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteType(@PathVariable Long id) {
        log.info("Deleting type with ID: {}", id);
        try {
            typeService.deleteType(id);
            return ResponseEntity.noContent().build();
        } catch (TypeNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}