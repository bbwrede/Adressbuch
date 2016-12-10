import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class ModelController
{
	private List<Person> liste;
	private List<Login> logindata;
	
	ModelController() throws FileNotFoundException
	{
		liste = new List<Person>();
		logindata = new List<Login>();
		
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
	
	Person getObjectAt(int i)
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
}
