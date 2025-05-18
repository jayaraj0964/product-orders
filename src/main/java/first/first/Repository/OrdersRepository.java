package first.first.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import first.first.models.Orders;

public interface  OrdersRepository  extends JpaRepository <Orders , Long> {
    
}
