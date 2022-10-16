package mamadaliev.model;

public class WindowModel {

    private int with;

    private int height;

    private boolean[][][] cells;

    private boolean isAllowZoomZone;

    private int zoomCount;

    private double radiusSize;

    public WindowModel() {
    }

    public WindowModel(int with, int height, boolean[][][] cells, boolean isAllowZoomZone, int zoomCount, double radiusSize) {
        this.with = with;
        this.height = height;
        this.cells = cells;
        this.isAllowZoomZone = isAllowZoomZone;
        this.zoomCount = zoomCount;
        this.radiusSize = radiusSize;
    }

    public int getWith() {
        return with;
    }

    public void setWith(int with) {
        this.with = with;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean[][][] getCells() {
        return cells;
    }

    public void setCells(boolean[][][] cells) {
        this.cells = cells;
    }

    public boolean isAllowZoomZone() {
        return isAllowZoomZone;
    }

    public void setAllowZoomZone(boolean allowZoomZone) {
        isAllowZoomZone = allowZoomZone;
    }

    public int getZoomCount() {
        return zoomCount;
    }

    public void setZoomCount(int zoomCount) {
        this.zoomCount = zoomCount;
    }

    public double getRadiusSize() {
        return radiusSize;
    }

    public void setRadiusSize(double zoomedRadiusSize) {
        this.radiusSize = zoomedRadiusSize;
    }
}
