package sdl;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Model model = new Model();
            MainView view = new MainView();
            new Controller(model, view);
            view.setVisible(true);
        });
    }
}
