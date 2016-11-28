public class Controller
{
	private List<Person> liste;
	
	Controller()
	{
		liste = new List<Person>();
		test();
	}
	
	
	//test
	void sortInNeu(Person neu)
	{
		liste.toFirst();
		
		if (liste.hasAccess() == false)
		{
			liste.insert(neu);
		}
		
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
				System.out.println(i);
				
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
	}
	
	
	
	
	int sortIn(Person neu) // Gibt Index f�r JList zur�ck
	{
		liste.toFirst();
		char a0 = neu.getNachname().charAt(0);
		int index = 0;
		
		FirstCharLoop:
		
			
		
			
		while (liste.hasAccess())
		{
			char b0 = liste.getContent().getNachname().charAt(0);
			
			
			while (Character.toLowerCase(b0) == Character.toLowerCase(a0))
			{
				if (liste.getContent().getNachname().length() >= 2)
				{
				char a1 = neu.getNachname().charAt(1);
				char b1 = liste.getContent().getNachname().charAt(1);
				
				while (Character.toLowerCase(b1) == Character.toLowerCase(a1))
				{
					if (liste.getContent().getNachname().length() >= 3)
					{
					char a2 = neu.getNachname().charAt(2);
					char b2 = liste.getContent().getNachname().charAt(2);
					
					while (Character.toLowerCase(b2) == Character.toLowerCase(a2))
					{
						if (liste.getContent().getNachname().length() >= 4)
						{
						char a3 = neu.getNachname().charAt(3);
						char b3 = liste.getContent().getNachname().charAt(3);
						
						while (Character.toLowerCase(b3) == Character.toLowerCase(a3))
						{
							if (liste.getContent().getNachname().length() >= 5)
							{
								char a4 = neu.getNachname().charAt(4);
								char b4 = liste.getContent().getNachname().charAt(4);
							
								if (Character.toLowerCase(b4) > Character.toLowerCase(a4))
								{
									liste.insert(neu);
									break FirstCharLoop;
								}
							
								liste.next();
								index++;
							}
							
						}
						
						if (Character.toLowerCase(b3) > Character.toLowerCase(a3))
						{
							liste.insert(neu);
							break FirstCharLoop;
						}
						
						liste.next();
						index++;
					  }
					}
					
					if (Character.toLowerCase(b2) > Character.toLowerCase(a2))
					{
						liste.insert(neu);
						break FirstCharLoop;
					}
					
					liste.next();
					index++;
				   }
				}
				
				if (Character.toLowerCase(b1) > Character.toLowerCase(a1))
				{
					liste.insert(neu);
					break FirstCharLoop;
				}
				
				liste.next();
				index++;
				
				}
				
			}
			
			if (Character.toLowerCase(b0) > Character.toLowerCase(a0))
			{
				liste.insert(neu);
				break;
			}
			
			liste.next();
			index++;
		}
		
		if (liste.hasAccess() == false)
		{
			liste.insert(neu);
		}
		
		return index;
	}
	
	void test()
	{
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
		
		sortInNeu(p1);
		sortInNeu(p2);
		sortInNeu(p3);
		sortInNeu(p4);
		sortInNeu(p5);
		sortInNeu(p6);
		System.out.println("Fertig");
		sortInNeu(p7);
		sortInNeu(p8);
		ausgabe();
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
	
	public static void main(String[] args)
	{
		Controller contrl = new Controller();
	}
	
	
	
	
	
}
