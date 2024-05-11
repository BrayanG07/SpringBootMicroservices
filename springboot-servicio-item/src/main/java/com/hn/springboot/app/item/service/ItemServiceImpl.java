package com.hn.springboot.app.item.service;

import com.hn.springboot.app.item.models.Item;
import com.hn.springboot.app.item.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Item> findAll() {
        List<Product> products = Arrays.asList(Objects.requireNonNull(this.restTemplate.getForObject("http://service-product/list", Product[].class)));

        return products.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());

        Product product = this.restTemplate.getForObject("http://service-product/detail/{id}", Product.class, pathVariables);
        return new Item(product, quantity);
    }
}
