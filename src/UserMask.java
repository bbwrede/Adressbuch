import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.ImageIcon;

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
	 * Create the frame.
	 */
	public UserMask(JFrame pFrame)
	{
		setVisible(true);
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
		lblNewLabel.setBounds(82, 9, 138, 14);
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
	
	
	User getNewUser()
	{
		User neu = new User();
		
		neu.setPassword(password.getText());
		neu.setUsername(username.getText());
		
		return neu;
	}
	
	boolean isPasswordCorrect()
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
	
	boolean isUserName3()
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
	
	void showPasswordWrong()
	{
		passwordIcon(true);
		pwCheckIcon(true);
	}
	
	
	void setActionListeners(ActionListener al)
	{
		x.addActionListener(al);
		x.setActionCommand("quit");
		save.addActionListener(al);
		save.setActionCommand("save");
	}
	
	
	void passwordIcon(boolean visible)
	{
		pw.setVisible(visible);
	}
	
	void pwCheckIcon(boolean visible)
	{
		pw2.setVisible(visible);
	}
	
	void usernameIcon(boolean visible)
	{
		un.setVisible(visible);
	}
}