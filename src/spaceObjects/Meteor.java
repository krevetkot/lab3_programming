package spaceObjects;

import enums.Direction;
import enums.Padezhy;

public class Meteor extends SpaceObject{
    public Meteor(String type, Direction direction, int speed, int weight){
        super(type, direction, speed, weight);
    }

    @Override
    public void changeDirection(Direction newDirection) {
        setDirection(newDirection);
        System.out.println("метеор поменял направление на: " + newDirection.getTitle());
    }

    @Override
    public void speedUp(int times) {
        setSpeed(getSpeed()*times);
        System.out.println("метеор ускорился в " + times + " раз");
    }

    @Override
    public void speedDown(int times) {
        setSpeed(getSpeed()/times);
        System.out.println("метеор замедлился в " + times + " раз");
    }

//    @Override
//    public String makeCharacterName(Padezhy p) {
//        String character = "";
//        if (p==Padezhy.I){
//            character = this.getType();
//        }
//        else if (p==Padezhy.R){
//            character = "метеора";
//        }
//        else if (p==Padezhy.T){
//            character = "метеором";
//        }
//        return character;
//    }
}
