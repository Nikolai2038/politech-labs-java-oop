package lab_1;

import lab_1.moving_strategies.IMovingStrategy;

import java.awt.*;

/**
 * Герой
 */
public class Hero {
    /**
     * Имя героя
     */
    private final String name;

    /**
     * Расположение героя
     */
    private final Point location;

    /**
     * Стратегия передвижения героя
     */
    private IMovingStrategy movingStrategy;

    /**
     * Создаёт героя
     * @param name Имя героя
     * @param movingStrategy Стратегия передвижения героя
     */
    public Hero(String name, IMovingStrategy movingStrategy) {
        this.name = name;
        this.location = new Point(0, 0);
        this.movingStrategy = movingStrategy;
    }

    @Override
    public String toString() {
        return "Hero name: " + name + ". Location: " + location.getX() + ", " + location.getY() + ". Moving strategy: " + movingStrategy.getClass().getSimpleName();
    }

    /**
     * Возвращает текущую стратегию передвижения героя
     * @return Стратегия передвижения героя
     */
    public IMovingStrategy getMovingStrategy() {
        return movingStrategy;
    }

    /**
     * Меняет стратегию передвижения героя
     * @param movingStrategy Стратегия передвижения
     */
    public void setMovingStrategy(IMovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    /**
     * Двигает героя
     */
    void move() {
        this.movingStrategy.move(this.location);
    }
}
