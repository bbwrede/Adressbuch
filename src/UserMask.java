
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Die UserMask Klasse von JBook, ein Adressverwaltungsprogramm entwickelt in Java.
 * Diese Klasse ist für die Darstellung der Nutzererstellung Verantwortlich. 
 * 
 * @author Fynn Lohse, Bastian Wrede
 * @version 1.0 R
 *
 */

@SuppressWarnings("serial")
public class UserMask extends JFrame
{

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField username;
	private JPasswordField password;
	private JPasswordField confirmPassword;
	private JLabel lblUsername;
	private JLabel lblPasswort;
	private JLabel lblPasswortBesttigen;
	private JPanel panel;
	private JSeparator separator;
	private JButton save;
	private JButton x;
	private JLabel un;
	private JLabel pw;
	private JLabel pw2;

	/**
	 * Konstruktor von der Klasse UserMask
	 * 
	 * @param pFrame JFrame
	 */
	
	public UserMask(JFrame pFrame)
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(UserMask.class.getResource("/resources/user.png")));
		setVisible(true);
		
		setTitle("Neuer Benutzer");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 309, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Neuer Benutzer");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 9, 291, 14);
		contentPane.add(lblNewLabel);
		
		username = new JTextField();
		username.setFont(new Font("SansSerif", Font.PLAIN, 13));
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setBounds(82, 66, 138, 28);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setFont(new Font("SansSerif", Font.PLAIN, 14));
		password.setBounds(82, 121, 138, 28);
		contentPane.add(password);
		
		confirmPassword = new JPasswordField();
		confirmPassword.setFont(new Font("SansSerif", Font.PLAIN, 14));
		confirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
		confirmPassword.setBounds(82, 171, 138, 28);
		contentPane.add(confirmPassword);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(82, 52, 139, 16);
		contentPane.add(lblUsername);
		
		lblPasswort = new JLabel("Passwort:");
		lblPasswort.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswort.setBounds(82, 105, 139, 16);
		contentPane.add(lblPasswort);
		
		lblPasswortBesttigen = new JLabel("Passwort best\u00E4tigen");
		lblPasswortBesttigen.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswortBesttigen.setBounds(82, 156, 139, 16);
		contentPane.add(lblPasswortBesttigen);
		
		separator = new JSeparator();
		separator.setBounds(-40, 27, 383, 2);
		contentPane.add(separator);
		
		save = new JButton("Speichern");
		save.setBounds(44, 240, 159, 28);
		contentPane.add(save);
		
		x = new JButton("X");
		x.setFont(new Font("SansSerif", Font.BOLD, 14));
		x.setBounds(215, 240, 37, 28);
		contentPane.add(x);
		
		un = new JLabel("");
		un.setVisible(false);
		un.setIcon(new ImageIcon(UserMask.class.getResource("/resources/error.png")));
		un.setBounds(221, 66, 31, 26);
		contentPane.add(un);
		
		pw = new JLabel("");
		pw.setVisible(false);
		pw.setIcon(new ImageIcon(UserMask.class.getResource("/resources/error.png")));
		pw.setBounds(221, 122, 31, 26);
		contentPane.add(pw);
		
		pw2 = new JLabel("");
		pw2.setVisible(false);
		pw2.setIcon(new ImageIcon(UserMask.class.getResource("/resources/error.png")));
		pw2.setBounds(221, 170, 31, 26);
		contentPane.add(pw2);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(44, 36, 214, 192);
		contentPane.add(panel);
		
		setLocationRelativeTo(pFrame);
	}
	
	/**
	 * Erstellt Nutzer aus der UserMask
	 * 
	 * @return Neuer Benutzer
	 */
	
	@SuppressWarnings("deprecation")
	public User getNewUser()
	{
		User neu = new User();
		
		neu.setPassword(password.getText());
		neu.setUsername(username.getText());
		
		return neu;
	}
	
	/**
	 * Überprüft ob das Passwort in dem Bestätigungsfeld richtig ist
	 * 
	 * @return true, false
	 */
	
	@SuppressWarnings("deprecation")
	public boolean isPasswordCorrect()
	{
		if (password.getText().equals(confirmPassword.getText()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Überprüft ob das Passwort mindestens 3 Zeichen lang ist
	 * 
	 * @return true,false
	 */
	
	public boolean isUserName3() 
	{
		if (username.getText().length() < 3)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 *  Zeight Fehler bei den Passwortfeldern an
	 */
	
	public void showPasswordWrong()
	{
		passwordIcon(true);
		pwCheckIcon(true);
	}
	
	/**
	 * Fügt ActionListener zu den GUI-Elemeten hinzu
	 * 
	 * @param al ActionListener
	 */
	
	public void setActionListeners(ActionListener al)
	{
		x.addActionListener(al);
		x.setActionCommand("quit");
		save.addActionListener(al);
		save.setActionCommand("save");
	}
	
	/**
	 * Zeigt Fehlerzeichen bei dem Passwortfeld an
	 * 
	 * @param visible Sichtbarkeit
	 */
	
	public void passwordIcon(boolean visible)
	{
		pw.setVisible(visible);
	}
	
	/**
	 * Zeigt Fehlerzeichen bei dem Kontrollpasswortfeld an
	 * 
	 * @param visible Sichtbarkeit
	 */
	
	public void pwCheckIcon(boolean visible)
	{
		pw2.setVisible(visible);
	}
	
	/**
	 * Zeigt Fehlerzeichen bei dem Usernamefeld an
	 * 
	 * @param visible Sichtbarkeit
	 */
	
	public void usernameIcon(boolean visible)
	{
		un.setVisible(visible);
	}
	
	/**
	 * Setzt Titel der GUI
	 * 
	 * @param pTitle
	 */
	
	public void setLabelTitle(String pTitle)
	{
		lblNewLabel.setText(pTitle);
		setTitle(pTitle);
	}
	
	/**
	 * Füllt die Felder aus
	 * 
	 * @param pUsername Nutzername
	 * @param pPassword Passwort
	 */
	
	public void setFieldData(String pUsername, String pPassword)
	{
		username.setText(pUsername);
		password.setText(pPassword);
		confirmPassword.setText(pPassword);
	}
	
	/**
	 * De-/Aktiviert das Username Fenster
	 * 
	 * @param pEditable Aktiviert, Deaktiviert
	 */
	
	public void setUsernameEditable(boolean pEditable)
	{
		username.setEditable(pEditable);
		username.setEnabled(pEditable);
	}
	
	/**
	 * Gibt des GUI-Titel zurück
	 * 
	 * @return Titel
	 */
	
	public String getLabelTitle()
	{
		return lblNewLabel.getText();
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
	            
	            if(c instanceof JSlider)
	            {
	                c.setForeground(font);
	            }
	            
	            setPanelColor((Container)c,bg,font);
	        }
	    }
	}
	
	/**
	 * Gibt JFrame zurück
	 * 
	 * @return JFrame
	 */
	
	public JFrame getFrame()
	{
		return this;
	}
}
