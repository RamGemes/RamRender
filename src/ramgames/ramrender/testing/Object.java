package ramgames.ramrender.testing;

import java.awt.*;
import java.awt.image.BufferedImage;

import ramgames.ramrender.objects.constructors.Position;
import ramgames.ramrender.objects.RenderableObject;
public class Object extends RenderableObject{
    public Object(Position position, Dimension size) {
        super(position, size);
    }

    @Override
    public void update() {

    }

    @Override
    public Image getSprite() {
        BufferedImage image = new BufferedImage(this.getWidth(),this.getHeight(),BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.BLUE);
        graphics.fillRect(0,0,this.getWidth(),this.getHeight());
        graphics.dispose();
        return image;
    }
}
