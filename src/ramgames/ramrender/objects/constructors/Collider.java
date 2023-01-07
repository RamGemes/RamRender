package ramgames.ramrender.objects.constructors;

import ramgames.ramrender.objects.RenderableObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Collider {

    private final Set<RelativePosition> points;

    private Collider(Set<RelativePosition> relativePositions) {
        this.points = relativePositions;
    }
    public boolean collides(Position position, RenderableObject object) {
        Collider collider = object.collider;
        List<RelativePosition> combined_list = new ArrayList<>(collider.points);
        combined_list.addAll(this.points);
        Set<RelativePosition> combined_set = collider.points;
        combined_set.addAll(this.points);
        return combined_list.size() != combined_set.size();
    }

    public static Collider build(Dimension size, Position... positions) {
        // TEMP TO PASS BUILD
        return null;
    }


}
