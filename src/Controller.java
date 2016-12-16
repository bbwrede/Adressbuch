import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;
import javax.swing.JTable;

@SuppressWarnings("rawtypes")
public class Controller extends MouseAdapter
{	
	private GUI gui;
	private ModelController mc;
	private String  password = "1111";
	private String username = "admin";
	private InputMask im;
	private UserMask um;
	private UserManager uman;
	private ActionListener menuAl;
	private ActionListener al;
	private KeyListener loginKl;
	private IOController ioc;
	private User active;

	
	Controller() throws FileNotFoundException 
	{
		gui = new GUI();
		mc = new ModelController();
		ioc =  new IOController();
		uman = new UserManager();
		initLoginKeyListener();
		initMenuActionListener();
		initActionListener();
		gui.setMouseListeners(this);
		
		try
		{
			saveUser();
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException | IOException e1)
		{
			// TODO Automatisch generierter Erfassungsblock
			e1.printStackTrace();
		}
		
		
		
		try
		{
			loadUser();
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException
				| NoSuchPaddingException | IOException e)
		{
			// TODO Automatisch generierter Erfassungsblock
			e.printStackTrace();
		}
		
		updateList();
		
	}
	
	
	void updateList()
	{
		gui.removeTableElements();
		for (int i = 0; i <mc.length(); i++)
		{
			gui.setTableData(mc.getObjectAt(i));
		}
		
	}
	
	public static void main(String[] args) throws IOException
	{
		new Controller();
	}

	void authentification()
	{
		if (uman.userAuthentification(gui.getPassword(), gui.getUsername()))
		{
			active = uman.getObjectAt(uman.indexOf(gui.getUsername()));
			gui.openMain();
		}
		else
		{
			gui.showLoginWarning();
		}
	}

	void initActionListener()
	{
		al = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String cmd = e.getActionCommand();
				if (cmd.equals("Login"))
				{
					authentification();
				}
				
				if (cmd.equals("Logout"))
				{
					gui.openLogin();
					active = null;
				}
				
				if (cmd.equals("Neu..."))
				{
					im = new InputMask(gui.getFrame());
					im.setActionListeners(al);
					im.setVisible(true);
				}
				
				if (cmd.equals("Hilfe"))
				{
					gui.showLoginInfo();
				}
				
				if (cmd.equals("X"))
				{
					im.dispose();
				}
				
				if (cmd.equals("quit"))
				{
					um.dispose();
				}
				
				if (cmd.equals("Erweitert..."))
				{
					im.openAdvanced();
				}
				
				if (cmd.equals("Zur�ck..."))
				{
					im.openMain();
				}
				
				if (cmd.equals("Speichern"))
				{
					mc.sortIn(im.getNewPerson());
					im.dispose();
					updateList();
					gui.initTable();
				}
				
				if (cmd.equals("L�schen"))
				{
						int reply = JOptionPane.showConfirmDialog(null, "M�chten Sie den Kontakt wirklich l�schen?", "L�schen", JOptionPane.YES_NO_OPTION);
				       
					 	if (reply == JOptionPane.YES_OPTION) 
				        {
					 		mc.removeObjectAt(gui.getSelectedTableRow());
							updateList();
				        }
					
				}
				if (cmd.equals("Registrieren"))
				{
					um = new UserMask(gui.getFrame());
					um.setActionListeners(al);
				}
				
				if (cmd.equals("save"))
				{
					if (um.isPasswordCorrect() && !uman.isInList(um.getNewUser().getUsername()) && um.isUserName3())
					{
						uman.sortIn(um.getNewUser());
						um.dispose();
					}
					if (uman.isInList(um.getNewUser().getUsername()) || !um.isUserName3())
					{
						um.usernameIcon(true);
					}
					else
					{
						um.usernameIcon(false);
					}
					
					if(!um.isPasswordCorrect())
					{
						um.passwordIcon(true);
						um.pwCheckIcon(true);
					}
					else
					{
						um.passwordIcon(false);
						um.pwCheckIcon(false);
					}
					
					try
					{
						saveUser();
					} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
							| IllegalBlockSizeException | BadPaddingException | IOException e1)
					{
						// TODO Automatisch generierter Erfassungsblock
						e1.printStackTrace();
					}
				}
			}
		};
		gui.setActionListeners(al);
	}
	
	void initMenuActionListener()
	{
		menuAl = new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				String cmd = e.getActionCommand();
				
				if (cmd.equals("Speichern"))
				{
					try
					{
						saveList();
						System.out.println("Gespeichert");
					} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
							| IllegalBlockSizeException | BadPaddingException | IOException e1)
					{
						// TODO Automatisch generierter Erfassungsblock
						e1.printStackTrace();
					}
				}
				
				if (cmd.equals("Neu"))
				{
					im = new InputMask(gui.getFrame());
					im.setActionListeners(al);
					im.setVisible(true);
				}
				
				if (cmd.equals("Laden"))
				{
					try
					{
						loadList();
						System.out.println("Geladen");
					} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException
							| NoSuchAlgorithmException | NoSuchPaddingException | IOException e1)
					{
						// TODO Automatisch generierter Erfassungsblock
						e1.printStackTrace();
					}
				}

			}
		};
		gui.setMenuListeners(menuAl);
	}
	
	void initLoginKeyListener()
	{
		loginKl = new KeyListener()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				int key = e.getKeyCode();
				
				if (key == KeyEvent.VK_ENTER)
				{
					authentification();	
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
				// TODO Automatisch generierter Methodenstub
				
			}

			@Override
			public void keyTyped(KeyEvent e)
			{
				// TODO Automatisch generierter Methodenstub
				
			}
		};
		
		gui.setKeyListeners(loginKl);
	}
	
	public void mouseClicked(MouseEvent e)
	{
		JTable table = (JTable)e.getSource();
		int index = 0;
		
		if (e.getClickCount() == 2) 
		{
           index = table.getSelectedRow();
           System.out.println(mc.getObjectAt(index).getNachname());
		}
	}
	
	void saveList() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException
	{
		ioc.setUserInfo(active.getUsername(), active.getPassword());
		ioc.initWriter();
		
		List<Person> temp = mc.getList();
		temp.toFirst();
		while (temp.hasAccess())
		{
			ioc.saveToFile(temp.getContent());
			temp.next();
		}
		
		ioc.createVCard(mc.getObjectAt(0));
		
		ioc.closeWriteStream();
	}
	
	void loadList() throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, IOException
	{
		ioc.setUserInfo(active.getUsername(), active.getPassword());
		mc.removeListElements();
		
		System.out.println("hier");
		ioc.initReader();
		
		int number = ioc.getLines();
		number = number/24;
		
	
		for (int i = 0; i < number; i++)
		{
			mc.sortIn(ioc.readPerson());
		}
		
		updateList();
		
	}
	
	void saveUser() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException
	{
		ioc.initUserWriter();
		List<User> temp = uman.getList();
		
		temp.toFirst();
		while(temp.hasAccess())
		{
			ioc.saveUserToFile(temp.getContent());
			temp.next();
		}
		
		ioc.closeUserWriteStream();
	}
	
	void loadUser() throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, IOException
	{
		
		ioc.initUserReader();
		uman.removeListElements();
		
		int number = ioc.getUserLines();
		number = number/3;
		
	
		for (int i = 0; i < number; i++)
		{
			uman.sortIn(ioc.readUser());
		}

	}
}
	


