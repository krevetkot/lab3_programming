package heroes;

import interfaces.Storytellable;

public abstract class AbstractHero implements Storytellable {
    private String name;
    private String profession;
    private String livingPlace;

    public AbstractHero(String name, String profession, String livingPlace){
        this.name = name;
        this.profession = profession;
        this.livingPlace = livingPlace;
    };

    public AbstractHero(String profession, String livingPlace){
        this.profession = profession;
        this.livingPlace = livingPlace;
    };

    public AbstractHero(String profession){
        this.profession = profession;
    };

    public String getName() {
        return this.name;
    }

    public String getProfession() {
        return this.profession;
    }

    public String getLivingPlace() {
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
