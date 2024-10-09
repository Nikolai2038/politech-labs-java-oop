package lab_1.moving_strategies;

import java.awt.*;

/**
 * Передвижение бегом
 */
public class MovingStrategyRunning implements IMovingStrategy {
    @Override
    public void move(Point location) {
        location.setLocation(location.getX() + 10, location.getY());
    }
}
