import java.awt.Color;

public class SettingManager
{
	private Settings[] themes;
	
	public SettingManager()
	{
		themes = new Settings[4];
		
		for (int i = 0; i< themes.length; i++)
		{
			themes[i] = new Settings();
		}
		
		themes[0].setBgColor(Color.MAGENTA);
		themes[0].setFontColor(Color.WHITE);
		
		themes[1].setBgColor(Color.decode("#0066ff"));
		themes[1].setFontColor(Color.WHITE);
		
		themes[2].setBgColor(Color.decode("#303030"));
		themes[2].setFontColor(Color.WHITE);
		
		themes[3].setBgColor(Color.WHITE);
		themes[3].setFontColor(Color.BLACK);
		
	}
	
	
	public Settings[] getThemes()
	{
		return themes;
	}
}
