package ProductsService.ProductsService;


import org.springframework.web.bind.annotation.*;

import ProductsService.ProductsService.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductService.ProductDTO> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductService.ProductDTO getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }
}
