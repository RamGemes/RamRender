package ramgames.ramrender.objects;

import ramgames.ramrender.objects.constructors.Position;

import java.awt.*;

public class Rectangle extends RenderableObject {
    public Rectangle(Position position, Dimension size) {
        super(position, size);
    }
    public Rectangle(Position position, Position top_left, Position top_right, Position bottom_left) {
        super(position, new Dimension(top_left.getX()-top_right.getX(),bottom_left.getY()-top_right.getY()));

    }

    @Override
    public void update() {

    }

    @Override
    public Image getSprite() {
        return null;
    }


}
