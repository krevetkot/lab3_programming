package heroes;

import enums.*;
import items.GravitonTelescope;
import spaceObjects.SpaceObject;

public class Astronoms extends AbstractHero {

    int[] lastMeasurement;

    {
        this.name = "астрономы";
        lastMeasurement = new int[]{0, 0, 0};
    }

    public Astronoms(Profession profession, LivingPlace livingPlace){
        super(profession, livingPlace);
        System.out.println("астрономы созданы");
    }

    @Override
    public void speak(String someSpeech, AbstractHero anotherHero, Dialogue type){
        System.out.println(
                this.getName() + ' ' + type.getTitle() + ' ' + anotherHero.getName() + ": " + someSpeech
        );
    }

    public void makeConclusions(String conc){
        System.out.println(this.getName() + " делают выводы: " + conc);
    }

    public void makeConclusions(){
        if (this.lastMeasurement[0] == 1000){
            System.out.println(this.getName() + " делают вывод: это космический корбаль");
        }
        else if (this.lastMeasurement[0] == 40){
            System.out.println(this.getName() + " делают вывод: это метеор");
        }
    }

    public void countTrajectory(SpaceObject object){
        //какие-то бурные вычисления
        System.out.println(this.getName() + " рассчитывают траекторию полета " + object.getType());
    }

    public void observe(GravitonTelescope telescope, SpaceObject object){
        System.out.println(this.getName() + " наблюдают за космическим телом");
        int[][] inf = telescope.getInformationAboutObject(object.getGravitons());
        int weight = (int)(inf[0][0]/200);
        int distance = inf[1][0];
        int speed = inf[1][1];
        this.lastMeasurement[0] = weight;
        this.lastMeasurement[1] = distance;
        this.lastMeasurement[2] = speed;
    }

    public void announceResultsOfObservation(){
        System.out.println("данные, полученные из наблюдений: вес: " + lastMeasurement[0] +
                " расстояние: " + lastMeasurement[1] + " скорость " + lastMeasurement[2]);
    }

    public void readTelescopeInstruction(GravitonTelescope.Instruction instruction){
        //читают типа
        System.out.println(this.getName() + " прочли инструкцию к телескопу. можно начинать работу!");
    }

}
