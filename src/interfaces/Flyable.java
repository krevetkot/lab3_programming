package interfaces;

import enums.Direction;

public interface Flyable {
    void changeDirection(Direction newDirection);
    void speedUp(int times);
}
