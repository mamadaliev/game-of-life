package mamadaliev;

public abstract class Game {

    /**
     * Game initial
     *
     * Calling one time in initial of game
     */
    public abstract void init();

    /**
     * Frame update
     *
     * Calling in cycle after initialization
     */
    public abstract void update();
}