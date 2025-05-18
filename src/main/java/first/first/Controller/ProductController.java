package first.first.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import first.first.Service.ProductService;
import first.first.models.Product;


@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/postp")
    public Product create(@RequestBody Product p) {
        return productService.createProduct(p);
    }

    @GetMapping("/getp")
    public List<Product> getAll() {
        return productService.getAllProducts();
    }
}