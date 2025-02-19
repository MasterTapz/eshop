package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateProduct() {
        Product product = new Product();
        product.setProductId("123");
        product.setProductName("Test Product");

        // Fix: Simulate the repository's create method returning the same product
        doAnswer(invocation -> {
            Product argProduct = invocation.getArgument(0);
            return argProduct;
        }).when(productRepository).create(any(Product.class));

        Product createdProduct = productService.create(product);

        assertNotNull(createdProduct);
        assertEquals("123", createdProduct.getProductId());
        assertEquals("Test Product", createdProduct.getProductName());

        verify(productRepository, times(1)).create(product);
    }

    @Test
    void testFindAllProducts() {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("123");
        product1.setProductName("Test Product 1");

        Product product2 = new Product();
        product2.setProductId("456");
        product2.setProductName("Test Product 2");

        products.add(product1);
        products.add(product2);

        Iterator<Product> productIterator = products.iterator();
        when(productRepository.findAll()).thenReturn(productIterator);

        List<Product> retrievedProducts = productService.findAll();

        assertEquals(2, retrievedProducts.size());
        assertEquals("123", retrievedProducts.get(0).getProductId());
        assertEquals("456", retrievedProducts.get(1).getProductId());

        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testUpdateProduct() {
        Product product = new Product();
        product.setProductId("123");
        product.setProductName("Updated Product");

        when(productRepository.update(product)).thenReturn(product);

        Product updatedProduct = productService.update(product);

        assertNotNull(updatedProduct);
        assertEquals("123", updatedProduct.getProductId());
        assertEquals("Updated Product", updatedProduct.getProductName());

        verify(productRepository, times(1)).update(product);
    }

    @Test
    void testDeleteProduct() {
        when(productRepository.delete("123")).thenReturn(true);

        boolean isDeleted = productService.delete("123");

        assertTrue(isDeleted);
        verify(productRepository, times(1)).delete("123");
    }
}
