package ramgames.ramrender.objects;

import ramgames.ramrender.objects.constructors.Collider;
import ramgames.ramrender.objects.constructors.Position;

import java.awt.*;

public abstract class RenderableObject {
    public Position position;
    public Dimension size;

    public Collider collider;
    public RenderableObject(Position position, Dimension size) {
        this.position = position;
        this.size = size;
        // TEMP TO PASS BUILD
        this.collider = Collider.build(new Dimension(),new Position(0,0));
    }
    public abstract void update();
    public abstract Image getSprite();

    public int getX() {
        return this.position.getX()+ (int) (this.getWidth()*this.position.Alignment().x);
    }
    public int getY() {
        return this.position.getY()+ (int) (this.getHeight()*this.position.Alignment().y);
    }
    public int getWidth() {
        return (int) this.size.getWidth();
    }
    public int getHeight() {
        return (int) this.size.getHeight();
    }

}
