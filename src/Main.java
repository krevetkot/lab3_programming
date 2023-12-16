import enums.*;
import heroes.*;
import items.GravitonTelescope;
import spaceObjects.*;

public class Main {

    public static void main(String[] args) {

        GravitonTelescope telescope = new GravitonTelescope(Direction.MOON, Direction.EARTH);
        Astronoms astronoms = new Astronoms(Profession.ASTRONOM, LivingPlace.DAVILON);
        Spruts spruts = new Spruts("Спрутс", Profession.SENIOR, LivingPlace.DAVILON);
        Rzhigl rzhigl = new Rzhigl("Ржигль", Profession.COMISSAR, LivingPlace.DAVILON);
        Poor poor = new Poor(Profession.POOR);
        Shortys shortys = new Shortys(Profession.SHORTY);

        System.out.println();

        Meteor meteor = new Meteor("метеор", Direction.UNKNOWN, 30, 40);
        astronoms.observe(telescope, meteor);
        astronoms.makeConclusions();
        Meteor meteor1 = new Meteor("метеор", Direction.UNKNOWN, 30, 40);
        astronoms.observe(telescope, meteor1);
        astronoms.makeConclusions();
        Meteor meteor2 = new Meteor("метеор", Direction.UNKNOWN, 30, 40);
        astronoms.observe(telescope, meteor2);
        astronoms.makeConclusions();

        System.out.println();

        Spaceship spaceship = new Spaceship("космический корабль", Direction.OUT_OF_EARTH, 10, 1000);
        astronoms.observe(telescope, spaceship);
        astronoms.makeConclusions("что-то странное");
        spaceship.speedUp(10);
        astronoms.observe(telescope, spaceship);
        astronoms.makeConclusions("оно противоречит законам небесной механики");
        astronoms.makeConclusions("у него есть реактивый двигатель");
        astronoms.makeConclusions();

        System.out.println();

        astronoms.observe(telescope, spaceship);
        spaceship.speedUp(100);
        while (!spaceship.isReadyToEscapeFromGravitation(Direction.EARTH)){
            astronoms.makeConclusions("чтобы выйти из сферы земного притяжения, космическому кораблю нужно еще больше разогнаться");
            spaceship.speedUp(10);
        }
        astronoms.makeConclusions("космический объект приобрел скорость для выхода из сферы земного притяжения");

        spaceship.changeDirection(Direction.MOON);
        astronoms.countTrajectory(spaceship);

        astronoms.speak("космический корабль направляется к Луне \n", spruts, Dialogue.REPORT);
        spruts.speak("продолжайте наблюдения", astronoms, Dialogue.DISPOSE);

        spruts.speak("ожидается прибытие космического корабля с коротышками на борту", rzhigl, Dialogue.CALL);
        spruts.speak("как можно скорее разделайтесь с коротышками\n", rzhigl, Dialogue.DISPOSE);

        shortys.intend("сеять повсюду гигантские семена и подстрекать бедняков к неповиновению богачам\n");

        rzhigl.speak("все необходимые меры будут приняты", spruts, Dialogue.ANSWER);
        rzhigl.speak("когда ожидается прибытие космического корабля на Луну?", spruts, Dialogue.ASK);
        rzhigl.speak("куда высадятся космонавты?", spruts, Dialogue.ASK);
        rzhigl.speak("сколько примерно будет космонавтов?\n", spruts, Dialogue.ASK);

        if (Math.random()<0.5){
            System.out.println("меры насчет коротышек не были приняты...");
            shortys.SowSeeds();
            shortys.instigate(poor);
        }
        else {
            System.out.println("меры насчет коротышек были успешно приняты :)");
        }

    }
}