package Lesson1.HW1;


import Lesson1.HW1.Obstacle.Track;
import Lesson1.HW1.Obstacle.Wall;
import Lesson1.HW1.Units.Cat;
import Lesson1.HW1.Units.Human;
import Lesson1.HW1.Units.Robot;

/**
 * 4. Создайте два массива:
 * с участниками и препятствиями,
 * и заставьте всех участников пройти этот набор препятствий.
 */

public class Execution {
    public static void main(String[] args) {

        Robot electronic = new Robot();
        Cat barsik = new Cat();
        Human alex = new Human("Alex");
        Wall wall = new Wall();
        Track track = new Track();

//        track.doTrack(barsik);
//        wall.doWall(barsik);
//
//        track.doTrack(electronic);
//        wall.doWall(electronic);
//
//        track.doTrack(alex);
//        wall.doWall(alex);

        Course coco = new Course(new Track(),new Wall(), new Wall(), new Wall(), new Track());
        Team team = new Team("Walkers",
                new Human("Superman",2),
                new Human("Charle"),
                new Human("Bettie"),
                new Human("Loosie", 0.01));
        coco.dolt(team);
        team.showResults();
        System.out.println("-----------------------------");
        team.displayMembers();






    }
}
