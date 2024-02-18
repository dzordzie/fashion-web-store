package com.example.fashionwebstore.controllers;

import com.example.fashionwebstore.services.ItemService;
import com.example.fashionwebstore.services.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class MainController {
  private final ItemService itemService;

  private final ManufacturerService manufacturerService;

  @Autowired
  public MainController(ItemService itemService, ManufacturerService manufacturerService) {
    this.itemService = itemService;
    this.manufacturerService = manufacturerService;
  }


  @GetMapping("/shoppingplanner")
  public String home(Model model) {
    model.addAttribute("items", itemService.getItems());
    model.addAttribute("manufacturers", manufacturerService.getManufacturers());
    return "index";
  }


  @PostMapping("/shoppingplanner/summary")
  public String summary(@RequestParam String itemName, @RequestParam String size, @RequestParam Integer total, RedirectAttributes redirectAttributes) {
    double price = itemService.getItemByNameAndSize(itemName, size).getUnit_price();
    redirectAttributes.addFlashAttribute("item", itemService.getItemByNameAndSize(itemName, size));
    redirectAttributes.addFlashAttribute("totalPrice", price * total);
    redirectAttributes.addFlashAttribute("quantity", total);
    return "redirect:/summary";
  }

}
