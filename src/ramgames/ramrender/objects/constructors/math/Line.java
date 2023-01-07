package ramgames.ramrender.objects.constructors.math;

import ramgames.ramrender.objects.constructors.Position;

public class Line {
    private final double slope;

    private final double intercept;
    private final Position[] positions;

    public Line(Position startPos, Position endPos) {
        this.positions = new Position[]{startPos,endPos};
        this.slope = ((double)startPos.getY()-endPos.getY())/(startPos.getX()-endPos.getX());
        this.intercept = startPos.getY() - this.slope*startPos.getX();
    }
    public double getPixelAtX(int x) {
        return Math.round(slope*x+intercept);
    }
    public Position getStartPosition() {
        return this.positions[0];
    }
    public Position getEndPosition() {
        return this.positions[1];
    }
}
