package enums;

public enum LivingPlace {
    DAVILON("давилон"),
    SPB("петербург");

    private String title;

    LivingPlace(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
