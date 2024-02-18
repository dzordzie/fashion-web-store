package com.example.fashionwebstore;

import com.example.fashionwebstore.services.ItemService;
import com.example.fashionwebstore.services.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FashionWebStore implements CommandLineRunner {

    private final ItemService itemService;

    private final ManufacturerService manufacturerService;

    @Autowired
    public FashionWebStore(ItemService itemService, ManufacturerService manufacturerService) {
        this.itemService = itemService;
        this.manufacturerService = manufacturerService;
    }

    public static void main(String[] args) {
        SpringApplication.run(FashionWebStore.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        /*Item item = new Item("Green Fox Jumper", "sweaters", "s", 80);
        Item item1 = new Item("Green Fox Jumper", "sweaters", "m", 80);
        Item item2 = new Item("Polo shirt", "shirts", "xl", 59.9);
        Item item3 = new Item("Polo shirt", "shirts", "m", 82.9);

        Manufacturer manufacturer = new Manufacturer("Gucci");
        Manufacturer manufacturer1 = new Manufacturer("Ralph Lauren");
        Manufacturer manufacturer2 = new Manufacturer("Bonnie Jean");

        manufacturerService.saveNewManufacturer(manufacturer);
        manufacturerService.saveNewManufacturer(manufacturer1);
        manufacturerService.saveNewManufacturer(manufacturer2);

        item.setManufacturer(manufacturer);
        item1.setManufacturer(manufacturer);
        item2.setManufacturer(manufacturer1);
        item3.setManufacturer(manufacturer2);

        itemService.saveOrUpdateItem(item);
        itemService.saveOrUpdateItem(item1);
        itemService.saveOrUpdateItem(item2);
        itemService.saveOrUpdateItem(item3);*/


    }
}
