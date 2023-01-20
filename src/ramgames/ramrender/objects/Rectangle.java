package ramgames.ramrender.objects;

import ramgames.ramrender.objects.constructors.Position;
import ramgames.ramrender.objects.constructors.RelativePosition;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Rectangle extends RenderableObject {
    private int cornerStroke;

    public Rectangle(Position position, Dimension size, Color outlineColor, int outlineThickness, Color fillColor, int cornerCutStroke) {
        super(position, size, new ArrayList<>(List.of(new RelativePosition[]{
                new RelativePosition(0, 0),
                new Position(size.getWidth() + position.getX(), position.getY()).asRelative(position),
                new Position(size.getWidth() + position.getX(), size.getHeight() + position.getY()).asRelative(position),
                new Position(position.getX(), size.getHeight() + position.getY()).asRelative(position)
        })), outlineColor, outlineThickness, fillColor);
        this.cornerStroke = cornerCutStroke;
    }

    public Rectangle(Position position, Dimension size, Color outlineColor, int outlineThickness, Color fillColor) {
        super(position, size, new ArrayList<>(List.of(new RelativePosition[]{
                new RelativePosition(0, 0),
                new Position(size.getWidth() + position.getX(), position.getY()).asRelative(position),
                new Position(size.getWidth() + position.getX(), size.getHeight() + position.getY()).asRelative(position),
                new Position(position.getX(), size.getHeight() + position.getY()).asRelative(position)
        })), outlineColor, outlineThickness, fillColor);
        this.cornerStroke = 0;
    }

    public Rectangle(Position position, Dimension size, Color fillColor) {
        super(position, size, new ArrayList<>(List.of(new RelativePosition[]{
                new RelativePosition(0, 0),
                new Position(size.getWidth() + position.getX(), position.getY()).asRelative(position),
                new Position(size.getWidth() + position.getX(), size.getHeight() + position.getY()).asRelative(position),
                new Position(position.getX(), size.getHeight() + position.getY()).asRelative(position)
        })), null, 0, fillColor);
        this.cornerStroke = 0;
    }

    public Rectangle(Position position, Dimension size, Color fillColor, int cornerCutStroke) {
        super(position, size, new ArrayList<>(List.of(new RelativePosition[]{
                new RelativePosition(0, 0),
                new Position(size.getWidth() + position.getX(), position.getY()).asRelative(position),
                new Position(size.getWidth() + position.getX(), size.getHeight() + position.getY()).asRelative(position),
                new Position(position.getX(), size.getHeight() + position.getY()).asRelative(position)
        })), null, 0, fillColor);
        this.cornerStroke = cornerCutStroke;
    }

    public int getCornerStroke() {
        return this.cornerStroke;
    }

    public void setCornerStroke(int strokeWeight) {
        this.cornerStroke = strokeWeight;
    }

    @Override
    public void update() {

    }

    @Override
    public void getVisual(Graphics2D graphics2D) {
        if (this.getStrokeColor() != null) {
            graphics2D.setColor(this.getStrokeColor());
            graphics2D.fillRoundRect(this.getX() - getStrokeWeight(), this.getY() - getStrokeWeight(), this.getWidth() + getStrokeWeight() * 2, this.getHeight() + getStrokeWeight() * 2, this.cornerStroke, this.cornerStroke);

        }

        if (this.getFillColor() != null) {
            graphics2D.setColor(this.getFillColor());
            graphics2D.fillRoundRect(this.getX(), this.getY(), this.getWidth(), this.getHeight(), this.cornerStroke, this.cornerStroke);
        }

    }

}
