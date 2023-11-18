package interfaces;

import enums.Direction;

public interface Flyable {
    public void changeDirection(Direction newDirection);
    public void speedUp(int times);
}
