package com.hn.springboot.app.item.clients;

import com.hn.springboot.app.item.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "service-product")
public interface ProductClientRest {
    @GetMapping("/list")
    List<Product> findAllProducts();

    @GetMapping("/detail/{id}")
    Product findById(@PathVariable Long id);
}
