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
import java.util.ArrayList;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.DefaultListModel;
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
	private String[] columns = {"Nachname","Vorname","Land","Stadt"};
	private JPanel panel;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JScrollPane scrollPane_1;
	private JPanel panel_2;
	private JButton btnDelete;
	private JButton btnNewButton;
	private JButton button;
	private JTable table2;
	private JButton btnRegister;
	private JMenu mnEingeloggt;
	private JMenuItem mntmLogout;
	private TableRowSorter<TableModel> sorter;
	
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
		
		button = new JButton("\u21C9");
		button.setFont(new Font("SansSerif", Font.BOLD, 16));
		button.setBounds(375, 282, 44, 28);
		mainPanel.add(button);
		
		btnNewButton = new JButton("\u21C7");
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnNewButton.setBounds(375, 242, 44, 28);
		mainPanel.add(btnNewButton);
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
		
		JMenu mnBearbeiten = new JMenu("Bearbeiten");
		menuBar.add(mnBearbeiten);
		
		JMenu mnSuchen = new JMenu("Suchen");
		menuBar.add(mnSuchen);
		
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
		
		mntmLogout = new JMenuItem("Logout");
		mntmLogout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mnEingeloggt.add(mntmLogout);
		
		
		tablemodel = new DefaultTableModel(0,0);
		tablemodel.setColumnIdentifiers(columns);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 360, 432);
		mainPanel.add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSurrendersFocusOnKeystroke(true);
		table.setModel(tablemodel);
		table.setDefaultEditor(Object.class, null);
		table.setVisible(true);
		
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(425, 96, 360, 432);
		mainPanel.add(scrollPane_1);
		
		tablemodel2 = new DefaultTableModel(0,0);
		tablemodel2.setColumnIdentifiers(columns);
		

		
		table2 = new JTable();
		scrollPane_1.setViewportView(table2);
		table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table2.setSurrendersFocusOnKeystroke(true);
		table2.setModel(tablemodel2);
		table2.setDefaultEditor(Object.class, null);
		table2.setVisible(true);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Adressliste", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(59, 59, 59)));
		panel.setBounds(0, 72, 380, 470);
		mainPanel.add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Warteschlange", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(59, 59, 59)));
		panel_1.setBounds(415, 72, 380, 470);
		mainPanel.add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(3, 29, 788, 41);
		mainPanel.add(panel_2);
		
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
				filter();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e)
			{
				filter();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e)
			{
				filter();
				
			}
		});
		
	}
	
	void setTableData(Person pPerson)
	{
		tablemodel.addRow(new String[] {pPerson.getNachname(), pPerson.getVorname(), pPerson.getLand(), pPerson.getOrt()});	
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
