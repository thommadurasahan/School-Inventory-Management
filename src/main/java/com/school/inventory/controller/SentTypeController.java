package com.school.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sent-types")
public class SentTypeController {

    @Autowired
    private SentTypeService sentTypeService;

    @GetMapping
    public List<SentType> getAllSentTypes() {
        return sentTypeService.getAllSentTypes();
    }

    @GetMapping("/{id}")
    public SentType getSentTypeById(@PathVariable int id) {
        return sentTypeService.getSentTypeById(id);
    }

    @PostMapping
    public SentType addSentType(@RequestBody SentType sentType) {
        return sentTypeService.addSentType(sentType);
    }

    @PutMapping("/{id}")
    public SentType updateSentType(@PathVariable int id, @RequestBody SentType sentType) {
        return sentTypeService.updateSentType(id, sentType);
    }

    @DeleteMapping("/{id}")
    public void deleteSentType(@PathVariable int id) {
        sentTypeService.deleteSentType(id);
    }
}
