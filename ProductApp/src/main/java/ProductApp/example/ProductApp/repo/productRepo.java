package ProductApp.example.ProductApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ProductApp.example.ProductApp.model.product;

public interface productRepo extends JpaRepository<product, Long> {
    
}
