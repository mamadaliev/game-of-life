package mamadaliev.model;

public class DeadCell implements Cell {

    @Override
    public boolean isLive() {
        return false;
    }
}
