package ramgames.ramrender.testing;

import ramgames.ramrender.PrintType;
import ramgames.ramrender.listeners.MouseController;

import java.awt.event.MouseEvent;

public class MouserController implements MouseController {
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        main.screen.print(PrintType.INFO, "clicked RECT!!");
    }
}
