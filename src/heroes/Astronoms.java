package heroes;

import enums.*;
import items.GravitonTelescope;
import spaceObjects.SpaceObject;

public class Astronoms extends AbstractHero {

    {
        this.name = "астрономы";
    }

    int[] lastMeasurement;

    {
        lastMeasurement = new int[]{0, 0, 0};
    }

    public Astronoms(Profession profession, LivingPlace livingPlace){
        super(profession, livingPlace);
        System.out.println("астрономы созданы");
    }

    @Override
    public void speak(String someSpeech, AbstractHero anotherHero, Dialogue type){
        System.out.println(
                "астрономы " + type.getTitle() + ' ' + anotherHero.getName() + ": " + someSpeech
        );
    }

//    @Override
//    public String makeCharacterName(enums.Padezhy p){
//        String character = "";
//        if (p==Padezhy.I){
//            character = this.getLivingPlace().getTitle() + "ские астрономы";
//        }
//        else if (p==Padezhy.R){
//            character = this.getLivingPlace().getTitle() + "ских астрономов";
//        }
//        else if (p==Padezhy.D){
//            character = this.getLivingPlace().getTitle() + "ским астрономам";
//        }
//        return character;
//
//    }

    public void makeConclusions(String conc){
        System.out.println("астрономы делают выводы: " + conc);
    }

    public void makeConclusions(){
        if (this.lastMeasurement[0] == 1000){
            System.out.println("астрономы делают вывод: это космический корбаль");
        }
        else if (this.lastMeasurement[0] == 40){
            System.out.println("астрономы делают вывод: это метеор");
        }
    }

    public void countTrajectory(SpaceObject object){
        //какие-то бурные вычисления
        System.out.println("астрономы рассчитывают траекторию полета " + object.getType());
    }

    public void observe(GravitonTelescope telescope, SpaceObject object){
        System.out.println("астрономы наблюдают за космическим телом"); //+ object.makeCharacterName(Padezhy.T));
        int[][] inf = telescope.getInformationAboutObject(object.getGraviton());
        int weight = (int)(inf[0][0]/200);
        int distance = inf[1][0];
        int speed = inf[1][1];
        this.lastMeasurement[0] = weight;
        this.lastMeasurement[1] = distance;
        this.lastMeasurement[2] = speed;
//        return new int[] {weight, distance, speed};
    }

    public void announceResultsOfObservation(){
        System.out.println("данные, полученные из наблюдений: вес: " + lastMeasurement[0] +
                " расстояние: " + lastMeasurement[1] + " скорость " + lastMeasurement[2]);
    }

}
