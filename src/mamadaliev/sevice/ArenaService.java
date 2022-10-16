package mamadaliev.sevice;

public interface ArenaService {

    boolean[][][] fillValues(boolean[][][] cells, int row, int column, double percent);

    boolean[][][] generateNextEpoch(boolean[][][] cells);
}
