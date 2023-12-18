package enums;

public enum Language {
    RUSSIAN("русский"),
    ENGLISH("английский"),
    TURKISH("турецкий"),
    ROMANIAN("румынский");

    private String title;

    Language(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
