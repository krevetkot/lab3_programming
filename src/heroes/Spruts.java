package heroes;

import enums.Dialogue;
import enums.Padezhy;
import interfaces.Speakable;
import interfaces.Storytellable;

public class Spruts extends AbstractHero {
    public Spruts(String name, String profession, String livingPlace){
        super(name, profession, livingPlace);
        System.out.println(makeCharacterName(Padezhy.I) + " создан");
    }

    @Override
    public void speak(String someSpeech, AbstractHero abstractHero, Dialogue type) {
        System.out.println(
                this.makeCharacterName(Padezhy.I) + ' ' + type + ' ' + abstractHero.makeCharacterName(Padezhy.D) + ": " + someSpeech
        );
    }

    @Override
    public String makeCharacterName(Padezhy p) {
        String character = "";
        if (p==Padezhy.I){
            character = this.getProfession() + ' ' + this.getName();
        }
        else if (p==Padezhy.R){
            character = this.getProfession() + 'а' + ' ' + this.getName() + 'а';
        }
        else if (p==Padezhy.D){
            character = this.getProfession() + 'у' + ' ' + this.getName() + 'у';
        }
        return character;
    }
}
