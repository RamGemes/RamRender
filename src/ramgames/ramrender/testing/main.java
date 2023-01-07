package ramgames.ramrender.testing;

import ramgames.ramrender.objects.constructors.Position;
import ramgames.ramrender.PrintType;
import ramgames.ramrender.Screen;

import java.awt.*;

public class main {
    static Screen screen;
    public static void main(String[] args) {

        screen = new Screen("Window of DOOOM",
                new Dimension(600,600),
                new Color(164,230,255),
                144,
                true,
                true,
                new OtherController());
        screen.enableDebugMode();
        OtherLayer layer = new OtherLayer(screen,true);
        Object object = new Object(new Position(5,5), new Dimension(40,60));

        layer.addObject(object);
        screen.addLayer(layer);
        Thread screenThread = new Thread(screen);
        screenThread.start();
        screen.print(PrintType.ERROR,"ERRORR!!!!!");
    }

}
