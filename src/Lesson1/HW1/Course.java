package Lesson1.HW1;


import Lesson1.HW1.Obstacle.Obstacle;
import Lesson1.HW1.Obstacle.Track;
import Lesson1.HW1.Obstacle.Wall;
import Lesson1.HW1.Units.Human;

/**
 * 7. * Добавить класс Course (полоса препятствий), в котором будут находиться:
 * массив препятствий,
 * метод который будет просить команду пройти всю полосу;
 */
public class Course {
    private final Obstacle[] obstacles;

    public Course(Obstacle... obstacles) {
        this.obstacles = obstacles;
    }

    public void dolt(Team team){
        Champion[] members = team.getMembers();
        boolean result;
        for (Champion champion : members) {
            result = true;
            for (Obstacle obstacle : obstacles) {
                result = obstacle.pass(champion);
                if (!result) break;
            }
            champion.setPass(result);
        }
    }

}
