import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.MatteBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.sun.org.apache.bcel.internal.generic.LAND;

import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.SystemColor;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import java.awt.Canvas;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JProgressBar;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.SoftBevelBorder;
import java.awt.GridLayout;
import java.awt.Image;

@SuppressWarnings({"rawtypes", "unchecked" , "unused"})
public class GUI  
{

	private JFrame frmAdressbuch;
	private JPasswordField passwordField;
	private JTextField usernameField;
	private JButton loginBtn;
	private JButton hilfeBtn;
	private JPanel mainPanel;
	private JPanel loginPanel;
	private DefaultListModel listmodel= new DefaultListModel();
	private JButton logoutBtn;
	private JLabel loginMessage;
	private JMenuBar menuBar;
	private JButton btnNeu;
	private JMenuItem mntmNeu;
	private JMenuItem mntmSpeichern;
	private JMenuItem mntmLaden;
	private JTextField suche;
	private JTable table;
	private DefaultTableModel tablemodel;
	private DefaultTableModel tablemodel2;
	private String[] columns = {"Nachname","Vorname","Land","Stadt","UUID"};
	private JPanel panel;
	private JScrollPane scrollPane;
	private JPanel panel_2;
	private JButton btnDelete;
	private JButton btnRegister;
	private JMenu mnEingeloggt;
	private JMenuItem mntmLogout;
	private TableRowSorter<TableModel> sorter;
	private JTextField textField;
	private JMenuItem mntmBeenden;
	private JMenuItem mntmEinstellungen;
	private JPanel panel_1;
	private JLabel bild;
	private JLabel vorname;
	private JLabel nachname;
	private JLabel geburtsdatum;
	private JLabel firma;
	private JLabel lblAdressdaten;
	private JSeparator separator_2;
	private JPanel panel_3;
	private JLabel strasse;
	private JLabel ort;
	private JLabel land;
	private JLabel adresszusatz;
	private JLabel label_2;
	private JPanel panel_4;
	private JLabel label_3;
	private JLabel telefon;
	private JLabel email;
	private JLabel handy;
	private JLabel lblPersnlicheDaten;
	private JSeparator separator_3;
	private JPanel panel_5;
	private JLabel label_6;
	private JLabel gewicht;
	private JLabel groesse;
	private JLabel augenfarbe;
	private JLabel haarfarbe;
	private JLabel hautfarbe;
	private JLabel religion;
	private JSeparator separator_4;
	private JLabel lblNewLabel_2;
	
	public GUI() 
	{
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) 
		{
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) 
			{
		        if ("Windows".equals(info.getName())) 
		        {
		            try
					{
						UIManager.setLookAndFeel(info.getClassName());
					} catch (ClassNotFoundException e1)
					{
						// TODO Automatisch generierter Erfassungsblock
						e1.printStackTrace();
					} catch (InstantiationException e1)
					{
						// TODO Automatisch generierter Erfassungsblock
						e1.printStackTrace();
					} catch (IllegalAccessException e1)
					{
						// TODO Automatisch generierter Erfassungsblock
						e1.printStackTrace();
					} catch (UnsupportedLookAndFeelException e1)
					{
						// TODO Automatisch generierter Erfassungsblock
						e1.printStackTrace();
					}
		            break;
		        }
			}
		}
		
		initialize();
		frmAdressbuch.setVisible(true);
	}


	private void initialize() {
		frmAdressbuch = new JFrame();
		frmAdressbuch.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/resources/logo.png")));
		frmAdressbuch.setResizable(false);
		frmAdressbuch.setTitle("Adressbuch");
		frmAdressbuch.setBounds(100, 100, 800, 600);
		frmAdressbuch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdressbuch.getContentPane().setLayout(new CardLayout(0, 0));
		
		mainPanel = new JPanel();
		mainPanel.setVisible(false);
		
		loginPanel = new JPanel();
		loginPanel.setBackground(UIManager.getColor("Menu.background"));
		loginPanel.setVisible(true);
		frmAdressbuch.getContentPane().add(loginPanel, "name_943493824808102");
		loginPanel.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(308, 372, 178, 35);
		loginPanel.add(passwordField);
		
		usernameField = new JTextField();
		usernameField.setHorizontalAlignment(SwingConstants.CENTER);
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		usernameField.setBounds(308, 305, 178, 35);
		loginPanel.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel(" Login");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setIcon(new ImageIcon(GUI.class.getResource("/resources/key.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(308, 239, 178, 41);
		loginPanel.add(lblNewLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 278, 774, 2);
		loginPanel.add(separator_1);
		
		JLabel lblJbook = new JLabel("");
		lblJbook.setIcon(new ImageIcon(GUI.class.getResource("/resources/logo.png")));
		lblJbook.setHorizontalAlignment(SwingConstants.CENTER);
		lblJbook.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblJbook.setBounds(237, 0, 320, 252);
		loginPanel.add(lblJbook);
		
		JCheckBox chckbxLoginSpeichern = new JCheckBox("Login speichern");
		chckbxLoginSpeichern.setForeground(Color.BLACK);
		chckbxLoginSpeichern.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxLoginSpeichern.setBounds(308, 417, 178, 23);
		loginPanel.add(chckbxLoginSpeichern);
		
		loginBtn = new JButton("Login");
		loginBtn.setIcon(new ImageIcon(GUI.class.getResource("/resources/pfeil-rechts.png")));
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		loginBtn.setBounds(308, 452, 89, 23);
		loginPanel.add(loginBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Benutzername");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(308, 283, 178, 14);
		loginPanel.add(lblNewLabel_1);
		
		JLabel lblPasswort = new JLabel("Passwort");
		lblPasswort.setForeground(Color.BLACK);
		lblPasswort.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswort.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPasswort.setBounds(308, 351, 178, 14);
		loginPanel.add(lblPasswort);
		
		hilfeBtn = new JButton("Hilfe");
		hilfeBtn.setIcon(new ImageIcon(GUI.class.getResource("/resources/help.PNG")));
		hilfeBtn.setBounds(396, 452, 90, 23);
		loginPanel.add(hilfeBtn);
		
		loginMessage = new JLabel("Bentzername oder Passwort falsch");
		loginMessage.setVisible(false);
		loginMessage.setForeground(Color.RED);
		loginMessage.setFont(new Font("SansSerif", Font.ITALIC, 11));
		loginMessage.setHorizontalAlignment(SwingConstants.CENTER);
		loginMessage.setBounds(237, 476, 327, 16);
		loginPanel.add(loginMessage);
		
		btnRegister = new JButton("Registrieren");
		btnRegister.setIcon(new ImageIcon(GUI.class.getResource("/resources/new-user.png")));
		btnRegister.setBounds(330, 497, 134, 23);
		loginPanel.add(btnRegister);
		mainPanel.setName("");
		mainPanel.setToolTipText(null);
		mainPanel.setBackground(UIManager.getColor("InternalFrame.minimizeIconBackground"));
		frmAdressbuch.getContentPane().add(mainPanel, "name_926217422352088");
		
		JLabel lblAdressliste = new JLabel("Adressliste");
		lblAdressliste.setIcon(new ImageIcon(GUI.class.getResource("/resources/list.png")));
		lblAdressliste.setBounds(10, 6, 110, 21);
		lblAdressliste.setFont(new Font("SansSerif", Font.BOLD, 16));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(132, 16, 654, 13);
		
		btnNeu = new JButton(" Neu...");
		btnNeu.setBounds(10, 32, 96, 32);
		btnNeu.setIcon(new ImageIcon(GUI.class.getResource("/resources/plus.png")));
		btnNeu.setHorizontalAlignment(SwingConstants.LEFT);
		btnNeu.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		JButton btnBearbeiten = new JButton("Bearbeiten...");
		btnBearbeiten.setBounds(110, 32, 142, 32);
		btnBearbeiten.setHorizontalAlignment(SwingConstants.LEFT);
		btnBearbeiten.setIcon(new ImageIcon(GUI.class.getResource("/resources/edit.png")));
		btnBearbeiten.setFont(new Font("SansSerif", Font.BOLD, 14));
		mainPanel.setLayout(null);
		
		
		
		
		
		
		mainPanel.add(lblAdressliste);
		mainPanel.add(separator);
		mainPanel.add(btnNeu);
		mainPanel.add(btnBearbeiten);
		
		JButton btnSortieren = new JButton("Sortieren");
		btnSortieren.setBounds(255, 32, 126, 32);
		btnSortieren.setHorizontalAlignment(SwingConstants.LEFT);
		btnSortieren.setIcon(new ImageIcon(GUI.class.getResource("/resources/sort.png")));
		btnSortieren.setFont(new Font("SansSerif", Font.BOLD, 14));
		mainPanel.add(btnSortieren);
		
		logoutBtn = new JButton("");
		logoutBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
		logoutBtn.setIcon(new ImageIcon(GUI.class.getResource("/resources/logout.png")));
		logoutBtn.setBounds(748, 32, 38, 30);
		mainPanel.add(logoutBtn);
		
		btnDelete = new JButton("L\u00F6schen");
		btnDelete.setHorizontalAlignment(SwingConstants.LEFT);
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnDelete.setBounds(385, 32, 133, 32);
		btnDelete.setIcon(new ImageIcon(GUI.class.getResource("/resources/delete.png")));
		mainPanel.add(btnDelete);
		
		suche = new HintTextField("Suchen");
		suche.setBounds(520, 33, 227, 30);
		suche.setFont(new Font("SansSerif", Font.PLAIN, 14));
		mainPanel.add(suche);
		suche.setColumns(10);
		
		menuBar = new JMenuBar();
		menuBar.setVisible(false);
		frmAdressbuch.setJMenuBar(menuBar);
		
		JMenu mnDatei = new JMenu("Datei");
		mnDatei.setLocale(Locale.GERMAN);
		menuBar.add(mnDatei);
		
		mntmNeu = new JMenuItem("Neu");
		mntmNeu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmNeu.setHorizontalTextPosition(SwingConstants.CENTER);
		mntmNeu.setHorizontalAlignment(SwingConstants.LEFT);
		mnDatei.add(mntmNeu);
		
		mntmSpeichern = new JMenuItem("Speichern");
		mntmSpeichern.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntmSpeichern.setHorizontalAlignment(SwingConstants.LEFT);
		mnDatei.add(mntmSpeichern);
		
		mntmLaden = new JMenuItem("Laden");
		mntmLaden.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnDatei.add(mntmLaden);
		
		mntmBeenden = new JMenuItem("Beenden");
		mntmBeenden.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		mnDatei.add(mntmBeenden);
		
		JMenu mnBearbeiten = new JMenu("Bearbeiten");
		menuBar.add(mnBearbeiten);
		
		JMenu mnSuchen = new JMenu("Suchen");
		menuBar.add(mnSuchen);
		
		textField = new JTextField();
		mnSuchen.add(textField);
		textField.setColumns(10);
		
		JMenu mnHilfe = new JMenu("Hilfe");
		menuBar.add(mnHilfe);
		
		JMenuItem mntmHilfe = new JMenuItem("Hilfe");
		mntmHilfe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mntmHilfe.setHorizontalAlignment(SwingConstants.CENTER);
		mnHilfe.add(mntmHilfe);
		
		JMenuItem mntmber = new JMenuItem("\u00DCber");
		mntmber.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		mnHilfe.add(mntmber);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);
		
		mnEingeloggt = new JMenu("<html> Eingeloggt als <b>admin</b>");
		mnEingeloggt.setFont(new Font("SansSerif", Font.PLAIN, 12));
		menuBar.add(mnEingeloggt);
		
		mntmEinstellungen = new JMenuItem("Einstellungen");
		mntmEinstellungen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mnEingeloggt.add(mntmEinstellungen);
		
		mntmLogout = new JMenuItem("Logout");
		mntmLogout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mnEingeloggt.add(mntmLogout);
		
		
		tablemodel = new DefaultTableModel(0,0);
		tablemodel.setColumnIdentifiers(columns);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 504, 432);
		mainPanel.add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSurrendersFocusOnKeystroke(true);
		table.setModel(tablemodel);
		table.setDefaultEditor(Object.class, null);
		table.setVisible(true);
		
		tablemodel2 = new DefaultTableModel(0,0);
		tablemodel2.setColumnIdentifiers(columns);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Adressliste", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(59, 59, 59)));
		panel.setBounds(0, 72, 524, 470);
		mainPanel.add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Kontakt", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, Color.DARK_GRAY));
		panel_1.setBounds(530, 72, 256, 470);
		mainPanel.add(panel_1);
		panel_1.setLayout(null);
		
		bild = new JLabel("");
		bild.setHorizontalTextPosition(SwingConstants.CENTER);
		bild.setIcon(new ImageIcon(GUI.class.getResource("/resources/profile_default.png")));
		bild.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(59, 59, 59)));
		bild.setHorizontalAlignment(SwingConstants.CENTER);
		bild.setBounds(10, 22, 105, 107);
		panel_1.add(bild);
		
		vorname = new JLabel("Vorname");
		vorname.setToolTipText("Vorname");
		vorname.setHorizontalAlignment(SwingConstants.CENTER);
		vorname.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		vorname.setFont(new Font("SansSerif", Font.BOLD, 13));
		vorname.setBounds(118, 22, 132, 26);
		panel_1.add(vorname);
		
		nachname = new JLabel("Nachname");
		nachname.setToolTipText("Nachname");
		nachname.setHorizontalAlignment(SwingConstants.CENTER);
		nachname.setFont(new Font("SansSerif", Font.BOLD, 13));
		nachname.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		nachname.setBounds(118, 50, 132, 26);
		panel_1.add(nachname);
		
		geburtsdatum = new JLabel("01.01.2000");
		geburtsdatum.setToolTipText("Geburtsdatum");
		geburtsdatum.setHorizontalAlignment(SwingConstants.CENTER);
		geburtsdatum.setFont(new Font("SansSerif", Font.BOLD, 13));
		geburtsdatum.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		geburtsdatum.setBounds(118, 103, 132, 26);
		panel_1.add(geburtsdatum);
		
		firma = new JLabel("---");
		firma.setToolTipText("Firma");
		firma.setHorizontalAlignment(SwingConstants.CENTER);
		firma.setFont(new Font("SansSerif", Font.BOLD, 13));
		firma.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		firma.setBounds(118, 76, 132, 26);
		panel_1.add(firma);
		
		lblAdressdaten = new JLabel("Adressdaten");
		lblAdressdaten.setForeground(Color.DARK_GRAY);
		lblAdressdaten.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAdressdaten.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdressdaten.setBounds(10, 134, 122, 16);
		panel_1.add(lblAdressdaten);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(93, 141, 146, 9);
		panel_1.add(separator_2);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 159, 208, 84);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		strasse = new JLabel("Musterstra\u00DFe 11a");
		strasse.setToolTipText("Strasse + Hausnummer");
		strasse.setIcon(new ImageIcon(GUI.class.getResource("/resources/marker.png")));
		strasse.setFont(new Font("SansSerif", Font.BOLD, 12));
		strasse.setBounds(6, 6, 212, 16);
		panel_3.add(strasse);
		
		ort = new JLabel("33654 Musterstadt");
		ort.setToolTipText("Postleitzahl + Ort");
		ort.setIcon(new ImageIcon(GUI.class.getResource("/resources/town.png")));
		ort.setFont(new Font("SansSerif", Font.BOLD, 12));
		ort.setBounds(6, 28, 212, 16);
		panel_3.add(ort);
		
		land = new JLabel("Deutschland");
		land.setToolTipText("Land");
		land.setIcon(new ImageIcon(GUI.class.getResource("/resources/world.png")));
		land.setFont(new Font("SansSerif", Font.BOLD, 12));
		land.setBounds(6, 48, 212, 16);
		panel_3.add(land);
		
		adresszusatz = new JLabel("");
		adresszusatz.setToolTipText("");
		adresszusatz.setFont(new Font("SansSerif", Font.ITALIC, 12));
		adresszusatz.setBounds(28, 62, 212, 16);
		panel_3.add(adresszusatz);
		
		label_2 = new JLabel("");
		label_2.setToolTipText("Adressdaten");
		label_2.setIcon(new ImageIcon(GUI.class.getResource("/resources/home.png")));
		label_2.setBounds(226, 189, 24, 16);
		panel_1.add(label_2);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 248, 208, 76);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		telefon = new JLabel("01516548669");
		telefon.setToolTipText("Telefonnummer");
		telefon.setIcon(new ImageIcon(GUI.class.getResource("/resources/telephone.png")));
		telefon.setFont(new Font("SansSerif", Font.BOLD, 12));
		telefon.setBounds(6, 6, 182, 16);
		panel_4.add(telefon);
		
		email = new JLabel("max.mustermann@mail.com");
		email.setToolTipText("E-Mail");
		email.setIcon(new ImageIcon(GUI.class.getResource("/resources/at.png")));
		email.setFont(new Font("SansSerif", Font.BOLD, 12));
		email.setBounds(6, 47, 202, 20);
		panel_4.add(email);
		
		handy = new JLabel("0151655656465");
		handy.setToolTipText("Handynummer");
		handy.setIcon(new ImageIcon(GUI.class.getResource("/resources/mobile.png")));
		handy.setFont(new Font("SansSerif", Font.BOLD, 12));
		handy.setBounds(6, 27, 182, 16);
		panel_4.add(handy);
		
		label_3 = new JLabel("");
		label_3.setToolTipText("Kontaktdaten");
		label_3.setIcon(new ImageIcon(GUI.class.getResource("/resources/phone.png")));
		label_3.setBounds(226, 276, 24, 16);
		panel_1.add(label_3);
		
		lblPersnlicheDaten = new JLabel("Pers\u00F6nliche Daten");
		lblPersnlicheDaten.setHorizontalAlignment(SwingConstants.LEFT);
		lblPersnlicheDaten.setForeground(Color.DARK_GRAY);
		lblPersnlicheDaten.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPersnlicheDaten.setBounds(10, 336, 122, 16);
		panel_1.add(lblPersnlicheDaten);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(124, 343, 115, 9);
		panel_1.add(separator_3);
		
		panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(10, 364, 208, 70);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		gewicht = new JLabel("70 Kg");
		gewicht.setToolTipText("K\u00F6rpergewicht");
		gewicht.setFont(new Font("SansSerif", Font.BOLD, 12));
		gewicht.setIcon(new ImageIcon(GUI.class.getResource("/resources/scale.png")));
		gewicht.setBounds(6, 6, 65, 16);
		panel_5.add(gewicht);
		
		groesse = new JLabel("180 cm");
		groesse.setToolTipText("K\u00F6rpergr\u00F6\u00DFe");
		groesse.setIcon(new ImageIcon(GUI.class.getResource("/resources/ruler.png")));
		groesse.setFont(new Font("SansSerif", Font.BOLD, 12));
		groesse.setBounds(83, 6, 65, 16);
		panel_5.add(groesse);
		
		augenfarbe = new JLabel("Gr\u00FCn");
		augenfarbe.setToolTipText("Augenfarbe");
		augenfarbe.setIcon(new ImageIcon(GUI.class.getResource("/resources/eye.png")));
		augenfarbe.setFont(new Font("SansSerif", Font.BOLD, 12));
		augenfarbe.setBounds(6, 25, 65, 16);
		panel_5.add(augenfarbe);
		
		haarfarbe = new JLabel("Blond");
		haarfarbe.setToolTipText("Haarfarbe");
		haarfarbe.setIcon(new ImageIcon(GUI.class.getResource("/resources/hair.png")));
		haarfarbe.setFont(new Font("SansSerif", Font.BOLD, 12));
		haarfarbe.setBounds(83, 25, 65, 16);
		panel_5.add(haarfarbe);
		
		hautfarbe = new JLabel("Wei\u00DF");
		hautfarbe.setToolTipText("Hautfarbe");
		hautfarbe.setIcon(new ImageIcon(GUI.class.getResource("/resources/skincolor.png")));
		hautfarbe.setFont(new Font("SansSerif", Font.BOLD, 12));
		hautfarbe.setBounds(6, 43, 65, 16);
		panel_5.add(hautfarbe);
		
		religion = new JLabel("J\u00FCdisch");
		religion.setToolTipText("Religion");
		religion.setIcon(new ImageIcon(GUI.class.getResource("/resources/religion.png")));
		religion.setFont(new Font("SansSerif", Font.BOLD, 12));
		religion.setBounds(83, 43, 119, 16);
		panel_5.add(religion);
		
		label_6 = new JLabel("");
		label_6.setToolTipText("Pers\u00F6nliche Daten");
		label_6.setIcon(new ImageIcon(GUI.class.getResource("/resources/user.png")));
		label_6.setBounds(226, 390, 24, 16);
		panel_1.add(label_6);
		
		separator_4 = new JSeparator();
		separator_4.setBounds(10, 446, 229, 2);
		panel_1.add(separator_4);
		
		lblNewLabel_2 = new JLabel("- Kein Element Ausgew\u00E4hlt -");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_2.setBounds(575, 250, 177, 16);
		mainPanel.add(lblNewLabel_2);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(3, 29, 788, 41);
		mainPanel.add(panel_2);
		
		panel_1.setVisible(false);
		
		table.removeColumn(table.getColumnModel().getColumn(4));
		
		sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		
		
		
	}
	private void addPopup(Component component, final JPopupMenu popup) 
	{
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	void setActionListeners(ActionListener al)
	{
		loginBtn.addActionListener(al);
		hilfeBtn.addActionListener(al);
		logoutBtn.addActionListener(al);
		logoutBtn.setActionCommand("Logout");
		btnNeu.addActionListener(al);
		btnNeu.setActionCommand("Neu...");
		btnDelete.addActionListener(al);
		btnRegister.addActionListener(al);
		suche.getDocument().addDocumentListener(new DocumentListener()
		{
			
			@Override
			public void removeUpdate(DocumentEvent e)
			{
				if(!suche.getText().equals("Suchen")) filter();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e)
			{
				if(!suche.getText().equals("Suchen")) filter();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e)
			{
				if(!suche.getText().equals("Suchen")) filter();
			}
		});
		
	}
	
	void setTableData(Person pPerson)
	{
		tablemodel.addRow(new String[] {pPerson.getNachname(), pPerson.getVorname(), pPerson.getLand(), pPerson.getOrt(), pPerson.getUuid().toString()});	
	}
	
	void initTable()
	{
		
	}
	void filter() 
	{
		ArrayList<RowFilter<TableModel, Object>> filters = new ArrayList<RowFilter<TableModel,Object>>();
	    try 
	    {
	    	for (int i = 0; i<4; i++)
	    	{
	    		filters.add(RowFilter.regexFilter("(?i)" + suche.getText(), i));
	    	}  
	    } catch (java.util.regex.PatternSyntaxException e) 
	    {
	        return;
	    }
	    sorter.setRowFilter(RowFilter.orFilter(filters));
	    
	}
	
	void killTable()
	{
		table = null;
	}
	
	void setMenuListeners(ActionListener al)
	{
		mntmNeu.addActionListener(al);
		mntmSpeichern.addActionListener(al);
		mntmLaden.addActionListener(al);
		mntmLogout.addActionListener(al);
		mntmBeenden.addActionListener(al);
	}
	
	void setPreview(Person pPerson)
	{
		Image image = null;
		try
		{
			image = IOController.createImage(IOController.base64ToImage(pPerson.getBild(), pPerson.getBildFormat()), pPerson.getBildFormat());
		} catch (IOException e)
		{
			JOptionPane.showMessageDialog(getFrame(),
				    "Die Datei konnte nicht geladen werden!",
				    "Fehler beim Laden der Datei",
				    JOptionPane.ERROR_MESSAGE);
		}
		
		ImageIcon icon = new ImageIcon(image);
		
		vorname.setText(pPerson.getVorname());
		nachname.setText(pPerson.getNachname());
		firma.setText(pPerson.getFirma());
		
		String monat = Integer.toString((Person.Monat.valueOf(pPerson.getGeburtsmonat().toString()).ordinal()+1));
		if (monat.length() == 1)  monat = 0 + monat;
		
		geburtsdatum.setText(pPerson.getGeburtstag()+". "+ monat +". "+pPerson.getGeburtsjahr());
		
		strasse.setText(pPerson.getStrasse()+" "+pPerson.getHausnummer());
		ort.setText(pPerson.getPostleitzahl()+" "+pPerson.getOrt());
		land.setText(pPerson.getLand());
		adresszusatz.setText(pPerson.getAdresszusatz());
		
		telefon.setText(pPerson.getTelefon());
		handy.setText(pPerson.getTelefonMobil());
		email.setText(pPerson.getEmail());
		
		gewicht.setText(pPerson.getGewicht()+ " kg");
		groesse.setText(pPerson.getGroesse()+ " cm");
		augenfarbe.setText(pPerson.getAugenfarbe().toString());
		haarfarbe.setText(pPerson.getHaarfarbe().toString());
		hautfarbe.setText(pPerson.getHautfarbe().toString());
		religion.setText(pPerson.getReligion().toString());
		
		bild.setIcon(icon);
		
		panel_1.setVisible(true);
	}
	
	void setMenuUsername(String pUsername)
	{
		mnEingeloggt.setText("<html> Eingeloggt als <b>"+ pUsername +"</b>");
	}
	
	void setKeyListeners(KeyListener kl)
	{
		usernameField.addKeyListener(kl);
		passwordField.addKeyListener(kl);
	}
	
	void setMouseListeners(MouseAdapter ma)
	{
		table.addMouseListener(ma);
	}
	
	@SuppressWarnings("deprecation")
	public String getPassword()
	{
		return passwordField.getText();
	}
	
	public String getUsername()
	{
		return usernameField.getText();
	}
	
	void showLoginInfo()
	{
		JOptionPane.showMessageDialog(frmAdressbuch, "Standard Benutzername:     admin \nStandard Passwort:                1111");
	}
	
	void openMain()
	{
		loginPanel.setVisible(false);
		mainPanel.setVisible(true);
		menuBar.setVisible(true);
	}
	
	void openLogin()
	{
		mainPanel.setVisible(false);
		menuBar.setVisible(false);
		loginPanel.setVisible(true);	
	}
	
	void removeListElements()
	{
		listmodel.removeAllElements();
	}
	
	void removeTableElements()
	{
		int rowCount = tablemodel.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) 
		{
		    tablemodel.removeRow(i);
		}
	}
	
	void addElement(String anzeige)
	{
		listmodel.addElement(anzeige);
	}
	
	int getSelectedTableRow()
	{
		return table.getSelectedRow();
	}
	
	UUID getSelectedUUID()
	{
		return UUID.fromString(tablemodel.getValueAt(table.getSelectedRow(), 4).toString());
	}
	
	void showLoginWarning()
	{
		loginMessage.setVisible(true);
		usernameField.setBackground(Color.RED);
		passwordField.setBackground(Color.RED);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() 
		{ 
			public void run() 
			{ 
				loginMessage.setVisible(false);
				usernameField.setBackground(null);
				passwordField.setBackground(null);
			}
		},  3000);
	}
	
	JFrame getFrame()
	{
		return frmAdressbuch;
	}
	
	public JTable getTable()
	{
		return table;
	}
}
