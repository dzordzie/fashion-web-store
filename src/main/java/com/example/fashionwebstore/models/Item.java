package com.example.fashionwebstore.models;

import jakarta.persistence.*;

@Entity
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String category;
  private String size;
  private double unit_price;
  @ManyToOne
  @JoinColumn(name = "manufacturer_id")
  private Manufacturer manufacturer;

  public Item() {
  }

  public Item(String name, String category, String size, double unit_price) {
    this.name = name;
    this.category = category;
    this.size = size;
    this.unit_price = unit_price;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public double getUnit_price() {
    return unit_price;
  }

  public void setUnit_price(double unit_price) {
    this.unit_price = unit_price;
  }

  public Manufacturer getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(Manufacturer manufacturer) {
    this.manufacturer = manufacturer;
  }
}
