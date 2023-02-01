import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class MilesConverter extends JFrame {
    private JPanel milesPanel;
    private JLabel milesLabel;
    private JTextField milesInput;
    private JButton calculate;

    public MilesConverter(){

        setSize(310,200);
        setTitle("Miles Convertor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(600,300);

        createPanel();

        add(milesPanel);

        setVisible(true);



    }

    private void createPanel() {

        milesInput= new JTextField(10);
        milesLabel= new JLabel("Enter distance in the miles");
        calculate= new JButton("Calculate");

        calculate.addActionListener(new milesConvert());



        milesPanel= new JPanel();
        milesPanel.add(milesLabel);
        milesPanel.add(milesInput);
        milesPanel.add(calculate);

    }

    public static void main(String[] args) {
        new MilesConverter();
    }

    private class milesConvert implements ActionListener {
        @Override
       public void actionPerformed(ActionEvent e){

            calculateMiles();
            milesInput.setText("");

        }

        private void calculateMiles() {

            DecimalFormat dp= new DecimalFormat("0.00");
            final double conversion=0.6214;
            String input;
            double kilometers;

            input=milesInput.getText();
            kilometers=Double.parseDouble(input)/conversion;

            JOptionPane.showMessageDialog(null, input +" Miles is " +
                    dp.format(kilometers)+" kilometers");



        }
    }
}
