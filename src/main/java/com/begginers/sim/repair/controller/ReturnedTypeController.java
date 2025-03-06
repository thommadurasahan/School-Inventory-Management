package com.begginers.sim.repair.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.begginers.sim.repair.model.ReturnedType;
import com.begginers.sim.repair.service.ReturnedTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/returned-types")
public class ReturnedTypeController {

    @Autowired
    private ReturnedTypeService returnedTypeService;

    @GetMapping
    public List<ReturnedType> getAllReturnedTypes() {
        return returnedTypeService.getAllReturnedTypes();
    }

    @GetMapping("/{id}")
    public ReturnedType getReturnedTypeById(@PathVariable int id) {
        return returnedTypeService.getReturnedTypeById(id);
    }

    @PostMapping
    public ReturnedType addReturnedType(@RequestBody ReturnedType returnedType) {
        return returnedTypeService.addReturnedType(returnedType);
    }

    @PutMapping("/{id}")
    public ReturnedType updateReturnedType(@PathVariable int id, @RequestBody ReturnedType returnedType) {
        return returnedTypeService.updateReturnedType(id, returnedType);
    }

    @DeleteMapping("/{id}")
    public void deleteReturnedType(@PathVariable int id) {
        returnedTypeService.deleteReturnedType(id);
    }
}
