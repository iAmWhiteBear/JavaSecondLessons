package Lesson1.HW1.Units;

import Lesson1.HW1.CanJump;
import Lesson1.HW1.CanRun;

public class Robot implements CanJump, CanRun {

    @Override
    public boolean jump(double height) {
        System.out.println("Робот прыгнул");
        return true;
    }

    @Override
    public boolean run(double distance) {
        System.out.println("Робот пробежал");
        return true;
    }
}
