import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BodyIndexForm extends JFrame {
    private JTextField tfHeight;
    private JTextField tfWeight;
    private JButton btnCalculate;
    private JButton btnClear;
    private JLabel lShowIndex;
    private JPanel mainPanel;
    private JLabel bodyTip;

    public BodyIndexForm() {
        setContentPane(mainPanel);
        setTitle("Calculate your body index");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //Calculate button Listener
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strHeight = tfHeight.getText();
                String strWeight = tfWeight.getText();

                Double height = Double.parseDouble(strHeight);
                Double weight = Double.parseDouble(strWeight);
                Double bodyIndex = weight / (height * height);

                lShowIndex.setText("Your body index is: " + bodyIndex);

                if(bodyIndex >= 33) {
                    bodyTip.setText("You have to lost weight immediately");
                } else if(bodyIndex >= 23) {
                    bodyTip.setText("You have to control what you eat");
                } else if(bodyIndex <= 16) {
                    bodyTip.setText("You should eat better");
                } else if(bodyIndex <= 22) {
                    bodyTip.setText("You are in good shape");
                }
            }
        });

        //Clear button listener
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfHeight.setText("");
                tfWeight.setText("");
                lShowIndex.setText("");
                bodyTip.setText("");
            }
        });
    }

    public static void main(String[] args) {
        BodyIndexForm bodyIndexForm = new BodyIndexForm();
    }
}
