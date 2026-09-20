package sdl;

import javax.swing.*;
import java.awt.*;

public class InputDialog extends JDialog {
    private final JTextField textField;
    private String inputText = null;

    public InputDialog(JFrame parent, String initialText) {
        super(parent, "Ввод предложения", true);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Предложение:"));
        textField = new JTextField(20);
        if (initialText != null) {
            textField.setText(initialText);
        }
        inputPanel.add(textField);
        add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton okButton = new JButton("ОК");
        JButton cancelButton = new JButton("Отмена");
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);

        okButton.addActionListener(e -> {
            inputText = textField.getText();
            dispose();
        });

        cancelButton.addActionListener(e -> {
            inputText = null;
            dispose();
        });

        pack();
        setLocationRelativeTo(parent);
    }

    public String getInputText() {
        return inputText;
    }
}