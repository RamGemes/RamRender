package ramgames.ramrender.objects.constructors;

public class Position {
    private double x;
    private double y;
    private Align alignment = Align.TOP_LEFT;
    private boolean userLocked;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
        this.userLocked = false;
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

    public boolean setX(double x) {
        if (this.userLocked) {
            return false;
        }
        this.x = x;
        return true;
    }

    public boolean setY(double y) {
        if (this.userLocked) {
            return false;
        }
        this.y = y;
        return true;
    }

    public boolean getLocked() {
        return this.userLocked;
    }

    public boolean set(double x, double y) {
        if (this.userLocked) {
            return false;
        }
        setX(x);
        setY(y);
        return true;
    }

    public void setLock(boolean value) {
        this.userLocked = value;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Position object) {
            if(object.getX() == this.getX() && object.getY() == this.getY()) {
                return true;
            }
        }
        return false;
    }
}
