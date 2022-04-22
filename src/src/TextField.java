import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Font;
class TextField {
    static JTextField textField = new JTextField();;
    TextField() {
        textField.setPreferredSize(new Dimension(500, 50));
        textField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 36));
        textField.addActionListener((e) -> {
            new Calculate(textField.getText());
        });
    }
    String getText() {
        return textField.getText();
    }
    void setText(String text) {
        textField.setText(text);
    }
    void append(String text) {
        textField.setText(getText() + text);
    }
}