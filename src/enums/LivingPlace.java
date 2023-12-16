package enums;

public enum LivingPlace {
    DAVILON("давилон"),
    FLOWER_CITY("цветочный город"),
    SPB("петербург");

    private String title;

    LivingPlace(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
