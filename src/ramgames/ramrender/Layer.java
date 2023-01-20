package ramgames.ramrender;

import ramgames.ramrender.listeners.MouseEvents;
import ramgames.ramrender.objects.RenderableObject;
import ramgames.ramrender.objects.constructors.BoundingBox;
import ramgames.ramrender.objects.constructors.Position;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

public class Layer {
    final UUID uuid = UUID.randomUUID();
    LinkedHashMap<UUID, RenderableObject> objects = new LinkedHashMap<>();
    Position position;
    Dimension size;
    boolean visible;
    Screen screen;

    public Layer(Screen screen, Position position, boolean visible) {
        this.position = position;
        this.visible = visible;
        this.screen = screen;
        this.size = screen.getSize();
    }

    public Layer(Screen screen, Position position, Dimension size, boolean visible) {
        this.position = position;
        this.visible = visible;
        this.screen = screen;
        this.size = size;
    }

    public Layer(Screen screen, boolean visible) {
        this.position = new Position(0, 0);
        this.visible = visible;
        this.screen = screen;
        this.size = screen.getSize();
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Screen getScreen() {
        return this.screen;
    }

    public boolean getVisibility() {
        return this.visible;
    }

    public void addObject(RenderableObject object, int insertBelowMany) {
        LinkedHashMap<UUID, RenderableObject> temp = new LinkedHashMap<>();
        if (objects.size() <= insertBelowMany) {
            temp.put(object.getUuid(), object);
            temp.putAll(objects);
            getScreen().print(PrintType.INFO, objects.toString());
            objects = temp;
            getScreen().print(PrintType.INFO, objects);
            getScreen().print(PrintType.INFO, "append object");
            return;
        }
        AtomicReference<RenderableObject> object1 = new AtomicReference<>(null);
        while (objects.size() > insertBelowMany) {
            object1.set((RenderableObject) objects.entrySet().toArray()[objects.size() - 1]);
            temp.put(object1.get().getUuid(), object1.get());
            objects.remove(object1.get().getUuid());
        }
        temp.put(object1.get().getUuid(), object1.get());
        temp.putAll(objects);
        objects = temp;
    }

    public void addObject(RenderableObject object) {
        objects.put(object.getUuid(), object);
    }

    public List<RenderableObject> getObjects() {
        return new ArrayList<>(this.objects.values());
    }

    public RenderableObject getObject(UUID uuid) {
        return objects.get(uuid);
    }

    public void update() {
        for (RenderableObject object : objects.values()) {
            object.update();
        }
    }

    public void captureMouseEvent(MouseEvents eventType, MouseEvent mouseEvent, Position location) {
        if (!new BoundingBox(this.position, new Position(this.position.getX() + this.size.getWidth(), this.position.getY() + this.size.getHeight())).inBounds(position)) {
            return;
        }
        location.set(location.getX() + position.getX(), location.getY() + position.getY());
        for (RenderableObject object : objects.values()) {
            if (new BoundingBox(object.position, new Position(object.position.getX() + object.getWidth(), object.position.getY() + object.getHeight())).inBounds(location)) {
                object.mouseEvent(eventType, mouseEvent);
            }
        }
    }

    public void render(Graphics graphics) {
        BufferedImage image = new BufferedImage((int) this.size.getWidth(), (int) this.size.getHeight(), 2);
        Graphics2D graphics2D = image.createGraphics();
        objects.values().forEach(object -> object.getVisual(graphics2D));
        graphics2D.dispose();
        graphics.drawImage(image, this.position.getX(), this.position.getY(), null);
    }


    public int getX() {
        return this.position.getX();
    }

    public int getY() {
        return this.position.getY();
    }
}
