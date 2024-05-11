package hn.beag.springboot.app.product.models.repository;

import hn.beag.springboot.app.product.models.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
