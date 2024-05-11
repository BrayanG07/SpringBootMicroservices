package com.hn.springboot.app.item.service;

import com.hn.springboot.app.item.clients.ProductClientRest;
import com.hn.springboot.app.item.models.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("itemServiceFeign")
// @Primary // Como tenemos dos implementaciones de ItemService, usamos esta como principal para que el controlador sepa que usa esta implementacion
public class ItemServiceFeign implements ItemService {

    private final ProductClientRest productClientRest;

    public ItemServiceFeign(ProductClientRest productClientRest) {
        this.productClientRest = productClientRest;
    }

    @Override
    public List<Item> findAll() {
        return this.productClientRest.findAllProducts().stream().map(product -> new Item(product, 1)).toList();
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        return new Item(this.productClientRest.findById(id), quantity);
    }
}
