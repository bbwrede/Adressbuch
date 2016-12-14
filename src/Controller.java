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
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JTable;

@SuppressWarnings("rawtypes")
public class Controller extends MouseAdapter
{	
	private GUI gui;
	private ModelController mc;
	private String  password = "1111";
	private String username = "admin";
	private InputMask im;
	private ActionListener menuAl;
	private ActionListener al;
	private KeyListener loginKl;
	private IOController ioc = new IOController(username, password);

	
	Controller() throws FileNotFoundException 
	{
		gui = new GUI();
		mc = new ModelController();
		initLoginKeyListener();
		initMenuActionListener();
		initActionListener();
		gui.setMouseListeners(this);
		updateList();
		
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
		gui.removeTableElements();
		for (int i = 0; i <mc.length(); i++)
		{
			gui.setTableData(mc.getObjectAt(i));
		}
		
	}
	
	
	void gupdateList()
	{
		gui.removeListElements();
		
		for (int i = 0; i <mc.length(); i++)
		{
			gui.addElement(mc.getObjectAt(i).getNachname()+", "+ mc.getObjectAt(i).getVorname());
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		new Controller();
		createVCard("Wrede","Bastian","016494949459959","bbwrede@gmail.com");
	
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
					UserAuthentification(gui.getPassword(), gui.getUsername());	
				}
				if (cmd.equals("Logout"))
				{
					gui.openLogin();
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
					UserAuthentification(gui.getPassword(), gui.getUsername());	
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
		ioc.initWriter();
		List<Person> temp = mc.getList();
		temp.toFirst();
		while (temp.hasAccess())
		{
			ioc.saveToFile(temp.getContent());
			temp.next();
		}
		
		ioc.closeWriteStream();
	}
	
	void loadList() throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, IOException
	{
		
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
	
	
	//VCard
	static void createVCard(String pName, String pVorname, String pTel, String pEmail) {
		BufferedWriter VCardbw = null;
		FileWriter VCardfw = null;

		try {

			/* Test:
			 * String name = "Wrede";
			*  String vorname ="Bastian";
			*  String tel = "+49-404-555-1212\;
			*  String email ="bbwrede@gmail.com";
			*/
			
			VCardfw = new FileWriter(System.getProperty("user.dir")+"\\VCard\\"+pName+".vcf");
			VCardbw = new BufferedWriter(VCardfw);
			
			VCardbw.write("BEGIN:VCARD\n");
			VCardbw.write("VERSION:4.0\n");
			VCardbw.write("N:"+pName+"\n");
			VCardbw.write("FN:"+ pVorname+"\n");
			VCardbw.write("TEL;TYPE=home,voice;VALUE=uri:tel:"+ pTel+"\n");
			VCardbw.write("EMAIL:"+pEmail+"\n");
			VCardbw.write("END:VCARD\n");
			

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (VCardbw != null)
					VCardbw.close();

				if (VCardfw != null)
					VCardfw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}
		
		
	}
	


