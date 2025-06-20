package project.springproject.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.springproject.model.Product;
import project.springproject.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/api/shop")
@Tag(name = "Product shop api")
public class ProductController {
    private final ProductRepository rep;
    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    public ProductController(ProductRepository rep) {
        log.debug("ProductController init");
        this.rep= rep;
    }

    @Operation(summary = "Get all products method executed")
    @ApiResponse(responseCode = "200", description = "Success")
    @GetMapping
    public List<Product> getAllProducts() {
        log.info("Get all products method");
        return rep.getAllProducts();
    }

    @Operation(summary = "Get product by ID method")
    @ApiResponses(value =
            {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "404", description = "Product not found")
            })
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        if(rep.findById(id).isPresent()) {
            log.info("Product with {} ID found", id);
            return ResponseEntity.ok(rep.findById(id).get());
        }
        else{
            log.info("GET: Product with {} ID not found", id);
            return ResponseEntity.notFound().build();
        }

    }

    @Operation(summary = "Add product method")
    @ApiResponses(value =
            {
                    @ApiResponse(responseCode = "201", description = "Success"),
                    @ApiResponse(responseCode = "400", description = "Incorrect data")
            })
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@Valid @RequestBody Product product) {
        log.debug("Product ID: {}, {}, {}, {}, {} added",
                product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getQuantity());
        return rep.save(product);
    }

    @Operation(summary = "Update product by ID method")
    @ApiResponses(value =
            {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "404", description = "Product not found"),
                    @ApiResponse(responseCode = "400", description = "Incorrect data")
            })
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @Valid @RequestBody Product updatedProduct) {
        log.info("Product with ID {} updated", id);
        return rep.findById(id)
                .map(existing -> {
                    updatedProduct.setId(id);
                    return ResponseEntity.ok(rep.save(updatedProduct));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete product method")
    @ApiResponses(value =
            {
                    @ApiResponse(responseCode = "204", description = "Success"),
                    @ApiResponse(responseCode = "404", description = "Product not found")
            })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(
            @PathVariable @Parameter(description = "Product ID", example = "1") Long id) {
        if(rep.findById(id).isPresent()) {
            rep.delete(id);
            log.info("Product with ID {} deleted", id);
            return ResponseEntity.noContent().build();
        }
        else
            log.info("DELETE: Product with {} ID not found", id);
        return ResponseEntity.notFound().build();
    }
}
