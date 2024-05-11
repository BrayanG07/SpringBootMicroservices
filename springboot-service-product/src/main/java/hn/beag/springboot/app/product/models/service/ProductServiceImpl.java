package hn.beag.springboot.app.product.models.service;

import hn.beag.springboot.app.product.models.entity.Product;
import hn.beag.springboot.app.product.models.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    private final ProductRepository _productRepository;

    ProductServiceImpl(ProductRepository productRepository) {
        this._productRepository = productRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return (List<Product>) this._productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return this._productRepository.findById(id).orElse(null);
    }
}
