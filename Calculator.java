import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    // Components
    private JTextField display;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[9];
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decPointButton, equButton, delButton, clrButton, negButton;
    private JPanel panel;

    // Variables for calculation
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    // Fonts and dimensions
    private Font font = new Font("Arial", Font.PLAIN, 30);
    private Dimension buttonSize = new Dimension(80, 80);
    private Dimension displaySize = new Dimension(300, 80);

    public Calculator() {
        // Set up frame
        setTitle("Java Calculator");
        setSize(420, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null); // Center on screen

        // Create display
        display = new JTextField();
        display.setBounds(30, 25, 360, 50);
        display.setFont(font);
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display);

        // Initialize function buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decPointButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decPointButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        // Set up function buttons
        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setFocusable(false);
        }

        // Initialize number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
            numberButtons[i].setFocusable(false);
        }

        // Set button bounds and add to frame
        negButton.setBounds(30, 100, 80, 50);
        delButton.setBounds(130, 100, 80, 50);
        clrButton.setBounds(230, 100, 80, 50);
        divButton.setBounds(330, 100, 80, 50);

        mulButton.setBounds(330, 170, 80, 50);
        subButton.setBounds(330, 240, 80, 50);
        addButton.setBounds(330, 310, 80, 50);
        equButton.setBounds(330, 380, 80, 120);
        decPointButton.setBounds(130, 450, 80, 50);

        // Number buttons layout (like a calculator)
        numberButtons[7].setBounds(30, 170, 80, 50);
        numberButtons[8].setBounds(130, 170, 80, 50);
        numberButtons[9].setBounds(230, 170, 80, 50);

        numberButtons[4].setBounds(30, 240, 80, 50);
        numberButtons[5].setBounds(130, 240, 80, 50);
        numberButtons[6].setBounds(230, 240, 80, 50);

        numberButtons[1].setBounds(30, 310, 80, 50);
        numberButtons[2].setBounds(130, 310, 80, 50);
        numberButtons[3].setBounds(230, 310, 80, 50);

        numberButtons[0].setBounds(30, 380, 180, 50);

        // Add components to frame
        for (int i = 0; i < 10; i++) {
            add(numberButtons[i]);
        }

        add(negButton);
        add(delButton);
        add(clrButton);
        add(divButton);
        add(mulButton);
        add(subButton);
        add(addButton);
        add(decPointButton);
        add(equButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle number buttons
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText().concat(String.valueOf(i)));
            }
        }

        // Handle decimal point
        if (e.getSource() == decPointButton) {
            display.setText(display.getText().concat("."));
        }

        // Handle operators
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        }

        // Handle equals
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(display.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        display.setText("Error");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }

            display.setText(String.valueOf(result));
            num1 = result;
        }

        // Handle clear
        if (e.getSource() == clrButton) {
            display.setText("");
        }

        // Handle delete
        if (e.getSource() == delButton) {
            String currentText = display.getText();
            if (!currentText.isEmpty()) {
                display.setText(currentText.substring(0, currentText.length() - 1));
            }
        }

        // Handle negative/positive toggle
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(display.getText());
            temp *= -1;
            display.setText(String.valueOf(temp));
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}