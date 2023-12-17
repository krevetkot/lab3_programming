package spaceObjects;

import enums.Direction;
import heroes.AbstractHero;
import interfaces.Flyable;
import interfaces.Storytellable;

public abstract class SpaceObject implements Flyable{
    protected Direction direction;
    protected int speed;
    protected String type;
    protected int weight;
    protected Graviton graviton;

    public SpaceObject(String type, Direction direction, int speed, int weight){
        this.type = type;
        this.direction = direction;
        this.speed = speed;
        this.weight = weight;

        this.graviton = new Graviton();
    }

    protected void setDirection(Direction direction) {
        this.direction = direction;
    }

    protected void setSpeed(int speed) {
        this.speed = speed;
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

    public Graviton getGraviton(){
        return this.graviton;
    }




    public class Graviton{

        private int [] inf;

        public Graviton(){
            int[] information = new int[2]; //speed and weight
            this.inf = information;
            this.setInf();
        }
        public void setInf(){
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
