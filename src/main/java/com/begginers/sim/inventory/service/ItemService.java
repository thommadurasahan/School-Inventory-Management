package com.begginers.sim.inventory.service;

import com.begginers.sim.inventory.exception.ItemNotFoundException;
import com.begginers.sim.inventory.model.Item;
import com.begginers.sim.inventory.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemService {
    // TODO
    //  Change class to interface, include only method signatures here
    //  Create a new class ItemServiceImpl, implement it from the Service class and move all code to the Impl class

    private final ItemRepository itemRepository;

    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(long id) throws ItemNotFoundException {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item not found with ID: " + id));
    }

    public void deleteItem(long id) throws ItemNotFoundException {
        if (!itemRepository.existsById(id)) {
            throw new ItemNotFoundException("Item not found with id: " + id);
        }
        itemRepository.deleteById(id);
    }
}