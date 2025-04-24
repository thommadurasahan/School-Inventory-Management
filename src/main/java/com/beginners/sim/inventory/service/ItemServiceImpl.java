package com.beginners.sim.inventory.service;

import com.beginners.sim.inventory.exception.ItemNotFoundException;
import com.beginners.sim.inventory.model.Item;
import com.beginners.sim.inventory.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Page<Item> getAllItemsPaginated(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return itemRepository.findAll(pageable);
    }

    @Override
    public Item getItemById(long itemId) throws ItemNotFoundException {
        return itemRepository.findById(itemId)
                .orElseThrow(() -> new ItemNotFoundException("Item not found with ID: " + itemId));
    }

    @Override
    public List<Item> getItemsByDate(Date receivedOn) {
        log.info("Finding items received on date: {}", receivedOn);
        return itemRepository.findItemsByDate(receivedOn);
    }

    @Override
    public void deleteItem(long itemId) throws ItemNotFoundException {
        if (!itemRepository.existsById(itemId)) {
            throw new ItemNotFoundException("Item not found with id: " + itemId);
        }
        itemRepository.deleteById(itemId);
    }
}
