package spaceObjects;

import enums.Direction;
import enums.Padezhy;
import heroes.AbstractHero;

public class Spaceship extends SpaceObject {
    JetEngine engine;
    AbstractHero[] passengers;

    {
        engine = new JetEngine();
    }
    public Spaceship(String type, Direction direction, int speed, int weight){
        super(type, direction, speed, weight);
    }

    @Override
    public void changeDirection(Direction newDirection) {
        setDirection(newDirection);
        System.out.println(makeCharacterName(Padezhy.I) + " поменял направление на: " + newDirection.getTitle());
    }

    @Override
    public void speedUp(int times) {
        setSpeed(getSpeed()*times);
        engine.turnOn();
        System.out.println(makeCharacterName(Padezhy.I) + " ускорился в " + times + " раз");
    }

    @Override
    public void speedDown(int times) {
        setSpeed(getSpeed()/times);
        engine.turnOf();
        System.out.println(makeCharacterName(Padezhy.I) + " замедлился в " + times + " раз");
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

    public void turn(int degrees, char side){
        if (side == 'r'){
            System.out.println(makeCharacterName(Padezhy.I) + " повернул на " + degrees + " градусов направо");
        }
        else if (side == 'l'){
            System.out.println(makeCharacterName(Padezhy.I) + " повернул на " + degrees + " градусов налево");
        }
    }

    public class JetEngine{
        int statement;

        public void turnOn(){
            this.statement = 1;
        }
        public void turnOf(){
            this.statement = 0;
        }
    }

}
