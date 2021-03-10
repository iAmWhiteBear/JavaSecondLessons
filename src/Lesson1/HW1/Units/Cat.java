package Lesson1.HW1.Units;

import Lesson1.HW1.Champion;

public class Cat implements Champion {
    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public boolean jump(double height) {
        System.out.println("кот "+name+" прыгнул");
        return true;
    }

    @Override
    public boolean run(double distance) {
        System.out.println("кот "+name+" пробежал");
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
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
