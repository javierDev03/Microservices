package OrdersService.OrdersService;


import org.springframework.web.bind.annotation.*;

import OrdersService.OrdersService.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/orders")
@Tag(name = "Orders", description = "API de gestión de órdenes")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Operation(summary = "Obtener todas las órdenes")
    @GetMapping
    public List<OrderService.OrderDTO> getOrders() {
        return orderService.getAllOrders();
    }

    @Operation(summary = "Obtener una orden por ID")
    @GetMapping("/{id}")
    public OrderService.OrderDTO getOrder(@PathVariable Long id) {
        return orderService.getOrderById(id);
        }

    @Operation(summary = "Crear una orden")
    @PostMapping
    public OrderService.OrderDTO createOrder(@RequestBody OrderService.OrderRequest request) {
        return orderService.createOrder(request);
    }
}
