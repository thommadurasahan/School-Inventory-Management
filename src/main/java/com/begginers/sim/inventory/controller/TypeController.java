package com.begginers.sim.inventory.controller;

import com.begginers.sim.inventory.model.Type;
import com.begginers.sim.inventory.service.TypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/types")
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
        Optional<Type> type = typeService.getTypeById(id);
        return type.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Type> updateType(@PathVariable Long id, @RequestBody Type updatedType) {
        log.info("Updating type with ID: {}", id);
        return typeService.getTypeById(id)
                .map(type -> {
                    type.setTypeName(updatedType.getTypeName());
                    Type saved = typeService.saveType(type);
                    return ResponseEntity.ok(saved);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteType(@PathVariable Long id) {
        log.info("Deleting type with ID: {}", id);
        typeService.deleteType(id);
        return ResponseEntity.noContent().build();
    }
}