package com.example.fashionwebstore.repositories;

import com.example.fashionwebstore.models.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

  Manufacturer findManufacturerByName(String name);
}
