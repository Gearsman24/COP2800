package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ActionsPanel extends JPanel implements ActionListener //Graphical Containers
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static String ADDLAB = "to add lab";
	public final static String ADDRESEARCHER = "to add researcher";
	public final static String YOUNGEST = "to find youngest researcher";
	public final static String AVERAGE = "to find average age";
	public final static String OLDER = "to find older researchers";
	public final static String POPULATED = "to find most populated lab";
	
	
	private JButton btnLab;
	private JButton btnResearcher;
	private JButton btnYoungest;
	private JButton btnAverage;
	private JButton btnOlder;
	private JButton btnPopulated;
	
	private Frame frame;
	
	public ActionsPanel(Frame pFrame)
	{
		frame = pFrame;
		setLayout(new GridLayout(4,1));
		
		btnLab = new JButton("Add Lab");
		btnLab.setActionCommand(ADDLAB);
		btnLab.addActionListener(this);
		
		btnResearcher = new JButton("Add Researcher");
		btnResearcher.setActionCommand(ADDRESEARCHER);
		btnResearcher.addActionListener(this);
		
		btnYoungest = new JButton("Find Youngest");
		btnYoungest.setActionCommand(YOUNGEST);
		btnYoungest.addActionListener(this);
		
		btnAverage = new JButton("Find Average Age");
		btnAverage.setActionCommand(AVERAGE);
		btnAverage.addActionListener(this);
		
		btnOlder = new JButton("Find Older");
		btnOlder.setActionCommand(OLDER);
		btnOlder.addActionListener(this);
		
		btnPopulated = new JButton("Find Most Populated");
		btnPopulated.setActionCommand(POPULATED);
		btnPopulated.addActionListener(this);
		
		
		add(btnLab);
		add(btnResearcher);
		add(btnYoungest);
		add(btnAverage);
		add(btnOlder);
		add(btnPopulated);
		
		TitledBorder title = new TitledBorder("Actions");
		setBorder(title);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String command = e.getActionCommand();
		
		if(command.equals(ADDLAB))
		{
			frame.requestLab();
		}
		else if(command.contentEquals(ADDRESEARCHER))
		{
			frame.requestResearcher();
		}
		else if(command.equals(YOUNGEST))
		{
			frame.requestYoungest();
		}
		else if(command.equals(AVERAGE))
		{
			frame.requestAverage();
		}
		else if(command.contentEquals(OLDER))
		{
			frame.requestOlder();
		}
		else if(command.contentEquals(POPULATED))
		{
			frame.requestPopulated();
		}
		
	}

	
}
