package ProductsService.ProductsService.service;


import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    // DTO 
    public record ProductDTO(Long id, String name) {}

    // List simulating the database
    private final List<ProductDTO> products = List.of(
            new ProductDTO(10L, "Laptop"),
            new ProductDTO(11L, "Mouse"),
            new ProductDTO(12L, "Keyboard")
    );

    // Get all products
    public List<ProductDTO> getAllProducts() {
        return products;
    }

    // Get product by id
    public ProductDTO getProductById(Long id) {
        return products.stream()
                .filter(p -> p.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}
