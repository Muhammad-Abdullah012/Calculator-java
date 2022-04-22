import javax.swing.JButton;
import java.util.ArrayList;

class OperatorButton {
    private final String[] OPERATOR_BUTTONS = {"DEL", "AC", "X", "/", "+", "-", "Ans", "="};
    private ArrayList<JButton> operatorButtons;
    OperatorButton() {
        operatorButtons = new ArrayList<JButton>();
        createButtons(operatorButtons, OPERATOR_BUTTONS);
        addActionListener(new TextField());
    }

    ArrayList<JButton> getOperatorButtons() {
        return operatorButtons;
    }
    void createButtons(ArrayList<JButton> container, String[] btnArray) {
        for (String btn : btnArray) {
            container.add(new JButton(btn));
        }
    }

    void addActionListener(TextField textField) {
        for(JButton btn : operatorButtons) {
            String btnName = btn.getText();
            btn.setFocusable(false);
            btn.addActionListener((e) -> {
                String input = textField.getText();
                switch(btnName) {
                    case "AC":
                        textField.setText("");
                        break;
                    case "DEL":
                        if(input.length() > 0)
                            textField.setText(input.substring(0, input.length() - 1));
                        break;
                    case "=":
                        {
                            Calculate c = new Calculate(textField.getText());
                            textField.setText(c.getResult());
                        }
                        break;
                    default:
                        textField.append(btnName);
                }       
            });
        }
    }
}