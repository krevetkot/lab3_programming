package enums;

public enum Direction {
    MOON("Луна"),
    EARTH("Земля"),
    SPACE("Космос"),
    UNKNOWN("неизвестно");

    private String title;

    Direction(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
