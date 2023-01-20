package ramgames.ramrender.objects.constructors;

import java.util.HashSet;
import java.util.Set;

public class AbsoluteCollider {
    protected final Set<Position> points;

    protected AbsoluteCollider(Position position, Collider collider) {
        points = new HashSet<>();
        for (RelativePosition pos : collider.getPoints()) {
            points.add(pos.asPosition(position));
        }
    }

    public Collider asCollider(Position position) {
        Set<RelativePosition> positions = new HashSet<>();
        for (Position position1 : this.points) {
            positions.add(position1.asRelative(position));
        }
        return new Collider(positions);
    }
}
