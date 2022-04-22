import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import java.util.ArrayList;


class UI {
    private static JFrame frame;
    private JPanel digitsPanel, operatorPanel, scientificPanel, textPanel, bottomPanel;
    private SelectAngle list;
    private final Short width = 500;
    private final Short height = 500;
    
    public UI() {
        createDataMembers();
        setFrameProperties();
        setLayouts();
        textPanel.setMinimumSize(new Dimension(500, 50));
        textPanel.setPreferredSize(textPanel.getMinimumSize());
        textPanel.setBackground(Color.LIGHT_GRAY);
        textPanel.add(TextField.textField);

        operatorPanel.setVisible(true);
        digitsPanel.setVisible(true);
        

        digitsPanel.setMinimumSize(new Dimension(300, 300));
        digitsPanel.setPreferredSize(digitsPanel.getMinimumSize());
        operatorPanel.setMinimumSize(new Dimension(200, 300));
        operatorPanel.setPreferredSize(operatorPanel.getMinimumSize());
        scientificPanel.setMinimumSize(new Dimension(300, 100));
        scientificPanel.setPreferredSize(scientificPanel.getMinimumSize());
        bottomPanel.setMinimumSize(new Dimension(width, height - 100));
        
        
        this.addToContainer(digitsPanel, new DigitsButton().getDigitsButtons());
        this.addToContainer(operatorPanel, new OperatorButton().getOperatorButtons());
        scientificPanel.add(list.getAnglesList());
        this.addToContainer(scientificPanel, new ScientificButtons().getScientificButtons());
        
        bottomPanel.add(digitsPanel);
        bottomPanel.add(operatorPanel);
        frame.add(textPanel);
        frame.add(scientificPanel);
        frame.add(bottomPanel);
        frame.pack(); 
    }
    void createDataMembers() {
        frame = new JFrame();
        digitsPanel = new JPanel();
        operatorPanel = new JPanel();
        scientificPanel = new JPanel();
        bottomPanel = new JPanel();
        textPanel = new JPanel();
        list = new SelectAngle();
    }
    void setLayouts() {
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.PAGE_AXIS));
        operatorPanel.setLayout(new GridLayout(4, 2));
        digitsPanel.setLayout(new GridLayout(4, 3));
        scientificPanel.setLayout(new GridLayout(3, 5));
    }
    void setFrameProperties() {
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    static void showError(String errorMessage) {
        JOptionPane.showMessageDialog(frame,
        errorMessage,
        "Error",
        JOptionPane.ERROR_MESSAGE);
        TextField.textField.setText("Invalid Syntax");
    }
    void addToContainer(JPanel container, ArrayList<JButton> buttons) {
        for (JButton btn : buttons) {
            container.add(btn);
        }
    }
}