package Lesson1.HW1;

import Lesson1.HW1.Units.Human;

/**
 * 6. * Добавить класс Team, который будет содержать:
 * название команды, массив из 4-х участников (т.е. в конструкторе можно сразу всех участников указывать),
 * метод для вывода информации о членах команды прошедших дистанцию,
 * метод вывода информации обо всех членах команды.
 */
public class Team {

    private String name;
    private final Human[] members = new Human[4];


    public Team(String name, Human ... members) {
        this.name = name;
        System.arraycopy(members, 0, this.members, 0, members.length);
    }

    public void showResults() {
        for (Human h: members){
            if (h.isPass()) System.out.println(h);
        }
    }

    public void displayMembers() {
        for (Human m: members)System.out.println(m);
    }

    public Human[] getMembers(){
        return members;
    }
}