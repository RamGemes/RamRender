package ramgames.ramrender.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public interface MouseController extends MouseListener {
    @Override
    default void mouseClicked(MouseEvent var1) {
    }

    @Override
    default void mousePressed(MouseEvent var1) {

    }

    @Override
    default void mouseReleased(MouseEvent var1) {

    }

    @Override
    default void mouseEntered(MouseEvent var1) {

    }

    @Override
    default void mouseExited(MouseEvent mouseEvent) {

    }
}
