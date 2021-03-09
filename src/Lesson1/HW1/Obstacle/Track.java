package Lesson1.HW1.Obstacle;

import Lesson1.HW1.CanRun;

public class Track extends Obstacle {

    public Track() {
        super();
    }

    public boolean doTrack(CanRun unit){
        return unit.run(this.getValue());
    }
}
