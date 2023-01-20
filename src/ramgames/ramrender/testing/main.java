package ramgames.ramrender.testing;

import ramgames.ramrender.Layer;
import ramgames.ramrender.Screen;
import ramgames.ramrender.objects.Rectangle;
import ramgames.ramrender.objects.constructors.Position;

import java.awt.*;

public class main {
    static Screen screen;

    public static void main(String[] args) {

        screen = new Screen("Window of DOOOM",
                new Dimension(600, 600),
                new Color(164, 230, 255),
                144,
                true,
                true,
                new OtherController());
        screen.enableDebugMode();
        Layer layer = new Layer(screen, true);
        Rectangle rect = new Rectangle(new Position(25, 25), new Dimension(100, 100), new Color(26, 87, 255), 5, new Color(53, 143, 252), 40);
        rect.setMouseController(new MouserController());
        layer.addObject(rect);
        screen.addLayer(layer);
        Thread screenThread = new Thread(screen);
        screenThread.start();
    }

}
