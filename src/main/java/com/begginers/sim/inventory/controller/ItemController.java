package com.begginers.sim.inventory.controller;

import com.begginers.sim.inventory.exception.ItemNotFoundException;
import com.begginers.sim.inventory.model.Item;
import com.begginers.sim.inventory.service.ItemService;
import com.begginers.sim.util.Constant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constant.ITEM_BASE_URL)
@RequiredArgsConstructor
@Slf4j
public class ItemController {
    // Todo
    //  Create a method with pagination for getAllItems to reduce the ResultSet size (OffSet and Limit)

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<Item> insertItem(@RequestBody Item item) {
        log.info("Inserting new item: {}", item);
        Item savedItem = itemService.saveItem(item);
        return ResponseEntity.ok(savedItem);
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        if (items.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable long id) {
        try {
            Item item = itemService.getItemById(id);
            return ResponseEntity.ok(item);
        } catch (ItemNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable long id, @RequestBody Item updatedItem) {
        log.info("Updating item with ID: {}", id);
        try {
            Item item = itemService.getItemById(id);
            item.setQuantity(updatedItem.getQuantity());
            Item saved = itemService.saveItem(item);
            return ResponseEntity.ok(saved);
        } catch (ItemNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable long id) {
        log.info("Deleting item with ID: {}", id);
        try {
            itemService.deleteItem(id);
            return ResponseEntity.noContent().build();
        } catch (ItemNotFoundException e) {
            return ResponseEntity.noContent().build();
        }
    }
}