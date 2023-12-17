import enums.*;
import heroes.*;
import items.GravitonTelescope;
import spaceObjects.*;

public class Main {

    public static void main(String[] args) {

        GravitonTelescope telescope = new GravitonTelescope(Direction.MOON, Direction.EARTH);
        Astronoms astronoms = new Astronoms(Profession.ASTRONOM, LivingPlace.DAVILON);
        Shorty spruts = new Shorty("Спрутс", Profession.SENIOR, LivingPlace.DAVILON);
        Shorty rzhigl = new Shorty("Ржигль", Profession.COMISSAR, LivingPlace.DAVILON);

        Shorty znaika = new Shorty("Знайка", Profession.UNKNOWN, LivingPlace.FLOWER_CITY);
        Shorty fuksiya = new Shorty("Фуксия", Profession.UNKNOWN, LivingPlace.FLOWER_CITY);
        Shorty seledochka = new Shorty("Селедочка", Profession.UNKNOWN, LivingPlace.FLOWER_CITY);

        Spaceship spaceship1 = new Spaceship("космический корабль 1", Direction.OUT_OF_EARTH, 10, 1000, 3);
        spaceship1.addPassenger(znaika);
        spaceship1.addPassenger(fuksiya);
        spaceship1.addPassenger(seledochka);

        Shorty neznaika = new Shorty("Незнайка", Profession.UNKNOWN, LivingPlace.FLOWER_CITY);
        Shorty ponchik = new Shorty("Пончик", Profession.UNKNOWN, LivingPlace.FLOWER_CITY);

        Spaceship spaceship2 = new Spaceship("космический корабль 2", Direction.OUT_OF_EARTH, 10, 1000, 2);
        spaceship2.addPassenger(neznaika);
        spaceship2.addPassenger(ponchik);


        Poor poor = new Poor(Profession.POOR);
        Shorty shortys = new Shorty("", Profession.SHORTY, LivingPlace.FLOWER_CITY);

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


        astronoms.observe(telescope, spaceship1);
        astronoms.makeConclusions("что-то странное");
        spaceship1.speedUp(10);
        astronoms.observe(telescope, spaceship1);
        astronoms.makeConclusions("оно противоречит законам небесной механики");
        astronoms.makeConclusions("у него есть реактивый двигатель");
        astronoms.makeConclusions();

        System.out.println();

        astronoms.observe(telescope, spaceship1);
        spaceship1.speedUp(100);
        while (!spaceship1.isReadyToEscapeFromGravitation(Direction.EARTH)){
            astronoms.makeConclusions("чтобы выйти из сферы земного притяжения, космическому кораблю нужно еще больше разогнаться");
            spaceship1.speedUp(10);
        }
        astronoms.makeConclusions("космический объект приобрел скорость для выхода из сферы земного притяжения");

        spaceship1.changeDirection(Direction.MOON);
        astronoms.countTrajectory(spaceship1);

        astronoms.speak("космический корабль направляется к Луне \n", spruts, Dialogue.REPORT);
        spruts.speak("продолжайте наблюдения", astronoms, Dialogue.DISPOSE);

        spruts.speak("ожидается прибытие космического корабля с коротышками на борту", rzhigl, Dialogue.CALL);
        spruts.speak("как можно скорее разделайтесь с коротышками\n", rzhigl, Dialogue.DISPOSE);

        shortys.intend("сеять повсюду гигантские семена и подстрекать бедняков к неповиновению богачам\n");

        rzhigl.speak("все необходимые меры будут приняты", spruts, Dialogue.ANSWER);
        rzhigl.speak("когда ожидается прибытие космического корабля на Луну?", spruts, Dialogue.ASK);
        rzhigl.speak("куда высадятся космонавты?", spruts, Dialogue.ASK);
        rzhigl.speak("сколько примерно будет космонавтов?\n", spruts, Dialogue.ASK);

//        if (Math.random()<0.5){
//            System.out.println("меры насчет коротышек не были приняты...");
//            shortys.SowSeeds();
//            shortys.instigate(poor);
//        }
//        else {
//            System.out.println("меры насчет коротышек были успешно приняты :)");
//        }

        System.out.println("а в это время...");

        astronoms.makeConclusions("космический корабль вышел из сферы притяжения Земли");
        astronoms.countTrajectory(spaceship1);
        astronoms.makeConclusions("космический корабль пролетит мимо Луны?");
        spaceship1.turn(10, 'r', true);
        astronoms.makeConclusions("теперь мы убеждены, что это космический корабль. стопроц");
        astronoms.announceResultsOfObservation();
        astronoms.makeConclusions("в космическом корабле 10-30 пассажиров\n");

        spaceship1.flyAround(Direction.MOON);
        astronoms.makeConclusions("ракета ищет место для посадки\n");

        System.out.println("а в это время на космическом корабле 1...");
        znaika.speak("не будем высаживаться, пока не найдем ракету пончика и незнайки", null, Dialogue.REPORT);
        seledochka.speak("согласна", znaika, Dialogue.ANSWER);
        fuksiya.speak("солидарна\n", znaika, Dialogue.ANSWER);

        spaceship2.land(Direction.SEE_OF_CLARITY);
        System.out.println();

        while(!znaika.discover(spaceship2)){
            spaceship1.flyAround(Direction.MOON);
        }

    }
}