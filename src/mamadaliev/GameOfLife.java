package mamadaliev;

import java.awt.*;
import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;

public class GameOfLife extends Game implements Config {
    private int width;
    private int height;
    private int row;
    private int column;
    private double radius;
    private double percent;
    private static int zoomCount;
    private boolean zoomZone;
    private boolean[][][] cells;
    private CellsController controller;

    // Static initializer block
    static {
        zoomCount = 0;
        StdDraw.enableDoubleBuffering();
    }

    // Block initializer
    {
        width    = DEFAULT_WINDOW_WIDTH;
        height   = DEFAULT_WINDOW_HEIGHT;
        row      = DEFAULT_MATRIX_WIDTH;
        column   = DEFAULT_MATRIX_HEIGHT;
        radius   = DEFAULT_RADIUS;
        percent  = DEFAULT_PERCENT;
        zoomZone = false;
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

        this.cells = new boolean[2][width][height]; // 2 x (row * column)
        this.controller = new CellsController(width, height, row, column, radius, percent, cells);
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
            drawCells();
            controller.getNextEpoch();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long tFrame = System.currentTimeMillis() - tStart;
            showLabels(tFrame);
            zoomWindow();
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
        String shortcuts[] = {"close zoom — C", "increase — 2", "decrease — 1"};
        StdDraw.textLeft(20, 20, time);
        StdDraw.textLeft(20, 40, fps);

        StdDraw.textRight(width - 30, 20, "zoom — Z");

        if (zoomZone) {
            for (int i = 0; i < shortcuts.length; i++) {
                StdDraw.textRight(width - 30, i * 20 + 40, shortcuts[i]);
            }
        }
    }

    public void zoomWindow() {
        if (StdDraw.isKeyPressed(KeyEvent.VK_Z)) {
            zoomZone = true;
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_C)) {
            zoomZone = false;
        }

        if (zoomZone) {
            StdDraw.rectangle(width / 2.0, height / 2.0, 200, 200);
        }

        if (zoomZone && zoomCount < 10 && StdDraw.isKeyPressed(KeyEvent.VK_2)) {
            radius++;
            zoomCount++;
        }

        if (zoomZone && zoomCount > 0 && StdDraw.isKeyPressed(KeyEvent.VK_1)) {
            radius--;
            zoomCount--;
        }
    }

    /**
     * Drawing cells
     */
    public void drawCells() {
        for (int i = 0; i < width - zoomCount; i++) {
            for (int j = 0; j < height - zoomCount; j++) {
                if (cells[0][i + zoomCount][j + zoomCount]) {
                    StdDraw.setPenColor(Color.BLACK);
                    StdDraw.filledRectangle(i * radius, j * radius,
                            0.5 * radius, 0.5 * radius);
                }
            }
        }
    }
}