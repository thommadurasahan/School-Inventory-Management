package com.begginers.sim.inventory.controller;

import com.begginers.sim.inventory.model.Item;
import com.begginers.sim.inventory.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;

    @PostMapping
    public Item insertItem(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @PutMapping
    public Item updateItem(@PathVariable short itemId, @RequestBody Item updatedItem) {
        return itemRepository.findById(itemId)
                .map(item -> {
                    item.setQuantity(updatedItem.getQuantity());
                    return itemRepository.save(item);
                })
                .orElseThrow();
    }
}
