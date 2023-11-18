import enums.*;
import heroes.*;
import objects.Spaceship;

public class Main {
    public static void main(String[] args) {

        Spaceship spaceship = new Spaceship("космический корабль", Direction.неизвестно, 100);
        Astronoms astronoms = new Astronoms("астрономы", "давилон");
        Spruts spruts = new Spruts("Спрутс", "господин", "давилон");
        Rzhigl rzhigl = new Rzhigl("Ржигль", "главный полицейский комиссар", "давилон");
        Shortys shortys = new Shortys("коротышки");

        astronoms.observe(spaceship);
        spaceship.speedUp(100);
        astronoms.makeConclusions("космический объект приобрел скорость для выхода из сферы земного притяжения");
        spaceship.changeDirection(Direction.Луна);
        astronoms.countTrajectory(spaceship);

        astronoms.speak("космический корабль направляется к Луне", spruts, Dialogue.сообщили);
        spruts.speak("продолжайте наблюдения", astronoms, Dialogue.отдал_распоряжение);

        spruts.speak("ожидается прибытие космического корабля с коротышками на борту", rzhigl, Dialogue.сказал_по_телефону);
        spruts.speak("как можно скорее разделайтесь с коротышками", rzhigl, Dialogue.отдал_распоряжение);

        shortys.intend("сеять повсюду гигантские семена и подстрекать бедняков к неповиновению богачам");

        rzhigl.speak("все необходимые меры будут приняты", spruts, Dialogue.ответил);
        rzhigl.speak("когда ожидается прибытие космического корабля на Луну?", spruts, Dialogue.спросил);
        rzhigl.speak("куда высадятся космонавты?", spruts, Dialogue.спросил);
        rzhigl.speak("сколько примерно будет космонавтов?", spruts, Dialogue.спросил);

        System.out.println("---------------------------------------");
        Astronoms astronoms2 = new Astronoms("астрономы", "давилон");
        System.out.println(astronoms.equals(astronoms2));
        System.out.println(astronoms.hashCode()==astronoms2.hashCode());
        System.out.println(astronoms.hashCode()==rzhigl.hashCode());

        System.out.println(spruts.toString());
        System.out.println(astronoms.equals(spaceship));
        System.out.println(astronoms.hashCode()==spaceship.hashCode());
    }
}