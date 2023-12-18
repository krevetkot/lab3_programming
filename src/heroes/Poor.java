package heroes;

import enums.Dialogue;
import enums.Profession;

public class Poor extends AbstractHero {

    protected boolean obedience;
    public Poor(Profession profession) {
        super(profession);
        obedience = true;
        System.out.println("бедняки созданы");
    }

    @Override
    public void speak(String someSpeech, AbstractHero anotherHero, Dialogue type){
        System.out.println(
                "бедняки " + type.getTitle() + ' ' + anotherHero.getName() + ": " + someSpeech
        );
    }

//    @Override
//    public String makeCharacterName(Padezhy p) {
//        String character = "";
//        if (p == Padezhy.I) {
//            character = this.getProfession().getTitle();
//        } else if (p == Padezhy.R) {
//            character = "бедняков";
//        } else if (p == Padezhy.D) {
//            character = "беднякам";
//        }
//        return character;
//    }


}
