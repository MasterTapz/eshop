package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.filter.ProductFilter;
import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

public interface ProductService extends ProductReader,ProductWriter {
    Product create(Product product);
    List<Product> findAll();
    Product findById(String productId);
    Product update(Product product);
    boolean delete(String productId);

    // New method: open for extension (new filters can be plugged in)
    List<Product> findAll(ProductFilter filter);
}
