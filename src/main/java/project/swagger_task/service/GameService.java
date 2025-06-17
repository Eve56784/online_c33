package project.swagger_task.service;

import org.springframework.stereotype.Service;
import project.swagger_task.model.Game;
import project.swagger_task.repository.GameRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    private final GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public List<Game> getAllGames() {
        return repository.getAllGames();
    }

    public Optional<Game> getGame(Long id) {
        return repository.getGame(id);
    }

    public void save(Game game) {
        repository.save(game);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public Game update(Game game) {
        return repository.updateGame(game);
    }
}
