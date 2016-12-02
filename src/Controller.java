import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

import javax.swing.JList;

@SuppressWarnings("rawtypes")
public class Controller extends MouseAdapter implements ActionListener 
{
	private GUI gui;
	private ModelController mc;
	private String password = "1111";
	private String username = "admin";

	
	Controller() throws FileNotFoundException 
	{
		gui = new GUI();
		mc = new ModelController();
		gui.setActionListeners(this);
		gui.setMouseListeners(this);
	}
	
	void UserAuthentification(String pPassword, String pUsername)
	{
		if (pPassword.equals(password) && pUsername.equals(username))
		{
			gui.openMain();
			updateList();
		}
		else
		{
			gui.showLoginWarning();
		}
	}
	
	void updateList()
	{
		gui.removeListElements();
		
		for (int i = 0; i <mc.length(); i++)
		{
			gui.addElement(mc.getObjectAt(i).getNachname()+", "+ mc.getObjectAt(i).getVorname());
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		new Controller();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();
		if (cmd.equals("Login"))
		{
			UserAuthentification(gui.getPassword(), gui.getUsername());	
		}
		if (cmd.equals("Logout"))
		{
			gui.openLogin();
		}
		
	}
	

	public void mouseClicked(MouseEvent e)
	{
		JList liste = gui.getList(); 
		JList temp = (JList)e.getSource();
		
		if (e.getClickCount() == 2) 
		{
            int index = liste.locationToIndex(e.getPoint());
            System.out.println(mc.getObjectAt(index).getNachname());
		}
	}	
}
