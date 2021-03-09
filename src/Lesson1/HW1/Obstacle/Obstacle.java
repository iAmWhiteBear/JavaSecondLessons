package Lesson1.HW1.Obstacle;

/**
 * 3. Создайте два класса: беговая дорожка и стена, при прохождении через которые,
 * участники должны выполнять соответствующие действия (бежать или прыгать),
 * результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
 */
public abstract class Obstacle {
    private final double value;

    protected Obstacle() {
        this.value = Math.random();
    }

    public double getValue() {
        return value;
    }
}
