package com.example.fashionwebstore.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Manufacturer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL)
  private List<Item> items;

  public Manufacturer() {
  }

  public Manufacturer(String name) {
    this.name = name;
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

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }
}
