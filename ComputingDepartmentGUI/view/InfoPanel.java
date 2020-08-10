package view;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class InfoPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNumberOfLabs;
	
	public InfoPanel()
	{
		//Graphical Layouts
		setLayout(new BorderLayout()); //North, Center, West, East, South
		lblNumberOfLabs = new JLabel("Laboratories: "); //Graphical elements
		
		add(lblNumberOfLabs, BorderLayout.CENTER);
		
		TitledBorder title = new TitledBorder("Information");
		setBorder(title);
		
	}
	
	public void updateNumber(int pNumber)
	{
		lblNumberOfLabs.setText("Laboratories: " + pNumber);
		validate();
	}

}
