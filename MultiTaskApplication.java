import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class MultiTaskApplication extends JFrame {

    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] operatorButtons;
    private JButton equalButton, clearButton;
    private String operator;
    private double firstOperand, secondOperand;

    private JTextArea textArea;
    private JTextField fileNameTextField;
    private JButton saveButton;

    private JPanel drawingPanel;

    public MultiTaskApplication() {
        setTitle("Multi Task Application");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel calculatorPanel = new JPanel();
        calculatorPanel.setLayout(new GridLayout(4, 4));
        textField = new JTextField();
        calculatorPanel.add(textField, BorderLayout.NORTH);

        numberButtons = new JButton[10];
        operatorButtons = new JButton[4];
        String[] operators = {"+", "-", "*", "/"};
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(new CalculatorActionListener());
            calculatorPanel.add(numberButtons[i]);
        }

        for (int i = 0; i < 4; i++) {
            operatorButtons[i] = new JButton(operators[i]);
            operatorButtons[i].addActionListener(new CalculatorActionListener());
            calculatorPanel.add(operatorButtons[i]);
        }

        equalButton = new JButton("=");
        equalButton.addActionListener(new CalculatorActionListener());
        clearButton = new JButton("C");
        clearButton.addActionListener(new CalculatorActionListener());
        calculatorPanel.add(equalButton);
        calculatorPanel.add(clearButton);

        add(calculatorPanel, BorderLayout.NORTH);

        JPanel filePanel = new JPanel();
        textArea = new JTextArea(5, 40);
        fileNameTextField = new JTextField(20);
        saveButton = new JButton("Save to File");
        saveButton.addActionListener(new FileSaveListener());

        filePanel.add(new JLabel("Enter File Name:"));
        filePanel.add(fileNameTextField);
        filePanel.add(new JScrollPane(textArea));
        filePanel.add(saveButton);

        add(filePanel, BorderLayout.CENTER);

        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.fillRect(100, 100, 200, 150); 
            }
        };
        drawingPanel.setBackground(Color.WHITE);
        drawingPanel.setPreferredSize(new Dimension(600, 200));
        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

            }
        });
        drawingPanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

                repaint();
            }
        });

        add(drawingPanel, BorderLayout.SOUTH);
    }

    private class CalculatorActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.charAt(0) == 'C') {
                textField.setText("");
                firstOperand = secondOperand = 0;
                operator = "";
            } else if (command.charAt(0) == '=') {
                secondOperand = Double.parseDouble(textField.getText());

                switch (operator) {
                    case "+":
                        textField.setText(String.valueOf(firstOperand + secondOperand));
                        break;
                    case "-":
                        textField.setText(String.valueOf(firstOperand - secondOperand));
                        break;
                    case "*":
                        textField.setText(String.valueOf(firstOperand * secondOperand));
                        break;
                    case "/":
                        textField.setText(String.valueOf(firstOperand / secondOperand));
                        break;
                }
                operator = "";
            } else {
                if (operator.isEmpty()) {
                    firstOperand = Double.parseDouble(textField.getText());
                }
                operator = command;
                textField.setText("");
            }
        }
    }

    private class FileSaveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String fileName = fileNameTextField.getText();
            String content = textArea.getText();

            try {
                FileWriter writer = new FileWriter(fileName);
                writer.write(content);
                writer.close();
                JOptionPane.showMessageDialog(null, "File saved successfully!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error saving file: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MultiTaskApplication app = new MultiTaskApplication();
            app.setVisible(true);
        });
    }
}
