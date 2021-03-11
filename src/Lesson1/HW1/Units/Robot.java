package Lesson1.HW1.Units;

import Lesson1.HW1.Champion;

public class Robot implements Champion {

    private final String name;

    public Robot(String name) {
        this.name = name;
    }

    @Override
    public boolean jump(double height) {
        System.out.println("Робот "+name+" прыгнул");
        return true;
    }

    @Override
    public boolean run(double distance) {
        System.out.println("Робот "+name+" пробежал");
        return true;
    }

    @Override
    public boolean isPass() {
        return true;
    }

    @Override
    public void setPass(boolean result) {

    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                '}';
    }
}
