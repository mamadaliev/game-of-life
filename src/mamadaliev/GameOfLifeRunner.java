package mamadaliev;

/**
 * Conway's Game of Life
 * March 30, 2019
 *
 * @author Sherzod Mamadaliev
 * @version 0.2
 */
public class GameOfLifeRunner {

    /**
     * Running Conway's Game of Life
     *
     * @param args CLI arguments
     */
    public static void main(String... args) {
        GameOfLife game = new GameOfLife(1280, 720, 1000, 500, 5.0d, 80);
        game.init();
        game.update();
    }
}