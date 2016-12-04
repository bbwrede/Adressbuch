import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class IOController 
{
	// Reader und Writer für .jbook
	private FileWriter fw;
	private BufferedWriter bw;
	private Scanner reader;
	private FileReader fr;
	//Reader und Writer für .login
	private FileWriter loginfw;
	private BufferedWriter loginbw;
	private static Scanner loginreader;
	private FileReader loginfr;
	
	
	IOController() throws FileNotFoundException
	{
		//saves
		File dir = new File("saves");
		dir.mkdir();
		
		
		
		try 
		{
			fw = new FileWriter(System.getProperty("user.dir")+"\\saves\\save.jbook");
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		bw = new BufferedWriter(fw);
		fr = new FileReader(System.getProperty("user.dir")+"\\saves\\save.jbook");
		reader = new Scanner(fr);
		
		//login Data
		File logindir = new File("Login-Data");
		logindir.mkdir();
		
		
		
		try 
		{
			loginfw = new FileWriter(System.getProperty("user.dir")+"\\saves\\data.login");
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		loginbw = new BufferedWriter(loginfw);
		loginfr = new FileReader(System.getProperty("user.dir")+"\\saves\\data.login");
		loginreader = new Scanner(loginfr);
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
		bw.write(pPerson.getFirma());
		bw.newLine();
		bw.write(pPerson.getReligion().toString());
		bw.newLine();
		bw.write(pPerson.getHaarfarbe().toString());
		bw.newLine();
		bw.write(pPerson.getHautfarbe().toString());
		bw.newLine();
		bw.write(pPerson.getGeschlecht().toString());
		bw.newLine();
		bw.write(Integer.toString(pPerson.getGeburtsjahr()));
		bw.newLine();
		bw.write(pPerson.getGeburtsmonat().toString());
		bw.newLine();
		bw.write(Integer.toString(pPerson.getGeburtstag()));
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
		String firma = reader.next();
		Person.Religion religion = Person.Religion.valueOf(reader.next());
		Person.Farbe haarfarbe = Person.Farbe.valueOf(reader.next());
		Person.Farbe hautfarbe = Person.Farbe.valueOf(reader.next());
		Person.Geschlecht geschlecht = Person.Geschlecht.valueOf(reader.next());
		int geburtsjahr = Integer.parseInt(reader.next());
		Person.Monat geburtsmonat = Person.Monat.valueOf(reader.next());
		int geburtstag = Integer.parseInt(reader.next());
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
		neu.setTelefon(telefon);
		neu.setTelefonMobil(telefonMobil);
		neu.setNationalitaet(nationalitaet);
		neu.setFirma(firma);
		neu.setReligion(religion);
		neu.setHaarfarbe(haarfarbe);
		neu.setHautfarbe(hautfarbe);
		neu.setGeschlecht(geschlecht);
		neu.setGeburtsjahr(geburtsjahr);
		neu.setGeburtsmonat(geburtsmonat);
		neu.setGeburtstag(geburtstag);
		
		return neu;
		
	}
		static login readlogindata() throws IOException 
		{
			login neu = new login();
			String username = loginreader.next();
			String password = loginreader.next();
			loginreader.next();
			System.out.println("Username: " +username);
			System.out.println("password: " +password);
			return neu;
		}
		
		  void writelogindata(login pLogin ) throws IOException 
		{
		  
			loginbw.write(pLogin.getUsername());
			loginbw.newLine();
			loginbw.write(pLogin.getPassword());
			loginbw.close();
		}
		
		                    
}
