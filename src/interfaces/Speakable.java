package interfaces;
import enums.Dialogue;
import heroes.AbstractHero;

public interface Speakable {
    public void speak(String someSpeech, AbstractHero abstractHero, Dialogue type);

}
