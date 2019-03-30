package mamadaliev;

import java.awt.*;
import java.util.Random;
import edu.princeton.cs.introcs.StdDraw;

class CellsController {
    private int row, column;
    private boolean[][][] cells;
    private double radius;
    private double percent;

    /**
     * Constructor with class parameters CellsController
     *
     * @param width window width
     * @param height window height
     * @param row row length of cells
     * @param column column length of cells
     * @param radius cell radius
     */
    CellsController(int width, int height, int row, int column, double radius, double percent) {
        this.row = row;
        this.column = column;
        this.radius = radius;
        this.cells = new boolean[2][width][height]; // 2 x (row * column)
        this.percent = percent;
    }

    /**
     * Initialization of cells
     */
    public void initValues() {
        Random rnd = new Random();
        int size = 0, x, y;
        int count = (int) (((row * column) / 100) * this.percent);

        while (size < count) {
            x = rnd.nextInt(row);
            y = rnd.nextInt(column);

            if (!cells[0][x][y]) {
                cells[0][x][y] = true;
                size++;
            }
        }
    }

    /**
     * Checking the neighbors and returning their quantity
     */
    private int getNeighborsCount(int x, int y) {
        int neighbors = 0;
        if (cells[0][x - 1][y - 1]) neighbors++;
        if (cells[0][x - 1][y])     neighbors++;
        if (cells[0][x][y - 1])     neighbors++;
        if (cells[0][x][y + 1])     neighbors++;
        if (cells[0][x + 1][y])     neighbors++;
        if (cells[0][x + 1][y + 1]) neighbors++;
        if (cells[0][x + 1][y - 1]) neighbors++;
        if (cells[0][x - 1][y + 1]) neighbors++;
        return neighbors;
    }

    /**
     * Generation of next epoch
     */
    public void getNextEpoch() {
        int neighbors;

        for (int x = 1; x < row - 1; x++) {
            for (int y = 1; y < column - 1; y++) {
                neighbors = getNeighborsCount(x, y);
                cells[1][x][y] = neighbors == 3 || (cells[0][x][y] && neighbors == 2);
            }
        }

        for (int i = 0; i < cells[0].length; i++) {
            System.arraycopy(cells[1][i], 0, cells[0][i], 0, cells[0][i].length);
        }
    }

    /**
     * Drawing cells
     */
    public void drawCells() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (cells[0][i][j]) {
                    StdDraw.setPenColor(Color.BLACK);
                    StdDraw.filledRectangle(i, j, 0.1 * radius, 0.1 * radius);
                }
            }
        }
    }

    /**
     * Drawing labels
     * @param tFrame the difference between initial and current frame
     */
    public void showInfo(long tFrame) {
        String time = "Frame: " + tFrame + "ms";
        String fps = "FPS: " + (int) (1000.0 / tFrame);
        StdDraw.textLeft(20, 20, time);
        StdDraw.textLeft(20, 40, fps);
    }
}