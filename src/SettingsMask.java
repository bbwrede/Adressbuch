
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * Die SettingsMask Klasse von JBook, ein Adressverwaltungsprogramm entwickelt in Java.
 * Diese Klasse ist für die Darstellung der Einstellungen Verantwortlich. 
 * 
 * @author Fynn Lohse, Bastian Wrede
 * @version 1.0 R
 *
 */


@SuppressWarnings("serial")
public class SettingsMask extends JFrame
{

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblSettings;
	private JButton btnUserSettings;
	@SuppressWarnings("rawtypes")
	private JComboBox cbLaf;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblLookAndFeel;
	private JLabel lblNutzerdaten;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_1;
	private JLabel lblAnpassen;
	private JButton btnBgColor;
	private JButton btnFontColor;
	private JButton btnSpeichern;
	private JButton btnX;
	private JPanel bgColor;
	private JPanel fontColor;
	private JLabel lblFarbeinstellungenWerdenNur;
	private JLabel lblFarbtheme;

	/**
	 * Konstruktor der Klasse SettingsMask.
	 * 
	 * @param pFrame Elternframe
	 */
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SettingsMask(JFrame pFrame)
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(SettingsMask.class.getResource("/resources/settings.png")));
		setResizable(false);
		setTitle("Einstellungen");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(21, 39, 242, 333);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnUserSettings = new JButton("Passwort \u00E4ndern...");
		btnUserSettings.setBounds(12, 32, 211, 28);
		panel.add(btnUserSettings);
		
		cbLaf = new JComboBox();
		cbLaf.setBounds(12, 96, 211, 26);
		panel.add(cbLaf);
		
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
		lblAnpassen.setBounds(74, 193, 94, 16);
		panel.add(lblAnpassen);
		
		btnBgColor = new JButton("Hintergrundfarbe...");
		btnBgColor.setBounds(37, 212, 186, 28);
		panel.add(btnBgColor);
		
		btnFontColor = new JButton("Textfarbe...");
		btnFontColor.setBounds(37, 250, 186, 28);
		panel.add(btnFontColor);
		
		bgColor = new JPanel();
		bgColor.setBorder(new LineBorder(new Color(0, 0, 0)));
		bgColor.setBounds(12, 212, 23, 28);
		panel.add(bgColor);
		
		fontColor = new JPanel();
		fontColor.setBorder(new LineBorder(new Color(0, 0, 0)));
		fontColor.setBackground(Color.BLACK);
		fontColor.setBounds(12, 250, 23, 28);
		panel.add(fontColor);
		
		lblFarbeinstellungenWerdenNur = new JLabel("<html>Farbeinstellungen werden\r\nnur für das <b>\"Standard\"</b> Look and Feel und dem <b>\"Eigene\"</b> Farbtheme übernommen</html>");
		lblFarbeinstellungenWerdenNur.setHorizontalAlignment(SwingConstants.CENTER);
		lblFarbeinstellungenWerdenNur.setFont(new Font("SansSerif", Font.ITALIC, 11));
		lblFarbeinstellungenWerdenNur.setBounds(22, 282, 196, 45);
		panel.add(lblFarbeinstellungenWerdenNur);
		
		lblFarbtheme = new JLabel("Farbtheme");
		lblFarbtheme.setHorizontalAlignment(SwingConstants.CENTER);
		lblFarbtheme.setBounds(74, 128, 94, 16);
		panel.add(lblFarbtheme);
		
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
		
		String[] laf = {"Standard", "Aluminium", "HiFi", "Acryl", "Aero", "Graphite","Seaglass"};
		
		for (int i = 0; i < laf.length; i++)
		{
			cbLaf.addItem(laf[i]);
		}
		
		String[] themes = {"Standard", "LM-Theme", "Royal Blue", "Dark Sense", "Polar White", "Eigene"};
		
		for (int i = 0; i < themes.length; i++)
		{
			 comboBox_1.addItem(themes[i]);
		}
		
		
		
		setLocationRelativeTo(pFrame);
		
		setVisible(true);
	}
	
	/**
	 * Methode fügt ActionListener zu den GUI-Elementen hinzu
	 * 
	 * @param al ActionListener
	 */
	
	public void setActionListeners(ActionListener al)
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
	
	/**
	 * Setzt die Hintergrundfarbe für die Farbvorschau
	 * 
	 * @param pColor Farbe
	 */
	
	public void setBgColorLabel(Color pColor)
	{
		bgColor.setBackground(pColor);
	}
	
	/**
	 * Setzt die Textfarbe für die Vorschau
	 * 
	 * @param pColor Farbe
	 */
	
	public void setFontColorLabel(Color pColor)
	{
		fontColor.setBackground(pColor);
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
	 * Gibt das Ausgewählte Look and Feel zurück
	 * 
	 * @return Name von Look and Feel
	 */
	
	public String getLaf()
	{
		switch (cbLaf.getSelectedItem().toString())
		{
		case "Aluminium": return "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel";
		case "HiFi": return "com.jtattoo.plaf.hifi.HiFiLookAndFeel";
		case "Acryl": return "com.jtattoo.plaf.acryl.AcrylLookAndFeel";
		case "Aero": return "com.jtattoo.plaf.aero.AeroLookAndFeel";
		case "Graphite": return "com.jtattoo.plaf.graphite.GraphiteLookAndFeel";
		case "Standard": return "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
		case "Seaglass": return "com.seaglasslookandfeel.SeaGlassLookAndFeel";
		}
		
		return null;
			
	}
	
	/**
	 * Gibt das Ausgewählte Theme zurück
	 * 
	 * @return Name von Theme 
	 */
	
	public String getTheme()
	{
		return comboBox_1.getSelectedItem().toString();
	}
	
	/**
	 * Gibt den ausgewählten Index der Theme-ComboBox zurück
	 * 
	 * @return Index
	 */
	
	public int getSelectedThemeIndex()
	{
		return comboBox_1.getSelectedIndex();
	}
	
	/**
	 * Getter für JFrame
	 * 
	 * @return Frame
	 */
	
	public JFrame getFrame()
	{
		return this;
	}
	
	/**
	 * Setzt das Look and Feel in die ComboBox 
	 * 
	 * @param pSelectedLaf das aktuelle Look and Feel
	 * @param pThemeName Name der Farb-theme
	 */
	
	public void setSelected(String pSelectedLaf, String pThemeName)
	{
		switch (pSelectedLaf)
		{
		case "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel": 
			cbLaf.setSelectedItem("Aluminium");
			break;
		case "com.jtattoo.plaf.hifi.HiFiLookAndFeel": 
			cbLaf.setSelectedItem("HiFi");
			break;
		case "com.jtattoo.plaf.acryl.AcrylLookAndFeel":
			cbLaf.setSelectedItem("Acryl");
			break;
		case "com.jtattoo.plaf.aero.AeroLookAndFeel": 
			cbLaf.setSelectedItem("Aero");
			break;
		case "com.jtattoo.plaf.graphite.GraphiteLookAndFeel": 
			cbLaf.setSelectedItem("Graphite");
			break;
		case "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel": cbLaf.setSelectedItem("Standard");
			break;
		case "com.seaglasslookandfeel.SeaGlassLookAndFeel": cbLaf.setSelectedItem("Seaglass");
			break;
		}
		
		if (pThemeName != null) comboBox_1.setSelectedItem(pThemeName);
	}
}
