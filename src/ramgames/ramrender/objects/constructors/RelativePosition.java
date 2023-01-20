package ramgames.ramrender.objects.constructors;

public class RelativePosition {
    private double x;
    private double y;
    private Align alignment = Align.TOP_LEFT;

    public RelativePosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return (int) x;
    }

    public RelativePosition setX(double x) {
        this.x = x;
        return this;
    }

    public void setAlignment(Align alignment) {
        this.alignment = alignment;
    }

    public Align Alignment() {
        return this.alignment;
    }

    public int getY() {
        return (int) y;
    }

    public RelativePosition setY(double y) {
        this.y = y;
        return this;
    }

    public int[] getPos() {
        return new int[]{(int) this.x, (int) this.y};
    }

    public RelativePosition set(double x, double y) {
        setX(x);
        setY(y);
        return this;
    }

    public RelativePosition addX(double x) {
        this.x += x;
        return this;
    }

    public RelativePosition addY(double y) {
        this.y += y;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RelativePosition object) {
            return object.getX() == this.getX() && object.getY() == this.getY();
        }
        return false;
    }

    public Position asPosition(Position position) {
        return new Position(position.getX() + this.getX(), position.getY() + this.getY());
    }

    @Override
    public String toString() {
        return String.format("RPos[%s,%s]", this.x, this.y);
    }

}
