package project.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.springproject.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

