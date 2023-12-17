package enums;

public enum Dialogue {
    REPORT("сказал"),
    DISPOSE("отдал_распоряжение"),
    ASK("спросил"),
    CALL("сказал_по_телефону"),
    OFFER("предложил"),
    EXCLAIM("воскликнул"),
    ANSWER("ответил");

    private String title;

    Dialogue(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
