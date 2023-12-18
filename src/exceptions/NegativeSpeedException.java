package exceptions;

public class NegativeSpeedException extends RuntimeException{

    private int speed;
    public NegativeSpeedException(String message, int speed) {
        super(message+speed);
        this.speed = speed;
    }
    public int getSpeed(){return speed;}
}
