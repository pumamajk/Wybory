package wybory;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class FrameManager extends JFrame{

	private static final long serialVersionUID = 1L;

	Login login;
	Kandidates kandidates; 
	JRadioButton concreteRadioButton;
	
	public FrameManager()
	{
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Wybory");
		this.setMinimumSize(new Dimension(400, 400));
		login = new Login();
		kandidates = new Kandidates();
		
		LogButtonHandler handler = new LogButtonHandler();
		login.getLogButton().addActionListener(handler);
		
		RadioHandler radioHandler = new RadioHandler();
		kandidates.firstKRadioButton.addActionListener(radioHandler);
		kandidates.secondKRadioButton.addActionListener(radioHandler);
		kandidates.thirdKRadioButton.addActionListener(radioHandler);
		kandidates.fourthKRadioButton.addActionListener(radioHandler);

		ConfirmHandler confirmHandler = new ConfirmHandler();
		kandidates.getConfirmRadioButton().addActionListener(confirmHandler);
		
		this.add(login.getPanel());
		this.pack();
	}
	
	private void changePanel(JPanel newPanel)
	{
		getContentPane().removeAll();
		getContentPane().add(newPanel);
		getContentPane().revalidate();
	}
	
	private class LogButtonHandler implements ActionListener 
	{
		public void actionPerformed(ActionEvent event) 
		{
			if (event.getSource() == login.getLogButton() && login.peselJTextField.getText().length() == 11)
			{
				PeselConfirmation peselConfirmation = new PeselConfirmation(login.peselJTextField.getText());
				
				if(peselConfirmation.isValid())
				{
					changePanel(kandidates.thePanel);		
				}
			}
		}
	}
	
	private class RadioHandler implements ActionListener 
	{	
		public void actionPerformed(ActionEvent event) 
		{	
			 concreteRadioButton = (JRadioButton) event.getSource();
		}
	}

	private class ConfirmHandler implements ActionListener 
	{
		public void actionPerformed(ActionEvent event) 
		{
			if ( event.getSource() == kandidates.getConfirmRadioButton() && ! concreteRadioButton.equals(null) )
			{
				setVisible(false);
				infoBox("Wybrales " + concreteRadioButton.getText(), "Wynik");
			}
			
		}
	
		public void infoBox(String infoMessage, String titleBar)
		{
			JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
		}		
	}
	
	
}