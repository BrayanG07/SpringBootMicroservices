package com.hn.springboot.app.item.controller;

import com.hn.springboot.app.item.models.Item;
import com.hn.springboot.app.item.service.ItemService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    private final ItemService itemService;

    // @Qualifier("itemServiceFeign") otra alternativa para no anotar el service con @Primary, sirve para indicarle que este service es el que debe tomar
    public ItemController(
            // serviceRestTemplate, itemServiceFeign
            @Qualifier("itemServiceFeign") ItemService itemService
    ) {
        this.itemService = itemService;
    }

    @GetMapping("/listar")
    public List<Item> findAllItems() {
        return this.itemService.findAll();
    }

    @GetMapping("/ver/{id}/cantidad/{cantidad}")
    public Item findItemById(@PathVariable Long id, @PathVariable Integer cantidad) {
        return this.itemService.findById(id, cantidad);
    }
}
