package heroes;

import enums.Dialogue;
import enums.LivingPlace;
import enums.Padezhy;
import enums.Profession;
import interfaces.Speakable;
import interfaces.Storytellable;

public class Spruts extends AbstractHero {
    public Spruts(String name, Profession profession, LivingPlace livingPlace){
        super(name, profession, livingPlace);
        System.out.println(makeCharacterName(Padezhy.I) + " создан");
    }

    @Override
    public void speak(String someSpeech, AbstractHero anotherHero, Dialogue type){
        System.out.println(
                this.makeCharacterName(Padezhy.I) + ' ' + type.getTitle() + ' ' + anotherHero.makeCharacterName(Padezhy.D) + ": " + someSpeech
        );
    }

    @Override
    public String makeCharacterName(Padezhy p) {
        String character = "";
        if (p==Padezhy.I){
            character = this.getProfession().getTitle() + ' ' + this.getName();
        }
        else if (p==Padezhy.R){
            character = this.getProfession().getTitle() + 'а' + ' ' + this.getName() + 'а';
        }
        else if (p==Padezhy.D){
            character = this.getProfession().getTitle() + 'у' + ' ' + this.getName() + 'у';
        }
        return character;
    }

}
