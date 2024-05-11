package hn.beag.springboot.app.product.models.service;

import hn.beag.springboot.app.product.models.entity.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findAll();
    public Product findById(Long id);
}
