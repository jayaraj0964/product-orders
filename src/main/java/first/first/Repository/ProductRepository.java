package first.first.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import first.first.models.Product;

public interface ProductRepository  extends  JpaRepository < Product,Long>{

}
