package heroes;

import enums.Dialogue;
import enums.LivingPlace;
import enums.Padezhy;
import enums.Profession;
import spaceObjects.SpaceObject;
import spaceObjects.Spaceship;

public class Shorty extends AbstractHero {
    public Shorty(String name, Profession profession, LivingPlace livingPlace){
        super(name, profession, livingPlace);
        System.out.println(profession.getTitle() + ' ' + name + " создан");
    }

    @Override
    public void speak(String someSpeech, AbstractHero anotherHero, Dialogue type){
        if (anotherHero!=null) {
            System.out.println(this.name + ' ' + type.getTitle() + " to " + anotherHero.getName() + ": " + someSpeech);
        }
        else{
            System.out.println(this.name + ' ' + type.getTitle() + ": " + someSpeech);
        }
    }

//    @Override
//    public String makeCharacterName(Padezhy p) {
//        String character = "";
//        if (p==Padezhy.I){
//            character = this.getProfession().getTitle();
//        }
//        else if (p==Padezhy.R){
//            character = "коротышек";
//        }
//        else if (p==Padezhy.D){
//            character = "коротышкам";
//        }
//        return character;
//    }

    public void intend(String intention){
        System.out.println("коротышки намереваются: " + intention
        );
    }

    public void SowSeeds(){
        //какие-то активные действия
        System.out.println("коротышки сеят гигантские семена");
    }

    public void instigate(Poor poor){
        if (Math.random()<0.5){
            poor.obedience = false;
        }
        System.out.println("коротышки подстрекают бедняков к неповиновению богачам");
        if (poor.obedience){
            System.out.println("бедняки не отреагировали на подстрекательства");
        }
        else {
            System.out.println("бедняки больше не повинуются богачам. Ура, мировая революция!");
        }
    }

    public boolean discover(SpaceObject obj){
        if(Math.random()<=0.2){
            this.speak("я обнаружил " + obj.getType() + "!", null, Dialogue.EXCLAIM);
            return true;
        }
        else{
            return false;
        }
    }

}
