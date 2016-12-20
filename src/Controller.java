import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("rawtypes")
public class Controller extends MouseAdapter
{	
	private GUI gui;
	private ModelController mc;
	private String password = "1111";
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
		uman = new UserManager();
		ioc =  new IOController();
		initLoginKeyListener();
		initMenuActionListener();
		initActionListener();
		gui.setMouseListeners(this);
		
		try
		{
			loadUser();
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException
				| NoSuchPaddingException | IOException e)
		{
			JOptionPane.showMessageDialog(gui.getFrame(),
			    "Es konnten keine Nutzer geladen werden. \n"
			    + "Ist dies der erste Start des Programms?");
		}
		
		if (!uman.isInList("admin"))
		{
			uman.initAdmin();
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
					gui.setMenuUsername(active.getUsername());
					try
					{
						loadList();
						System.out.println("Geladen");
					} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException
							| NoSuchAlgorithmException | NoSuchPaddingException | IOException e1)
					{
						/*JOptionPane.showMessageDialog(gui.getFrame(),
							    "Es konnte kein Speicherstand geladen werden! \n",
							    "Fehler beim Laden der Datei",
							    JOptionPane.ERROR_MESSAGE);*/
						e1.printStackTrace();
					}
					
				}
				
				if (cmd.equals("Logout"))
				{
					gui.openLogin();
					mc.removeListElements();
					updateList();
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
				
				if (cmd.equals("Zurück..."))
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
				
				if (cmd.equals("Löschen"))
				{
						if (!mc.isEmpty())
						{
							int reply = JOptionPane.showConfirmDialog(gui.getFrame(), "Möchten Sie den Kontakt wirklich löschen?", "Löschen", JOptionPane.YES_NO_OPTION);
					       
						 	if (reply == JOptionPane.YES_OPTION) 
					        {
						 		mc.removeObjectAt(gui.getSelectedTableRow());
								updateList();
					        }
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
						try
						{
							saveUser();
						} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
								| IllegalBlockSizeException | BadPaddingException | IOException e1)
						{
							// TODO Automatisch generierter Erfassungsblock
							e1.printStackTrace();
						}
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
					
				}
				
				if (cmd.equals("Bild..."))
				{
					JFileChooser chooser = new JFileChooser();
				    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg", "gif", "png");
				    chooser.setFileFilter(filter);
				    int returnVal = chooser.showOpenDialog(im.getFrame());
				    if(returnVal == JFileChooser.APPROVE_OPTION) 
				    {
				    	try
						{
							File selc = chooser.getSelectedFile();
							
							String ext = selc.getName().substring(selc.getName().lastIndexOf("."));
							ext = ext.toLowerCase();
							ext = ext.substring(1);
							//System.out.println(ext);
				    		im.setImage(ioc.readImage(chooser.getSelectedFile()), ext);
				    		im.setImageButton(chooser.getSelectedFile().getName());
						} catch (IOException e1)
						{
							// TODO Automatisch generierter Erfassungsblock
							e1.printStackTrace();
						}
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
					} catch (NullPointerException e2)
					{
						JOptionPane.showMessageDialog(gui.getFrame(),
							    "Die Datei konnte nicht gespeichert werden! \n"
							    + "Es sind keine Elemente zum Speichern vorhanden!",
							    "Fehler beim Speichern der Datei",
							    JOptionPane.ERROR_MESSAGE);
						e2.printStackTrace();
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
							| NoSuchAlgorithmException | NoSuchPaddingException e1)
					{
						JOptionPane.showMessageDialog(gui.getFrame(),
							    "Die Datei konnte nicht geladen werden! \n"
							    + "Wurde zuvor gespeichert?",
							    "Fehler beim Laden der Datei",
							    JOptionPane.ERROR_MESSAGE);
					} catch (FileNotFoundException e2)
					{
						e2.printStackTrace();
					} catch (IOException e3)
					{
						JOptionPane.showMessageDialog(gui.getFrame(),
							    "Die Datei konnte nicht geladen werden!",
							    "Fehler beim Laden der Datei",
							    JOptionPane.ERROR_MESSAGE);
					}
				}
				
				if (cmd.equals("Logout"))
				{
					gui.openLogin();
					mc.removeListElements();
					updateList();
					active = null;
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
					gui.setMenuUsername(active.getUsername());
					try
					{
						loadList();
						System.out.println("Geladen");
					} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException
							| NoSuchAlgorithmException | NoSuchPaddingException | IOException e1)
					{
						JOptionPane.showMessageDialog(gui.getFrame(),
							    "Es konnte kein Speicherstand geladen werden! \n",
							    "Fehler beim Laden der Datei",
							    JOptionPane.ERROR_MESSAGE);
					}
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
		number = number/27;
	
		System.out.println(number);
	
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
	


