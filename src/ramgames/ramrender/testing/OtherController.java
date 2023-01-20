package ramgames.ramrender.testing;

import ramgames.ramrender.listeners.KeyboardController;

import java.awt.event.KeyEvent;

public class OtherController implements KeyboardController {


    @Override
    public void onRelease_ESCAPE(KeyEvent event) {
        main.screen.halt();
    }
}
