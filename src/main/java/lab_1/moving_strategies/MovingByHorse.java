package lab_1.moving_strategies;

import java.awt.*;

/**
 * Передвижение на лошади
 */
public class MovingByHorse implements IMovingStrategy {
    @Override
    public void move(Point location) {
        location.setLocation(location.getX() + 30, location.getY());
    }
}
