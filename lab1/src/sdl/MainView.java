package sdl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    private final JLabel resultLabel;

    public MainView() {
        setTitle("Инвертирование слов");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        resultLabel = new JLabel("Результат: ");
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(resultLabel, BorderLayout.CENTER);

        JButton inputButton = new JButton("Ввести данные");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(inputButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setSize(400, 200);
        setLocationRelativeTo(null);
    }

    public void setInputButtonListener(ActionListener listener) {
        Component[] comps = ((JPanel) getContentPane().getComponent(1)).getComponents();
        for (Component c : comps) {
            if (c instanceof JButton) {
                ((JButton) c).addActionListener(listener);
                break;
            }
        }
    }

    public void updateResult(String inverted) {
        resultLabel.setText("Результат: " + inverted);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Ошибка", JOptionPane.ERROR_MESSAGE);
    }
}