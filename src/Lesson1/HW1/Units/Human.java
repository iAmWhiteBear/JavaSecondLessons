package Lesson1.HW1.Units;

import Lesson1.HW1.CanJump;
import Lesson1.HW1.CanRun;

public class Human implements CanJump, CanRun {
    private String name;
    private double stamina;
    private boolean pass = false;

    public Human(String name) {
        this.name = name;
        stamina = Math.random();
    }

    public Human(String name, double stamina) {
        this.name = name;
        this.stamina = stamina;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean jump(double height) {
        if (height<stamina) {
            System.out.println(name+" Прыгнул");
            return true;
        }
        System.out.println(name+" не прыгнул");
        return false;
    }

    @Override
    public boolean run(double distance) {
        if (distance<stamina) {
            System.out.println(name+" пробежал");
            return true;
        }
        System.out.println(name+" не пробежал");
        return false;
    }



    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public boolean isPass() {
        return pass;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", stamina=" + stamina +
                '}';
    }
}
