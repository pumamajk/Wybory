package wybory;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Kandidates 
{	
	public JPanel thePanel;
	
	JRadioButton firstKRadioButton, secondKRadioButton, thirdKRadioButton, fourthKRadioButton; 	
	JRadioButton concreteRadioButton;

	private JButton confirmButton;
	
	public JRadioButton getConcreteRadioButton()
	{
		return concreteRadioButton;
	}
	
	public JButton getConfirmRadioButton()
	{
		return confirmButton;
	}
	
	public Kandidates() 
	{
		thePanel = new JPanel();
		thePanel.setLayout(new GridBagLayout());
	
		Box klientBox = Box.createVerticalBox();
		
		firstKRadioButton = new JRadioButton("Kandydat nr 1");
		secondKRadioButton = new JRadioButton("Kandydat nr 2");
		thirdKRadioButton = new JRadioButton("Kandydat nr 3");
		fourthKRadioButton = new JRadioButton("Kandydat nr 4");
				
		ButtonGroup klientGroup = new ButtonGroup();
		klientGroup.add(firstKRadioButton);
		klientGroup.add(secondKRadioButton);
		klientGroup.add(thirdKRadioButton);
		klientGroup.add(fourthKRadioButton);
		
		klientBox.add(firstKRadioButton);
		klientBox.add(secondKRadioButton);
		klientBox.add(thirdKRadioButton);
		klientBox.add(fourthKRadioButton);
		klientBox.setBorder(BorderFactory.createTitledBorder("Kandydaci"));
		
		addComp(thePanel, klientBox, 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		
		confirmButton = new JButton("Zatwierdz");
	
		addComp(thePanel, confirmButton, 0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
	}

	private void addComp(JPanel thePanel, JComponent comp, int xPos,
			int yPos, int compWidth, int compHeight, int place, int stretch) {

		GridBagConstraints gridConstraints = new GridBagConstraints();
		
		gridConstraints.gridx = xPos;
		gridConstraints.gridy = yPos;
		gridConstraints.gridwidth = compWidth;	
		gridConstraints.gridheight = compHeight;	
		gridConstraints.weightx = 100;
		gridConstraints.weighty = 100;
		gridConstraints.insets = new Insets(5, 5, 5, 5);
		gridConstraints.anchor = place;
		gridConstraints.fill = stretch;
		
		thePanel.add(comp, gridConstraints);	
	}
}

//pamietac zeby sprawdzic multiple panels
// sprawdzic czy mozna pozniej zmienic
// thePanel.setLayout(new GridBagLayout());
// na 
// thePanel.setLayout(new GridLayout());
// //pamietac zeby sprawdzic multiple panels
// sprawdzic czy mozna pozniej zmienic
// thePanel.setLayout(new GridBagLayout());
// na 
// thePanel.setLayout(new GridLayout());
// 

//zrobic jeszcze jakis exception jesli command bedzie pusty
// stworzyc osobna klase ktora bedzie przechwytywac tylko actionCommand i Zatwierdz nie bêdzie mia³ tam dostêpu
