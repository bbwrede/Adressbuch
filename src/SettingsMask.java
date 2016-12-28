import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;

public class SettingsMask extends JFrame
{

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblSettings;
	private JButton btnUserSettings;
	private JComboBox comboBox;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblLookAndFeel;
	private JLabel lblNutzerdaten;
	private JComboBox comboBox_1;
	private JLabel lblAnpassen;
	private JButton btnBgColor;
	private JButton btnFontColor;
	private JButton btnSpeichern;
	private JButton btnX;
	private JPanel bgColor;
	private JPanel fontColor;


	public SettingsMask(JFrame pFrame)
	{
		try 
		{
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) 
		{
			e.printStackTrace();
		}
		
		
		setTitle("Einstellungen");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(21, 39, 242, 324);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnUserSettings = new JButton("Passwort \u00E4ndern...");
		btnUserSettings.setBounds(12, 32, 211, 28);
		panel.add(btnUserSettings);
		
		comboBox = new JComboBox();
		comboBox.setBounds(12, 107, 211, 26);
		panel.add(comboBox);
		
		separator = new JSeparator();
		separator.setBounds(12, 193, 211, 2);
		panel.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(12, 72, 211, 2);
		panel.add(separator_1);
		
		lblLookAndFeel = new JLabel("Look and Feel");
		lblLookAndFeel.setHorizontalAlignment(SwingConstants.CENTER);
		lblLookAndFeel.setBounds(74, 79, 94, 16);
		panel.add(lblLookAndFeel);
		
		lblNutzerdaten = new JLabel("Nutzerdaten");
		lblNutzerdaten.setHorizontalAlignment(SwingConstants.CENTER);
		lblNutzerdaten.setBounds(74, 4, 94, 16);
		panel.add(lblNutzerdaten);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(12, 145, 211, 26);
		panel.add(comboBox_1);
		
		lblAnpassen = new JLabel("Anpassen");
		lblAnpassen.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnpassen.setBounds(74, 207, 94, 16);
		panel.add(lblAnpassen);
		
		btnBgColor = new JButton("Hintergrundfarbe...");
		btnBgColor.setBounds(37, 235, 186, 28);
		panel.add(btnBgColor);
		
		btnFontColor = new JButton("Textfarbe...");
		btnFontColor.setBounds(37, 275, 186, 28);
		panel.add(btnFontColor);
		
		bgColor = new JPanel();
		bgColor.setBounds(12, 235, 23, 28);
		panel.add(bgColor);
		
		fontColor = new JPanel();
		fontColor.setBackground(Color.BLACK);
		fontColor.setBounds(12, 275, 23, 28);
		panel.add(fontColor);
		
		lblSettings = new JLabel("Einstellungen");
		lblSettings.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSettings.setIcon(new ImageIcon(SettingsMask.class.getResource("/resources/settings.png")));
		lblSettings.setHorizontalAlignment(SwingConstants.CENTER);
		lblSettings.setBounds(21, 6, 242, 31);
		contentPane.add(lblSettings);
		
		btnSpeichern = new JButton("Speichern");
		btnSpeichern.setBounds(21, 375, 184, 28);
		contentPane.add(btnSpeichern);
		
		btnX = new JButton("X");
		btnX.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnX.setBounds(217, 375, 46, 28);
		contentPane.add(btnX);
		
		setLocationRelativeTo(pFrame);
		
		setVisible(true);
	}
	
	void setActionListeners(ActionListener al)
	{
		btnUserSettings.addActionListener(al);
		btnUserSettings.setActionCommand("UserSettings");
		btnBgColor.addActionListener(al);
		btnBgColor.setActionCommand("BG");
		btnFontColor.addActionListener(al);
		btnFontColor.setActionCommand("Font");
		btnSpeichern.addActionListener(al);
		btnSpeichern.setActionCommand("saveSettings");
		btnX.addActionListener(al);
		btnX.setActionCommand("closeSettings");
	}
	
	void setBgColorLabel(Color pColor)
	{
		bgColor.setBackground(pColor);
	}
	
	void setFontColorLabel(Color pColor)
	{
		fontColor.setBackground(pColor);
	}
}
