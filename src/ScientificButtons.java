import java.util.ArrayList;

import java.awt.Color;

import javax.swing.JButton;

public class ScientificButtons {
    private final String[] SCIENTIFIC_BUTTONS = {"sin(", "cos(", "tan(", "asin(", "acos(", "atan(", "sinh(", "cosh(", "tanh(", "sqrt(", "cbrt(", "abs(", ")"};
    private ArrayList<JButton> scientificButtons;
    static ArrayList<Integer> beginIndex, endIndex;
    static ArrayList<String> op;
    ScientificButtons() {
        scientificButtons = new ArrayList<JButton>();
        beginIndex = new ArrayList<Integer>();
        endIndex = new ArrayList<Integer>();
        op = new ArrayList<String>();
        createButtons(scientificButtons, SCIENTIFIC_BUTTONS);
        addActionListener(new TextField());
    }

    void createButtons(ArrayList<JButton> container, String[] btnArray) {
        for (String btn : btnArray) {
            container.add(new JButton(btn));
        }
    }
    ArrayList<JButton> getScientificButtons() {
        return scientificButtons;
    }
    void addActionListener(TextField textField) {
        for(JButton btn : scientificButtons) {
            String btnName = btn.getText();
            btn.setFocusable(false);
            btn.setBackground(Color.gray);
            btn.setForeground(Color.black);
            btn.addActionListener((e) -> {
                if(btnName.equals(")")) {
                    endIndex.add(textField.getText().length());
                }
                else {
                    beginIndex.add(textField.getText().length());
                    op.add(btnName);
                }
                textField.append(btnName);
            });
        }
    }
}
