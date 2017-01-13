
import java.io.FileNotFoundException;
import java.util.UUID;

/**
 * Die IOController Klasse von JBook, ein Adressverwaltungsprogramm entwickelt in Java.
 * Diese Klasse ist für sämtliche Interaktion mit den Modellklassen verantwortlich. 
 * 
 * @author Fynn Lohse, Bastian Wrede
 * @version 1.0 R
 *
 */

public class ModelController
{
	private List<Person> liste;
	
	/**
	 * Konstruktor der Klasse Controller. 
	 * 
	 * @throws FileNotFoundException
	 */
	
	public ModelController() throws FileNotFoundException
	{
		liste = new List<Person>();
	}
	
	/**
	 * Methode gibt die Länge der Liste zurück
	 * 
	 * @return Länge der Liste
	 */
	
	public int length()
	{
	    liste.toFirst();
	    int i = 0;
	    while (liste.hasAccess())
	    {
	        i++;
	        liste.next();
	    }
	    return i;
	}
	
	/**
	 * Fügt Kontakt alphabetisch nach Nachnamen in die Liste ein
	 * 
	 * @param neu Der einzusortierende Kontakt
	 */
	
	public void sortIn(Person neu)
	{
		liste.toFirst();
		
		while (liste.hasAccess())
		{
			if (liste.getContent().getNachname().compareTo(neu.getNachname()) > 0)
			{
				liste.insert(neu);
				break;
			}
			liste.next();
		}
		
		if (!liste.hasAccess())
		{
			liste.append(neu);
		}
		
	}
	
	/**
	 * Methode gibt Objekt an bestimmtem Index zurück
	 * 
	 * @param i Index
	 * @return Objekt an dem Index
	 */
	
	public Person getObjectAt(int i)
	{
		liste.toFirst();
		for (int c = 0; c<i; c++)
		{
			liste.next();
		}
		return liste.getContent();	
	}
	
	/**
	 * Methode entfernt Objekt an bestimmtem Index
	 * 
	 * @param i Index
	 */
	
	public void removeObjectAt(int i)
	{
		liste.toFirst();
		for (int c =0; c<i; c++)
		{
			liste.next();
		}
		liste.remove();
	}
	
	/**
	 * Getter für die Kontaktliste
	 * 
	 * @return Kontaktliste
	 */
	
	public List<Person> getList()
	{
		return liste;
	}
	
	/**
	 * Entfernt alle Objekte in der Kontaktliste
	 */
	
	public void removeListElements()
	{
		liste.toFirst();
		while (liste.hasAccess())
		{
			liste.remove();
		}
	}
	
	/**
	 * Methode überprüft, ob die Kontaktliste leer ist
	 * 
	 * @return true, wenn leer oder false, wenn nicht leer
	 */
	
	public boolean isEmpty()
	{
		if (liste.isEmpty())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Methode gibt die Nachnamen aller Kontakte in Konsole aus
	 */
	
	public void ausgabe()
	{
		liste.toFirst();
		while (liste.hasAccess())
		{
			System.out.println(liste.getContent().getNachname());
			liste.next();
		}
	}
	
	/**
	 * Setter für die Kontaktliste
	 * 
	 * @param pList Liste
	 */
	
	public void setList(List<Person> pList)
	{
		liste = pList;
	}
	
	/**
	 * Gibt Index eines Objekts mit einer bestimmten UUID zurück
	 * 
	 * @param pUUID UUID
	 * @return index
	 */
	
	public int indexOf(UUID pUUID)
	{
		liste.toFirst();
		int i = 0;
		
		while (liste.hasAccess())
		{
			if (liste.getContent().getUuid().equals(pUUID))
			{
				return i;
			}
			liste.next();
			i++;
		}
		return 0;
	}
	
}
