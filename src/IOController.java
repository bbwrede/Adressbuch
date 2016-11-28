import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class IOController 
{
	private FileWriter fw;
	private BufferedWriter bw;
	private Scanner reader;
	private FileReader fr;
	
	IOController() throws FileNotFoundException
	{
		
		File dir = new File("saves");
		dir.mkdir();
		
		try 
		{
			fw = new FileWriter(System.getProperty("user.dir")+"\\saves\\save.jcts");
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		bw = new BufferedWriter(fw);
		fr = new FileReader(System.getProperty("user.dir")+"\\saves\\save.jcts");
	}
	
	
	void saveToFile(Person pPerson) throws IOException
	{
		
		bw.newLine();
		bw.write(pPerson.getNachname());
		bw.newLine();
		bw.write(pPerson.getVorname());
		bw.newLine();
		bw.write(pPerson.getLand());
		bw.newLine();
		bw.write(pPerson.getPostleitzahl());
		bw.newLine();
		bw.write(pPerson.getOrt());
		bw.newLine();
		bw.write(pPerson.getStrasse());
		bw.newLine();
		bw.write(pPerson.getHausnummer());
		bw.newLine();
		bw.write(pPerson.getAdresszusatz());
		bw.newLine();
		bw.write(pPerson.getEmail());
		bw.newLine();
		bw.write(Integer.toString(pPerson.getGroesse()));
		bw.newLine();
		bw.write(Integer.toString(pPerson.getGewicht()));
		bw.newLine();
		bw.write(pPerson.getAugenfarbe().toString());
		bw.newLine();
		bw.write(pPerson.getTelefon());
		bw.newLine();
		bw.write(pPerson.getTelefonMobil());
		bw.newLine();
		bw.write(pPerson.getNationalitaet());
		bw.newLine();
		bw.write(pPerson.getReligion().toString());
		bw.newLine();
		bw.write(pPerson.getHaarfarbe().toString());
		bw.newLine();
		bw.write(pPerson.getHautfarbe().toString());
		bw.newLine();
		bw.write(pPerson.getGeschlecht().toString());
		bw.newLine();
		bw.write(";");
		bw.flush();
		
	}
	
	void closeWriteStream() throws IOException
	{
		bw.close();
	}
	
	Person ReadPerson()
	{
		Person neu = new Person();
		
		reader = new Scanner(fr);
		
		String nachname = reader.nextLine();
		String vorname = reader.nextLine();
		String land = reader.nextLine();
		String postleitzahl = reader.nextLine();
		String ort = reader.nextLine();
		String strasse = reader.nextLine();
		String hausnummer = reader.nextLine();
		String adresszusatz = reader.nextLine();
		String email = reader.nextLine();
		int groesse = Integer.parseInt(reader.nextLine());
		int gewicht = Integer.parseInt(reader.nextLine());
		Person.Farbe augenfarbe = Person.Farbe.valueOf(reader.nextLine());
		String telefon = reader.nextLine();
		String telefonMobil = reader.nextLine();
		String nationalitaet = reader.nextLine();
		Person.Religion religion = Person.Religion.valueOf(reader.nextLine());
		Person.Farbe haarfarbe = Person.Farbe.valueOf(reader.nextLine());
		Person.Farbe hautfarbe = Person.Farbe.valueOf(reader.nextLine());
		Person.Geschlecht geschlecht = Person.Geschlecht.valueOf(reader.nextLine());
		reader.nextLine();
		
		neu.setNachname(nachname);
		neu.setVorname(vorname);
		neu.setLand(land);
		neu.setPostleitzahl(postleitzahl);
		neu.setOrt(ort);
		neu.setStrasse(strasse);
		neu.setHausnummer(hausnummer);
		neu.setAdresszusatz(adresszusatz);
		neu.setLand(land);
		
		return neu;
		

	}
		
}
