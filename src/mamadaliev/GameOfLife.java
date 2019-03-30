package mamadaliev;

import java.awt.*;
import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;

public class GameOfLife {

    public static final int WINDOW_WIDTH    = 1280;
    public static final int WINDOW_HEIGHT   = 720;
    public static final int ROW_WIDTH       = 1000;
    public static final int ROW_HEIGHT      = 500;
    public static final double RADIUS       = 5.0;
    public static final int PERCENT         = 80;

    private CellsController cells;

    /**
     * Default constructor
     *
     **/
    GameOfLife() {
        StdDraw.setCanvasSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        StdDraw.setXscale(0, WINDOW_WIDTH - 1);
        StdDraw.setYscale(0, WINDOW_HEIGHT - 1);
        StdDraw.enableDoubleBuffering();
        this.cells = new CellsController(WINDOW_WIDTH, WINDOW_HEIGHT, ROW_WIDTH, ROW_HEIGHT, RADIUS, PERCENT);
    }

    /**
     * Constructor with class parameters Game
     *
     * @param radius cell radius
     */
    GameOfLife(double radius) {
        StdDraw.setCanvasSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        StdDraw.setXscale(0, WINDOW_WIDTH - 1);
        StdDraw.setYscale(0, WINDOW_HEIGHT - 1);
        StdDraw.enableDoubleBuffering();
        this.cells = new CellsController(WINDOW_WIDTH, WINDOW_HEIGHT, ROW_WIDTH, ROW_HEIGHT, radius, PERCENT);
    }

    /**
     * Constructor with class parameters Game
     *
     * @param radius cell radius
     * @param percent percent count of all cells
     */
    GameOfLife(double radius, double percent) {
        StdDraw.setCanvasSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        StdDraw.setXscale(0, WINDOW_WIDTH - 1);
        StdDraw.setYscale(0, WINDOW_HEIGHT - 1);
        StdDraw.enableDoubleBuffering();
        this.cells = new CellsController(WINDOW_WIDTH, WINDOW_HEIGHT, ROW_WIDTH, ROW_HEIGHT, radius, percent);
    }

    /**
     * Constructor with class parameters Game
     *
     * @param row row length of cells
     * @param column column length of cells
     * @param radius cell radius
     * @param percent percent count of all cells
     */
    GameOfLife(int row, int column, double radius, double percent) {
        StdDraw.setCanvasSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        StdDraw.setXscale(0, WINDOW_WIDTH - 1);
        StdDraw.setYscale(0, WINDOW_HEIGHT - 1);
        StdDraw.enableDoubleBuffering();
        this.cells = new CellsController(WINDOW_WIDTH, WINDOW_HEIGHT, row, column, radius, percent);
    }

    /**
     * Constructor with class parameters Game
     *
     * @param width window width
     * @param height window height
     * @param row row length of cells
     * @param column column length of cells
     * @param radius cell radius
     */
    GameOfLife(int width, int height, int row, int column, double radius, double percent) {
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width - 1);
        StdDraw.setYscale(0, height - 1);
        StdDraw.enableDoubleBuffering();
        this.cells = new CellsController(width, height, row, column, radius, percent);
    }

    /**
     * Game initial
     *
     * Calling one time in initial of game
     */
    public void init() {
        cells.initValues();
    }

    /**
     * Frame update
     *
     * Calling in cycle after initialization
     */
    public void update() {
        do {
            StdDraw.clear(Color.WHITE);
            long tStart = System.currentTimeMillis();
            cells.drawCells();
            cells.getNextEpoch();
            long tFrame = System.currentTimeMillis() - tStart;
            cells.showInfo(tFrame);
            StdDraw.show();
        } while (!StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE));
    }
}