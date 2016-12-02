import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.MatteBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.event.ActionEvent;

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
	
	public GUI() 
	{
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
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
		mainPanel.setToolTipText("");
		mainPanel.setBackground(UIManager.getColor("InternalFrame.minimizeIconBackground"));
		frmAdressbuch.getContentPane().add(mainPanel, "name_926217422352088");
		
		list = new JList(listmodel);
		list.setBounds(10, 41, 375, 488);
		list.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		list.setMinimumSize(new Dimension(200, 0));
		
		JLabel lblAdressliste = new JLabel("Adressliste");
		lblAdressliste.setBounds(10, 16, 99, 14);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(69, 24, 705, 13);
		
		JButton btnNeu = new JButton("Neu...");
		btnNeu.setBounds(440, 39, 105, 23);
		
		JButton btnBearbeiten = new JButton("Bearbeiten...");
		btnBearbeiten.setBounds(440, 73, 106, 23);
		mainPanel.setLayout(null);
		mainPanel.add(lblAdressliste);
		mainPanel.add(separator);
		mainPanel.add(list);
		mainPanel.add(btnNeu);
		mainPanel.add(btnBearbeiten);
		
		JButton btnSortieren = new JButton("Sortieren");
		btnSortieren.setBounds(440, 197, 105, 23);
		mainPanel.add(btnSortieren);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(440, 166, 105, 20);
		mainPanel.add(comboBox);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		logoutBtn.setBounds(672, 38, 105, 23);
		mainPanel.add(logoutBtn);
		mainPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{list}));
		
		menuBar = new JMenuBar();
		menuBar.setVisible(false);
		frmAdressbuch.setJMenuBar(menuBar);
		
		JMenu mnDatei = new JMenu("Datei");
		mnDatei.setLocale(Locale.GERMAN);
		menuBar.add(mnDatei);
		
		JMenuItem mntmNeu = new JMenuItem("Neu");
		mntmNeu.setHorizontalTextPosition(SwingConstants.CENTER);
		mntmNeu.setHorizontalAlignment(SwingConstants.LEFT);
		mnDatei.add(mntmNeu);
		
		JMenuItem mntmSpeichern = new JMenuItem("Speichern");
		mntmSpeichern.setHorizontalAlignment(SwingConstants.LEFT);
		mnDatei.add(mntmSpeichern);
		
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
	
	public JList getList()
	{
		return list;
	}
}
