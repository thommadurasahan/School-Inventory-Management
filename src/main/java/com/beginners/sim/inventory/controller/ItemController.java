package com.beginners.sim.inventory.controller;

import com.beginners.sim.common.util.Constant;
import com.beginners.sim.inventory.exception.ItemNotFoundException;
import com.beginners.sim.inventory.model.Item;
import com.beginners.sim.inventory.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(Constant.ITEM_BASE_URL)
@RequiredArgsConstructor
@Slf4j
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/add-item")
    public ResponseEntity<Item> insertItem(@RequestBody Item item) {
        log.info("Inserting new item: {}", item);
        Item savedItem = itemService.saveItem(item);
        return ResponseEntity.ok(savedItem);
    }

    @GetMapping("/view-items")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        if (items.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(items);
    }

    @GetMapping("/view-paginated-items")
    public ResponseEntity<Map<String, Object>> getAllItemsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        log.info("Getting paginated items with page: {} and size: {}", page, size);

        Page<Item> pageItems = itemService.getAllItemsPaginated(page, size);
        List<Item> items = pageItems.getContent();

        if (items.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        Map<String, Object> response = new HashMap<>();
        response.put("items", items);
        response.put("currentPage", pageItems.getNumber());
        response.put("totalItems", pageItems.getTotalElements());
        response.put("totalPages", pageItems.getTotalPages());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/view-item-by-id/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable long id) {
        try {
            Item item = itemService.getItemById(id);
            return ResponseEntity.ok(item);
        } catch (ItemNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/view-items-by-date")
    public ResponseEntity<List<Item>> getItemsByDate(@RequestParam("date") Date receivedOn) {
        log.info("Getting items by date: {}", receivedOn);
        List<Item> items = itemService.getItemsByDate(receivedOn);

        if (items.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(items);
    }

    @PutMapping("/update-item-by-id/{id}")
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

    @DeleteMapping("/delete-item-by-id/{id}")
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