package lab_1.moving_strategies;

import java.awt.*;

/**
 * Передвижение на машине
 */
public class MovingByCar implements IMovingStrategy {
    @Override
    public void move(Point location) {
        location.setLocation(location.getX() + 100, location.getY());
    }
}
