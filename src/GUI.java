import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Dimension;

/**
 * Die GUIKlasse von JBook, ein Adressverwaltungsprogramm entwickelt in Java.
 * Diese Klasse ist für die Darstellung der Hauptelemente verantwortlich. 
 * 
 * @author Fynn Lohse, Bastian Wrede
 * @version 1.0 R
 *
 */

@SuppressWarnings({"rawtypes", "unused"})
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
	private String[] columns = {"Nachname","Vorname","Land","Stadt","Geburtsdatum","Geburtsmonat","Geburtstag","Geburtsjahr","Augenfarbe","Haarfarbe","Hautfarbe",
			"E-Mail","Straße","Telefon","Handy","Firma","Religion","UUID"};
	private JPanel panel;
	private JScrollPane scrollPane;
	private JPanel panel_2;
	private JButton btnDelete;
	private JButton btnRegister;
	private JMenu mnEingeloggt;
	private JMenuItem mntmLogout;
	private TableRowSorter<TableModel> sorter;
	private JTextField menuSearch;
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
	private JLabel geschlecht;
	private JLabel lblAdressliste_1;
	private JLabel lblKontakt;
	private JCheckBox checkbox;
	private JButton btnBearbeiten;
	private JMenuItem mntmBearbeiten;
	private JMenuItem mntmLschen;
	private JSeparator separator_5;
	private JMenuItem mntmAllesLschen;
	private JSeparator separator_6;
	private JMenuItem mntmImport;
	private JMenuItem mntmExport;
	private JSeparator separator_7;
	private JMenuItem mntmber;
	private JMenuItem mntmHilfe;
	
	/**
	 * Konstruktor von GUI
	 */
	
	public GUI() 
	{
		initialize();
		frmAdressbuch.setVisible(true);
	}

	/**
	 * Methode instanziert GUI Elemente
	 */

	private void initialize() {
		frmAdressbuch = new JFrame();
		frmAdressbuch.setPreferredSize(new Dimension(1366, 630));
		frmAdressbuch.setMinimumSize(new Dimension(540, 630));
		frmAdressbuch.setMaximumSize(new Dimension(1366, 768));
		frmAdressbuch.setForeground(Color.RED);
		frmAdressbuch.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/resources/logo.png")));
		frmAdressbuch.setTitle("Adressbuch");
		frmAdressbuch.setBounds(100, 100, 810, 630);
		frmAdressbuch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdressbuch.getContentPane().setLayout(new CardLayout(0, 0));
		
		mainPanel = new JPanel();
		mainPanel.setMaximumSize(new Dimension(1366, 768));
		mainPanel.setVisible(false);
		
		loginPanel = new JPanel();
		loginPanel.setMaximumSize(new Dimension(1366, 768));
		loginPanel.setBackground(UIManager.getColor("Menu.background"));
		loginPanel.setVisible(true);
		frmAdressbuch.getContentPane().add(loginPanel, "name_943493824808102");
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		usernameField = new JTextField();
		usernameField.setHorizontalAlignment(SwingConstants.CENTER);
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		usernameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel(" Login");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setIcon(new ImageIcon(GUI.class.getResource("/resources/key.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel lblJbook = new JLabel("");
		lblJbook.setIcon(new ImageIcon(GUI.class.getResource("/resources/logo.png")));
		lblJbook.setHorizontalAlignment(SwingConstants.CENTER);
		lblJbook.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		checkbox = new JCheckBox("Login speichern");
		checkbox.setForeground(Color.BLACK);
		checkbox.setHorizontalAlignment(SwingConstants.CENTER);
		
		loginBtn = new JButton("Login");
		loginBtn.setIcon(new ImageIcon(GUI.class.getResource("/resources/pfeil-rechts.png")));
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNewLabel_1 = new JLabel("Benutzername:");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setForeground(Color.BLACK);
		lblPasswort.setHorizontalAlignment(SwingConstants.LEFT);
		lblPasswort.setHorizontalTextPosition(SwingConstants.CENTER);
		
		hilfeBtn = new JButton("Hilfe");
		hilfeBtn.setPreferredSize(new Dimension(59, 28));
		hilfeBtn.setIcon(new ImageIcon(GUI.class.getResource("/resources/help.PNG")));
		
		loginMessage = new JLabel("Bentzername oder Passwort falsch");
		loginMessage.setVisible(false);
		loginMessage.setForeground(Color.RED);
		loginMessage.setFont(new Font("SansSerif", Font.ITALIC, 11));
		loginMessage.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnRegister = new JButton("Registrieren");
		btnRegister.setMaximumSize(new Dimension(120, 38));
		btnRegister.setMinimumSize(new Dimension(50, 10));
		btnRegister.setIcon(new ImageIcon(GUI.class.getResource("/resources/new-user.png")));
		GroupLayout gl_loginPanel = new GroupLayout(loginPanel);
		gl_loginPanel.setHorizontalGroup(
			gl_loginPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_loginPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_loginPanel.createSequentialGroup()
							.addGap(302)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
							.addGap(287))
						.addGroup(gl_loginPanel.createSequentialGroup()
							.addGap(231)
							.addComponent(lblJbook, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
							.addGap(216))
						.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE))
					.addGap(14))
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addGap(308)
					.addComponent(usernameField, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
					.addGap(301))
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addGap(237)
					.addComponent(loginMessage, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(230, Short.MAX_VALUE))
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addGap(308)
					.addComponent(loginBtn, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(hilfeBtn, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(301))
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addGap(308)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(301, Short.MAX_VALUE))
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addGap(308)
					.addGroup(gl_loginPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPasswort, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
					.addGap(301))
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addGap(270)
					.addComponent(checkbox, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(339, Short.MAX_VALUE))
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addGap(310)
					.addComponent(btnRegister, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
					.addGap(301))
		);
		gl_loginPanel.setVerticalGroup(
			gl_loginPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addGroup(gl_loginPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_loginPanel.createSequentialGroup()
							.addGap(239)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblJbook, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_loginPanel.createSequentialGroup()
							.addGap(278)
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(3)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblPasswort, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(checkbox, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_loginPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginBtn)
						.addComponent(hilfeBtn, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(1)
					.addComponent(loginMessage, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(53))
		);
		loginPanel.setLayout(gl_loginPanel);
		mainPanel.setName("");
		mainPanel.setToolTipText(null);
		mainPanel.setBackground(UIManager.getColor("InternalFrame.minimizeIconBackground"));
		frmAdressbuch.getContentPane().add(mainPanel, "name_926217422352088");
		
		JLabel lblAdressliste = new JLabel("Adressliste");
		lblAdressliste.setIcon(new ImageIcon(GUI.class.getResource("/resources/list.png")));
		lblAdressliste.setFont(new Font("SansSerif", Font.BOLD, 16));
		
		JSeparator separator = new JSeparator();
		
		lblAdressliste_1 = new JLabel("Adressliste");
		lblAdressliste_1.setForeground(Color.DARK_GRAY);
		lblAdressliste_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		menuBar = new JMenuBar();
		menuBar.setVisible(false);
		frmAdressbuch.setJMenuBar(menuBar);
		
		JMenu mnDatei = new JMenu("Datei");
		mnDatei.setIcon(null);
		mnDatei.setLocale(Locale.GERMAN);
		menuBar.add(mnDatei);
		
		mntmNeu = new JMenuItem("Neu");
		mntmNeu.setIcon(null);
		mntmNeu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmNeu.setHorizontalTextPosition(SwingConstants.CENTER);
		mntmNeu.setHorizontalAlignment(SwingConstants.LEFT);
		mnDatei.add(mntmNeu);
		
		mntmSpeichern = new JMenuItem("Speichern");
		mntmSpeichern.setIcon(null);
		mntmSpeichern.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntmSpeichern.setHorizontalAlignment(SwingConstants.LEFT);
		mnDatei.add(mntmSpeichern);
		
		mntmLaden = new JMenuItem("Laden");
		mntmLaden.setIcon(null);
		mntmLaden.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnDatei.add(mntmLaden);
		
		separator_7 = new JSeparator();
		mnDatei.add(separator_7);
		
		mntmImport = new JMenuItem("Import");
		mntmImport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnDatei.add(mntmImport);
		
		mntmExport = new JMenuItem("Export");
		mntmExport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mnDatei.add(mntmExport);
		
		separator_6 = new JSeparator();
		mnDatei.add(separator_6);
		
		mntmBeenden = new JMenuItem("Beenden");
		mntmBeenden.setIcon(null);
		mntmBeenden.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		mnDatei.add(mntmBeenden);
		
		JMenu mnBearbeiten = new JMenu("Bearbeiten");
		menuBar.add(mnBearbeiten);
		
		mntmBearbeiten = new JMenuItem("Bearbeiten");
		mntmBearbeiten.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		mnBearbeiten.add(mntmBearbeiten);
		
		mntmLschen = new JMenuItem("Entfernen");
		mntmLschen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
		mnBearbeiten.add(mntmLschen);
		
		separator_5 = new JSeparator();
		mnBearbeiten.add(separator_5);
		
		mntmAllesLschen = new JMenuItem("Alles entfernen");
		mntmAllesLschen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, InputEvent.CTRL_MASK));
		mnBearbeiten.add(mntmAllesLschen);
		
		JMenu mnSuchen = new JMenu("Suchen");
		menuBar.add(mnSuchen);
		
		menuSearch = new JTextField();
		mnSuchen.add(menuSearch);
		menuSearch.setColumns(10);
		
		JMenu mnHilfe = new JMenu("Hilfe");
		menuBar.add(mnHilfe);
		
		mntmHilfe = new JMenuItem("Hilfe");
		mntmHilfe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mntmHilfe.setHorizontalAlignment(SwingConstants.CENTER);
		mnHilfe.add(mntmHilfe);
		
		mntmber = new JMenuItem("\u00DCber");
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
		panel.setBorder(new TitledBorder(null, " ", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(59, 59, 59)));
		
		lblKontakt = new JLabel("Kontakt");
		lblKontakt.setForeground(Color.DARK_GRAY);
		lblKontakt.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setBorder(new TitledBorder(null, " ", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(64, 64, 64)));
		panel_1.setLayout(null);
		
		bild = new JLabel("");
		bild.setToolTipText("Image");
		bild.setHorizontalTextPosition(SwingConstants.CENTER);
		bild.setIcon(new ImageIcon(GUI.class.getResource("/resources/profile_default.png")));
		bild.setBorder(new LineBorder(Color.DARK_GRAY));
		bild.setHorizontalAlignment(SwingConstants.CENTER);
		bild.setBounds(10, 22, 100, 100);
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
		panel_5.setBounds(10, 364, 208, 84);
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
		haarfarbe.setBounds(83, 25, 119, 16);
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
		
		geschlecht = new JLabel("---");
		geschlecht.setIcon(new ImageIcon(GUI.class.getResource("/resources/gender.png")));
		geschlecht.setToolTipText("Geschlecht");
		geschlecht.setFont(new Font("SansSerif", Font.BOLD, 12));
		geschlecht.setBounds(6, 62, 152, 16);
		panel_5.add(geschlecht);
		
		label_6 = new JLabel("");
		label_6.setToolTipText("Pers\u00F6nliche Daten");
		label_6.setIcon(new ImageIcon(GUI.class.getResource("/resources/user.png")));
		label_6.setBounds(226, 390, 24, 16);
		panel_1.add(label_6);
		
		separator_4 = new JSeparator();
		separator_4.setBounds(10, 450, 229, 2);
		panel_1.add(separator_4);
		
		lblNewLabel_2 = new JLabel("- Kein Element Ausgew\u00E4hlt -");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		btnNeu = new JButton(" Neu...");
		btnNeu.setIcon(new ImageIcon(GUI.class.getResource("/resources/plus.png")));
		btnNeu.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		btnBearbeiten = new JButton("Bearbeiten...");
		btnBearbeiten.setIcon(new ImageIcon(GUI.class.getResource("/resources/edit.png")));
		btnBearbeiten.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		btnDelete = new JButton("L\u00F6schen");
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnDelete.setIcon(new ImageIcon(GUI.class.getResource("/resources/delete.png")));
		
		suche = new HintTextField("Suchen");
		suche.setFont(new Font("SansSerif", Font.PLAIN, 14));
		suche.setColumns(10);
		
		logoutBtn = new JButton("");
		logoutBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
		logoutBtn.setIcon(new ImageIcon(GUI.class.getResource("/resources/logout.png")));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(btnNeu, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
					.addGap(2)
					.addComponent(btnBearbeiten, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
					.addGap(2)
					.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
					.addGap(2)
					.addComponent(suche, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
					.addGap(2)
					.addComponent(logoutBtn, GroupLayout.PREFERRED_SIZE, 38, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(btnNeu)
				.addComponent(btnBearbeiten)
				.addComponent(btnDelete)
				.addComponent(suche, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
				.addComponent(logoutBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
		);
		panel_2.setLayout(gl_panel_2);
		
		lblKontakt.setVisible(false);
		panel_1.setVisible(false);
		
		for (int i = 5; i < 18; i++)
		{
			table.getColumnModel().getColumn(i).setMinWidth(0);
			table.getColumnModel().getColumn(i).setMaxWidth(0);
		}
		
		sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
		gl_mainPanel.setHorizontalGroup(
			gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblAdressliste, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
					.addGap(8))
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addGap(10)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
							.addGap(10))
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addGap(218)
							.addComponent(lblAdressliste_1, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
							.addGap(218))
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE))
					.addGap(6)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addGap(84)
							.addComponent(lblKontakt, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addGap(45)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE))
					.addGap(5))
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addGap(3)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 791, Short.MAX_VALUE))
		);
		gl_mainPanel.setVerticalGroup(
			gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAdressliste)
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addGap(10)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addGap(24)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
							.addGap(14))
						.addComponent(lblAdressliste_1)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
						.addComponent(lblKontakt)
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addGap(178)
							.addComponent(lblNewLabel_2))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE))
					.addGap(5))
		);
		mainPanel.setLayout(gl_mainPanel);
		
		
	}
	
	/**
	 * Methode erstellt PopUp für die Menüleiste
	 * 
	 * @param component Die Quellkomponente
	 * @param popup Das Popup-Element
	 */
	
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
	
	/**
	 * Methode fügt ActionListener zu den GUI-Elementen hinzu
	 * 
	 * @param al ActionListener
	 */
	
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
		btnBearbeiten.addActionListener(al);
		btnBearbeiten.setActionCommand("Edit");
		suche.getDocument().addDocumentListener(new DocumentListener()
		{
			
			@Override
			public void removeUpdate(DocumentEvent e)
			{
				if(!suche.getText().equals("Suchen")) filter(suche);
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e)
			{
				if(!suche.getText().equals("Suchen")) filter(suche);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e)
			{
				if(!suche.getText().equals("Suchen")) filter(suche);
			}
		});
		
		menuSearch.getDocument().addDocumentListener(new DocumentListener()
		{
			
			@Override
			public void removeUpdate(DocumentEvent e)
			{
				if(!menuSearch.getText().equals("Suchen")) filter(menuSearch);
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e)
			{
				if(!menuSearch.getText().equals("Suchen")) filter(menuSearch);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e)
			{
				if(!menuSearch.getText().equals("Suchen")) filter(menuSearch);
			}
		});
		
	}
	
	/**
	 * Methode stellt ein Objekt vom Typ Person in der Tabelle dar
	 * 
	 * @param pPerson Die darzustellene Person
	 */
	
	void setTableData(Person pPerson)
	{
		String monat = Integer.toString((Person.Monat.valueOf(pPerson.getGeburtsmonat().toString()).ordinal()+1));
		String tag = Integer.toString(pPerson.getGeburtstag())+". ";
		String jahr = ". "+Integer.toString(pPerson.getGeburtsjahr());
		
		if (jahr.equals(". 0")) jahr = "";
		if (tag.equals("0. ")) tag = "";
		if (monat.equals("13")) monat = "---";
		
		if (tag.length() == 1)  tag = 0 + tag;
		if (monat.length() == 1)  monat = 0 + monat;
		geburtsdatum.setText(tag+ monat +jahr);
		
		
		tablemodel.addRow(new String[] {pPerson.getNachname(), pPerson.getVorname(), pPerson.getLand(), pPerson.getOrt(),
				tag+ monat +jahr,pPerson.getGeburtsmonat().toString(),
				Integer.toString(pPerson.getGeburtstag()),Integer.toString(pPerson.getGeburtsjahr()),pPerson.getAugenfarbe().toString(),
				pPerson.getHaarfarbe().toString(),pPerson.getGeschlecht().toString(),pPerson.getEmail(),pPerson.getStrasse(),pPerson.getTelefon(),
				pPerson.getTelefonMobil(),pPerson.getFirma(),pPerson.getReligion().toString(),pPerson.getUuid().toString()});	
	}
	
	/**
	 * Methode filtert Tabelle nach Text in einem JTextField
	 * 
	 * @param pTextField Suchfeld
	 */
	
	void filter(JTextField pTextField) 
	{
		ArrayList<RowFilter<TableModel, Object>> filters = new ArrayList<RowFilter<TableModel,Object>>();
	    try 
	    {
	    	for (int i = 0; i<17; i++)
	    	{
	    		filters.add(RowFilter.regexFilter("(?i)" + pTextField.getText(), i));
	    	}  
	    } catch (java.util.regex.PatternSyntaxException e) 
	    {
	        return;
	    }
	    sorter.setRowFilter(RowFilter.orFilter(filters));
	    
	}
	
	/**
	 * Methode fügt ActionListener zu den Menü-Elementen hinzu
	 * 
	 * @param al ActionListener
	 */
	
	void setMenuListeners(ActionListener al)
	{
		mntmNeu.addActionListener(al);
		mntmSpeichern.addActionListener(al);
		mntmLaden.addActionListener(al);
		mntmLogout.addActionListener(al);
		mntmBeenden.addActionListener(al);
		mntmEinstellungen.addActionListener(al);
		mntmImport.addActionListener(al);
		mntmExport.addActionListener(al);
		mntmLschen.addActionListener(al);
		mntmAllesLschen.addActionListener(al);
		mntmber.addActionListener(al);
		mntmBearbeiten.addActionListener(al);
		}
	
	/**
	 * Methode zeigt Preview von der übergebenden Person an
	 * 
	 * @param pPerson anzuzeigende Person
	 */
	
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
		
		//Geburtsdaten
		String monat = Integer.toString((Person.Monat.valueOf(pPerson.getGeburtsmonat().toString()).ordinal()+1));
		String tag = Integer.toString(pPerson.getGeburtstag())+". ";
		String jahr = ". "+Integer.toString(pPerson.getGeburtsjahr());
		
		if (jahr.equals(". 0")) jahr = "";
		if (tag.equals("0. ")) tag = "";
		if (monat.equals("13")) monat = "---";
		
		if (tag.length() == 1)  tag = 0 + tag;
		if (monat.length() == 1)  monat = 0 + monat;
		geburtsdatum.setText(tag+ monat +jahr);
		
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
		geschlecht.setText(pPerson.getGeschlecht().toString());
		
		JLabel[] temp = {augenfarbe,haarfarbe,hautfarbe,religion,geschlecht};
		
		for (int i=0; i<temp.length; i++)
		{
			switch (temp[i].getText())
			{
			case "unbekannt": temp[i].setText("---");
			}	
		}
		
		JLabel[] scales = {gewicht,groesse};
		int[] scalesData = {pPerson.getGewicht(),pPerson.getGroesse()};
		
		for (int i=0; i<scales.length; i++)
		{
			switch (scalesData[i])
			{
			case 0: scales[i].setText("---");
			}	
		}
		
		gewicht = scales[0];
		groesse = scales[1];
		augenfarbe = temp[0];
		haarfarbe = temp[1];
		hautfarbe = temp[2];
		religion = temp[3];
		geschlecht = temp[4];

		bild.setIcon(icon);
		
		panel_1.setVisible(true);
		lblKontakt.setVisible(true);
		
		lblNewLabel_2.setVisible(false);
	}
	
	/**
	 * Fügt den Nutzernamen zum Menü hinzu
	 * 
	 * @param pUsername Nutzername
	 */
	
	void setMenuUsername(String pUsername)
	{
		mnEingeloggt.setText("<html> Eingeloggt als <b>"+ pUsername +"</b>");
	}
	
	/**
	 * Fügt KeyListener zu GUI-Elementen hinzu
	 * 
	 * @param kl KeyListemer
	 */
	
	void setKeyListeners(KeyListener kl)
	{
		usernameField.addKeyListener(kl);
		passwordField.addKeyListener(kl);
	}
	
	/**
	 * Fügt MouseListener zu GUI-Elementen hinzu
	 * 
	 * @param ma MouseAdapter
	 */
	
	void setMouseListeners(MouseAdapter ma)
	{
		table.addMouseListener(ma);
	}
	
	/**
	 * Getter für das Nutzerpasswort
	 * 
	 * @return Passwort
	 */
	
	@SuppressWarnings("deprecation")
	public String getPassword()
	{
		return passwordField.getText();
	}
	
	/**
	 * Getter für Nutzernamen
	 * 
	 * @return Nutzername
	 */
	
	public String getUsername()
	{
		return usernameField.getText();
	}
	
	/**
	 * Zeigt Standard Nutzername bzw Passwort an
	 */
	
	void showLoginInfo()
	{
		JOptionPane.showMessageDialog(frmAdressbuch, "Standard Benutzername:     admin \nStandard Passwort:                1111");
	}
	
	/**
	 * Zeigt Haupt-GUI an
	 */
	
	void openMain()
	{
		loginPanel.setVisible(false);
		mainPanel.setVisible(true);
		menuBar.setVisible(true);
	}
	
	/**
	 * Zeigt Login-GUI an
	 */
	
	void openLogin()
	{
		mainPanel.setVisible(false);
		menuBar.setVisible(false);
		panel_1.setVisible(false);
		loginPanel.setVisible(true);
		
		lblNewLabel_2.setVisible(true);
		lblKontakt.setVisible(false);
	}
	
	/**
	 * Entfernt Tabellendaten
	 */
	
	void removeTableElements()
	{
		int rowCount = tablemodel.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) 
		{
		    tablemodel.removeRow(i);
		}
	}
	
	/**
	 * Gibt UUID von aktuell selektierten Kontakt zurück
	 * 
	 * @return UUID
	 */
	
	UUID getSelectedUUID()
	{
		return UUID.fromString(table.getValueAt(table.getSelectedRow(), 17).toString());
	}
	
	/**
	 * Zeigt Nutzername/Passwort falsch Warnung an
	 * 
	 * @param pColor Anzeigefarbe
	 */
	
	void showLoginWarning(Color pColor)
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
				usernameField.setBackground(pColor);
				passwordField.setBackground(pColor);
			}
		},  3000);
	}
	
	/**
	 * Getter für JFrame
	 * 
	 * @return JFrame
	 */
	
	JFrame getFrame()
	{
		return frmAdressbuch;
	}
	
	/**
	 * Getter für Tabelle
	 * 
	 * @return Tabelle
	 */
	
	public JTable getTable()
	{
		return table;
	}
	
	/**
	 * Methode setzt Hintergrundfarbe bzw. Textfarbe der GUI
	 * 
	 * @param parent Elternkomponente
	 * @param bg Hintergrundfarbe
	 * @param font Textfarbe
	 */
	
	public void setPanelColor(Container parent, Color bg, Color font)
	{
	    for(Component c : parent.getComponents())
	    {
	        if(c instanceof Container)
	        {
	            if(c instanceof JPanel)
	            {
	                c.setBackground(bg);
	                c.setForeground(font);
	            }
	            
	            if(c instanceof JButton)
	            {
	                c.setBackground(bg);
	                c.setForeground(font);
	            }
	            
	            if(c instanceof JLabel)
	            {
	                c.setForeground(font);
	            }
	            
	            if(c instanceof JScrollPane)
	            {
	            	scrollPane.getViewport().setBackground(bg);
	                c.setBackground(bg);
	            }
	            
	            if(c instanceof JMenuBar)
	            {
	                c.setBackground(bg);
	                c.setForeground(bg);
	            }
	            if(c instanceof JCheckBox)
	            {
	                c.setForeground(font);
	            }
	            
	            
	            setPanelColor((Container)c,bg,font);
	        }
	    }
	}
	
	/**
	 * Getter für "Login Speichern" Checkbox boolean
	 * 
	 * @return true, false
	 */
	
	public boolean getCheckBoxStatus()
	{
		return checkbox.isSelected();
	}
	
	/**
	 * Methode entfernt Inhalt der Textfelder bei der Login-Ansicht
	 */
	
	public void removeLoginContent()
	{
		usernameField.setText("");
		passwordField.setText("");
	}
	
	/**
	 * Setzt die Sichtbarkeit der Kontaktvorschau
	 * 
	 * @param pVisible Sichtbarkeit
	 */
	
	public void setPreviewVisible(boolean pVisible)
	{
		panel_1.setVisible(pVisible);
		lblKontakt.setVisible(pVisible);
		lblNewLabel_2.setVisible(!pVisible);
	}
	
	/**
	 * Schließt die GUI
	 */
	
	public void disposeGUI()
	{
		frmAdressbuch.dispose();
	}
}
