package Lesson1.HW1.Units;

import Lesson1.HW1.CanJump;
import Lesson1.HW1.CanRun;

public class Cat implements CanJump, CanRun {
    @Override
    public boolean jump(double height) {
        System.out.println("кот прыгнул");
        return true;
    }

    @Override
    public boolean run(double distance) {
        System.out.println("кот пробежал");
        return true;
    }
}
