package heroes;

import enums.Dialogue;
import enums.LivingPlace;
import enums.Padezhy;
import enums.Profession;
import interfaces.Speakable;
import interfaces.Storytellable;

public class Rzhigl extends AbstractHero {
    public Rzhigl(String name, Profession profession, LivingPlace livingPlace){
        super(name, profession, livingPlace);
        System.out.println(makeCharacterName(Padezhy.I) + " создан");
    }

    @Override
    public void speak(String someSpeech, AbstractHero abstractHero, Dialogue type) {
        if (type==Dialogue.ASK){
            System.out.println(
                    this.makeCharacterName(Padezhy.I) + ' ' + type.getTitle() + " у " + abstractHero.makeCharacterName(Padezhy.R) + ": " + someSpeech
            );
        }
        else{
            System.out.println(
                    this.makeCharacterName(Padezhy.I) + ' ' + type.getTitle() + ' ' + abstractHero.makeCharacterName(Padezhy.D) + ": " + someSpeech
            );
        }

    }

    @Override
    public String makeCharacterName(Padezhy p) {
        String character = "";
        if (p==Padezhy.I){
            character = this.getProfession().getTitle() + ' ' + this.getName();
        }
        else if (p==Padezhy.R){
            character = "главного полицейского комиссара Ржигля";
        }
        else if (p==Padezhy.D){
            character = "главному полицейскому комиссару Ржиглю";
        }
        return character;
    }

}
