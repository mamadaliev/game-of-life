package mamadaliev.sevice.deprecated;

public interface Game {

    void start();

    void update();

    void pause();

    void resume();

    void delay(int milliseconds) throws InterruptedException;

    void reset();

    void clear();

    void display();
}
