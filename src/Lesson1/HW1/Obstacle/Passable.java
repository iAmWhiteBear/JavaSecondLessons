package Lesson1.HW1.Obstacle;

import Lesson1.HW1.Champion;

//гарантия что наследниках будет публичный pass
public interface Passable {
    boolean pass(Champion unit);
}
