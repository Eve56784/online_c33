package project.swagger_task.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.swagger_task.model.Game;
import project.swagger_task.service.GameService;

import java.util.List;

@RestController
@RequestMapping("/game-store")
public class GameController {
    private final GameService gameService;
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<Game> getGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGame(@PathVariable Long id) {
        return gameService.getGame(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Game> addGame(@Valid @RequestBody Game game) {
        gameService.save(game);
        return ResponseEntity.ok(game);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable Long id, @Valid @RequestBody Game game) {
        if(gameService.getGame(id).isEmpty())
            return ResponseEntity.notFound().build();
        game.setId(id);
        gameService.save(game);
        return ResponseEntity.ok(game);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGame(@PathVariable Long id) {
        if(gameService.getGame(id).isEmpty())
            return ResponseEntity.notFound().build();
        gameService.delete(id);
        return ResponseEntity.ok("Game deleted with id: " + id);
    }
}
