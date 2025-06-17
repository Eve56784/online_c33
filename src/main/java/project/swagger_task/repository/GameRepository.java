package project.swagger_task.repository;

import org.springframework.stereotype.Repository;
import project.swagger_task.model.Game;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class GameRepository {

    private final Map<Long, Game> games = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    public Optional<Game> getGame(Long id) {
        return Optional.ofNullable(games.get(id));
    }

    public List<Game> getAllGames() {
        return new ArrayList<>(games.values());
    }

    public void save(Game game) {
        if (game.getId() == null) {
            Long newId = idGenerator.incrementAndGet();
            game.setId(newId);
            games.put(newId, game);
        } else {
            games.put(game.getId(), game);
        }
    }


    public void delete(Long id) {
        games.remove(id);
    }

    public Game updateGame(Game game) {
        games.put(game.getId(), game);
        return game;
    }
}
