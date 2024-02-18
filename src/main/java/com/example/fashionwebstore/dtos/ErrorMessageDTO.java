package com.example.fashionwebstore.dtos;

public class ErrorMessageDTO {
  private String error_message;

  public ErrorMessageDTO(String error_message) {
    this.error_message = error_message;
  }

  public String getError_message() {
    return error_message;
  }

  public void setError_message(String error_message) {
    this.error_message = error_message;
  }
}
