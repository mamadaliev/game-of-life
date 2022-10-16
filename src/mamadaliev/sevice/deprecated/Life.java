package mamadaliev.sevice.deprecated;

import mamadaliev.model.Cell;

public interface Life {

    void fill();

    void fill(Cell[][] cells);

    void generate(double percent);

    int getNeighborsCount(int x, int y);

    void generateNextEpoch();
}
