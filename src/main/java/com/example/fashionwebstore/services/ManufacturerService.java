package com.example.fashionwebstore.services;

import com.example.fashionwebstore.models.Manufacturer;

import java.util.List;

public interface ManufacturerService {
  void saveNewManufacturer(Manufacturer manufacturer);

  List<Manufacturer> getManufacturers();

  Manufacturer getManufacturerByName(String name);
}
