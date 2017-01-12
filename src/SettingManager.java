
import java.awt.Color;

/**
 * Die SettingsManager Klasse von JBook, ein Adressverwaltungsprogramm entwickelt in Java.
 * Diese Klasse ist für das Erstellen von Voreinstellungen Verantwortlich. 
 * 
 * @author Fynn Lohse, Bastian Wrede
 * @version 1.0 R
 *
 */

public class SettingManager
{
	private Settings[] themes;
	
	/**
	 * Konstruktor der Klasse SettingManager
	 */
	
	public SettingManager()
	{
		themes = new Settings[6];
		
		for (int i = 0; i< themes.length; i++)
		{
			themes[i] = new Settings();
		}
		
		themes[0].setBgColor(Color.decode("#d6d9df"));
		themes[0].setFontColor(Color.BLACK);
		
		themes[1].setBgColor(Color.MAGENTA);
		themes[1].setFontColor(Color.WHITE);
		
		themes[2].setBgColor(Color.decode("#0066ff"));
		themes[2].setFontColor(Color.WHITE);
		
		themes[3].setBgColor(Color.decode("#303030"));
		themes[3].setFontColor(Color.WHITE);
		
		themes[4].setBgColor(Color.WHITE);
		themes[4].setFontColor(Color.BLACK);
		
	}
	
	/**
	 * Gibt das Array mit dem Themes zurück
	 * 
	 * @return Array aus Settings
	 */
	
	public Settings[] getThemes()
	{
		return themes;
	}
}
