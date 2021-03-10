package Lesson1.HW1.Obstacle;

public abstract class Obstacle implements Passable{
    private final double value;

    public Obstacle() {
        this.value = Math.random();
    }

    public double getValue() {
        return value;
    }


}
