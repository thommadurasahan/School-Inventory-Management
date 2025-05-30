package com.beginners.sim.inventory.controller;

import com.beginners.sim.common.util.Constant;
import com.beginners.sim.inventory.exception.TypeNotFoundException;
import com.beginners.sim.inventory.model.Type;
import com.beginners.sim.inventory.service.TypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(Constant.TYPE_BASE_URL)
@RequiredArgsConstructor
@Slf4j
public class TypeController {

    private final TypeService typeService;

    @PostMapping("/add-type")
    public ResponseEntity<Type> createType(@RequestBody Map<String, Object> typeData) {
        log.info("Creating new type: {}", typeData);

        // Extract data from the request
        String typeName = (String) typeData.get("typeName");
        Date typeAddedOn = new Date();

        // Create and save the Type
        Type type = new Type();
        type.setTypeName(typeName);
        type.setTypeAddedOn(typeAddedOn);

        Type savedType = typeService.saveType(type);
        return ResponseEntity.ok(savedType);
    }

    @GetMapping("/view-types")
    public ResponseEntity<Map<String, Object>> getAllTypes() {
        List<Type> types = typeService.getAllTypes();
        if (types.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        Map<String, Object> response = new HashMap<>();
        response.put("types", types);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/view-paginated-types")
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

    @GetMapping("/view-type-by-id/{id}")
    public ResponseEntity<Type> getTypeById(@PathVariable Long id) {
        try {
            Type type = typeService.getTypeById(id);
            return ResponseEntity.ok(type);
        } catch (TypeNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update-type-by-id/{typeId}")
    public ResponseEntity<Type> updateType(@PathVariable Long typeId, @RequestBody Type updatedType) {
        log.info("Updating type with ID: {}", typeId);
        try {
            Type type = typeService.getTypeById(typeId);
            type.setTypeName(updatedType.getTypeName());
            Type saved = typeService.saveType(type);
            return ResponseEntity.ok(saved);
        } catch (TypeNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete-type-by-id/{id}")
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