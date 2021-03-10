package Lesson1.HW1.Obstacle;

import Lesson1.HW1.Champion;

public class Track extends Obstacle {

    public Track() {
        super();
    }

    @Override
    public boolean pass(Champion unit) {
        return unit.run(this.getValue());
    }
}
