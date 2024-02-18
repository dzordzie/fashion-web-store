package com.example.fashionwebstore.controllers;

import com.example.fashionwebstore.dtos.ErrorMessageDTO;
import com.example.fashionwebstore.dtos.PayloadDTO;
import com.example.fashionwebstore.models.Item;
import com.example.fashionwebstore.services.ItemService;
import com.example.fashionwebstore.services.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController {
  private final ItemService itemService;
  private final ManufacturerService manufacturerService;

  @Autowired
  public ApiController(ItemService itemService, ManufacturerService manufacturerService) {
    this.itemService = itemService;
    this.manufacturerService = manufacturerService;
  }


  @DeleteMapping("/item/{id}")
  public ResponseEntity deleteItem(@PathVariable Long id) {
    Optional<Item> foundItem = itemService.findItemById(id);
    if (!foundItem.isPresent()) {
      ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO("Incorrect provided data");
      return ResponseEntity.status(404).body(errorMessageDTO);
    } else {
      itemService.deleteItemById(id);
      return ResponseEntity.status(203).build();
    }
  }

  @PutMapping("/item/{id}")
  public ResponseEntity updateItem(@PathVariable Long id, @RequestBody PayloadDTO payloadDTO) {
    Optional<Item> foundItem = itemService.findItemById(id);
    if (!foundItem.isPresent()) {
      ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO("Incorrect provided data");
      return ResponseEntity.status(404).body(errorMessageDTO);
    } else if (foundItem.isPresent() && !payloadDTO.getManufacturer().equals(manufacturerService.getManufacturerByName(payloadDTO.getManufacturer()).getName())) {
      ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO("Incorrect provided data");
      return ResponseEntity.status(400).body(errorMessageDTO);
    } else {
      Item itemFromDatabase = foundItem.get();
      itemFromDatabase.setName(payloadDTO.getItem_name());
      itemFromDatabase.setManufacturer(manufacturerService.getManufacturerByName(payloadDTO.getManufacturer()));
      itemFromDatabase.setCategory(payloadDTO.getCategory());
      itemFromDatabase.setSize(payloadDTO.getSize());
      itemFromDatabase.setUnit_price(payloadDTO.getUnit_price());
      itemService.saveOrUpdateItem(itemFromDatabase);
      return ResponseEntity.status(200).body(itemFromDatabase);
    }
  }
}
