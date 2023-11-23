import enums.*;
import heroes.*;
import objects.*;

public class Main {

    public static void main(String[] args) {

        Spaceship spaceship = new Spaceship("космический корабль", Direction.UNKNOWN, 10);
        Astronoms astronoms = new Astronoms(Profession.ASTRONOM, LivingPlace.DAVILON);
        Spruts spruts = new Spruts("Спрутс", Profession.SENIOR, LivingPlace.DAVILON);
        Rzhigl rzhigl = new Rzhigl("Ржигль", Profession.COMISSAR, LivingPlace.DAVILON);
        Poor poor = new Poor(Profession.POOR);
        Shortys shortys = new Shortys(Profession.SHORTY);

        astronoms.observe(spaceship);
        spaceship.speedUp(100);
        while (!spaceship.isReadyToEscapeFromGravitation(Direction.EARTH)){
            astronoms.makeConclusions("чтобы выйти из сферы земного притяжения, космическому кораблю нужно еще больше разогнаться");
            spaceship.speedUp(10);
        }
        astronoms.makeConclusions("космический объект приобрел скорость для выхода из сферы земного притяжения");

        spaceship.changeDirection(Direction.MOON);
        astronoms.countTrajectory(spaceship);

        astronoms.speak("космический корабль направляется к Луне", spruts, Dialogue.REPORT);
        spruts.speak("продолжайте наблюдения", astronoms, Dialogue.DISPOSE);

        spruts.speak("ожидается прибытие космического корабля с коротышками на борту", rzhigl, Dialogue.CALL);
        spruts.speak("как можно скорее разделайтесь с коротышками", rzhigl, Dialogue.DISPOSE);

        shortys.intend("сеять повсюду гигантские семена и подстрекать бедняков к неповиновению богачам");

        rzhigl.speak("все необходимые меры будут приняты", spruts, Dialogue.ANSWER);
        rzhigl.speak("когда ожидается прибытие космического корабля на Луну?", spruts, Dialogue.ASK);
        rzhigl.speak("куда высадятся космонавты?", spruts, Dialogue.ASK);
        rzhigl.speak("сколько примерно будет космонавтов?", spruts, Dialogue.ASK);

        if (Math.random()<0.5){
            System.out.println("меры насчет коротышек не были приняты...");
            shortys.SowSeeds();
            shortys.instigate(poor);
        }
        else {
            System.out.println("меры насчет коротышек были успешно приняты :)");
        }


//        System.out.println("---------------------------------------");
//        Astronoms astronoms2 = new Astronoms("астрономы", "давилон");
//
//        System.out.println(astronoms.hashCode()==astronoms2.hashCode());
//        System.out.println(astronoms.hashCode()==rzhigl.hashCode());
//
//        System.out.println(spruts.toString());
//        System.out.println(astronoms.equals(spaceship));
//        System.out.println(astronoms.hashCode()==spaceship.hashCode());
    }
}