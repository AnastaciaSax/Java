/*
Есть сайт, на котором рассчитывается рейтинг игроков различных сетевых игр. Игрок при регистрации
 указывает ник, а так же список игр, в которые он играет.
Задача – написать программу, которая:
- регистрирует игроков в системе (должна быть проверка, занят ли ник);
- добавляет рейтинг игроку, в случае его выигрыша в игре;
- выводит список игр, в которые играют все игроки на сайте;
- выводит рейтинг по имени игрока и игре;
- выводит 10 лучших игроков в определенной игре;
- выводит 10 лучших игроков с учетом всех игр.

 */

import java.util.*; // all packs
import java.util.stream.Collectors;

interface PlayerManager {
    boolean checkInPlayer(String nick, List<String> games);
    boolean addRating(String nick, String game, int points);
    Map<String, Integer> getPlayerRatings(String nick);
    List<String> getCommonGames();
    List<Player> getTopPlayersByGame(String game, int topN);
    List<Player> getTopPlayersOverall(int topN);
}

class Player {
    private String nick;
    private List<String> games;
    private Map<String, Integer> ratings;

    public Player(String nick, List<String> games) {
        this.nick = nick;
        this.games = new ArrayList<>(games);
        this.ratings = new HashMap<>();
        for (String game : games) {
            ratings.put(game, 0);
        }
    }

    public String getNick() {
        return nick;
    }

    public List<String> getGames() {
        return new ArrayList<>(games);
    }

    public Map<String, Integer> getRatings() {
        return new HashMap<>(ratings);
    }

    public void addRating(String game, int points) {
        ratings.put(game, ratings.getOrDefault(game, 0) + points);
    }

    public int getTotalRating() {
        return ratings.values().stream().mapToInt(Integer::intValue).sum();
    }
}

class GameRatingSystem implements PlayerManager { // interface realization
    private List<Player> players;

    public GameRatingSystem() {
        players = new ArrayList<>();
    }
// redefinition
    @Override
    public boolean checkInPlayer(String nick, List<String> games) {
        for (Player p : players) {
            if (p.getNick().equalsIgnoreCase(nick)) {
                return false; // Nickname taken
            }
        }
        players.add(new Player(nick, games));
        return true;
    }

    @Override
    public boolean addRating(String nick, String game, int points) {
        for (Player p : players) {
            if (p.getNick().equalsIgnoreCase(nick)) {
                if (p.getGames().contains(game)) {
                    p.addRating(game, points);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    @Override
    public Map<String, Integer> getPlayerRatings(String nick) {
        for (Player p : players) {
            if (p.getNick().equalsIgnoreCase(nick)) {
                return p.getRatings();
            }
        }
        return null;
    }

    @Override
    public List<String> getCommonGames() {
        if (players.isEmpty()) return new ArrayList<>();
        Set<String> common = new HashSet<>(players.get(0).getGames());
        for (Player p : players) {
            common.retainAll(p.getGames());
        }
        return new ArrayList<>(common);
    }

    @Override
    public List<Player> getTopPlayersByGame(String game, int topN) {
        return players.stream()
                .filter(p -> p.getGames().contains(game))
                .sorted((a, b) -> b.getRatings().get(game) - a.getRatings().get(game))
                .limit(topN)
                .collect(Collectors.toList());
    }

    @Override
    public List<Player> getTopPlayersOverall(int topN) {
        return players.stream()
                .sorted((a, b) -> b.getTotalRating() - a.getTotalRating())
                .limit(topN)
                .collect(Collectors.toList());
    }
}
public class Task01 {
    public static void main(String[] args) {
        GameRatingSystem system = new GameRatingSystem();

        system.checkInPlayer("Alice", Arrays.asList("CS", "LoL", "Dota"));
        system.checkInPlayer("Bob", Arrays.asList("CS", "LoL"));
        system.checkInPlayer("Charlie", Arrays.asList("CS", "Dota"));

        system.addRating("Alice", "CS", 10);
        system.addRating("Bob", "CS", 15);
        system.addRating("Charlie", "CS", 20);
        system.addRating("Alice", "Dota", 5);

        System.out.println("Alice ratings: " + system.getPlayerRatings("Alice"));

        System.out.println("Common games: " + system.getCommonGames());

        System.out.println("Top players in CS:");
        for (Player p : system.getTopPlayersByGame("CS", 10)) {
            System.out.println(p.getNick() + ": " + p.getRatings().get("CS"));
        }

        System.out.println("Top players in general:");
        for (Player p : system.getTopPlayersOverall(10)) {
            System.out.println(p.getNick() + ": " + p.getTotalRating());
        }
    }
}