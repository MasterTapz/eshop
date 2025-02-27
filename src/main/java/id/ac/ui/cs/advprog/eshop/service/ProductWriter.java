package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;

public interface ProductWriter {
    Product create(Product product);
    Product update(Product product);
    boolean delete(String productId);
}
