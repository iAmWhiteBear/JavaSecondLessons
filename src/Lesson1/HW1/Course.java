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

    public Course(Obstacle ... obstacles) {
        this.obstacles = obstacles;
    }

    public void dolt(Team team){
        Human[] members = team.getMembers();
        boolean result;
        for (Human champion : members) {
            result = true;
            for (Obstacle obstacle : obstacles) {
                if (obstacle.getClass().getSimpleName().equals("Track")) {
                    Track t = (Track) obstacle;
                    result = t.doTrack(champion);
                } else {
                    Wall w = (Wall) obstacle;
                    result = w.doWall(champion);
                }
                if (!result) break;
            }
            champion.setPass(result);
        }
    }

}
