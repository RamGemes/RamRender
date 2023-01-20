package ramgames.ramrender.listeners;

import java.awt.event.*;

public interface MouseController extends MouseListener, MouseMotionListener, MouseWheelListener {

    @Override
    default void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    default void mousePressed(MouseEvent mouseEvent) {
        // USELESS. SAME AS CLICKED.
    }

    @Override
    default void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    default void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    default void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    default void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    default void mouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    default void mouseWheelMoved(MouseWheelEvent mouseEvent) {

    }
}
