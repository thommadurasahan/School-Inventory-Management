package com.begginers.sim.inventory.service;

import com.begginers.sim.inventory.exception.ItemNotFoundException;
import com.begginers.sim.inventory.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    // TODO
    //  Change class to interface, include only method signatures here
    //  Create a new class ItemServiceImpl, implement it from the Service class and move all code to the Impl class

    Item saveItem(Item item);

    List<Item> getAllItems();

    Item getItemById(long id) throws ItemNotFoundException;

    void deleteItem(long id) throws ItemNotFoundException;
}