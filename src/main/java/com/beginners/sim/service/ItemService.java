package com.beginners.sim.service;

import com.beginners.sim.exception.ItemNotFoundException;
import com.beginners.sim.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface ItemService {

    Item saveItem(Item item);

    List<Item> getAllItems();

    Page<Item> getAllItemsPaginated(int page, int pageSize);

    Item getItemById(long id) throws ItemNotFoundException;

    List<Item> getItemsByDate(Date receivedOn);

    void deleteItem(long id) throws ItemNotFoundException;
}