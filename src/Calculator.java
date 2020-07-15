import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {

    public Calculator() {

        setTitle("Calculator");
        setBounds(200, 200, 400, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);


        // создаю цвета для цифр и знаков и шрифт
        Color numeralColor = new Color(225, 234, 234);
        Color signColor = new Color(197, 201, 201);
        Font font = new Font("Verdana", Font.ITALIC, 22);

        setLayout(new BorderLayout());

        // создаю поле для ввода и получения результата
        JTextField textField = new JTextField(25);
        textField.setBackground(new Color(252, 255, 255));
        textField.setPreferredSize(new Dimension(40, 40));
        textField.setFont(font);
        add(textField, BorderLayout.NORTH);


        ButtonListener buttonListener = new ButtonListener(textField);

        // создаю панель c кнопками для циферблата
        JPanel panel = new JPanel(new GridLayout(0, 3));
        JButton[] numberButtons = new JButton[10];
        for (int i = 1; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setForeground(new Color(14, 0, 0));
            numberButtons[i].setBackground(numeralColor);
            numberButtons[i].setFont(font);
            numberButtons[i].addActionListener(buttonListener);
            panel.add(numberButtons[i]);
        }

        // Создаю кнопку сброса одного знака
        JButton buttonC = new JButton("C");
        buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = textField.getText();
                if (temp.length() > 0) {
                    textField.setText(temp.substring(0, temp.length() - 1));
                    System.out.println(temp);
                }
            }
        });
        buttonC.setFont(font);
        buttonC.setBackground(signColor);
        panel.add(buttonC);

        // создаю кнопку 0
        JButton buttonZero = new JButton("0");
        buttonZero.addActionListener(buttonListener);
        buttonZero.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(buttonZero);

        buttonZero.setBackground(numeralColor);
        JButton buttonEmpty = new JButton(" ");
        buttonEmpty.setFont(font);
        buttonEmpty.setBackground(signColor);
        panel.add(buttonEmpty);


        // создаю панель с кнопками -математическими символами
        JPanel panel1 = new JPanel(new GridLayout(4, 1));
        panel1.setPreferredSize(new Dimension(100, 100));

        JButton buttonDev = new JButton("/");
        buttonDev.setBackground(signColor);
        buttonDev.setFont(font);
        buttonDev.addActionListener(buttonListener);

        JButton buttonMul = new JButton("*");
        buttonMul.setFont(font);
        buttonMul.setBackground(signColor);
        buttonMul.addActionListener(buttonListener);

        JButton buttonSub = new JButton("-");
        buttonSub.setBackground(signColor);
        buttonSub.setFont(font);
        buttonSub.addActionListener(buttonListener);

        JButton buttonSum = new JButton("+");
        buttonSum.setFont(font);
        buttonSum.setBackground(signColor);
        buttonSum.addActionListener(buttonListener);


        add(panel);
        add(panel1, BorderLayout.EAST);
        panel1.add(buttonDev);
        panel1.add(buttonMul);
        panel1.add(buttonSub);
        panel1.add(buttonSum);

        // создаю кнопку результат вычитания
        JButton buttonResult = new JButton("=");
        buttonResult.setFont(font);
        //buttonResult.setBackground(signColor);
        buttonResult.setPreferredSize(new Dimension(40, 40));
        buttonResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ScriptEngineManager manager = new ScriptEngineManager();
                ScriptEngine engine = manager.getEngineByName("js");
                String textResult = textField.getText();
                try {
                    Object object = engine.eval(textResult);
                    textField.setText(object.toString());
                } catch (ScriptException scriptException) {
                    scriptException.printStackTrace();
                }

            }
        });

        add(buttonResult, BorderLayout.SOUTH);
        setVisible(true);
    }
}




