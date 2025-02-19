package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());

    }
    @Test
    void testEditProductPositive() {
        // Create and add a product
        Product product = new Product();
        product.setProductId("a1b2c3d4-e5f6-7890-abcd-ef1234567890");
        product.setProductName("Laptop Ultra X");
        product.setProductQuantity(50);
        productRepository.create(product);

        // Edit product details
        product.setProductName("Laptop Ultra X Pro");
        product.setProductQuantity(75);
        productRepository.update(product);

        // Retrieve and verify the updated product
        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product updatedProduct = productIterator.next();
        assertEquals("Laptop Ultra X Pro", updatedProduct.getProductName());
        assertEquals(75, updatedProduct.getProductQuantity());
    }

    @Test
    void testEditProductNegative() {
        // Attempt to edit a non-existent product
        Product nonExistentProduct = new Product();
        nonExistentProduct.setProductId("unknown-id-9876");
        nonExistentProduct.setProductName("Smartwatch Phantom");
        nonExistentProduct.setProductQuantity(200);

        Product result = productRepository.update(nonExistentProduct);
        assertNull(result, "Expected null when updating a non-existent product");
    }

    @Test
    void testDeleteProductPositive() {
        // Create and add a product
        Product product = new Product();
        product.setProductId("z9y8x7w6-v5u4-3210-qrst-0987654321ab");
        product.setProductName("Wireless Headphones Z");
        product.setProductQuantity(120);
        productRepository.create(product);

        // Delete the product
        productRepository.delete("z9y8x7w6-v5u4-3210-qrst-0987654321ab");

        // Verify the product is deleted
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testDeleteProductNegative() {
        // Attempt to delete a non-existent product
        boolean result = productRepository.delete("fake-product-0001");
        assertFalse(result, "Expected false when deleting a non-existent product");
    }

}