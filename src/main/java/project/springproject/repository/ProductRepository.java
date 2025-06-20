package project.springproject.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import project.springproject.model.Product;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {
    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
    private final Map<Long, Product> products = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public Optional<Product> findById(Long id) {
        log.debug("Find product by ID: {}", id);
        return Optional.ofNullable(products.get(id));
    }

    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(idGenerator.incrementAndGet());
        }
        products.put(product.getId(), product);
        log.debug("Saving product: {}", product);
        return product;
    }

    public void delete(Long id) {
        products.remove(id);
        log.warn("Deleting product with ID {}", id);
    }

    public List<Product> getAllProducts() {
        log.debug("Get all products");
        return new ArrayList<>(products.values());
    }
}

