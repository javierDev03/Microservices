package OrdersService.OrdersService.service;



import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final WebClient webClient;

    public OrderService(WebClient webClient) {
        this.webClient = webClient;
    }

    // DTOs
    public record OrderDTO(Long id, Long userId, List<Long> productIds) {}
    public record OrderRequest(Long userId, List<Long> productIds) {}
    public record UserDTO(Long id, String name) {}
    public record ProductDTO(Long id, String name) {}

    
    private final List<OrderDTO> orders = new ArrayList<>();
    private Long nextId = 1L;

    public OrderDTO createOrder(OrderRequest request) {

        // valided users
        Mono<UserDTO> userMono = webClient.get()
                .uri("http://users-service:8081/users/{id}", request.userId())
                .retrieve()
                .bodyToMono(UserDTO.class);

        UserDTO user = userMono.block(); // bloqueamos solo por simplicidad en este ejemplo
        if (user == null) throw new RuntimeException("User not found");

        // valided products
        List<Long> validProducts = new ArrayList<>();
        for (Long pid : request.productIds()) {
            Mono<ProductDTO> prodMono = webClient.get()
                    .uri("http://products-service:8082/products/{id}", pid)
                    .retrieve()
                    .bodyToMono(ProductDTO.class);

            ProductDTO prod = prodMono.block();
            if (prod != null) validProducts.add(pid);
        }

        if (validProducts.isEmpty()) throw new RuntimeException("No valid products");

        // Create order
        OrderDTO order = new OrderDTO(nextId++, user.id(), validProducts);
        orders.add(order);
        return order;
    }

    public List<OrderDTO> getAllOrders() {
        return orders;
    }

    public OrderDTO getOrderById(Long id) {
        return orders.stream()
                .filter(o -> o.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}
