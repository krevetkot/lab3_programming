package heroes;

import enums.Dialogue;
import enums.Padezhy;
import enums.Profession;
import interfaces.Speakable;
import interfaces.Storytellable;

public class Shortys extends AbstractHero {
    public Shortys(Profession profession){
        super(profession);
        System.out.println(makeCharacterName(Padezhy.I) + " созданы");
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
            character = this.getProfession().getTitle();
        }
        else if (p==Padezhy.R){
            character = "коротышек";
        }
        else if (p==Padezhy.D){
            character = "коротышкам";
        }
        return character;
    }

    public void intend(String intention){
        System.out.println(
                this.makeCharacterName(Padezhy.I) + " намереваются: " + intention
        );
    }

    public void SowSeeds(){
        //какие-то активные действия
        System.out.println(makeCharacterName(Padezhy.I) + " сеят гигантские семена");
    }

    public void instigate(Poor poor){
        if (Math.random()<0.5){
            poor.obedience = false;
        }
        System.out.println(makeCharacterName(Padezhy.I) + " подстрекают бедняков к неповиновению богачам");
        if (poor.obedience){
            System.out.println(poor.makeCharacterName(Padezhy.I) + " не отреагировали на подстрекательства");
        }
        else {
            System.out.println(poor.makeCharacterName(Padezhy.I) + " больше не повинуются богачам. Ура, мировая революция!");
        }
    }

}
