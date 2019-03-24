package mamadaliev;

import java.awt.*;
import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;

class Game {
    private CellsController cellsController;

    /**
     * Constructor with class parameters Game
     *
     * @param width window width
     * @param height window height
     * @param row row length of cells
     * @param column column length of cells
     * @param radius cell radius
     */
    Game(int width, int height, int row, int column, double radius) {
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width - 1);
        StdDraw.setYscale(0, height - 1);
        StdDraw.enableDoubleBuffering();
        this.cellsController = new CellsController(width, height, row, column, radius);
    }

    /**
     * Initialization
     */
    void init() {
        cellsController.initValues();
    }

    /**
     * Refresh frames
     */
    void update() {
        do {
            StdDraw.clear(Color.WHITE);
            long tStart = System.currentTimeMillis();
            cellsController.drawCells();
            cellsController.getNextEpoch();
            long tFrame = System.currentTimeMillis() - tStart;
            cellsController.showInfo(tFrame);
            StdDraw.show();
        } while (!StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE));
    }
}