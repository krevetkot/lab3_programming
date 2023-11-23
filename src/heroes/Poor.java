package heroes;

import enums.Dialogue;
import enums.Padezhy;
import enums.Profession;

public class Poor extends AbstractHero {

    protected boolean obedience;
    public Poor(Profession profession) {
        super(profession);
        obedience = true;
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
        if (p == Padezhy.I) {
            character = this.getProfession().getTitle();
        } else if (p == Padezhy.R) {
            character = "бедняков";
        } else if (p == Padezhy.D) {
            character = "беднякам";
        }
        return character;
    }


}
