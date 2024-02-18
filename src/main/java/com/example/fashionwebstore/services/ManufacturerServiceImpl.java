package com.example.fashionwebstore.services;

import com.example.fashionwebstore.models.Manufacturer;
import com.example.fashionwebstore.repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
  private final ManufacturerRepository manufacturerRepository;

  @Autowired
  public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
    this.manufacturerRepository = manufacturerRepository;
  }

  @Override
  public void saveNewManufacturer(Manufacturer manufacturer) {
    manufacturerRepository.save(manufacturer);
  }

  @Override
  public List<Manufacturer> getManufacturers() {
    return manufacturerRepository.findAll();
  }

  @Override
  public Manufacturer getManufacturerByName(String name) {
    return manufacturerRepository.findManufacturerByName(name);
  }


}
