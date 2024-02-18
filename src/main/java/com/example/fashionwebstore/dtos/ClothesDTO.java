package com.example.fashionwebstore.dtos;

public class ClothesDTO {
  private String[] clothes;

  public ClothesDTO() {
  }

  public ClothesDTO(String[] clothes) {
    this.clothes = clothes;
  }

  public String[] getClothes() {
    return clothes;
  }

  public void setClothes(String[] clothes) {
    this.clothes = clothes;
  }
}
