package heroes;

import enums.*;
import interfaces.Speakable;
import interfaces.Storytellable;
import objects.SpaceObject;

public class Astronoms extends AbstractHero {
    public Astronoms(Profession profession, LivingPlace livingPlace){
        super(profession, livingPlace);
        System.out.println(makeCharacterName(Padezhy.I) + " созданы");
    }

    @Override
    public void speak(String someSpeech, AbstractHero anotherHero, Dialogue type){
        System.out.println(
                this.makeCharacterName(Padezhy.I) + ' ' + type.getTitle() + ' ' + anotherHero.makeCharacterName(Padezhy.D) + ": " + someSpeech
        );
    }

    @Override
    public String makeCharacterName(enums.Padezhy p){
        String character = "";
        if (p==Padezhy.I){
            character = this.getLivingPlace().getTitle() + "ские астрономы";
        }
        else if (p==Padezhy.R){
            character = this.getLivingPlace().getTitle() + "ских астрономов";
        }
        else if (p==Padezhy.D){
            character = this.getLivingPlace().getTitle() + "ским астрономам";
        }
        return character;

    }

    public void observe(SpaceObject object){
        System.out.println(makeCharacterName(Padezhy.I) + " наблюдают за " + object.makeCharacterName(Padezhy.T));
    }

    public void makeConclusions(String conc){
        System.out.println(makeCharacterName(Padezhy.I) + " делают выводы: " + conc);
    }

    public void countTrajectory(SpaceObject object){
        //какие-то бурные вычисления
        System.out.println(
                makeCharacterName(Padezhy.I) + " рассчитывают траекторию полета " + object.makeCharacterName(Padezhy.R));
    }

}
