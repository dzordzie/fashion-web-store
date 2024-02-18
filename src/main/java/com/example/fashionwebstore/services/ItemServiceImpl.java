package com.example.fashionwebstore.services;

import com.example.fashionwebstore.models.Item;
import com.example.fashionwebstore.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
  private final ItemRepository itemRepository;

  @Autowired
  public ItemServiceImpl(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  @Override
  public void saveOrUpdateItem(Item item) {
    itemRepository.save(item);
  }

  @Override
  public List<Item> getItems() {
    return itemRepository.findAll();
  }

  @Override
  public double getItemPriceByNameAndSize(String name, String size) {
    Optional<Item> foundItem = itemRepository.findItemByNameAndSize(name, size);
    double price = 0;
    if (foundItem.isPresent()) {
      price = foundItem.get().getUnit_price();
    }
    return price;
  }

  @Override
  public Item getItemByNameAndSize(String name, String size) {
    List<Item> itemsByName = itemRepository.findItemsByName(name);
    Item i = new Item();
    if (itemsByName.contains(itemRepository.findItemBySize(size))) {
      i = itemsByName.stream().filter(item -> size.equals(item.getSize()))
          .findAny()
          .orElse(null);
    }
    return i;
  }

  @Override
  public Optional<Item> findItemById(Long id) {
    return itemRepository.findById(id);
  }

  @Override
  public void deleteItemById(Long id) {
    itemRepository.deleteById(id);
  }

}
