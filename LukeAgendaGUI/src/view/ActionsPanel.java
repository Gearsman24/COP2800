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
	public final static String ADD = "to add";
	public final static String REMOVE = "please remove";
	public final static String SEARCH = "search!";
	public final static String UPDATE = "change number";
	
	
	private JButton btnAdd;
	private JButton btnRemove;
	private JButton btnSearch;
	private JButton btnUpdate;
	
	private Frame frame;
	
	public ActionsPanel(Frame pFrame)
	{
		frame = pFrame;
		setLayout(new GridLayout(4,1));
		
		btnAdd = new JButton("Add Friend");
		btnAdd.setActionCommand(ADD);
		btnAdd.addActionListener(this);
		
		btnRemove = new JButton("Remove Friend");
		btnRemove.setActionCommand(REMOVE);
		btnRemove.addActionListener(this);
		
		btnSearch = new JButton("Search Friend");
		btnSearch.setActionCommand(SEARCH);
		btnSearch.addActionListener(this);
		
		btnUpdate = new JButton("Update #");
		btnUpdate.setActionCommand(UPDATE);
		btnUpdate.addActionListener(this);
		
		add(btnAdd);
		add(btnRemove);
		add(btnSearch);
		add(btnUpdate);
		
		TitledBorder title = new TitledBorder("Actions");
		setBorder(title);
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		String command = event.getActionCommand();
		
		if(command.equals(ADD))
		{
			frame.requestAdding();
		}
		else if(command.contentEquals(REMOVE))
		{
			frame.requestRemoval();
		}
		else if(command.equals(SEARCH))
		{
			frame.requestSearching();
		}
		else if(command.equals(UPDATE))
		{
			frame.requestUpdate();
		}
		
	}
}
