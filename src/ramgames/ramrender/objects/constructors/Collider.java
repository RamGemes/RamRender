package ramgames.ramrender.objects.constructors;

import ramgames.ramrender.objects.constructors.math.Line;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class Collider {
    public static Collider EMPTY = new Collider();

    private final Set<RelativePosition> points;

    protected Collider(Set<RelativePosition> relativePositions) {
        this.points = relativePositions;
    }

    private Collider() {
        this.points = new HashSet<>();
    }

    public static Collider build(Position mainPos, RelativePosition... relPositions) {
        System.out.println(Arrays.toString(relPositions));
        Position[] positions = new Position[relPositions.length];
        for (var i = 0; i < relPositions.length; i++) {
            positions[i] = relPositions[i].asPosition(mainPos);
        }
        System.out.println(Arrays.toString(positions));
        if (positions.length <= 2) {
            throw new ArrayIndexOutOfBoundsException("Expected 3 or more positions, found " + positions.length);
        }
        Set<Line> lineSet = new HashSet<>();
        Set<Position> linePositions = new HashSet<>();
        BoundingBox boundingBox = new BoundingBox(positions);
        System.out.println(boundingBox);
        for (var i = 1; i < positions.length; i++) {
            lineSet.add(new Line(positions[i - 1], positions[i]));
        }
        lineSet.add(new Line(positions[positions.length - 1], positions[0]));
        for (var x = boundingBox.getTopLeft().getX(); x <= boundingBox.getBottomRight().getX(); x++) {
            for (var y = boundingBox.getTopLeft().getY(); y <= boundingBox.getBottomRight().getY(); y++) {
                for (Line line : lineSet) {
                    if (line.inPixel(new Position(x, y))) {
                        linePositions.add(new Position(x, y));
                    }
                }
            }
        }

        Set<RelativePosition> colliderPoints = new HashSet<>();

        for (var x = boundingBox.getTopLeft().getX(); x <= boundingBox.getBottomRight().getX(); x++) {
            boolean canPlace = false;
            boolean inBlack = false;
            for (var y = boundingBox.getTopLeft().getY(); y <= boundingBox.getBottomRight().getY(); y++) {
                if (containsPos(linePositions, new Position(x, y))) {
                    if (!inBlack) {
                        canPlace = !canPlace;
                    }
                    inBlack = true;
                } else {
                    inBlack = false;
                }
                if (canPlace) {
                    colliderPoints.add(new Position(x, y).asRelative(mainPos));
                } else {
                }
            }
        }
        return new Collider(colliderPoints);
    }

    private static boolean containsPos(Set<Position> set, Position pos) {
        AtomicBoolean flag = new AtomicBoolean(false);
        set.forEach(poser -> {
            if (poser.equals(pos)) {
                flag.set(true);
            }
        });
        return flag.get();
    }

    public static Collider fromBoundingBox(BoundingBox box) {
        Set<RelativePosition> colliderPoints = new HashSet<>();
        for (var x = box.getTopLeft().getX(); x <= box.getBottomRight().getX(); x++) {
            for (var y = box.getTopLeft().getY(); y <= box.getBottomRight().getY(); y++) {
                colliderPoints.add(new RelativePosition(x, y));
            }
        }
        return new Collider(colliderPoints);
    }

    public AbsoluteCollider ToAbsolute(Position position) {
        return new AbsoluteCollider(position, this);
    }

    protected Set<RelativePosition> getPoints() {
        return this.points;
    }

    public void printPoints() {
        System.out.println(this.points);
    }


}
