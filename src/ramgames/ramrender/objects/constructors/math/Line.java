package ramgames.ramrender.objects.constructors.math;

import ramgames.ramrender.objects.constructors.Position;

public class Line {
    private final double slope;

    private final double intercept;
    private final Position[] positions;
    private final LineType type;

    public Line(Position startPos, Position endPos) {
        if (startPos.equals(endPos)) {
            throw new ArithmeticException("StartPos can't be the same as endPos");
        }
        this.positions = new Position[]{startPos, endPos};
        if (startPos.getY() - endPos.getY() == 0) {
            this.type = LineType.HORIZONTAL;
            this.slope = 0;
            this.intercept = endPos.getY();
            return;
        }
        if (startPos.getX() - endPos.getX() == 0) {
            this.type = LineType.VERTICAL;
            this.slope = 0;
            this.intercept = endPos.getX();
            return;
        }
        this.type = LineType.LINEAR;
        this.slope = ((double) startPos.getY() - endPos.getY()) / (startPos.getX() - endPos.getX());
        this.intercept = startPos.getY() - this.slope * startPos.getX();
    }

    private int calcY(int x) {
        return (int) Math.ceil(slope * x + intercept);
    }

    private int calcX(int y) {
        return (int) Math.ceil((y - this.intercept) / this.slope);
    }

    public boolean inPixel(Position position) {
        switch (this.type) {
            case HORIZONTAL -> {
                return position.getY() == intercept;
            }
            case VERTICAL -> {
                return position.getX() == intercept;
            }
            case LINEAR -> {
                if (Math.abs(this.slope) <= 1) {
                    return new Position(calcX(position.getY()), position.getY()).equals(position);
                } else {
                    return new Position(position.getX(), calcY(position.getX())).equals(position);
                }
            }
        }
        throw new TypeNotPresentException("Line contains improper type: " + this.type.name(), new Throwable());
    }

    public Position getStartPosition() {
        return this.positions[0];
    }

    public Position getEndPosition() {
        return this.positions[1];
    }
}