
/**
 * Die User Klasse von JBook, ein Adressverwaltungsprogramm entwickelt in Java.
 * Diese Klasse ist dient als Modell für die Benutzer. 
 * 
 * @author Fynn Lohse, Bastian Wrede
 * @version 1.0 R
 *
 */

public class User 
{
	private String username = "";
	private String password ="";
	
	
	
	public String getUsername() 
	{
		return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	
	
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	

}
