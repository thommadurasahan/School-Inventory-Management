package com.begginers.sim.inventory.controller;

import com.begginers.sim.inventory.model.Item;
import com.begginers.sim.inventory.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor
@Slf4j
public class ItemController {
    // Todo
    //  Create util package, class Constant, hardcode values
    //  Crete base url, create a method with pagination for getAll

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
        Optional<Item> item = itemService.getItemById(id);
        return item.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable long id, @RequestBody Item updatedItem) {
        log.info("Updating item with ID: {}", id);
        return itemService.getItemById(id)
                .map(item -> {
                    item.setQuantity(updatedItem.getQuantity());
                    Item saved = itemService.saveItem(item);
                    return ResponseEntity.ok(saved);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable long id) {
        log.info("Deleting item with ID: {}", id);
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}