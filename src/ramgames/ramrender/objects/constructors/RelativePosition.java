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

    public void setAlignment(Align alignment) {
        this.alignment = alignment;
    }

    public Align Alignment() {
        return this.alignment;
    }

    public int getY() {
        return (int) y;
    }

    public int[] getPos() {
        return new int[]{(int) this.x, (int) this.y};
    }


    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void set(double x, double y) {
        setX(x);
        setY(y);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof RelativePosition object) {
            if(object.getX() == this.getX() && object.getY() == this.getY()) {
                return true;
            }
        }
        return false;
    }
}
