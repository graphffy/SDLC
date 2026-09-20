package sdl;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Model {
    public static final String INPUT_PROPERTY = "input";

    private String inputSentence;
    private String invertedSentence;
    private String lastInput = "";

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    
    public void setInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Введите непустое предложение.");
        }
        String oldInput = this.inputSentence;
        this.inputSentence = input;
        this.lastInput = input;
        this.invertedSentence = invertWords(input);
        support.firePropertyChange(INPUT_PROPERTY, oldInput, input);
    }

    public String getInvertedSentence() {
        return invertedSentence;
    }

    public String getLastInput() {
        return lastInput;
    }

    private String invertWords(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(new StringBuilder(words[i]).reverse().toString());
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}