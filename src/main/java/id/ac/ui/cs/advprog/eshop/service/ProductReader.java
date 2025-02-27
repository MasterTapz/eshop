package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

public interface ProductReader {
    List<Product> findAll();
    Product findById(String productId);
}
