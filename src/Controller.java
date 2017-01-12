
import java.awt.Color;
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
import java.util.Properties;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;

@SuppressWarnings("static-access")

/**
 * Die Controller Klasse von JBook, ein Adressverwaltungsprogramm entwickelt in Java.
 * Diese Klasse verarbeitet sämtliche Nutzereingaben und Objekte
 * 
 * @author Fynn Lohse, Bastian Wrede
 * @version 1.0 R
 *
 */


public class Controller extends MouseAdapter
{	
	private GUI gui;
	private ModelController mc;
	private InputMask im;
	private UserMask um;
	private UserManager uman;
	private SettingManager sman;
	private SettingsMask sm;
	private ActionListener menuAl;
	private ActionListener al;
	private KeyListener loginKl;
	private IOController ioc;
	private User active;
	private Settings activeSetting;
	private Color background;
	private Color font;
	private int activeIndex;

	
	/**
	 * Konstruktor der Klasse Controller. 
	 * 
	 * @throws FileNotFoundException
	 */
	
	Controller() throws FileNotFoundException 
	{	
		mc = new ModelController();
		uman = new UserManager();
		sman = new SettingManager();
		ioc =  new IOController();
		background = Color.GRAY;
		font = Color.BLACK;
		activeSetting = new Settings();
		
		boolean notLoaded = false;
		
		try
		{
			loadSetting();
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException
				| NoSuchPaddingException | IOException e)
		{
			notLoaded = true;
			e.printStackTrace();
		}
		
		try 
		{
			Properties props;
			switch (activeSetting.getLaf())
			{
			case "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel":
				props = new Properties();
				props.put("logoString", "");
				AluminiumLookAndFeel.setCurrentTheme(props);
				break;
			case "com.jtattoo.plaf.acryl.AcrylLookAndFeel":
				props = new Properties();
				props.put("logoString", "");
				AcrylLookAndFeel.setCurrentTheme(props);
				break;
			case "com.jtattoo.plaf.aero.AeroLookAndFeel":
				props = new Properties();
				props.put("logoString", "");
				AeroLookAndFeel.setCurrentTheme(props);
				break;
			case "com.jtattoo.plaf.hifi.HiFiLookAndFeel":
				props = new Properties();
				props.put("logoString", "");
				HiFiLookAndFeel.setCurrentTheme(props);
				break;
			case "com.jtattoo.plaf.graphite.GraphiteLookAndFeel":
				props = new Properties();
				props.put("logoString", "");
				GraphiteLookAndFeel.setCurrentTheme(props);
				break;
			}
			UIManager.setLookAndFeel(activeSetting.getLaf());
			
		} catch (Exception e) 
		{
			try
			{
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			}
			catch (Exception e2) 
			{
				try
				{
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e3)
				{
						e3.printStackTrace();
				}
			}
		}

		gui = new GUI();
		
		if (notLoaded) JOptionPane.showMessageDialog(null,
			    "Es konnten keine Einstellungen geladen werden. \n"
			    + "Ist dies der erste Start des Programms?");
		
		
		if (!(activeSetting.getLaf().contains("com.jtattoo.plaf")||activeSetting.getLaf().contains("com.seaglasslookandfeel"))) changeColors(activeSetting.getBgColor(), activeSetting.getFontColor());
		gui.setMouseListeners(this);
		initLoginKeyListener();
		initMenuActionListener();
		initActionListener();
		
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
	
	/**
	 *  Methode Aktualisiert die Tabelle in der GUI
	 */
	
	void updateList()
	{
		gui.removeTableElements();
		for (int i = 0; i <mc.length(); i++)
		{
			gui.setTableData(mc.getObjectAt(i));
		}
		
	}
	
	/**
	 *  main-Methode von JBook. Erstellt eine Controller Instanz
	 * 
	 * @param args Kommandozeilenparameter
	 * @throws IOException
	 */
	
	public static void main(String[] args) throws IOException
	{
		new Controller();
	}
	
	/**
	 *  Methode überprüft Passwort und Nutzername und sorgt ggf. für eine Warnung in der GUI
	 */
	
	void authentification()
	{
		if (uman.userAuthentification(gui.getPassword(), gui.getUsername()))
		{
			active = uman.getObjectAt(uman.indexOf(gui.getUsername()));
			gui.openMain();
		}
		else
		{
			gui.showLoginWarning(Color.WHITE);
		}
	}
	
	/**
	 * Methoder instanziert den ActionListener
	 */

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
						JOptionPane.showMessageDialog(gui.getFrame(),
							    "Es konnte kein Speicherstand geladen werden! \n",
							    "Fehler beim Laden der Datei",
							    JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
					
				}
				
				if (cmd.equals("Logout"))
				{
					gui.openLogin();
					mc.removeListElements();
					updateList();
					if (!gui.getCheckBoxStatus()) gui.removeLoginContent();
					active = null;
				}
				
				if (cmd.equals("Neu..."))
				{
					im = new InputMask(gui.getFrame());
					im.setActionListeners(al);
					if (!(activeSetting.getLaf().contains("com.jtattoo.plaf")||activeSetting.getLaf().contains("com.seaglasslookandfeel"))) im.setPanelColor(im.getFrame(),activeSetting.getBgColor(), activeSetting.getFontColor());
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
					if (im.getRemoveOnClose()) mc.removeObjectAt(activeIndex);
					mc.sortIn(im.getNewPerson());
					im.dispose();
					updateList();
				}
				
				if (cmd.equals("Löschen"))
				{
					try
					{
						if (!mc.isEmpty())
						{
							//Damit Error vor Dialog auftritt
							mc.indexOf(gui.getSelectedUUID());
							
							int reply = JOptionPane.showConfirmDialog(gui.getFrame(), "Möchten Sie den Kontakt wirklich löschen?", "Löschen", JOptionPane.YES_NO_OPTION);
					       
						 	if (reply == JOptionPane.YES_OPTION) 
					        {
						 		mc.removeObjectAt(mc.indexOf(gui.getSelectedUUID()));
								updateList();
					        }
						 	gui.setPreviewVisible(false);;
						}
					}
					catch (IndexOutOfBoundsException e1)
					{
						JOptionPane.showMessageDialog(gui.getFrame(),
							    "Kein Element ausgewählt!",
							    "Löschen nicht möglich",
							    JOptionPane.ERROR_MESSAGE);
					}
					
				}
				if (cmd.equals("Registrieren"))
				{
					um = new UserMask(gui.getFrame());
					um.setPanelColor(um.getFrame(), activeSetting.getBgColor(), activeSetting.getFontColor());
					um.setActionListeners(al);
				}
				
				if (cmd.equals("save"))
				{
					if (active != null) uman.removeUser(active.getUsername());
					if (um.isPasswordCorrect() && !uman.isInList(um.getNewUser().getUsername()) && um.isUserName3())
					{
						
						uman.sortIn(um.getNewUser());
						try
						{
							saveUser();
						} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
								| IllegalBlockSizeException | BadPaddingException | IOException e1)
						{
							JOptionPane.showMessageDialog(gui.getFrame(),
								    "Die Benutzer konnten nicht gespeichert werden!",
								    "Fehler beim Speichern der Datei",
								    JOptionPane.ERROR_MESSAGE);
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
					
					try
					{
						if (um.getLabelTitle().equals("Benutzerdaten ändern")) active = uman.getObjectAt(uman.indexOf(active.getUsername()));
						if (um.getLabelTitle().equals("Benutzerdaten ändern")) saveList();
						System.out.println("Gespeichert");
						
					} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
							| IllegalBlockSizeException | BadPaddingException | IOException e1)
					{
						JOptionPane.showMessageDialog(gui.getFrame(),
							    "Die Datei konnte nicht gespeichert werden!",
							    "Fehler beim Speichern der Datei",
							    JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					} catch (NullPointerException e2)
					{
						e2.printStackTrace();
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
							
				    		im.setImage(ioc.readImage(chooser.getSelectedFile(), ext), ext);
				    		im.setImageButton(chooser.getSelectedFile().getName());
						} catch (IOException e1)
						{
							JOptionPane.showMessageDialog(gui.getFrame(),
								    "Die Datei konnte nicht geladen werden!",
								    "Fehler beim Laden der Datei",
								    JOptionPane.ERROR_MESSAGE);
						}
				    }
				}
				
				if (cmd.equals("Import"))
				{
					JFileChooser chooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("VCard File" ,"vcf");
				    chooser.setFileFilter(filter);
				    int returnVal = chooser.showOpenDialog(im.getFrame());
				    if(returnVal == JFileChooser.APPROVE_OPTION) 
				    {
						try
						{
							Person neu =  ioc.importVCard(chooser.getSelectedFile());
							im.setData(neu);
						} catch (FileNotFoundException e1)
						{
							JOptionPane.showMessageDialog(gui.getFrame(),
								    "Die Datei konnte nicht geladen werden!",
								    "Fehler beim Laden der Datei",
								    JOptionPane.ERROR_MESSAGE);
						}
				    }
				}
				
				if (cmd.equals("UserSettings"))
				{
					um = new UserMask(gui.getFrame());
					um.setUsernameEditable(false);
					um.setFieldData(active.getUsername(), active.getPassword());
					um.setActionListeners(al);
					if (!(activeSetting.getLaf().contains("com.jtattoo.plaf")||activeSetting.getLaf().contains("com.seaglasslookandfeel"))) um.setPanelColor(um.getFrame(), activeSetting.getBgColor(), activeSetting.getFontColor());
					um.setLabelTitle("Benutzerdaten ändern");
				}
				
				if (cmd.equals("closeSettings"))
				{
					sm.dispose();
				}
				
				if (cmd.equals("BG"))
				{
					background = JColorChooser.showDialog(gui.getFrame(), "Wähle eine Farbe aus", Color.decode("#d6d9df"));
					sm.setBgColorLabel(background);
				}
				
				if (cmd.equals("Font"))
				{
					font = JColorChooser.showDialog(gui.getFrame(), "Wähle eine Farbe aus", Color.BLACK);
					sm.setFontColorLabel(font);
				}
				
				if (cmd.equals("saveSettings"))
				{

					activeSetting.setBgColor(sman.getThemes()[sm.getSelectedThemeIndex()].getBgColor());
					activeSetting.setFontColor(sman.getThemes()[sm.getSelectedThemeIndex()].getFontColor());
					activeSetting.setThemeName(sm.getTheme());
					
					if (sm.getTheme().equals("Eigene")) 
					{
						activeSetting.setBgColor(background);
						activeSetting.setFontColor(font);
					}
					activeSetting.setLaf(sm.getLaf());
					
					int reply = JOptionPane.showConfirmDialog(gui.getFrame(), "Damit die Änderungen Wirksam werden muss das Programm neugestartet werden.\n"
							+ "Soll das Programm jetzt neugestartet werden?", "Neustart benötigt", JOptionPane.YES_NO_OPTION);
				       
				 	
					
					if (!(activeSetting.getLaf().contains("com.jtattoo.plaf")||activeSetting.getLaf().contains("com.seaglasslookandfeel"))) changeColors(background,font);

					try
					{
						saveSetting();
					} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
							| IllegalBlockSizeException | BadPaddingException | IOException e1)
					{
						
						JOptionPane.showMessageDialog(gui.getFrame(),
							    "Die Einstellungen konnten nicht gespeichert werden!",
							    "Fehler beim Speichern der Datei",
							    JOptionPane.ERROR_MESSAGE);
					}
					
					sm.dispose();
					
					if (reply == JOptionPane.YES_OPTION) 
			        {
				 		try
						{
				 			try
							{
								saveList();
								System.out.println("Gespeichert");
							} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
									| IllegalBlockSizeException | BadPaddingException | IOException e1)
							{
								JOptionPane.showMessageDialog(gui.getFrame(),
									    "Die Datei konnte nicht gespeichert werden!",
									    "Fehler beim Speichern der Datei",
									    JOptionPane.ERROR_MESSAGE);
							} catch (NullPointerException e2)
							{
								JOptionPane.showMessageDialog(gui.getFrame(),
									    "Die Datei konnte nicht gespeichert werden! \n"
									    + "Es sind keine Elemente zum Speichern vorhanden!",
									    "Fehler beim Speichern der Datei",
									    JOptionPane.ERROR_MESSAGE);
							}
							gui.disposeGUI();
							new Controller();
						} catch (FileNotFoundException e1)
						{
							JOptionPane.showMessageDialog(gui.getFrame(),
								    "Das Programm konnte nicht neugestartet werden!",
								    "Fehler beim Neustarten",
								    JOptionPane.ERROR_MESSAGE);
						}
			        }
				}
				
				if (cmd.equals("Edit"))
				{
					try
					{
						im = new InputMask(gui.getFrame());
						im.setActionListeners(al);
						im.setMode("Bearbeiten", true);
						if (!(activeSetting.getLaf().contains("com.jtattoo.plaf")||activeSetting.getLaf().contains("com.seaglasslookandfeel"))) im.setPanelColor(im.getFrame(),activeSetting.getBgColor(), activeSetting.getFontColor());
						activeIndex = mc.indexOf(gui.getSelectedUUID());
						Person temp = (mc.getObjectAt(activeIndex));
						im.setData(temp);
						updateList();
						im.setVisible(true);
						gui.setPreviewVisible(false);
					}
					catch (IndexOutOfBoundsException e1)
					{
						JOptionPane.showMessageDialog(gui.getFrame(),
							    "Kein Element ausgewählt!",
							    "Bearbeiten nicht möglich",
							    JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		};
		gui.setActionListeners(al);
	}
	
	/**
	 * Methode instanziert die ActionListener für die Menüleiste
	 */
	
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
						JOptionPane.showMessageDialog(gui.getFrame(),
							    "Die Datei konnte nicht gespeichert werden!",
							    "Fehler beim Speichern der Datei",
							    JOptionPane.ERROR_MESSAGE);
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
					if (!(activeSetting.getLaf().contains("com.jtattoo.plaf")||activeSetting.getLaf().contains("com.seaglasslookandfeel"))) im.setPanelColor(im.getFrame(),activeSetting.getBgColor(), activeSetting.getFontColor());
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
					if (!gui.getCheckBoxStatus()) gui.removeLoginContent();
					active = null;
				}
				
				if (cmd.equals("Beenden"))
				{
					System.exit(0);
				}
				
				if (cmd.equals("Einstellungen"))
				{
					sm = new SettingsMask(gui.getFrame());
					if (!(activeSetting.getLaf().contains("com.jtattoo.plaf")||activeSetting.getLaf().contains("com.seaglasslookandfeel"))) sm.setPanelColor(sm.getFrame(), activeSetting.getBgColor(), activeSetting.getFontColor());
					sm.setBgColorLabel(activeSetting.getBgColor());
					sm.setFontColorLabel(activeSetting.getFontColor());
					sm.setActionListeners(al);
					sm.setSelected(activeSetting.getLaf(),activeSetting.getThemeName());
				}
				
				if (cmd.equals("Import"))
				{
					JFileChooser chooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("VCard File" ,"vcf");
				    chooser.setFileFilter(filter);
				    int returnVal = chooser.showOpenDialog(gui.getFrame());
				    if(returnVal == JFileChooser.APPROVE_OPTION) 
				    {
						try
						{
							Person neu =  ioc.importVCard(chooser.getSelectedFile());
							mc.sortIn(neu);
							updateList();
						} catch (FileNotFoundException e1)
						{
							JOptionPane.showMessageDialog(gui.getFrame(),
								    "Die Datei konnte nicht geladen werden!",
								    "Fehler beim Laden der Datei",
								    JOptionPane.ERROR_MESSAGE);
						} catch (IndexOutOfBoundsException e2)
						{
							JOptionPane.showMessageDialog(gui.getFrame(),
								    "Fehlerhafte VCard Datei!",
								    "Fehler beim Laden der Datei",
								    JOptionPane.ERROR_MESSAGE);
						}
				    }
				}
				
				if (cmd.equals("Export"))
				{
					
					try
					{
						//Damit Error vor Dialog auftritt
						mc.indexOf(gui.getSelectedUUID());
						
						JFileChooser chooser = new JFileChooser();
					    chooser.setCurrentDirectory(new File("C:\\"));
					    int retrival = chooser.showSaveDialog(gui.getFrame());
					    if (retrival == JFileChooser.APPROVE_OPTION) 
					    {
					    	try
							{
								ioc.createVCard(mc.getObjectAt(mc.indexOf(gui.getSelectedUUID())), chooser.getSelectedFile()+".vcf");
							} catch (IOException e1)
							{
								JOptionPane.showMessageDialog(gui.getFrame(),
									    "Die Datei konnte nicht gespeichert werden!",
									    "Fehler beim Speichern der Datei",
									    JOptionPane.ERROR_MESSAGE);
							}
					    }
					}
				    catch (IndexOutOfBoundsException e1)
					{
						JOptionPane.showMessageDialog(gui.getFrame(),
							    "Kein Element ausgewählt!",
							    "Exportieren nicht möglich",
							    JOptionPane.ERROR_MESSAGE);
					}
				}
				
				if (cmd.equals("Entfernen"))
				{
					try
					{
						if (!mc.isEmpty())
						{
							//Damit Error vor Dialog auftritt
							mc.indexOf(gui.getSelectedUUID());
							
							int reply = JOptionPane.showConfirmDialog(gui.getFrame(), "Möchten Sie den Kontakt wirklich löschen?", "Löschen", JOptionPane.YES_NO_OPTION);
					       
						 	if (reply == JOptionPane.YES_OPTION) 
					        {
						 		mc.removeObjectAt(mc.indexOf(gui.getSelectedUUID()));
								updateList();
					        }
						 	gui.setPreviewVisible(false);;
						}
					}
					catch (IndexOutOfBoundsException e1)
					{
						JOptionPane.showMessageDialog(gui.getFrame(),
							    "Kein Element ausgewählt!",
							    "Löschen nicht möglich",
							    JOptionPane.ERROR_MESSAGE);
					}
				}
				
				if (cmd.equals("Alles entfernen"))
				{
					try
					{
						if (!mc.isEmpty())
						{
							
							int reply = JOptionPane.showConfirmDialog(gui.getFrame(),"Möchten Sie wirklich alle Kontakte löschen?", "Löschen", JOptionPane.YES_NO_OPTION);
					       
						 	if (reply == JOptionPane.YES_OPTION) 
					        {
						 		mc.removeListElements();
					        }
						 	updateList();
						 	gui.setPreviewVisible(false);;
						}
					}
					catch (IndexOutOfBoundsException e1)
					{
						JOptionPane.showMessageDialog(gui.getFrame(),
							    "Kein Element ausgewählt!",
							    "Löschen nicht möglich",
							    JOptionPane.ERROR_MESSAGE);
					}
				}
				
				if (cmd.equals("Über"))
				{
					new CreditsMask();
				}
				
				if (cmd.equals("Bearbeiten"))
				{
					im = new InputMask(gui.getFrame());
					im.setActionListeners(al);
					im.setMode("Bearbeiten", true);
					if (!(activeSetting.getLaf().contains("com.jtattoo.plaf")||activeSetting.getLaf().contains("com.seaglasslookandfeel"))) im.setPanelColor(im.getFrame(),activeSetting.getBgColor(), activeSetting.getFontColor());
					activeIndex = mc.indexOf(gui.getSelectedUUID());
					Person temp = (mc.getObjectAt(activeIndex));
					im.setData(temp);
					updateList();
					im.setVisible(true);
					gui.setPreviewVisible(false);
				}

			}
		};
		gui.setMenuListeners(menuAl);
	}
	
	/**
	 * Methode instanziert den KeyListener für das Login-Fenster
	 */
	
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

			public void keyReleased(KeyEvent e)
			{
				
			}

			public void keyTyped(KeyEvent e)
			{
				
			}
		};
		
		gui.setKeyListeners(loginKl);
	}
	
	public void mouseClicked(MouseEvent e)
	{
		System.out.println(mc.getObjectAt(mc.indexOf(gui.getSelectedUUID())).getNachname());
		gui.setPreview(mc.getObjectAt(mc.indexOf(gui.getSelectedUUID())));
		
		if (e.getClickCount() == 2) 
		{
			im = new InputMask(gui.getFrame());
			im.setActionListeners(al);
			im.setMode("Bearbeiten", true);
			if (!(activeSetting.getLaf().contains("com.jtattoo.plaf")||activeSetting.getLaf().contains("com.seaglasslookandfeel"))) im.setPanelColor(im.getFrame(),activeSetting.getBgColor(), activeSetting.getFontColor());
			im.setVisible(true);
			activeIndex = mc.indexOf(gui.getSelectedUUID());
			Person temp = (mc.getObjectAt(activeIndex));
			im.setData(temp);
			updateList();
			
			gui.setPreviewVisible(false);
		}
	}
	
	/**
	 * Methode speichert alle Kontakte in eine Datei
	 * 
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws IOException
	 */
	
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
		
		
		ioc.closeWriteStream();
	}
	
	/**
	 * Methode liest Kontakte aus Datei
	 * 
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IOException
	 */
	
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
	
	/**
	 * Methode speicher Nutzer in Datei
	 * 
	 * @throws InvalidKeyException
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws IOException
	 */
	
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
	
	/**
	 * Methode liest Nutzer aus Datei
	 * 
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IOException
	 */
	
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
	
	/**
	 * Methode speichert Einstellungen in Datei
	 * 
	 * @throws InvalidKeyException
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws IOException
	 */
	
	void saveSetting() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException
	{
		ioc.initSettingsWriter();
		ioc.saveSettingsToFile(activeSetting);
	}
	
	/**
	 * Methode liest Einstellungen aus Datei
	 * 
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IOException
	 */
	
	void loadSetting() throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, IOException
	{
		ioc.initSettingsReader();
		activeSetting = ioc.readSettings();
	}
	
	/**
	 * Methode setzt benutzerdefinierte Farben für die Haupt-GUI Elemente
	 * 
	 * @param bg Hintergrundfarbe
	 * @param font Textfarbe
	 */
	
	void changeColors(Color bg, Color font)
	{
		gui.setPanelColor(gui.getFrame(),bg, font);
	}
}
	


