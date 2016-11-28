import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Controller implements ActionListener
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
		
	}
	
	void UserAuthentification(String pPassword, String pUsername)
	{
		if (pPassword.equals(password) && pUsername.equals(username))
		{
			gui.openMain();
			updateList();
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
		Controller contrl = new Controller();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();
		if (cmd.equals("Login"))
		{
			UserAuthentification(gui.getPassword(), gui.getUsername());	
		}
		
	}
		
}
