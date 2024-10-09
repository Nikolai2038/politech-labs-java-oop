package lab_1.moving_strategies;

import java.awt.*;

/**
 * Передвижение пешком
 */
public class MovingStrategyWalking implements IMovingStrategy {
    @Override
    public void move(Point location) {
        location.setLocation(location.getX() + 5, location.getY());
    }
}
