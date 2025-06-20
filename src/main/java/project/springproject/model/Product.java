package project.springproject.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Product model")
public class Product {

    @NotNull(message = "ID cant be blank")
    @Schema(example = "1")
    private Long id;

    @NotBlank(message = "Name cant be blank")
    @Schema(example = "TV")
    private String name;

    @NotBlank(message = "Description cant be blank")
    @Schema(example = "LG tv")
    private String description;

    @DecimalMin(value = "0.01", message = "Цена должна быть больше 0")
    @Schema(example = "300.99")
    private Double price;

    @PositiveOrZero(message = "Количество не может быть отрицательным")
    @Schema(example = "100")
    private int quantity;
}
