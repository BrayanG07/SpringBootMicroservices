package hn.beag.springboot.app.product.controllers;

import hn.beag.springboot.app.product.models.entity.Product;
import hn.beag.springboot.app.product.models.service.IProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class ProductController {
    private final IProductService _productService;
    private final Environment _environment;

    @Value("${server.port}")
    private Integer serverPort;

    ProductController(IProductService productService, Environment environment) {
        this._productService = productService;
        this._environment = environment;
    }

    @GetMapping("/list")
    public List<Product> findAllProducts() {
        return this._productService.findAll().stream().peek(p -> p.setServerPort(serverPort)).toList();
    }

    @GetMapping("/detail/{id}")
    public Product findProductById(@PathVariable Long id) {
        Integer port = this._environment.getProperty("server.port", Integer.class, 8080);
        Product product = this._productService.findById(id);
        product.setServerPort(port);
        return this._productService.findById(id);
    }

}
