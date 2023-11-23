package enums;

public enum Profession {
    ASTRONOM("астрономы"),
    COMISSAR("главный полицейский коммисар"),
    SENIOR("господин"),
    POOR("бедняки"),
    SHORTY("коротышки");

    private String title;

    Profession(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
