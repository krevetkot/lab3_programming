package spaceObjects;

import enums.Direction;
import enums.State;
import exceptions.NotEnoughPlaceInSpaceshipException;
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
        System.out.println(type + " создан");
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
        System.out.println(this.getType() + " ускорился в " + times + " раз");
    }

    @Override
    public void speedDown(int times) {
        setSpeed(getSpeed()/times);
        engine.turnOf();
        System.out.println(this.getType() + " замедлился в " + times + " раз");
    }

    public void start(){
        System.out.println(this.getType() + " пошел на взлет");
        this.state = State.FLY;
        this.speed += 10;
        while (this.speed<=1000){
            this.speedUp(10);
        }
    }

    public void land(Direction where){
        while (this.speed>1){
            this.speedDown(10);
        }
        this.speed --;
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



    public void addPassenger(AbstractHero passenger) throws NotEnoughPlaceInSpaceshipException {
        if (this.passengers[capacityOfPassengers-1]!=null){
            throw new NotEnoughPlaceInSpaceshipException("В ракете не достаточно места! Не поместившийся персонаж: ", passenger);
        }
        else {
            int i = 0;
            while (this.passengers[i]!=null){
                i++;
            }
            this.passengers[i] = passenger;
        }
    }

    public AbstractHero[] getPassengers(){
        return this.passengers;
    }

    //вложенный класс
    public class JetEngine{
        int statement;

        public void turnOn(){
            this.statement = 1;

            if (Math.random()<0.5){
                //огонь - локальный класс
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
