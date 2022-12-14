import java.util.*;     

/**
 * Observable interface
**/
interface Observable {
    void addObserver(Gamer gamer);

    void notifyObservers();
}

/**
 * Concrete Observable - Rockstar Games
**/
class RockstarGames implements Observable {

    public String releaseGame;
    private final List<Observer> observers = new ArrayList<>();

    public void release(String game) {
        this.releaseGame = game;
        notifyObservers();
    }

    @Override
    public void addObserver(Gamer gamer) {
        observers.add(gamer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            System.out.println("Notification for gamer : " + observer);
            observer.update(releaseGame);
        }
    }
}

/**
 * Observer interface
**/
interface Observer {
    // write your code here ...
    void update(String game);
}

/**
 * Concrete observer - Gamer
**/
class Gamer implements Observer {

    private final String name;
    private final Set<String> games = new HashSet<>();

    public Gamer(String name) {
        this.name = name;
    }

    // write your code here ...
    @Override
    public void update(String game) {
        if (games.contains(game)) {
            System.out.println("What? They've already released this game ... I don't understand");
        } else {
            buyGame(game);
        }
    }

    public void buyGame(String game) {
        System.out.println(name + " says : \"Oh, Rockstar releases new game " + game + " !\"");
        games.add(game);
    }

    @Override
    public String toString() {
        return this.name;
    }
}

/**
 * Main class
**/
public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        String game;

        RockstarGames rockstarGames = new RockstarGames();

        Gamer garry = new Gamer("Garry Rose");
        Gamer peter = new Gamer("Peter Johnston");
        Gamer helen = new Gamer("Helen Jack");

        rockstarGames.addObserver(garry);
        rockstarGames.addObserver(peter);
        rockstarGames.addObserver(helen);

        for (int i = 0; i < 2; i++) {
            game = scanner.nextLine();
            rockstarGames.release(game);
        }
    }
}