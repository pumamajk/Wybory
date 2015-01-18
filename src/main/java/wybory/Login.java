package wybory;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login {
		
	private JLabel zipCodeLabel;
	private JButton logButton;
    private JPanel thePanel;
    public JTextField peselJTextField;
    private JLabel peselLabel;
    
    public JButton getLogButton()
    {
    	return logButton;
    }
    
    public JPanel getPanel()
    {
    	return thePanel;
    }
    
	public Login() 
	{
		thePanel = new JPanel();
		
		thePanel.setLayout(new GridBagLayout());
		
		zipCodeLabel = new JLabel("Kod pocztowy");
		addComp(thePanel, zipCodeLabel, 0, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		
		String[] zipCodes = {"51-203", "56-234", "76-342", "87-764", "21-546"};
		
		JComboBox <String> zipCodesComboBox = new JComboBox <String> (zipCodes);
		addComp(thePanel, zipCodesComboBox, 1, 0, 2, 1,	GridBagConstraints.WEST, GridBagConstraints.NONE);
		
		peselLabel = new JLabel("Pesel");
		
		addComp(thePanel, peselLabel, 0, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

		peselJTextField = new JTextField(11);  

		peselJTextField.addKeyListener(new KeyAdapter() 
		{
			public void keyTyped(KeyEvent e) 
			{
				char c = e.getKeyChar();
				
				if ( !( ( (c >= '0') && (c <= '9') ||
							  (c == KeyEvent.VK_BACK_SPACE) ||
								  (c == KeyEvent.VK_DELETE ) ) &&
						(peselJTextField.getText().length() < 11) ) ) 
				{
					thePanel.getToolkit().beep();
					e.consume();
				}
			}
		});

		addComp(thePanel, peselJTextField, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		
		logButton = new JButton("Zaloguj");
		addComp(thePanel, logButton, 1, 3, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
	}
	
	
	private void addComp(JPanel thePanel, JComponent comp, int xPos,
			int yPos, int compWidth, int compHeight, int place, int stretch) {

		GridBagConstraints gridConstraints = new GridBagConstraints();
		
		gridConstraints.gridx = xPos;
		gridConstraints.gridy = yPos;
		gridConstraints.gridwidth = compWidth;	//ile kolumn komponent wezmie
		gridConstraints.gridheight = compHeight;	//ile rol komponent wezmie
		gridConstraints.weightx = 100;
		gridConstraints.weighty = 100;
		gridConstraints.insets = new Insets(5, 5, 5, 5);
		gridConstraints.anchor = place;
		gridConstraints.fill = stretch;
		
		thePanel.add(comp, gridConstraints);
	}	
}

//public LogButtonHandler logButtonHandler;
// jak to zrobic zeby tworzyl tylko jedna instancje