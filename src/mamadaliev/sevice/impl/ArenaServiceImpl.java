package mamadaliev.sevice.impl;

import mamadaliev.sevice.ArenaService;

import java.util.Random;

import static mamadaliev.util.Constants.Window.HEIGHT;
import static mamadaliev.util.Constants.Window.WIDTH;

public class ArenaServiceImpl implements ArenaService {

    @Override
    public boolean[][][] fillValues(boolean[][][] cells, int row, int column, double percent) {
        Random rnd = new Random();
        int size = 0, x, y;
        int count = (int) (((row * column) / 100) * percent);

        while (size < count) {
            x = rnd.nextInt(row);
            y = rnd.nextInt(column);

            if (!cells[0][x][y]) {
                cells[0][x][y] = true;
                size++;
            }
        }
        return cells;
    }

    private int getNeighborsCount(boolean[][][] cells, int x, int y) {
        int neighbors = 0;

        // left bottom cell
        if (y == 0 && x == 0) {
            if (cells[0][x + 1][y])              neighbors++; // [x+1, y]
            if (cells[0][x + 1][y + 1])          neighbors++; // [x+1, y+1]
            if (cells[0][x][y + 1])              neighbors++; // [x,   y+1]
            if (cells[0][x + 1][HEIGHT - 1])     neighbors++; // [x+1, y-1]
            if (cells[0][x][HEIGHT - 1])         neighbors++; // [x,   y-1]
            if (cells[0][WIDTH - 1][HEIGHT - 1]) neighbors++; // [x-1, y-1]
            if (cells[0][WIDTH - 1][y])          neighbors++; // [x-1, y]
            if (cells[0][WIDTH - 1][y + 1])      neighbors++; // [x-1, y+1]
        }

        // right bottom cell
        if (y == 0 && x == WIDTH - 1) {
            if (cells[0][0][y])              neighbors++; // [x+1, y]
            if (cells[0][0][y + 1])          neighbors++; // [x+1, y+1]
            if (cells[0][x][y + 1])          neighbors++; // [x,   y+1]
            if (cells[0][0][HEIGHT - 1])     neighbors++; // [x+1, y-1]
            if (cells[0][x][HEIGHT - 1])     neighbors++; // [x,   y-1]
            if (cells[0][x - 1][HEIGHT - 1]) neighbors++; // [x-1, y-1]
            if (cells[0][x - 1][y])          neighbors++; // [x-1, y]
            if (cells[0][x - 1][y + 1])      neighbors++; // [x-1, y+1]
        }

        // right top cell
        if (y == HEIGHT - 1 && x == WIDTH - 1) {
            if (cells[0][0][y])         neighbors++; // [x+1, y]
            if (cells[0][0][0])         neighbors++; // [x+1, y+1]
            if (cells[0][x][0])         neighbors++; // [x,   y+1]
            if (cells[0][0][y - 1])     neighbors++; // [x+1, y-1]
            if (cells[0][x][y - 1])     neighbors++; // [x,   y-1]
            if (cells[0][x - 1][y - 1]) neighbors++; // [x-1, y-1]
            if (cells[0][x - 1][y])     neighbors++; // [x-1, y]
            if (cells[0][x - 1][0])     neighbors++; // [x-1, y+1]
        }

        // left top cell
        if (y == HEIGHT - 1 && x == 0) {
            if (cells[0][x + 1][y])         neighbors++; // [x+1, y]
            if (cells[0][x + 1][0])         neighbors++; // [x+1, y+1]
            if (cells[0][x][0])             neighbors++; // [x,   y+1]
            if (cells[0][x + 1][y - 1])     neighbors++; // [x+1, y-1]
            if (cells[0][x][y - 1])         neighbors++; // [x,   y-1]
            if (cells[0][WIDTH - 1][y - 1]) neighbors++; // [x-1, y-1]
            if (cells[0][WIDTH - 1][y])     neighbors++; // [x-1, y]
            if (cells[0][WIDTH - 1][0])     neighbors++; // [x-1, y+1]
        }

        // bottom cells
        if (y == 0 && (x > 0 && x < WIDTH - 1)) {
            if (cells[0][x + 1][y])          neighbors++; // [x+1, y]
            if (cells[0][x + 1][y + 1])      neighbors++; // [x+1, y+1]
            if (cells[0][x][y + 1])          neighbors++; // [x,   y+1]
            if (cells[0][x + 1][HEIGHT - 1]) neighbors++; // [x+1, y-1]
            if (cells[0][x][HEIGHT - 1])     neighbors++; // [x,   y-1]
            if (cells[0][x - 1][HEIGHT - 1]) neighbors++; // [x-1, y-1]
            if (cells[0][x - 1][y])          neighbors++; // [x-1, y]
            if (cells[0][x - 1][y + 1])      neighbors++; // [x-1, y+1]
        }

        // top cells
        if (y == HEIGHT - 1 && (x > 0 && x < WIDTH - 1)) {
            if (cells[0][x + 1][y])     neighbors++; // [x+1, y]
            if (cells[0][x + 1][0])     neighbors++; // [x+1, y+1]
            if (cells[0][x][0])         neighbors++; // [x,   y+1]
            if (cells[0][x + 1][y - 1]) neighbors++; // [x+1, y-1]
            if (cells[0][x][y - 1])     neighbors++; // [x,   y-1]
            if (cells[0][x - 1][y - 1]) neighbors++; // [x-1, y-1]
            if (cells[0][x - 1][y])     neighbors++; // [x-1, y]
            if (cells[0][x - 1][0])     neighbors++; // [x-1, y+1]
        }

        // left cells
        if (x == 0 && (y > 1 && y < HEIGHT - 2)) {
            if (cells[0][x + 1][y])         neighbors++; // [x+1, y]
            if (cells[0][x + 1][0])         neighbors++; // [x+1, y+1]
            if (cells[0][x][y + 1])         neighbors++; // [x,   y+1]
            if (cells[0][x + 1][y - 1])     neighbors++; // [x+1, y-1]
            if (cells[0][x][y - 1])         neighbors++; // [x,   y-1]
            if (cells[0][WIDTH - 1][y - 1]) neighbors++; // [x-1, y-1]
            if (cells[0][WIDTH - 1][y])     neighbors++; // [x-1, y]
            if (cells[0][WIDTH - 1][y + 1]) neighbors++; // [x-1, y+1]
        }

        // right cells
        if (x == WIDTH - 1 && (y > 1 && y < HEIGHT - 2)) {
            if (cells[0][0][y])         neighbors++; // [x+1, y]
            if (cells[0][0][0])         neighbors++; // [x+1, y+1]
            if (cells[0][x][y + 1])     neighbors++; // [x,   y+1]
            if (cells[0][0][y - 1])     neighbors++; // [x+1, y-1]
            if (cells[0][x][y - 1])     neighbors++; // [x,   y-1]
            if (cells[0][x - 1][y - 1]) neighbors++; // [x-1, y-1]
            if (cells[0][x - 1][y])     neighbors++; // [x-1, y]
            if (cells[0][x - 1][y + 1]) neighbors++; // [x-1, y+1]
        }

        // other cells
        if ((x > 0 && y > 0) && (x < WIDTH - 1 && y < HEIGHT - 1)) {
            if (cells[0][x + 1][y])     neighbors++; // [x+1, y]
            if (cells[0][x + 1][y + 1]) neighbors++; // [x+1, y+1]
            if (cells[0][x][y + 1])     neighbors++; // [x,   y+1]
            if (cells[0][x + 1][y - 1]) neighbors++; // [x+1, y-1]
            if (cells[0][x][y - 1])     neighbors++; // [x,   y-1]
            if (cells[0][x - 1][y - 1]) neighbors++; // [x-1, y-1]
            if (cells[0][x - 1][y])     neighbors++; // [x-1, y]
            if (cells[0][x - 1][y + 1]) neighbors++; // [x-1, y+1]
        }
        return neighbors;
    }

    @Override
    public boolean[][][] generateNextEpoch(boolean[][][] cells) {
        int neighbors;

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                neighbors = getNeighborsCount(cells, x, y);
                cells[1][x][y] = neighbors == 3 || (cells[0][x][y] && neighbors == 2);
            }
        }

        for (int i = 0; i < cells[0].length; i++) {
            System.arraycopy(cells[1][i], 0, cells[0][i], 0, cells[0][i].length);
        }
        return cells;
    }
}
