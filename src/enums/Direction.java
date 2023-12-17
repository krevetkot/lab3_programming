package enums;

public enum Direction {
    MOON("Луна"),
    EARTH("Земля"),
    SPACE("Космос"),
    OUT_OF_EARTH("от Земли"),
    SEE_OF_CLARITY("лунное море Ясности"),
    UNKNOWN("неизвестно");

    private String title;

    Direction(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
