package project.swagger_task.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.swagger_task.model.Game;
import project.swagger_task.model.GameInput;
import project.swagger_task.model.GameUpdate;
import project.swagger_task.service.GameService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/game-store")
@Tag(name = "GameStore API", description = "Homework on Swagger||Game Store")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }


    @Operation(summary = "Get all games",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of games",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Game.class, type = "array")))
            }
    )
    @GetMapping
    public List<Game> getGames() {
        return gameService.getAllGames();
    }

    @Operation(summary = "Get game by ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Game found",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Game.class))),
                    @ApiResponse(responseCode = "404", description = "Game not found")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Game> getGame(
            @Parameter(description = "ID of the game", required = true)
            @PathVariable Long id) {
        return gameService.getGame(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Add a new game",
            requestBody = @RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = GameInput.class),
                            examples = {
                                    @ExampleObject(name = "Example 1", value = "{\"title\": \"StarDew Valley\", \"genre\": \"Farm RPG\"}"),
                                    }
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Game added",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Game.class)))
            }
    )
    @PostMapping("/add")
    public ResponseEntity<Game> addGame(@Valid @org.springframework.web.bind.annotation.RequestBody GameInput gameInput) {
        Game game = new Game();
        game.setTitle(gameInput.getTitle());
        game.setGenre(gameInput.getGenre());
        gameService.save(game);
        return ResponseEntity.ok(game);
    }

    @Operation(summary = "Update game by ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Game updated",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Game.class))),
                    @ApiResponse(responseCode = "404", description = "Game not found")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(
            @Parameter(description = "ID of the game", required = true)
            @PathVariable Long id,
            @Valid @org.springframework.web.bind.annotation.RequestBody GameUpdate gameUpdate) {
        if (gameService.getGame(id).isEmpty())
            return ResponseEntity.notFound().build();

        Game game = gameService.getGame(id).get();
        game.setTitle(gameUpdate.getTitle());
        game.setGenre(gameUpdate.getGenre());
        gameService.save(game);

        return ResponseEntity.ok(game);
    }

    @Operation(summary = "Delete game by ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Game deleted",
                            content = @Content(mediaType = MediaType.TEXT_PLAIN_VALUE,
                                    schema = @Schema(type = "string", example = "Game deleted with id : 1"))),
                    @ApiResponse(responseCode = "404", description = "Game not found")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGame(
            @Parameter(description = "ID of the game", required = true)
            @PathVariable Long id) {
        if (gameService.getGame(id).isEmpty())
            return ResponseEntity.notFound().build();

        gameService.delete(id);
        return ResponseEntity.ok("Game deleted with id : " + id);
    }
}