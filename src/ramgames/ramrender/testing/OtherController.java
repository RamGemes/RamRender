package ramgames.ramrender.testing;

import ramgames.ramrender.PrintType;
import ramgames.ramrender.listeners.KeyboardController;

import java.awt.*;
import java.awt.event.KeyEvent;

public class OtherController implements KeyboardController {

    @Override
    public void onRelease_ESCAPE(KeyEvent event) {
        System.out.println("STOPPPINGGGG");
        main.screen.stopRunning();
        main.screen.setBackground(new Color(255,255,255));
    }

    @Override
    public void onRelease_0(KeyEvent event) {
        main.screen.print(PrintType.INFO,"0");
    }
}
