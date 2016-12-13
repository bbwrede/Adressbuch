import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;




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
	private String username;
	private String password;
	
	IOController(String pUsername, String pPassword) throws FileNotFoundException
	{
		username = pUsername;
		password = pPassword;
		
	}
	
	
	void initWriter() throws FileNotFoundException
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
	
	void initReader() throws FileNotFoundException
	{
		fr = new FileReader(System.getProperty("user.dir")+"\\saves\\save.jbook");
		reader = new Scanner(fr);
	}
	
	private SecretKeySpec initEncrypt() throws UnsupportedEncodingException, NoSuchAlgorithmException
	{
		String keytext = username + password;
		byte[] key = keytext.getBytes("UTF-8");
		MessageDigest sha = MessageDigest.getInstance("SHA-256");
		key = sha.digest(key);
		key = Arrays.copyOf(key, 16);
		SecretKeySpec secretkey = new SecretKeySpec(key, "AES");
		return secretkey;
	}
	
	
	
	private String encryptString(String pText) throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException
	{
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, initEncrypt());
		byte[] encrypted = cipher.doFinal(pText.getBytes());
		
		BASE64Encoder myEncoder = new BASE64Encoder();
		String verschluesselt = myEncoder.encode(encrypted);
		
		return verschluesselt;
	}
	
	private String decryptString(String pText) throws IOException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException
	{
		BASE64Decoder myDecoder2 = new BASE64Decoder();
		byte[] crypted2 = myDecoder2.decodeBuffer(pText);
		
		Cipher cipher2 = Cipher.getInstance("AES");
		cipher2.init(Cipher.DECRYPT_MODE, initEncrypt());
		byte[] cipherData2 = cipher2.doFinal(crypted2);
		String text = new String(cipherData2);
		
		return text;

	}
	
	int getLines() throws FileNotFoundException
	{
		FileReader tempfr = new FileReader(System.getProperty("user.dir")+"\\saves\\save.jbook");
		Scanner tempreader = new Scanner(tempfr);
		
		int lines = 0;
		while (tempreader.hasNextLine())
		{
			tempreader.nextLine();
			lines++;
			
		}
		System.out.println(lines);
		tempreader.close();
		return lines;
		
	}
	
	void saveToFile(Person pPerson) throws IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException
	{

	
		//bw.write(pPerson.getNachname());
		bw.write(encryptString(pPerson.getNachname()));
		bw.newLine();
		bw.write(encryptString(pPerson.getVorname()));
		bw.newLine();
		bw.write(encryptString(pPerson.getLand()));
		bw.newLine();
		bw.write(encryptString(pPerson.getPostleitzahl()));
		bw.newLine();
		bw.write(encryptString(pPerson.getOrt()));
		bw.newLine();
		bw.write(encryptString(pPerson.getStrasse()));
		bw.newLine();
		bw.write(encryptString(pPerson.getHausnummer()));
		bw.newLine();
		bw.write(encryptString(pPerson.getAdresszusatz()));
		bw.newLine();
		bw.write(encryptString(pPerson.getEmail()));
		bw.newLine();
		bw.write(encryptString(Integer.toString(pPerson.getGroesse())));
		bw.newLine();
		bw.write(encryptString(Integer.toString(pPerson.getGewicht())));
		bw.newLine();
		bw.write(encryptString(pPerson.getAugenfarbe().toString()));
		bw.newLine();
		bw.write(encryptString(pPerson.getTelefon()));
		bw.newLine();
		bw.write(encryptString(pPerson.getTelefonMobil()));
		bw.newLine();
		bw.write(encryptString(pPerson.getNationalitaet()));
		bw.newLine();
		bw.write(encryptString(pPerson.getFirma()));
		bw.newLine();
		bw.write(encryptString(pPerson.getReligion().toString()));
		bw.newLine();
		bw.write(encryptString(pPerson.getHaarfarbe().toString()));
		bw.newLine();
		bw.write(encryptString(pPerson.getHautfarbe().toString()));
		bw.newLine();
		bw.write(encryptString(pPerson.getGeschlecht().toString()));
		bw.newLine();
		bw.write(encryptString(Integer.toString(pPerson.getGeburtsjahr())));
		bw.newLine();
		bw.write(encryptString(pPerson.getGeburtsmonat().toString()));
		bw.newLine();
		bw.write(encryptString(Integer.toString(pPerson.getGeburtstag())));
		bw.newLine();
		bw.write(";");
		bw.newLine();
		bw.flush();
		
	}
	
	void closeWriteStream() throws IOException
	{
		bw.close();
	}
	
	
	Person readPerson() throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, IOException
	{
		Person neu = new Person();
		String nachname = decryptString(reader.next());
		String vorname = decryptString(reader.next());
		String land = decryptString(reader.next());
		String postleitzahl = decryptString(reader.next());
		String ort = decryptString(reader.next());
		String strasse = decryptString(reader.next());
		String hausnummer = decryptString(reader.next());
		String adresszusatz = decryptString(reader.next());
		String email = decryptString(reader.next());
		int groesse = Integer.parseInt(decryptString(reader.next()));
		int gewicht = Integer.parseInt(decryptString(reader.next()));
		Person.Augenfarbe augenfarbe = Person.Augenfarbe.valueOf(decryptString(reader.next()));
		String telefon = decryptString(reader.next());
		String telefonMobil = decryptString(reader.next());
		String nationalitaet = decryptString(reader.next());
		String firma = decryptString(reader.next());
		Person.Religion religion = Person.Religion.valueOf(decryptString(reader.next()));
		Person.Haarfarbe haarfarbe = Person.Haarfarbe.valueOf(decryptString(reader.next()));
		Person.Hautfarbe hautfarbe = Person.Hautfarbe.valueOf(decryptString(reader.next()));
		Person.Geschlecht geschlecht = Person.Geschlecht.valueOf(decryptString(reader.next()));
		int geburtsjahr = Integer.parseInt(decryptString(reader.next()));
		Person.Monat geburtsmonat = Person.Monat.valueOf(decryptString(reader.next()));
		int geburtstag = Integer.parseInt(decryptString(reader.next()));
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
	
	void closeReader()
	{
		reader.close();
	}
	
	Login readlogindata() throws IOException 
	{
		Login neu = new Login();
		String username = loginreader.next();
		String password = loginreader.next();
		loginreader.next();
		System.out.println("Username: " +username);
		System.out.println("password: " +password);
		return neu;
	}
		
	void writelogindata(Login pLogin ) throws IOException 
	{
		  
		loginbw.write(pLogin.getUsername());
		loginbw.newLine();
		loginbw.write(pLogin.getPassword());
		loginbw.close();
	}
		
		                    
}
