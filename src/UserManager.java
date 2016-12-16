public class UserManager
{
	private List<User> user;
	

	public UserManager()
	{
		user = new List<User>();
		User admin = new User();
		admin.setUsername("admin");
		admin.setPassword("1111");
		user.append(admin);
	}
	
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
	
	User getObjectAt(int i)
	{
		user.toFirst();
		for (int c = 0; c<i; c++)
		{
			user.next();
		}
		return user.getContent();	
	}
	
	void removeObjectAt(int i)
	{
		user.toFirst();
		for (int c =0; c<i; c++)
		{
			user.next();
		}
		user.remove();
	}
	
	void removeListElements()
	{
		user.toFirst();
		while (user.hasAccess())
		{
			user.remove();
		}
	}
	
	List<User> getList()
	{
		return user;
	}
	
	void setList(List<User> pUser)
	{
		user = pUser;
	}
	
}
