package heroes;

import enums.Dialogue;
import enums.Padezhy;

public class Poor extends AbstractHero {

    protected boolean obedience;
    public Poor(String profession) {
        super(profession);
        obedience = true;
        System.out.println(makeCharacterName(Padezhy.I) + " созданы");
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
        if (p == Padezhy.I) {
            character = this.getProfession();
        } else if (p == Padezhy.R) {
            character = "бедняков";
        } else if (p == Padezhy.D) {
            character = "беднякам";
        }
        return character;
    }

}
