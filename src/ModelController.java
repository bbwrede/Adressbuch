import java.io.FileNotFoundException;
import java.util.UUID;

public class ModelController
{
	private static List<Person> liste;
	private static List<Person> queue;
	
	ModelController() throws FileNotFoundException
	{
		liste = new List<Person>();
		queue = new List<Person>();
		
	}
	
	
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
	
	
	void sortIn(Person neu)
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
	
	
	static Person getObjectAt(int i)
	{
		liste.toFirst();
		for (int c = 0; c<i; c++)
		{
			liste.next();
		}
		return liste.getContent();	
	}
	
	void removeObjectAt(int i)
	{
		liste.toFirst();
		for (int c =0; c<i; c++)
		{
			liste.next();
		}
		liste.remove();
	}
	
	
	List<Person> getList()
	{
		return liste;
	}
	
	
	void removeListElements()
	{
		liste.toFirst();
		while (liste.hasAccess())
		{
			liste.remove();
		}
	}
	
	boolean isEmpty()
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
	
	void ausgabe()
	{
		liste.toFirst();
		while (liste.hasAccess())
		{
			System.out.println(liste.getContent().getNachname());
			liste.next();
		}
	}
	
	void setList(List<Person> pList)
	{
		liste = pList;
	}
	
	static int indexOf(UUID pUUID)
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
