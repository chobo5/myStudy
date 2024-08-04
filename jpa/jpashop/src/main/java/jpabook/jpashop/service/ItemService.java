package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public Long saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Transactional
    public void updateItem(UpdateItemDto dto) {
        Item foundItem = itemRepository.findOne(dto.getId());
        foundItem.change(dto.getName(), dto.getPrice(), dto.getStockQuantity());
    }

    public Item findItem(Long itemId) {
        return itemRepository.findOne(itemId);
    }

    public List<Item> findItems()  {
        return itemRepository.findAll();
    }
}
