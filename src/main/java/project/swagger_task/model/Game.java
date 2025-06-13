package project.swagger_task.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    private Long id;

    @NotBlank(message = "Title cant be empty")
    @Pattern(regexp = "^[A-Za-z0-9А-Яа-я., ]{2,35}$",
            message = "Title should only contain eng/rus letters, digits, spaces, dots, and commas")
    private String title;

    @NotBlank(message = "Genre cant be empty")
    @Pattern(regexp = "^[A-Za-zА-Яа-я., ]{2,25}$",
    message = "Genre should only contain eng/rus letters, and spaces")
    private String genre;
}
