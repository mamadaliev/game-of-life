package mamadaliev;

/**
 * Conway's Game of Life
 *
 * @author Sherzod Mamadaliev
 * @version 0.1 (March 24, 2019)
 */
public class Run {
    public static void main(String[] args) {
        Game game = new Game(1280,720, 1280, 720, 5);
        game.init();
        game.update();
    }
}