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
		
		OuterLoop:
		while (liste.hasAccess())
		{
			int i = 0;
			char x = neu.getNachname().charAt(i);
			char y = liste.getContent().getNachname().charAt(i);
			
			if (Character.toLowerCase(y) > Character.toLowerCase(x))	
			{
				liste.insert(neu);
				break OuterLoop;
			}
			
			while (Character.toLowerCase(x) == Character.toLowerCase(y))
			{
				i++;
				if (neu.getNachname().length() > i+1)
				x = neu.getNachname().charAt(i);
				else
				{
					liste.next();
					liste.insert(neu);
					break OuterLoop;
				}
					
				if (liste.getContent().getNachname().length() > i+1)
				y = liste.getContent().getNachname().charAt(i);
				else
				{
					liste.next();
					liste.insert(neu);
					break OuterLoop;
				}
				
				if (Character.toLowerCase(y) > Character.toLowerCase(x))	
				{
					liste.insert(neu);
					break OuterLoop;
				}
			}
			liste.next();
		}
		
		if (liste.hasAccess() == false)
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
	

	void ausgabe()
	{
		liste.toFirst();
		while (liste.hasAccess())
		{
			System.out.println(liste.getContent().getNachname());
			liste.next();
		}
	}
}
