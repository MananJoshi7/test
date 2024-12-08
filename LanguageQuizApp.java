import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LanguageQuizApp {
    public static void main(String[] args) {
        // Create a JFrame for the application window
        JFrame frame = new JFrame("Identify Non-OOP Language");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create radio buttons for C++, Java, and Pascal
        JRadioButton cppButton = new JRadioButton("C++");
        JRadioButton javaButton = new JRadioButton("Java");
        JRadioButton pascalButton = new JRadioButton("Pascal");

        // Group the radio buttons to ensure only one can be selected at a time
        ButtonGroup group = new ButtonGroup();
        group.add(cppButton);
        group.add(javaButton);
        group.add(pascalButton);

        // Add the radio buttons to the panel
        panel.add(cppButton);
        panel.add(javaButton);
        panel.add(pascalButton);

        // Create a button to submit the choice
        JButton submitButton = new JButton("Submit");
        panel.add(submitButton);

        // Create a label to display the result
        JLabel resultLabel = new JLabel("");
        panel.add(resultLabel);

        // Action listener for the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check which radio button is selected and display result
                if (cppButton.isSelected()) {
                    resultLabel.setText("Correct! C++ is not purely OOP.");
                } else if (javaButton.isSelected()) {
                    resultLabel.setText("Wrong! Java is an OOP language.");
                } else if (pascalButton.isSelected()) {
                    resultLabel.setText("Wrong! Pascal is not fully OOP.");
                } else {
                    resultLabel.setText("Please select an option.");
                }
            }
        });

        // Add the panel to the frame and set the frame visible
        frame.add(panel);
        frame.setVisible(true);
    }
}
