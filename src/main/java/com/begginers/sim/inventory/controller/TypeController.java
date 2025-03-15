package com.begginers.sim.inventory.controller;

import com.begginers.sim.common.util.Constant;
import com.begginers.sim.inventory.exception.TypeNotFoundException;
import com.begginers.sim.inventory.model.Type;
import com.begginers.sim.inventory.service.TypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(Constant.TYPE_BASE_URL)
@RequiredArgsConstructor
@Slf4j
public class TypeController {

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

    @GetMapping("/paginated")
    public ResponseEntity<Map<String, Object>> getAllTypesPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        log.info("Getting paginated types with page: {} and size: {}", page, size);

        Page<Type> pageTypes = typeService.getAllTypesPaginated(page, size);
        List<Type> types = pageTypes.getContent();

        if (types.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        Map<String, Object> response = new HashMap<>();
        response.put("types", types);
        response.put("currentPage", pageTypes.getNumber());
        response.put("totalTypes", pageTypes.getTotalElements());
        response.put("totalPages", pageTypes.getTotalPages());

        return ResponseEntity.ok(response);
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