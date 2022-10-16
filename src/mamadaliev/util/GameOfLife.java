package mamadaliev.util;

import mamadaliev.controller.WindowController;
import mamadaliev.sevice.impl.ArenaServiceImpl;
import mamadaliev.view.WindowView;

public class GameOfLife {

    public static void launch() {
        WindowController controller = new WindowController(
                new WindowView(),
                new ArenaServiceImpl()
        );
        controller.launch();
    }
}
