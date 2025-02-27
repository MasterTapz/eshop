package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.filter.ProductFilter;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    // Constructor-based dependency injection
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository.create(product);
    }

    @Override
    public List<Product> findAll() {
        // We delegate to a helper method to convert the iterator to a List.
        return productRepository.findAllAsList();
    }

    @Override
    public Product findById(String productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Product update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public boolean delete(String productId) {
        return productRepository.delete(productId);
    }

    @Override
    public List<Product> findAll(ProductFilter filter) {
        // Get all products, then filter based on the provided filter
        List<Product> allProducts = findAll();
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : allProducts) {
            if (filter.filter(product)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }
}
