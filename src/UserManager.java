
/**
 * Die UserManager Klasse von JBook, ein Adressverwaltungsprogramm entwickelt in Java.
 * Diese Klasse ist für das Verwalten der Nutzer verantwortlich 
 * 
 * @author Fynn Lohse, Bastian Wrede
 * @version 1.0 R
 *
 */

public class UserManager
{
	private List<User> user;
	
	/**
	 * Konstruktor der Klasse UserManager
	 */
	
	public UserManager()
	{
		user = new List<User>();
	}
	
	/**
	 * Authentifiziert einen Benutzer. Es wird Nutzername und Passwort auf Korrektheit überprüft
	 * 
	 * @param pPassword Passwort
	 * @param pUsername Username
	 * @return true, wenn korrekt - false, wenn falsch
	 */
	
	boolean userAuthentification(String pPassword, String pUsername) 
	{

		if (isInList(pUsername))
		{
			user.toFirst();
			
			User neu = getObjectAt(indexOf(pUsername));
			
			if (pPassword.equals(neu.getPassword()) && pUsername.equals(neu.getUsername()))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		return false;
	}
	
	/**
	 * Gibt die Länge der Nutzerliste zurück
	 * 
	 * @return Länge der Liste
	 */
	
	public int length()
	{
		user.toFirst();
		int i = 0;
		while (user.hasAccess())
		{
			i++;
	        user.next();
		}
	    return i;
	}
	
	/**
	 * Erstellt den Standardbenutzer "admin"
	 */
	
	void initAdmin()
	{
		User admin = new User();
		admin.setUsername("admin");
		admin.setPassword("1111");
		sortIn(admin);
	}
	
	/**
	 * Entfernt Nutzer mit übergebenen Nutzernamen
	 * 
	 * @param pUsername der zu entfernene Nutzer
	 */
	
	void removeUser(String pUsername)
	{
		removeObjectAt(indexOf(pUsername));
	}
	
	/**
	 * Überprüft ob Nutzer mit bestimmten Nutzernamen vorhanden ist
	 * 
	 * @param pUsername Nutzername
	 * @return true,false
	 */
	
	boolean isInList(String pUsername)
	{
		user.toFirst();
		while (user.hasAccess())
		{
			if (user.getContent().getUsername().equals(pUsername))
			{
				return true;
			}
			user.next();
		}
		return false;
	}
	
	/**
	 * Gibt den Index von einem Nutzer zurück
	 * 
	 * @param pUsername Nutzername
	 * @return Index
	 */
	
	int indexOf(String pUsername)
	{
		user.toFirst();
		int i = 0;
		
		while (user.hasAccess())
		{
			if (user.getContent().getUsername().equals(pUsername))
			{
				return i;
			}
			user.next();
			i++;
		}
		return 0;
	}
	
	/**
	 * Sortiert einen Nutzer alphabetisch in die Liste ein
	 * 
	 * @param neu Der neue Benutzer
	 */
	
	void sortIn(User neu)
	{
		user.toFirst();
		
		while (user.hasAccess())
		{
			if (user.getContent().getUsername().compareTo(neu.getUsername()) > 0)
			{
				user.insert(neu);
				break;
			}
			user.next();
		}
		
		if (!user.hasAccess())
		{
			user.append(neu);
		}
		
	}
	
	/**
	 * Gibt das Objekt an einem bestimmtem Index zurück
	 * 
	 * @param i Index
	 * @return Objekt an dem Index
	 */
	
	User getObjectAt(int i)
	{
		user.toFirst();
		for (int c = 0; c<i; c++)
		{
			user.next();
		}
		return user.getContent();	
	}
	
	/**
	 * Entfernt Objekt an bestimmten Index
	 * 
	 * @param i Index
	 */
	
	void removeObjectAt(int i)
	{
		user.toFirst();
		for (int c =0; c<i; c++)
		{
			user.next();
		}
		user.remove();
	}
	
	/**
	 * Entfernt alle Nutzer aus der Liste
	 */
	
	void removeListElements()
	{
		user.toFirst();
		while (user.hasAccess())
		{
			user.remove();
		}
	}
	
	/**
	 * Gibt die Liste zurück
	 * 
	 * @return Liste
	 */
	
	List<User> getList()
	{
		return user;
	}
	
	/**
	 * Setzt die Liste
	 * 
	 * @param pUser Liste von Benutzern
	 */
	
	void setList(List<User> pUser)
	{
		user = pUser;
	}
	
}
