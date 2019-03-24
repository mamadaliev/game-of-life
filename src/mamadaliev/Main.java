package mamadaliev;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(1280,720, 1280, 720, 5);
        game.init();
        game.update();
    }
}