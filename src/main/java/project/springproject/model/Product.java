package project.springproject.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
@Schema(description = "Product model")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Name cant be blank")
    @Schema(example = "TV")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "Description cant be blank")
    @Schema(example = "LG tv")
    private String description;

    @Schema(example = "300.99")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    private Double price;

    @Schema(example = "100")
    @PositiveOrZero(message = "Quantity must be zero or positive")
    private int quantity;
}
