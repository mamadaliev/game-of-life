package mamadaliev.controller;

import edu.princeton.cs.introcs.StdDraw;
import mamadaliev.model.WindowModel;
import mamadaliev.sevice.ArenaService;
import mamadaliev.util.Constants;
import mamadaliev.view.View;

import java.awt.event.KeyEvent;

import static mamadaliev.util.Constants.Window.HEIGHT;
import static mamadaliev.util.Constants.Window.WIDTH;

public class WindowController {

    boolean[][][] cells = new boolean[2][WIDTH][HEIGHT];
    boolean isAllowZoomZone = false;
    int zoomCount = 0;
    double radiusSize = 0.5;

    private final View<WindowModel> view;
    private final ArenaService arenaService;

    public WindowController(View<WindowModel> view,
                            ArenaService arenaService) {
        this.view = view;
        this.arenaService = arenaService;
    }

    public void launch() {
        cells = arenaService.fillValues(cells, Constants.Arena.ROW, Constants.Arena.COLUMN, 0.99);
        WindowModel data = new WindowModel(
                Constants.Window.WIDTH,
                Constants.Window.HEIGHT,
                cells,
                isAllowZoomZone,
                zoomCount,
                radiusSize
        );
        view.init(data);

        do {
            data.setCells(arenaService.generateNextEpoch(cells));
            zoom(data);
            view.render(data);
            StdDraw.show();
        } while (!StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE));
    }

    private void zoom(WindowModel data) {
        if (zoomCount < 200 && StdDraw.isKeyPressed(KeyEvent.VK_1)) {
            radiusSize++;
            zoomCount++;
        }

        if (zoomCount > 10 && StdDraw.isKeyPressed(KeyEvent.VK_2)) {
            radiusSize--;
            zoomCount--;
        }
        data.setRadiusSize(radiusSize);
        data.setZoomCount(zoomCount);
    }
}
