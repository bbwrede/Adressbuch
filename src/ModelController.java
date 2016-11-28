import java.io.FileNotFoundException;

public class ModelController
{
	private List<Person> liste;
	
	ModelController() throws FileNotFoundException
	{
		liste = new List<Person>();
		test();
		
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
	

	void test() throws FileNotFoundException
	{
		IOController ioc = new IOController();
		
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		Person p4 = new Person();
		Person p5 = new Person();
		Person p6 = new Person();
		Person p7 = new Person();
		Person p8 = new Person();
		p1.setNachname("Meier");
		p2.setNachname("Lohse");
		p3.setNachname("Behler");
		p4.setNachname("Esders");
		p5.setNachname("Knigge");
		p6.setNachname("Lahsse");		
		p7.setNachname("Lahsue");
		p8.setNachname("Lohsee");
		
		p1.setVorname("Peter");
		p2.setVorname("Hans");
		p3.setVorname("Giesela");
		p4.setVorname("Gerholt");
		p5.setVorname("Adolf");
		p6.setVorname("Reiner");		
		p7.setVorname("Friedhelm");
		p8.setVorname("Ruth");
		
		sortIn(p1);
		sortIn(p2);
		sortIn(p3);
		sortIn(p4);
		sortIn(p5);
		sortIn(p6);
		sortIn(p7);
		sortIn(p8);
		ausgabe();
		
		/*try
		{
			ioc.saveToFile(p1);
			ioc.saveToFile(p2);
			ioc.saveToFile(p3);
			ioc.closeWriteStream();
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}*/
		
		//System.out.println(ioc.ReadPerson().getNachname() + ioc.ReadPerson().getVorname());
		
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
