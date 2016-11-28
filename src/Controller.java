import java.io.FileNotFoundException;
import java.io.IOException;

public class Controller
{
	private GUI gui;
	private ModelController mc;
	
	Controller() throws FileNotFoundException
	{
		gui = new GUI();
		mc = new ModelController();
		
	}
	
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Controller contrl = new Controller();
	}
		
}
