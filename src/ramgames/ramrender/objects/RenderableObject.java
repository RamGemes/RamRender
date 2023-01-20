package ramgames.ramrender.objects;

import ramgames.ramrender.listeners.MouseController;
import ramgames.ramrender.listeners.MouseEvents;
import ramgames.ramrender.objects.constructors.Collider;
import ramgames.ramrender.objects.constructors.Position;
import ramgames.ramrender.objects.constructors.RelativePosition;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.List;
import java.util.UUID;

public abstract class RenderableObject {
    public final RelativePosition[] points;
    private final UUID uuid = UUID.randomUUID();
    private final Collider collider;
    public Position position;
    public Dimension size;
    private int strokeWeight;
    private Color fillColor;
    private Color strokeColor;

    private MouseController mouseController = null;


    public RenderableObject(Position position, Dimension size, List<RelativePosition> points, Color outlineColor, int outlineThickness, Color fillColor) {
        if (fillColor == null && outlineColor == null) {
            throw new NullPointerException("'fillColor' and 'outlineColor' can not both be null");
        }
        this.position = position;
        this.size = size;
        this.points = new RelativePosition[points.size()];
        for (var i = 0; i < points.size(); i++) {
            this.points[i] = points.get(i);
        }
        this.collider = buildCollider();
        this.strokeColor = outlineColor;
        this.strokeWeight = outlineThickness;
        this.fillColor = fillColor;
    }

    public Collider buildCollider() {
        return Collider.build(this.position, this.points);
    }

    public MouseController getMouseController() {
        return this.mouseController;
    }

    public void setMouseController(MouseController controller) {
        this.mouseController = controller;
    }

    public abstract void update();

    public abstract void getVisual(Graphics2D graphics2D);

    public int getX() {
        return this.position.getX() + (int) (this.getWidth() * this.position.Alignment().x);
    }

    public int getY() {
        return this.position.getY() + (int) (this.getHeight() * this.position.Alignment().y);
    }

    public int getWidth() {
        return (int) this.size.getWidth();
    }

    public int getHeight() {
        return (int) this.size.getHeight();
    }

    public Collider getCollider() {
        return this.collider;
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getStrokeWeight() {
        return strokeWeight;
    }

    public void setStrokeWeight(int strokeWeight) {
        this.strokeWeight = strokeWeight;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public Color getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }

    public void mouseEvent(MouseEvents eventType, MouseEvent mouseEvent) {
        if (this.mouseController == null) {
            System.out.println("null controller");
            return;
        }

        switch (eventType) {
            case CLICK -> this.mouseController.mouseClicked(mouseEvent);
            case RELEASE -> this.mouseController.mouseReleased(mouseEvent);
            case MOVE -> this.mouseController.mouseMoved(mouseEvent);
            case DRAG -> this.mouseController.mouseDragged(mouseEvent);
            case ENTER -> this.mouseController.mouseEntered(mouseEvent);
            case EXIT -> this.mouseController.mouseExited(mouseEvent);
            case WHEEL -> this.mouseController.mouseWheelMoved((MouseWheelEvent) mouseEvent);
        }
    }
}
