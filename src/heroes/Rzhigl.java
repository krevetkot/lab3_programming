package heroes;

import enums.Dialogue;
import enums.Padezhy;
import interfaces.Speakable;
import interfaces.Storytellable;

public class Rzhigl extends AbstractHero implements Speakable, Storytellable {
    public Rzhigl(String name, String profession, String livingPlace){
        super(name, profession, livingPlace);
        System.out.println(makeCharacterName(Padezhy.I) + " создан");
    }

    @Override
    public void speak(String someSpeech, AbstractHero abstractHero, Dialogue type) {
        if (type==Dialogue.спросил){
            System.out.println(
                    this.makeCharacterName(Padezhy.I) + ' ' + type + " у " + abstractHero.makeCharacterName(Padezhy.R) + ": " + someSpeech
            );
        }
        else{
            System.out.println(
                    this.makeCharacterName(Padezhy.I) + ' ' + type + ' ' + abstractHero.makeCharacterName(Padezhy.D) + ": " + someSpeech
            );
        }

    }

    @Override
    public String makeCharacterName(Padezhy p) {
        String character = "";
        if (p==Padezhy.I){
            character = this.getProfession() + ' ' + this.getName();
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
