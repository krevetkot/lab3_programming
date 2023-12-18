package spaceObjects;

import enums.Direction;
import interfaces.Flyable;
import exceptions.*;

public abstract class SpaceObject implements Flyable{
    protected Direction direction;
    protected int speed;
    protected String type;
    protected int weight;
    protected Graviton[] gravitons;
    private final int COUNT_OF_GRAVITONS = 10;

    public SpaceObject(String type, Direction direction, int speed, int weight){
        this.type = type;
        this.direction = direction;
        this.speed = speed;
        this.weight = weight;

        this.gravitons = new Graviton[COUNT_OF_GRAVITONS];
        for (int i=0; i<COUNT_OF_GRAVITONS; i++){
            this.gravitons[i] = new Graviton();
        }

    }

    protected void setDirection(Direction direction) {
        this.direction = direction;
        for (int i=0; i<COUNT_OF_GRAVITONS; i++){
            gravitons[i].updateInf();
        }
    }

    public void setSpeed(int speed) {
        //вот сюда можно добавить ошибку: скорость/масса отрицательные
        if (speed<0){
            throw new NegativeSpeedException("Ошибка: нельзя установить отрицательную скорость. Значение: ", speed);
        }
        this.speed = speed;
        for (int i=0; i<COUNT_OF_GRAVITONS; i++){
            gravitons[i].updateInf();
        }
    }

    public Direction getDirection() {
        return this.direction;
    }

    public int getSpeed() {
        return this.speed;
    }

    public String getType() {
        return this.type;
    }

    public Graviton[] getGravitons(){
        return this.gravitons;
    }




    public class Graviton{

        private int [] inf;

        public Graviton(){
            int[] information = new int[2]; //speed and weight
            this.inf = information;
            this.updateInf();
        }
        public void updateInf(){
            this.inf[0] = SpaceObject.this.speed;
            this.inf[1] = SpaceObject.this.weight;
            //use after changing with speed or weight in space object
        }

        public int[] getInf(){
            return this.inf;
        }
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SpaceObject that = (SpaceObject) obj;
        return (getDirection() == that.getDirection() && getSpeed() == that.getSpeed() && getType() == that.getType());
    }

    @Override
    public String toString(){
        return this.getClass().getName() + '{'
                + "type= \'" + this.getType() + '\''
                + ", direction=" + this.getDirection()
                + ", speed=" + this.getSpeed()
                + '}';
    }

    @Override
    public int hashCode() {
        int result = getDirection() != null ? getDirection().hashCode() : 0;
        result = 31 * result + getSpeed();
        result = getType() != null ? 31 * result + getType().hashCode() : 31 * result;
        return result;
    }

}
