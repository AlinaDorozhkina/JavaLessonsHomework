import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private final JTextField textField;
    private final StringBuilder sb = new StringBuilder();
    //private JButton previousButton = new JButton();

    public ButtonListener(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton currentButton = (JButton) e.getSource();
        /*String text = currentButton.getText();
         String text2=previousButton.getText();
         if (text2.equals("+")&&text.equals("*")){
         textField.remove(previousButton);
         System.out.println("итог"+previousButton.getText());
        }
      */
        sb.append(textField.getText());

        if (!textField.getText().isBlank()) {
            sb.append(" + ");
        }

        sb.append(currentButton.getText());
        this.textField.setText(sb.toString());
        //previousButton.setText(currentButton.getText());
        sb.setLength(0);


    }
}
