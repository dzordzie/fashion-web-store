package com.example.fashionwebstore.repositories;

import com.example.fashionwebstore.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

  Optional<Item> findItemByNameAndSize(String name, String size);

  Item findItemBySize(String size);

  List<Item> findItemsByName(String name);
}
