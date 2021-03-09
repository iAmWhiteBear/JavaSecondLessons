package Lesson1.HW1.Obstacle;

import Lesson1.HW1.CanJump;

public class Wall extends Obstacle{

    public Wall() {
        super();
    }

    public boolean doWall(CanJump unit){
        return unit.jump(this.getValue());
    }
}
