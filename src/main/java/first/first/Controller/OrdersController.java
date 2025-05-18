package first.first.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import first.first.Service.OrderService;
import first.first.models.Orders;

@RestController
public class OrdersController {
    
    @Autowired
    private OrderService orderService;


    @PostMapping("/postorder")
    public Orders createOrder(@RequestBody Orders o) {
        return orderService.createOrder(o);
    }
    
    @GetMapping("/getorder")
    public List<Orders> getAllOrders (){
         return orderService.getAllOrders();
    }

    @GetMapping("getbyid/{id}")
    public Orders getOrder(@PathVariable Long id){
        return orderService.getOrderById(id);
    }




}
