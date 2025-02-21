package com.begginers.sim.inventory.controller;

import com.begginers.sim.inventory.model.Item;
import com.begginers.sim.inventory.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/item")
public class ItemController {

    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item insertItem(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    @GetMapping
    private List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}
