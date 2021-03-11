package Lesson1.HW1.Obstacle;

import Lesson1.HW1.Champion;

public class Wall extends Obstacle {

    public Wall() {
        super();
    }

    @Override
    public boolean pass(Champion unit) {
        return unit.jump(this.getValue());
    }
}
