package enums;

public enum State {
    SOWN("посеяны"),
    SPROUTED("проросли"),
    NOT_SPROUTED("не_проросли"),
    FLY("летит"),
    STAY("стоит"),
    LANDED("приземлился");

    private String title;

    State(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
