import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Settings
{
	private Color bgColor;
	private Color fontColor;
	private String laf;
	
	public Settings()
	{
		laf = "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel";
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
}
