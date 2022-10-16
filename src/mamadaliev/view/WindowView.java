package mamadaliev.view;

import edu.princeton.cs.introcs.StdDraw;
import mamadaliev.model.WindowModel;
import mamadaliev.util.TimeUtil;

import java.awt.*;
import java.awt.event.KeyEvent;

import static mamadaliev.util.Constants.Arena.COLUMN;
import static mamadaliev.util.Constants.Arena.ROW;
import static mamadaliev.util.Constants.Cell.RADIUS;
import static mamadaliev.util.Constants.Window.HEIGHT;
import static mamadaliev.util.Constants.Window.WIDTH;

public class WindowView implements View<WindowModel> {

    public WindowView() {
        StdDraw.enableDoubleBuffering();
        StdDraw.clear();
        StdDraw.setCanvasSize(WIDTH, HEIGHT);
        StdDraw.setXscale(0, WIDTH - 1);
        StdDraw.setYscale(0, HEIGHT - 1);
    }

    @Override
    public void init(WindowModel data) {
        drawCells(data.getCells(), data.getRadiusSize());
    }

    @Override
    public void render(WindowModel data) {
        StdDraw.clear();
        StdDraw.clear(Color.WHITE);
        long startTime = System.currentTimeMillis();
        drawCells(data.getCells(), data.getRadiusSize());
        TimeUtil.sleep(30);
        long frameRate = System.currentTimeMillis() - startTime;
        showLabels(frameRate);
        //zoomWindow(data.isAllowZoomZone(), data.getZoomCount(), data.getZoomedRadiusSize());
    }

    private void showLabels(long frameRate) {
        String time = "Sleep: " + frameRate + "ms";
        String fps = "FPS: " + (int) (1000.0 / frameRate);
        StdDraw.textLeft(20, 20, fps);
        StdDraw.textLeft(20, 40, time);
    }

    private void drawCells(boolean[][][] cells, double radiusSize) {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                if (cells[0][i][j]) {
                    StdDraw.setPenColor(Color.BLACK);
                    StdDraw.filledRectangle(i, j, 0.1 * radiusSize, 0.1 * radiusSize);
                }
            }
        }
    }

        public void zoomWindow(boolean zoomZone, int zoomCount, double radius) {
//        if (StdDraw.isKeyPressed(KeyEvent.VK_Z)) {
//            zoomZone = true;
//        } else if (StdDraw.isKeyPressed(KeyEvent.VK_C)) {
//            zoomZone = false;
//        }

//        if (zoomZone) {
//            StdDraw.rectangle(WIDTH / 2.0, HEIGHT / 2.0, 200, 200);
//        }

        if (zoomZone && zoomCount < 10 && StdDraw.isKeyPressed(KeyEvent.VK_2)) {
            radius++;
            zoomCount++;
        }

        if (zoomZone && zoomCount > 0 && StdDraw.isKeyPressed(KeyEvent.VK_1)) {
            radius--;
            zoomCount--;
        }
    }
}
