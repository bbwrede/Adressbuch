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
		
		//Test
		
		try 
		{
			fw = new FileWriter(System.getProperty("user.dir")+"\\saves\\save.jcts");
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		bw = new BufferedWriter(fw);
		fr = new FileReader(System.getProperty("user.dir")+"\\saves\\save.jcts");
		reader = new Scanner(fr);
	}
	
	
	void saveToFile(Person pPerson) throws IOException
	{
		
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
		bw.newLine();
		bw.flush();
		
	}
	
	void closeWriteStream() throws IOException
	{
		bw.close();
	}
	
	Person ReadPerson()
	{
		Person neu = new Person();
		//reader.nextLine();
		String nachname = reader.next();
		String vorname = reader.next();
		String land = reader.next();
		String postleitzahl = reader.next();
		String ort = reader.next();
		String strasse = reader.next();
		String hausnummer = reader.next();
		String adresszusatz = reader.next();
		String email = reader.next();
		int groesse = Integer.parseInt(reader.next());
		int gewicht = Integer.parseInt(reader.next());
		Person.Farbe augenfarbe = Person.Farbe.valueOf(reader.next());
		String telefon = reader.next();
		String telefonMobil = reader.next();
		String nationalitaet = reader.next();
		Person.Religion religion = Person.Religion.valueOf(reader.next());
		Person.Farbe haarfarbe = Person.Farbe.valueOf(reader.next());
		Person.Farbe hautfarbe = Person.Farbe.valueOf(reader.next());
		Person.Geschlecht geschlecht = Person.Geschlecht.valueOf(reader.next());
		reader.next();
		
		neu.setNachname(nachname);
		neu.setVorname(vorname);
		neu.setLand(land);
		neu.setPostleitzahl(postleitzahl);
		neu.setOrt(ort);
		neu.setStrasse(strasse);
		neu.setHausnummer(hausnummer);
		neu.setAdresszusatz(adresszusatz);
		neu.setLand(land);
		neu.setOrt(ort);
		neu.setStrasse(strasse);
		neu.setHausnummer(hausnummer);
		neu.setAdresszusatz(adresszusatz);
		neu.setEmail(email);
		neu.setGroesse(groesse);
		neu.setGewicht(gewicht);
		neu.setAugenfarbe(augenfarbe);
		neu.setTelefon(telefonMobil);
		neu.setTelefonMobil(telefonMobil);
		neu.setNationalitaet(nationalitaet);
		neu.setReligion(religion);
		neu.setHaarfarbe(haarfarbe);
		neu.setHautfarbe(hautfarbe);
		neu.setGeschlecht(geschlecht);
		
		return neu;
		
	}
		
}
