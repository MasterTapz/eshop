package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();
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
    void testUpdateProductCoversForLoop() {
        // Add multiple products to ensure the loop iterates
        Product product1 = new Product();
        product1.setProductId("111");
        product1.setProductName("Product 1");
        product1.setProductQuantity(10);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("222");
        product2.setProductName("Product 2");
        product2.setProductQuantity(20);
        productRepository.create(product2);

        Product product3 = new Product();
        product3.setProductId("333");
        product3.setProductName("Product 3");
        product3.setProductQuantity(30);
        productRepository.create(product3);

        // Attempt to update the second product
        Product updatedProduct = new Product();
        updatedProduct.setProductId("222");
        updatedProduct.setProductName("Updated Product 2");
        updatedProduct.setProductQuantity(50);

        Product result = productRepository.update(updatedProduct);

        // Ensure update was successful and loop iterated
        assertNotNull(result);
        assertEquals("222", result.getProductId());
        assertEquals("Updated Product 2", result.getProductName());
        assertEquals(50, result.getProductQuantity());

        // Verify that product1 and product3 remain unchanged
        Iterator<Product> productIterator = productRepository.findAll();
        Product firstProduct = productIterator.next();
        assertEquals("111", firstProduct.getProductId());

        Product secondProduct = productIterator.next();
        assertEquals("222", secondProduct.getProductId()); // This should be the updated one
        assertEquals("Updated Product 2", secondProduct.getProductName());

        Product thirdProduct = productIterator.next();
        assertEquals("333", thirdProduct.getProductId());
    }

    @Test
    void testEditProductNegative() {
        Product nonExistentProduct = new Product();
        nonExistentProduct.setProductId("unknown-id-9876");
        nonExistentProduct.setProductName("Smartwatch Phantom");
        nonExistentProduct.setProductQuantity(200);

        Product result = productRepository.update(nonExistentProduct);
        assertNull(result, "Expected null when updating a non-existent product");
    }

    @Test
    void testEditProductWithNullId() {
        Product product = new Product();
        product.setProductId(null);
        product.setProductName("Null ID Product");
        product.setProductQuantity(100);

        Product result = productRepository.update(product);
        assertNull(result, "Expected null when updating a product with a null ID");
    }

    @Test
    void testEditProductOnEmptyRepository() {
        Product product = new Product();
        product.setProductId("does-not-exist");
        product.setProductName("Fake Product");
        product.setProductQuantity(10);

        Product result = productRepository.update(product);
        assertNull(result, "Expected null when updating in an empty repository");
    }

    @Test
    void testDeleteProductPositive() {
        Product product = new Product();
        product.setProductId("z9y8x7w6-v5u4-3210-qrst-0987654321ab");
        product.setProductName("Wireless Headphones Z");
        product.setProductQuantity(120);
        productRepository.create(product);

        boolean deleted = productRepository.delete("z9y8x7w6-v5u4-3210-qrst-0987654321ab");
        assertTrue(deleted, "Expected delete() to return true");

        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext(), "Expected product list to be empty after deletion");
    }

    @Test
    void testDeleteProductNegative() {
        boolean result = productRepository.delete("fake-product-0001");
        assertFalse(result, "Expected false when deleting a non-existent product");
    }

    @Test
    void testDeleteProductWithNullId() {
        boolean result = productRepository.delete(null);
        assertFalse(result, "Expected false when deleting a product with null ID");
    }

    @Test
    void testDeleteProductWhenMultipleExist() {
        Product product1 = new Product();
        product1.setProductId("111");
        product1.setProductName("Product 1");
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("222");
        product2.setProductName("Product 2");
        productRepository.create(product2);

        Product product3 = new Product();
        product3.setProductId("333");
        product3.setProductName("Product 3");
        productRepository.create(product3);

        // Delete the middle product
        boolean deleted = productRepository.delete("222");
        assertTrue(deleted, "Expected delete() to return true");

        // Ensure other products still exist
        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product remainingProduct1 = productIterator.next();
        assertEquals("111", remainingProduct1.getProductId());

        Product remainingProduct2 = productIterator.next();
        assertEquals("333", remainingProduct2.getProductId());

        assertFalse(productIterator.hasNext(), "Expected only two products remaining");
    }

    @Test
    void testDeleteFromEmptyRepository() {
        boolean deleted = productRepository.delete("any-id");
        assertFalse(deleted, "Expected delete() to return false when repository is empty");
    }
}
