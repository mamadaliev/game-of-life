package mamadaliev;

import java.awt.*;
import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;

public class GameOfLife extends Game {

    public static final int WINDOW_WIDTH    = 1280;
    public static final int WINDOW_HEIGHT   = 720;
    public static final int ROW_WIDTH       = 1000;
    public static final int ROW_HEIGHT      = 500;
    public static final double RADIUS       = 5.0;
    public static final int PERCENT         = 80;
    public static final int FPS_MAX         = 30;

    private CellsController controller;

    static {
        StdDraw.enableDoubleBuffering();
    }

    /**
     * Default constructor
     *
     **/
    GameOfLife() {
        StdDraw.setCanvasSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        StdDraw.setXscale(0, WINDOW_WIDTH - 1);
        StdDraw.setYscale(0, WINDOW_HEIGHT - 1);
        this.controller = new CellsController(WINDOW_WIDTH, WINDOW_HEIGHT, ROW_WIDTH, ROW_HEIGHT, RADIUS, PERCENT);
    }

    /**
     * Constructor with class parameters Game
     *
     * @param row row length of controller
     * @param column column length of controller
     * @param radius cell radius
     * @param percent percent count of all controller
     */
    GameOfLife(int row, int column, double radius, double percent) {
        StdDraw.setCanvasSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        StdDraw.setXscale(0, WINDOW_WIDTH - 1);
        StdDraw.setYscale(0, WINDOW_HEIGHT - 1);

        if (row > WINDOW_WIDTH) {
            row = WINDOW_WIDTH;
        }

        if (column > WINDOW_HEIGHT) {
            column = WINDOW_HEIGHT;
        }

        this.controller = new CellsController(WINDOW_WIDTH, WINDOW_HEIGHT, row, column, radius, percent);
    }

    /**
     * Constructor with class parameters Game
     *
     * @param width window width
     * @param height window height
     * @param row row length of controller
     * @param column column length of controller
     * @param radius cell radius
     */
    GameOfLife(int width, int height, int row, int column, double radius, double percent) {
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width - 1);
        StdDraw.setYscale(0, height - 1);

        if (row > width) {
            row = width;
        }

        if (column > height) {
            column = height;
        }

        this.controller = new CellsController(width, height, row, column, radius, percent);
    }

    /**
     * Game initial
     *
     * Calling one time in initial of game
     */
    @Override
    public void init() {
        controller.fillValues();
    }

    /**
     * Frame update
     *
     * Calling in cycle after initialization
     */
    @Override
    public void update() {
        do {
            StdDraw.clear(Color.WHITE);
            long tStart = System.currentTimeMillis();
            controller.drawCells();
            controller.getNextEpoch();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long tFrame = System.currentTimeMillis() - tStart;
            showLabels(tFrame);
            StdDraw.show();
        } while (!StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE));
    }

    /**
     * Drawing labels
     * @param tFrame the difference between initial and current frame
     */
    public void showLabels(long tFrame) {
        String time = "Frame: " + tFrame + "ms";
        String fps = "FPS: " + (int) (1000.0 / tFrame);
        StdDraw.textLeft(20, 20, time);
        StdDraw.textLeft(20, 40, fps);
    }
}