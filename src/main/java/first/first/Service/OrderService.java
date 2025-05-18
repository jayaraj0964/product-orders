package first.first.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import first.first.Repository.OrdersRepository;
import first.first.Repository.ProductRepository;
import first.first.models.Orders;
import first.first.models.Product;

@Service
public class OrderService {

    @Autowired
    private OrdersRepository orderRepo;

    @Autowired
    private ProductRepository productRepo;
    public Orders createOrder(Orders order) {
        List<Product> products = order.getProducts();
    
        if (products == null || products.isEmpty()) {
            throw new IllegalArgumentException("Product list cannot be null or empty");
        }
    
        List<Product> fullProducts = productRepo.findAllById(
            products.stream().map(Product::getId).toList()
        );
    
        BigDecimal total = fullProducts.stream()
            .map(Product::getPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    
        order.setProducts(fullProducts);
        order.setTotalPrice(total);
        order.setOrderDate(LocalDate.now());
    
        return orderRepo.save(order);
    }

    public List<Orders> getAllOrders() {
        return orderRepo.findAll();
    }

    public Orders getOrderById(Long id) {
        return orderRepo.findById(id).orElse(null);
    }
}
