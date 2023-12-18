package exceptions;

import heroes.AbstractHero;

public class NotEnoughPlaceInSpaceshipException extends Exception{
    private AbstractHero unluckyHero;
    public NotEnoughPlaceInSpaceshipException(String message, AbstractHero unluckyHero) {
        super(message+unluckyHero.getName());
        this.unluckyHero = unluckyHero;
    }
    public AbstractHero getUnluckyHero(){return unluckyHero;}
}
