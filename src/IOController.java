import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import javax.imageio.ImageIO;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;




public class IOController 
{
	// Reader und Writer für .jbook
	private FileWriter fw;
	private BufferedWriter bw;
	private Scanner reader;
	private FileReader fr;
	
	private FileWriter ufw;
	private BufferedWriter ubw;
	private FileReader ufr;
	private Scanner ureader;
	
	private String username;
	private String password;
	
	void setUserInfo(String pUsername, String pPassword)
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
			fw = new FileWriter(System.getProperty("user.dir")+"\\saves\\"+username+".jbook");
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		bw = new BufferedWriter(fw);
		
	}
	
	void initReader() throws FileNotFoundException
	{
		fr = new FileReader(System.getProperty("user.dir")+"\\saves\\"+username+".jbook");
		reader = new Scanner(fr);
	}
	
	void initUserWriter() throws FileNotFoundException
	{
		File dir = new File("saves");
		dir.mkdir();
		
		try 
		{
			ufw = new FileWriter(System.getProperty("user.dir")+"\\saves\\user.juser");
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		ubw = new BufferedWriter(ufw);
	}
	
	void initUserReader() throws FileNotFoundException
	{
		ufr = new FileReader(System.getProperty("user.dir")+"\\saves\\user.juser");
		ureader = new Scanner(ufr);
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
		FileReader tempfr = new FileReader(System.getProperty("user.dir")+"\\saves\\"+username+".jbook");
		Scanner tempreader = new Scanner(tempfr);
		
		int lines = 0;
		while (tempreader.hasNextLine())
		{
			tempreader.nextLine();
			lines++;
			
		}
		tempreader.close();
		return lines;
		
	}
	
	int getUserLines() throws FileNotFoundException
	{
		FileReader tempfr = new FileReader(System.getProperty("user.dir")+"\\saves\\user.juser");
		Scanner tempreader = new Scanner(tempfr);
		
		int lines = 0;
		while (tempreader.hasNextLine())
		{
			tempreader.nextLine();
			lines++;
			
		}
		tempreader.close();
		return lines;
		
	}
	
	void saveToFile(Person pPerson) throws IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException
	{

	
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
		bw.write(encryptString(pPerson.getBild()));
		bw.newLine();
		bw.write(encryptString(pPerson.getBildFormat()));
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
	
	void closeUserWriteStream() throws IOException
	{
		ubw.close();
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
		String bild = decryptString(reader.next());
		String bildFormat = decryptString(reader.next());;
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
		neu.setBild(bild);
		neu.setBildFormat(bildFormat);
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
	
	void saveUserToFile(User pUser) throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException
	{
		ubw.write(pUser.getUsername());
		ubw.newLine();
		ubw.write(pUser.getPassword());
		ubw.newLine();
		ubw.write(";");
		ubw.newLine();
		ubw.flush();
	}
	
	User readUser()
	{
		User neu = new User();
		
		String name = ureader.next();
		String pw = ureader.next();
		ureader.next();
		
		neu.setUsername(name);
		neu.setPassword(pw);
		
		return neu;
	}
	
	
	private static byte[] imageToByte (BufferedImage image, String pFormat) throws IOException 
	{
		 BufferedImage bufferedImage = image;

		 ByteArrayOutputStream baos = new ByteArrayOutputStream();
		 ImageIO.write(bufferedImage, pFormat, baos);
		 byte[] bytes = baos.toByteArray();

		 return (bytes);
	}
	
	
	private static String byteToBase64(byte[] pBytes)
	{
		BASE64Encoder encoder = new BASE64Encoder();
		String encoded = encoder.encode(pBytes);
		return encoded;
	}
	
	private static byte[] base64toByte(String pText) throws IOException
	{
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] bytes = decoder.decodeBuffer(pText);
		return bytes;
	}
	
	private static BufferedImage bytesToImage(byte[] pBytes, String pFormat) throws IOException
	{
		ByteArrayInputStream bais = new ByteArrayInputStream(pBytes);
		BufferedImage bi = ImageIO.read(bais);
		//FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"\\test\\"+pPerson.getNachname()+" - "+pPerson.getVorname()+ "." +pFormat);
		//ImageIO.write(bi, pFormat, fos);
		
		return bi;
	}
	
	
	
	
	static String imageToBase64(BufferedImage image, String pFormat) throws IOException
	{
		return byteToBase64(imageToByte(image,pFormat));	
	}
	
	
	
	static BufferedImage base64ToImage(String pBase, String pFormat) throws IOException
	{
		return bytesToImage(base64toByte(pBase),pFormat);
	}
	
	BufferedImage readImage(File pFile) throws IOException
	{
		BufferedImage image = ImageIO.read(pFile);
		return image;
	}
	
	void createVCard(Person pPerson) 
	{
		BufferedWriter VCardbw = null;
		FileWriter VCardfw = null;
		
		

		try 
		{

			VCardfw = new FileWriter(System.getProperty("user.dir")+"\\VCard\\"+pPerson.getNachname()+" - "+pPerson.getVorname()+".vcf");
			VCardbw = new BufferedWriter(VCardfw);
			
			VCardbw.write("BEGIN:VCARD\n");
			VCardbw.write("VERSION:4.0\n");
			VCardbw.write("N:"+pPerson.getNachname()+"\n");
			VCardbw.write("FN:"+ pPerson.getVorname()+"\n");
			VCardbw.write("TEL;TYPE=home:"+ pPerson.getTelefon()+"\n");
			VCardbw.write("EMAIL:"+pPerson.getEmail()+"\n");
			
			String month = Integer.toString(pPerson.getGeburtsmonat().ordinal() +1);
			
			if (!(month.length() == 2))
			{
				month = "0" + month;
			}
			
			VCardbw.write("BDAY:"+pPerson.getGeburtsjahr()+"-"+month+"-"+pPerson.getGeburtstag()+"\n");
			VCardbw.write("GENDER:"+pPerson.getGeschlecht()+"\n");
			VCardbw.write("END:VCARD\n");
			

			System.out.println("Done");

		} catch (IOException e) 
		{

			e.printStackTrace();

		} finally 
		{

			try 
			{

				if (VCardbw != null)
					VCardbw.close();

				if (VCardfw != null)
					VCardfw.close();

			} catch (IOException ex) 
			{

				ex.printStackTrace();

			}

		}

	}
		                    
}
