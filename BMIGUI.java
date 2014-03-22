import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class BMIGUI extends JFrame {
  // Create text fields for interest rate, years
  // loan amount, monthly payment, and total payment
  private JTextField textField_name = new JTextField();
  private JTextField textField_age = new JTextField();
  private JTextField textField_Height = new JTextField();
  private JTextField textField_Weight = new JTextField();
  private JTextField textField_BMI = new JTextField();

  // Create a Compute Payment button
  private JButton jbtCalculateBMI = new JButton("CalculateBMI");

  public BMIGUI() {
    // Panel p1 to hold labels and text fields
    JPanel p1 = new JPanel(new GridLayout(5, 2));
    p1.add(new JLabel("name"));
    p1.add(textField_name);
    p1.add(new JLabel("age"));
    p1.add(textField_age);
    p1.add(new JLabel("Height(cm)"));
    p1.add(textField_Height);
    p1.add(new JLabel("Weight(Kg)"));
    p1.add(textField_Weight);
    p1.add(new JLabel("BMI"));
    p1.add(textField_BMI);
    p1.setBorder(new
      TitledBorder("BMI"));

    // Panel p2 to hold the button
    JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    p2.add(jbtCalculateBMI);

    // Add the panels to the frame
    add(p1, BorderLayout.CENTER);
    add(p2, BorderLayout.SOUTH);

    // Register listener
    jbtCalculateBMI.addActionListener(new ButtonListener());
  }

  /** Handle the Compute Payment button */
  private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			double height = Double.parseDouble(textField_Height.getText());
			double Weight = Double.parseDouble(textField_Weight.getText());
			double BMI = Weight/Math.pow(height*0.01,2);
			textField_BMI.setText(String.format("%.2f", BMI));
		}
	}
  
  public static void main(String[] args) {
    BMIGUI frame = new BMIGUI();
    frame.pack();
    frame.setTitle("BMI");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
