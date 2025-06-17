package project.swagger_task.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Input model for creating (adding) a game")
public class GameInput {
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9А-Яа-я., ]{2,35}$",
            message = "Title should only contain eng/rus letters, digits, spaces, dots, and commas")
    @Schema(description = "Title of the game", example = "StarDew Valley", required = true)
    private String title;

    @NotBlank
    @Pattern(regexp = "^[A-Za-zА-Яа-я., ]{2,25}$",
            message = "Genre should only contain eng/rus letters, dots, commas, and spaces")
    @Schema(description = "Genre of the game", example = "Farm RPG", required = true)
    private String genre;
}
