import javax.swing.JComboBox;

public class SelectAngle {
    private String[] angles = {"Degrees", "Radians"};
    private JComboBox<String> anglesList;
    private static Boolean isDegrees = true;
    SelectAngle() {
        anglesList = new JComboBox<String>(angles);
        anglesList.setSelectedIndex(0);
        anglesList.addActionListener((e) -> {
            if(anglesList.getSelectedIndex() == 0) {
                isDegrees = true;
            }
            else {
                isDegrees = false;
            }
        });
    }
    JComboBox<String> getAnglesList() {
        return anglesList;
    }
    static Boolean getAngleUnit() {
        return isDegrees;
    }
}
