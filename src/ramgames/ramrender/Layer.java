package ramgames.ramrender;

import ramgames.ramrender.objects.RenderableObject;
import ramgames.ramrender.objects.constructors.Position;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Layer {
    List<RenderableObject> Objects = new ArrayList<>();
    Position position;
    boolean visible;
    Screen screen;

    public Layer(Screen screen, Position position, boolean visible) {
        this.position = position;
        this.visible = visible;
        this.screen = screen;
    }
    public Layer(Screen screen, boolean visible) {
        this.position = new Position(0,0);
        this.visible = visible;
        this.screen = screen;
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
        List<RenderableObject> temp = new ArrayList<>();
        if(Objects.size() <= insertBelowMany) {
            temp.add(object);
            temp.addAll(Objects);
            getScreen().print(PrintType.INFO, Arrays.toString(Objects.toArray()));
            Objects = temp;
            getScreen().print(PrintType.INFO, Arrays.toString(Objects.toArray()));
            getScreen().print(PrintType.INFO,"append object");
            return;
        }
        while(Objects.size() > insertBelowMany) {
            temp.add(Objects.get(Objects.size()-1));
            Objects.remove(Objects.get(Objects.size()-1));
        }
        temp.add(object);
        temp.addAll(Objects);
        Objects = temp;
    }
    public void addObject(RenderableObject object) {
        Objects.add(object);
    }
    public List<RenderableObject> getObjects() {
        return Objects;
    }
    public RenderableObject getObject(int index) {
        return Objects.get(index);
    }
    public int getIndex(RenderableObject object) {
        for(var i = 0; i < Objects.size(); i++) {
            if(object.equals(Objects.get(i))) {
                return i;
            }
        }
        return -1;
    }
    public void update() {
        for(RenderableObject object: Objects) {
            object.update();
        }
    }
    public void render(Dimension screenSize, Graphics graphics) {
        //Objects.forEach(object -> object.render(graphics));
        Objects.forEach(object -> graphics.drawImage(object.getSprite(),object.getX(),object.getY(),null));
    }
    public int getX() {
        return this.position.getX();
    }
    public int getY() {
        return this.position.getY();
    }
}
