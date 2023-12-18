package spaceObjects;

import enums.Direction;
import enums.Padezhy;
import enums.State;
import heroes.AbstractHero;

public class Spaceship extends SpaceObject {

    private JetEngine engine;
    private int capacityOfPassengers;
    private AbstractHero[] passengers = new AbstractHero[30];
    private State state;

    {
        engine = new JetEngine();
        state = State.STAY;
    }
    public Spaceship(String type, Direction direction, int weight, int capacityOfPassengers){
        super(type, direction, 0, weight);
        this.capacityOfPassengers = capacityOfPassengers;
    }

    @Override
    public void changeDirection(Direction newDirection) {
        setDirection(newDirection);
        System.out.println(this.getType() + " поменял направление на: " + newDirection.getTitle());
    }

    @Override
    public void speedUp(int times) {
        setSpeed(getSpeed()*times);
        engine.turnOn();
        //фаер появляется

        System.out.println(this.getType() + " ускорился в " + times + " раз");
    }

    @Override
    public void speedDown(int times) {
        setSpeed(getSpeed()/times);
        engine.turnOf();
        System.out.println(this.getType() + " замедлился в " + times + " раз");
    }

//    @Override
//    public String makeCharacterName(Padezhy p) {
//        String character = "";
//        if (p==Padezhy.I){
//            character = this.getType();
//        }
//        else if (p==Padezhy.R){
//            character = "космического корабля";
//        }
//        else if (p==Padezhy.T){
//            character = "космическим кораблем";
//        }
//        return character;
//    }

    public void start(){
        this.state = State.FLY;
        this.speed += 10;
        while (this.speed<=1000){
            this.speedUp(10);
        }
    }

    public void land(Direction where){
        while (this.speed>0){
            this.speed--;
        }
        this.setDirection(direction);
        System.out.println(this.getType() +  " приземлился на " + where.getTitle());
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

    public void turn(int degrees, char side, boolean print){
        if (print) {
            if (side == 'r') {
                System.out.println(this.getType() + " повернул на " + degrees + " градусов направо");
            } else if (side == 'l') {
                System.out.println(this.getType() + " повернул на " + degrees + " градусов налево");
            }
        }
    }

    public void flyAround(Direction direction){
        this.turn(90, 'r', false);
        for (int i=0; i<27; i++){
            this.turn(10, 'l', false);
        }
        System.out.println(this.getType() +  " облетел " + direction.getTitle());
    }



    public void addPassenger(AbstractHero passenger){
        //сделать исключение если нет мест в ракете т е если последняя ячейка уже занята
        int i = 0;
        while (this.passengers[i]!=null){
            i++;
        }
        this.passengers[i] = passenger;
    }

    public class JetEngine{
        int statement;

        public void turnOn(){
            this.statement = 1;

            if (Math.random()<0.5){
                class Fire{
                    private float temperature;
                    {
                        temperature = 2564.7F;
                    }
                    public void appear(){
                        System.out.println("из турбины вырвался огонь!");
                    }
                }

                Fire fire = new Fire();
                fire.appear();
            }

        }
        public void turnOf(){
            this.statement = 0;
        }
    }

}
