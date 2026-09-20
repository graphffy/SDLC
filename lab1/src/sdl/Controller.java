package sdl;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Controller {
    private final Model model;
    private final MainView view;

    public Controller(Model model, MainView view) {
        this.model = model;
        this.view = view;

        view.setInputButtonListener(e -> showInputDialog());

        model.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (Model.INPUT_PROPERTY.equals(evt.getPropertyName())) {
                    view.updateResult(model.getInvertedSentence());
                }
            }
        });
    }

    private void showInputDialog() {
        String lastInput = model.getLastInput();
        InputDialog dialog = new InputDialog(view, lastInput);
        dialog.setVisible(true);
        String input = dialog.getInputText();
        if (input != null) {
            try {
                model.setInput(input);
            } catch (IllegalArgumentException ex) {
                view.showError(ex.getMessage());
            }
        }
    }
}