package heroes;

import enums.LivingPlace;
import enums.Profession;
import interfaces.Speakable;
import interfaces.Storytellable;

public abstract class AbstractHero implements Storytellable, Speakable {
    protected String name;
    protected Profession profession;
    protected LivingPlace livingPlace;

    public AbstractHero(String name, Profession profession, LivingPlace livingPlace){
        this.name = name;
        this.profession = profession;
        this.livingPlace = livingPlace;
    };

    public AbstractHero(Profession profession, LivingPlace livingPlace){
        this.profession = profession;
        this.livingPlace = livingPlace;
    };

    public AbstractHero(Profession profession){
        this.profession = profession;
    };

    public String getName() {
        return this.name;
    }

    public Profession getProfession() {
        return this.profession;
    }

    public LivingPlace getLivingPlace() {
        return this.livingPlace;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractHero that = (AbstractHero) obj;
        return (getName() == that.getName() && getProfession() == that.getProfession() && getLivingPlace() == that.getLivingPlace());
    }

    @Override
    public String toString(){
        return this.getClass().getName() + '{'
                + "name= \'" + this.getName() + '\''
                + ", profession=" + this.getProfession()
                + ", living place=" + this.getLivingPlace()
                + '}';
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = getProfession() != null ? 31 * result + getProfession().hashCode() : 31 * result;
        result = getLivingPlace() != null ? 31 * result + getLivingPlace().hashCode() : 31 * result;
        return result;
    }
}
