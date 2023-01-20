package ramgames.ramrender.objects.constructors;

import java.awt.*;

public class BoundingBox {
    private final Position[] positions;

    public BoundingBox(Position topLeft, Position bottomRight) {
        this.positions = new Position[]{topLeft, bottomRight};
    }

    public BoundingBox(Position... positions) {
        Position topLeft = new Position(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Position bottomRight = new Position(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (Position position : positions) {
            if (position.getX() > topLeft.getX()) {
                topLeft.setX(position.getX());
            }
            if (position.getX() < bottomRight.getX()) {
                bottomRight.setX(position.getX());
            }

            if (position.getY() > topLeft.getY()) {
                topLeft.setY(position.getY());
            }
            if (position.getY() < bottomRight.getY()) {
                bottomRight.setY(position.getY());
            }
        }
        this.positions = new Position[]{bottomRight, topLeft};
    }

    public static BoundingBox fromDimension(Position position, Dimension dimension) {
        return new BoundingBox(position, new Position(position.getX() + dimension.getWidth(), position.getY() + dimension.getHeight()));
    }

    public Position getTopLeft() {
        return this.positions[0];
    }

    public Position getBottomRight() {
        return this.positions[1];
    }

    public boolean inBounds(Position position) {
        return position.getX() >= getTopLeft().getX() &&
                position.getX() <= getBottomRight().getX() &&
                position.getY() >= getTopLeft().getY() &&
                position.getY() <= getBottomRight().getY();
    }

    @Override
    public String toString() {
        return String.format("BoundingBox[%s,%s]", this.getTopLeft(), this.getBottomRight());
    }

    public Dimension asDimension() {
        return new Dimension(this.getBottomRight().getX() - this.getTopLeft().getX(), this.getBottomRight().getY() - this.getTopLeft().getY());
    }
}
