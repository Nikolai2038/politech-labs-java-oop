package lab_1.moving_strategies;

import java.awt.*;

/**
 * Передвижение на самолёте
 */
public class MovingStrategyFlying implements IMovingStrategy {
    @Override
    public void move(Point location) {
        location.setLocation(location.getX() + 1000, location.getY());
    }
}
