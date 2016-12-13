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
	private JList list;
	private DefaultListModel listmodel= new DefaultListModel();
	private JButton logoutBtn;
	private JLabel loginMessage;
	private JMenuBar menuBar;
	private JButton btnNeu;
	private JMenuItem mntmNeu;
	private JMenuItem mntmSpeichern;
	private JMenuItem mntmLaden;
	private JTextField textField;
	
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
		frmAdressbuch.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/resources/key.png")));
		frmAdressbuch.setResizable(false);
		frmAdressbuch.setTitle("Adressbuch");
		frmAdressbuch.setBounds(100, 100, 800, 600);
		frmAdressbuch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdressbuch.getContentPane().setLayout(new CardLayout(0, 0));
		
		mainPanel = new JPanel();
		mainPanel.setVisible(false);
		
		loginPanel = new JPanel();
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
		lblNewLabel.setIcon(new ImageIcon(GUI.class.getResource("/resources/key.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(308, 225, 178, 41);
		loginPanel.add(lblNewLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 270, 774, 2);
		loginPanel.add(separator_1);
		
		JLabel lblJbook = new JLabel("JBook");
		lblJbook.setHorizontalAlignment(SwingConstants.CENTER);
		lblJbook.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblJbook.setBounds(237, 56, 320, 80);
		loginPanel.add(lblJbook);
		
		JCheckBox chckbxLoginSpeichern = new JCheckBox("Login speichern");
		chckbxLoginSpeichern.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxLoginSpeichern.setBounds(308, 417, 178, 23);
		loginPanel.add(chckbxLoginSpeichern);
		
		loginBtn = new JButton("Login");
		loginBtn.setIcon(new ImageIcon(GUI.class.getResource("/resources/pfeil-rechts.png")));
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		loginBtn.setBounds(308, 452, 89, 23);
		loginPanel.add(loginBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Benutzername");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(308, 283, 178, 14);
		loginPanel.add(lblNewLabel_1);
		
		JLabel lblPasswort = new JLabel("Passwort");
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
		mainPanel.setName("");
		mainPanel.setToolTipText(null);
		mainPanel.setBackground(UIManager.getColor("InternalFrame.minimizeIconBackground"));
		frmAdressbuch.getContentPane().add(mainPanel, "name_926217422352088");
		
		list = new JList(listmodel);
		list.setFont(new Font("SansSerif", Font.BOLD, 18));
		list.setBounds(10, 41, 324, 488);
		list.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		list.setMinimumSize(new Dimension(200, 0));
		
		JLabel lblAdressliste = new JLabel("Adressliste");
		lblAdressliste.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblAdressliste.setBounds(10, 16, 99, 14);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(106, 24, 668, 13);
		
		btnNeu = new JButton("Neu...");
		btnNeu.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNeu.setBounds(337, 64, 120, 40);
		
		JButton btnBearbeiten = new JButton("Bearbeiten...");
		btnBearbeiten.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnBearbeiten.setBounds(337, 104, 120, 40);
		mainPanel.setLayout(null);
		mainPanel.add(lblAdressliste);
		mainPanel.add(separator);
		mainPanel.add(list);
		mainPanel.add(btnNeu);
		mainPanel.add(btnBearbeiten);
		
		JButton btnSortieren = new JButton("Sortieren");
		btnSortieren.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnSortieren.setBounds(337, 199, 120, 40);
		mainPanel.add(btnSortieren);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(337, 156, 120, 32);
		mainPanel.add(comboBox);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		logoutBtn.setBounds(672, 38, 105, 23);
		mainPanel.add(logoutBtn);
		
		textField = new HintTextField("Suchen");
		textField.setBounds(480, 44, 102, 28);
		mainPanel.add(textField);
		textField.setColumns(10);
		mainPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{list}));
		
		menuBar = new JMenuBar();
		menuBar.setVisible(false);
		frmAdressbuch.setJMenuBar(menuBar);
		
		JMenu mnDatei = new JMenu("Datei");
		mnDatei.setLocale(Locale.GERMAN);
		menuBar.add(mnDatei);
		
		mntmNeu = new JMenuItem("Neu");
		mntmNeu.setHorizontalTextPosition(SwingConstants.CENTER);
		mntmNeu.setHorizontalAlignment(SwingConstants.LEFT);
		mnDatei.add(mntmNeu);
		
		mntmSpeichern = new JMenuItem("Speichern");
		mntmSpeichern.setHorizontalAlignment(SwingConstants.LEFT);
		mnDatei.add(mntmSpeichern);
		
		mntmLaden = new JMenuItem("Laden");
		mnDatei.add(mntmLaden);
		
		JMenu mnBearbeiten = new JMenu("Bearbeiten");
		menuBar.add(mnBearbeiten);
		
		JMenu mnSuchen = new JMenu("Suchen");
		menuBar.add(mnSuchen);
		
		JMenu mnHilfe = new JMenu("Hilfe");
		menuBar.add(mnHilfe);
		
		JMenuItem mntmHilfe = new JMenuItem("Hilfe");
		mntmHilfe.setHorizontalAlignment(SwingConstants.CENTER);
		mnHilfe.add(mntmHilfe);
		
		JMenuItem mntmber = new JMenuItem("\u00DCber");
		mnHilfe.add(mntmber);
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
		btnNeu.addActionListener(al);
		mntmNeu.addActionListener(al);
		
	}
	
	void setMenuListeners(ActionListener al)
	{
		mntmNeu.addActionListener(al);
		mntmSpeichern.addActionListener(al);
		mntmLaden.addActionListener(al);
	}
	
	void setKeyListeners(KeyListener kl)
	{
		usernameField.addKeyListener(kl);
		passwordField.addKeyListener(kl);
	}
	
	void setMouseListeners(MouseAdapter ma)
	{
		list.addMouseListener(ma);
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
	
	void addElement(String anzeige)
	{
		listmodel.addElement(anzeige);
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
	
	public JList getList()
	{
		return list;
	}
}
