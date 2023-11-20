package objects;

import enums.Direction;
import enums.Padezhy;
import interfaces.Flyable;
import interfaces.Storytellable;

public class Spaceship extends SpaceObject implements Flyable, Storytellable {
    public Direction direction = null;
    public int speed;

    public Spaceship(String type, Direction direction, int speed){
        super(type, direction, speed);
    }

    @Override
    public void changeDirection(Direction newDirection) {
        setDirection(newDirection);
        System.out.println(makeCharacterName(Padezhy.I) + " поменял направление на: " + newDirection);
    }

    @Override
    public void speedUp(int times) {
        setSpeed(getSpeed()*times);
        System.out.println(makeCharacterName(Padezhy.I) + " ускорился в " + times + " раз");
    }

    @Override
    public String makeCharacterName(Padezhy p) {
        String character = "";
        if (p==Padezhy.I){
            character = this.getType();
        }
        else if (p==Padezhy.R){
            character = "космического корабля";
        }
        else if (p==Padezhy.T){
            character = "космическим кораблем";
        }
        return character;
    }

    public boolean isReadyToEscapeFromGravitation(Direction location){
        String place = (String)(location.name());
        int gravity = place.length()*100;
        if (getSpeed()>gravity){
            return true;
        }
        else {
            return false;
        }
    }
}
