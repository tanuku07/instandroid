package kg.android.instagram.model;

import com.google.gson.annotations.Expose;

public class Position {

    @Expose
    private double y;
    @Expose
    private double x;

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

}
