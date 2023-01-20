package ramgames.ramrender;

import ramgames.ramrender.listeners.MouseEvents;
import ramgames.ramrender.objects.constructors.Position;

import java.awt.*;
import java.awt.event.MouseEvent;

public class ClickableLayer extends Layer {
    public ClickableLayer(Screen screen, Position position, boolean visible) {
        super(screen, position, visible);
    }

    public ClickableLayer(Screen screen, Position position, Dimension size, boolean visible) {
        super(screen, position, size, visible);
    }

    public ClickableLayer(Screen screen, boolean visible) {
        super(screen, visible);
    }

    @Override
    public void captureMouseEvent(MouseEvents eventType, MouseEvent mouseEvent, Position location) {
        super.captureMouseEvent(eventType, mouseEvent, location);
    }
}
