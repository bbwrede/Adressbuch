import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;
import java.util.UUID;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;
import javax.imageio.stream.IIOByteBuffer;
import javax.imageio.stream.ImageInputStream;


import javafx.scene.effect.ImageInput;
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
	
	private FileWriter sfw;
	private BufferedWriter sbw;
	private FileReader sfr;
	private Scanner sreader;
	
	private byte[] masterkey;
	
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
	
	void initSettingsWriter() throws FileNotFoundException
	{
		//saves
		File dir = new File("saves");
		dir.mkdir();
		
		try 
		{
			sfw = new FileWriter(System.getProperty("user.dir")+"\\saves\\settings.jsettings");
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		sbw = new BufferedWriter(sfw);
		
	}
	
	void initSettingsReader() throws FileNotFoundException
	{
		sfr = new FileReader(System.getProperty("user.dir")+"\\saves\\settings.jsettings");
		sreader = new Scanner(sfr);
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
	
	
	private SecretKeySpec initMasterEncrypt() throws UnsupportedEncodingException, NoSuchAlgorithmException
	{
		masterkey = "zHwQXNLcEVzXFT8VXWd4EK86RIESO0cbzM7u3XQiGp1wkiqLV32zkYmgqjyZP3A".getBytes("UTF-8");
		MessageDigest sha = MessageDigest.getInstance("SHA-256");
		masterkey = sha.digest(masterkey);
		masterkey = Arrays.copyOf(masterkey, 16);
		SecretKeySpec secretkey = new SecretKeySpec(masterkey, "AES");
		return secretkey;
	}
	
	
	
	private String encryptMasterString(String pText) throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException
	{
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, initMasterEncrypt());
		byte[] encrypted = cipher.doFinal(pText.getBytes());
		
		BASE64Encoder myEncoder = new BASE64Encoder();
		String verschluesselt = myEncoder.encode(encrypted);
		
		return verschluesselt;
	}
	
	private String decryptMasterString(String pText) throws IOException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException
	{
		BASE64Decoder myDecoder2 = new BASE64Decoder();
		byte[] crypted2 = myDecoder2.decodeBuffer(pText);
		
		Cipher cipher2 = Cipher.getInstance("AES");
		cipher2.init(Cipher.DECRYPT_MODE, initMasterEncrypt());
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

		bw.write(pPerson.getUuid().toString());
		bw.newLine();
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
		bw.write(pPerson.getBild());
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
		UUID uuid = UUID.fromString(reader.next());
		String nachname = decryptString(reader.next());
		String vorname = decryptString(reader.next());
		String land = decryptString(reader.next());
		String postleitzahl = decryptString(reader.next());
		String ort = decryptString(reader.next());
		String strasse = decryptString(reader.next());
		String hausnummer = decryptString(reader.next());
		String adresszusatz = decryptString(reader.next());
		String email = decryptString(reader.next());
		String bild = reader.next();
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
		
		neu.setUuid(uuid);
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
		ubw.write(encryptMasterString(pUser.getUsername()));
		ubw.newLine();
		ubw.write(encryptMasterString(pUser.getPassword()));
		ubw.newLine();
		ubw.write(";");
		ubw.newLine();
		ubw.flush();
	}
	
	User readUser() throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, IOException
	{
		User neu = new User();
		
		String name = decryptMasterString(ureader.next());
		String pw = decryptMasterString(ureader.next());
		ureader.next();
		
		neu.setUsername(name);
		neu.setPassword(pw);
		
		return neu;
	}
	
	void saveSettingsToFile(Settings pSettings) throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException
	{
		sbw.write(pSettings.getLaf());
		sbw.newLine();
		sbw.write(pSettings.getThemeName());
		sbw.newLine();
		
		int r = pSettings.getBgColor().getRed();
		int g = pSettings.getBgColor().getGreen();
		int b = pSettings.getBgColor().getBlue();
		
		String hex = String.format("#%02x%02x%02x", r, g, b);
		
		sbw.write(hex);
		sbw.newLine();
		
		r = pSettings.getFontColor().getRed();
		g = pSettings.getFontColor().getGreen();
		b = pSettings.getFontColor().getBlue();
		
		hex = String.format("#%02x%02x%02x", r, g, b);
		
		sbw.write(hex);
		sbw.newLine();
		sbw.write(";");
		sbw.newLine();
		sbw.flush();
	}
	
	Settings readSettings() throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, IOException
	{
		Settings neu = new Settings();
		
		String laf = sreader.nextLine();
		String name = sreader.nextLine();
		Color bg = Color.decode(sreader.nextLine());
		Color font = Color.decode(sreader.nextLine());
		sreader.nextLine();
		
		neu.setLaf(laf);
		neu.setBgColor(bg);
		neu.setFontColor(font);
		neu.setThemeName(name);
		
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
		String encoded = Base64.getEncoder().encodeToString(pBytes);
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
	
	BufferedImage readImage(File pFile, String pFormat) throws IOException
	{
		Image temp = ImageIO.read(pFile);
		temp = temp.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		
		BufferedImage bufferedImage = new BufferedImage(temp.getWidth(null), temp.getHeight(null),
		BufferedImage.TYPE_INT_RGB);

		Graphics g = bufferedImage.createGraphics();
		g.drawImage(temp, 0, 0, null);
		g.dispose();
		
		return bufferedImage;
	}
	
	static Image createImage(BufferedImage bi, String pFormat) throws IOException
	{
		
		Image image = bi;
		
		return image;
	}
	
	
	void createVCard(Person pPerson, String path) throws IOException 
	{
		BufferedWriter vCardbw = null;
		FileWriter vCardfw = null;

			vCardfw = new FileWriter(path);
			vCardbw = new BufferedWriter(vCardfw);
			
			vCardbw.write("BEGIN:VCARD\n");
			vCardbw.write("VERSION:4.0\n");
			vCardbw.write("N:"+pPerson.getNachname()+";"+pPerson.getVorname()+"\n");
			vCardbw.write("TEL;TYPE=home:"+ pPerson.getTelefon()+"\n");
			vCardbw.write("EMAIL:"+pPerson.getEmail()+"\n");
			
			String month = Integer.toString(pPerson.getGeburtsmonat().ordinal() +1);
			
			if (!(month.length() == 2))
			{
				month = "0" + month;
			}
			
			vCardbw.write("BDAY:"+pPerson.getGeburtsjahr()+"-"+month+"-"+pPerson.getGeburtstag()+"\n");
			if(pPerson.getGeschlecht() != Person.Geschlecht.Sonstiges||pPerson.getGeschlecht() !=Person.Geschlecht.unbekannt)   vCardbw.write("GENDER:");
			if(pPerson.getGeschlecht() == Person.Geschlecht.Männlich) vCardbw.write("M\n");
			if(pPerson.getGeschlecht() == Person.Geschlecht.Weiblich) vCardbw.write("F\n");
			vCardbw.write("END:VCARD\n");

			System.out.println("Done");
			
			vCardbw.close();

	}
	
	Person importVCard(File pFile) throws FileNotFoundException
	{
		
		
		Person neu = new Person();
		FileReader fr;
		fr = new FileReader(pFile);
		Scanner reader = new Scanner(fr);
		
    	while(reader.hasNext())
		{
			
			
			String temp = reader.next();
			String [] split = temp.split(":");
			
			

			
			if(temp.contains("TEL"))
			{
				neu.setTelefon(split[split.length-1]);
				reader.nextLine();
			}
			
			switch(split[0]) 
			{
				case  	"N": 

					String [] namesplit = split[1].split(";");
					neu.setNachname(namesplit[0]);
					neu.setVorname(namesplit[1]);
					break;
					
				case  	"EMAIL": 
				
					neu.setEmail(split[1]);				
					break;
				
				case  	"BDAY":
					String[] bday = split[1].split("-");
					neu.setGeburtsjahr(Integer.parseInt(bday[0]));
					
					if(bday[1].contains("0"))
					{
						bday[1].replace("0","");
					}
					neu.setGeburtsmonat(Person.Monat.values()[Integer.parseInt(bday[1])-1]);	
					
					if(bday[2].contains("0"))
					{
						bday[2].replace("0","");
					}
					neu.setGeburtstag(Integer.parseInt(bday[2]));
					
					break;
					
					case  "GENDER":
					
					try{
							if(split[1].contains("M"))
							{
								neu.setGeschlecht(Person.Geschlecht.Männlich);
							}
							if(split[1].contains("F"))
							{
								neu.setGeschlecht(Person.Geschlecht.Weiblich);
							}
				}catch(Exception e){
					//Muss so TODO Warum?
					System.out.println("fail");
				}
					
					break;
				
				default: 	//no setable  
							
							break;
			
			}
			
	
		}
			
		
		reader.close();
    	return neu;
		
		
	}
	
		                    
}
