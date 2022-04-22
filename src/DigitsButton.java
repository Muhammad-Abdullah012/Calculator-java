import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;

class DigitsButton {
    private final String[] DIGITS_BUTTONS = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", ".", "!"};
    private ArrayList<JButton> digitsButtons;
    DigitsButton() {
        digitsButtons = new ArrayList<JButton>();
        createButtons(digitsButtons, DIGITS_BUTTONS);
        addActionListener(new TextField());
    }

    void createButtons(ArrayList<JButton> container, String[] btnArray) {
        for (String btn : btnArray) {
            container.add(new JButton(btn));
        }
    }
    ArrayList<JButton> getDigitsButtons() {
        return digitsButtons;
    } 
    void addActionListener(TextField textField) {
        for(JButton btn : digitsButtons) {
            String btnName = btn.getText();
            btn.setFocusable(false);
            btn.setBackground(Color.lightGray);
            btn.setForeground(Color.black);
            btn.addActionListener((e) -> {
                textField.append(btnName);
            });
        }
    }
}