package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/product")
public class ProductController {

    private static final String REDIRECT_PRODUCT_LIST = "redirect:/product/list";  // ✅ Define constant

    @Autowired
    private ProductService service;

    @GetMapping("/create")
    public String createProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "createProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product, Model model) {
        product.setProductId(UUID.randomUUID().toString());
        service.create(product);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String productListPage(Model model) {
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "productList";
    }

    @GetMapping("/edit/{id}")
    public String editProductPage(@PathVariable("id") String id, Model model) {
        List<Product> allProducts = service.findAll();
        for (Product product : allProducts) {
            if (id.equals(product.getProductId())) {  // Null-safe comparison
                model.addAttribute("product", product);
                return "editProduct";
            }
        }
        return REDIRECT_PRODUCT_LIST;  // ✅ Use constant
    }

    @PostMapping("/edit")
    public String editProductPost(@ModelAttribute Product product) {
        service.update(product);
        return REDIRECT_PRODUCT_LIST;  // ✅ Use constant
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") String id) {
        service.delete(id);
        return REDIRECT_PRODUCT_LIST;  // ✅ Use constant
    }
}
