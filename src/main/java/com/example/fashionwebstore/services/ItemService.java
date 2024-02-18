package com.example.fashionwebstore.services;

import com.example.fashionwebstore.models.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
  void saveOrUpdateItem(Item item);

  List<Item> getItems();

  double getItemPriceByNameAndSize(String name, String size);

  Item getItemByNameAndSize(String name, String size);

  Optional<Item> findItemById(Long id);

  void deleteItemById(Long id);


}
