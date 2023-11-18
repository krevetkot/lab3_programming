package objects;

import enums.Direction;
import heroes.AbstractHero;
import interfaces.Flyable;
import interfaces.Storytellable;

public abstract class SpaceObject implements Flyable, Storytellable{
    private Direction direction;
    private int speed;
    private String type;

    public SpaceObject(String type, Direction direction, int speed){
        this.type = type;
        this.direction = direction;
        this.speed = speed;
    }
    protected void setDirection(Direction direction){
        this.direction = direction;
    }
    protected void setSpeed(int speed){
        this.speed = speed;
    }
    public Direction getDirection(){
        return this.direction;
    }

    public int getSpeed(){
        return this.speed;
    }

    public String getType(){
        return this.type;
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
