import java.awt.Color;

/**
 * Die Settings Klasse von JBook, ein Adressverwaltungsprogramm entwickelt in Java.
 * Diese Klasse ist dient als Modell für die Einstellungen. 
 * 
 * @author Fynn Lohse, Bastian Wrede
 * @version 1.0 R
 *
 */

public class Settings
{
	private Color bgColor;
	private Color fontColor;
	private String laf;
	private String themeName;
	
	public Settings()
	{
		laf = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
	}
	public String getLaf()
	{
		return laf;
	}
	public void setLaf(String laf)
	{
		this.laf = laf;
	}
	public Color getFontColor()
	{
		return fontColor;
	}
	public void setFontColor(Color fontColor)
	{
		this.fontColor = fontColor;
	}
	public Color getBgColor()
	{
		return bgColor;
	}
	public void setBgColor(Color bgColor)
	{
		this.bgColor = bgColor;
	}
	public String getThemeName()
	{
		return themeName;
	}
	public void setThemeName(String themeName)
	{
		this.themeName = themeName;
	}
}
