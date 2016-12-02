/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 12.09.2016
  * @author 
  */
  


public class Person {
  
  public enum Farbe
  {
    SCHWARZ, WEISS, BRAUN, GRUEN, BLAU, GRAU, ROT, GELB, LILA, ORANGE, UNBEKANNT
  }
  
  public enum Geschlecht
  {
    MAENNLICH, WEIBLICH, SONSTIGES, UNBEKANNT
  }
  
  public enum Religion
  {
    MUSLIMISCH, KATHOLISCH, EVANGELISCH, JUEDISCH, ATHEISTISCH, UNBEKANNT
  }
  
  public enum Monat
  {
    JANUAR, FEBRUAR, MÄRZ, APRIL, MAI, JUNI, JULI, AUGUST, SEPTEMBER, OKTOBER, NOVEMBER, DEZEMBER, UNBEKANNT
  }
  
  // Anfang Attribute
  private String vorname = "-";
  private String nachname = "-";
  private String land = "-";
  private String postleitzahl = "-";
  private String ort = "-";
  private String strasse = "-";
  private String hausnummer = "-";
  private String adresszusatz = "-";
  private String email = "-";
  private int groesse = 0;
  private int gewicht = 0;
  private Farbe augenfarbe = Farbe.UNBEKANNT;
  private String telefon = "-";
  private String telefonMobil = "-";
  private String nationalitaet = "-";
  private String firma = "-";
  private Religion religion = Religion.UNBEKANNT;
  private Farbe haarfarbe = Farbe.UNBEKANNT;
  private Farbe hautfarbe = Farbe.UNBEKANNT;
  private Geschlecht geschlecht = Geschlecht.UNBEKANNT;
  private int geburtsjahr = 0;
  private Monat geburtsmonat = Monat.UNBEKANNT;
  private int geburtstag = 0;
  // Ende Attribute
  
  // Anfang Methoden
  public String getVorname() {
    return vorname;
  }

  
  public void setVorname(String vorname) {
    this.vorname = vorname;
  }

  
  public String getNachname() {
    return nachname;
  }

  
  public void setNachname(String nachname) {
    this.nachname = nachname;
  }

  
  
  
  public String getLand() {
    return land;
  }

  public String getFirma() 
  {
	    return firma;
  }
  
  public void setLand(String land) {
    this.land = land;
  }

  
  public String getPostleitzahl() {
    return postleitzahl;
  }  
  
  public void setPostleitzahl(String postleitzahl) {
    this.postleitzahl = postleitzahl;
  }       
  
  public String getOrt() {
    return ort;
  }

  
  public void setOrt(String ort) {
    this.ort = ort;
  }

  
  public String getStrasse() {
    return strasse;
  }

  
  public void setStrasse(String strasse) {
    this.strasse = strasse;
  }

  
  public String getHausnummer() {
    return hausnummer;
  }

  
  public void setHausnummer(String hausnummer) {
    this.hausnummer = hausnummer;
  }

  
  public String getAdresszusatz() {
    return adresszusatz;
  }

  
  public void setAdresszusatz(String adresszusatz) {
    this.adresszusatz = adresszusatz;
  }

  
  public String getEmail() {
    return email;
  }

  
  public void setEmail(String email) {
    this.email = email;
  }

  
  public int getGroesse() {
    return groesse;
  }

  
  public void setGroesse(int groesse) {
    this.groesse = groesse;
  }

  
  public int getGewicht() {
    return gewicht;
  }

  
  public void setGewicht(int gewicht) {
    this.gewicht = gewicht;
  }

  
  public Farbe getAugenfarbe() {
    return augenfarbe;
  }

  
  public void setAugenfarbe(Farbe augenfarbe) {
    this.augenfarbe = augenfarbe;
  }

  
  public String getTelefon() {
    return telefon;
  }

  
  public void setTelefon(String telefon) {
    this.telefon = telefon;
  }

  
  public String getTelefonMobil() {
    return telefonMobil;
  }

  
  public void setTelefonMobil(String telefonMobil) {
    this.telefonMobil = telefonMobil;
  }

  
  public String getNationalitaet() {
    return nationalitaet;
  }

  
  public void setNationalitaet(String nationalitaet) {
    this.nationalitaet = nationalitaet;
  }
  
  public void setFirma(String firma) {
	    this.firma = firma;
	  }


  
  public Religion getReligion() {
    return religion;
  }

  
  public void setReligion(Religion religion) {
    this.religion = religion;
  }

  
  public Farbe getHaarfarbe() {
    return haarfarbe;
  }

  
  public void setHaarfarbe(Farbe haarfarbe) {
    this.haarfarbe = haarfarbe;
  }

  
  public Farbe getHautfarbe() {
    return hautfarbe;
  }

  public void setHautfarbe(Farbe hautfarbe) {
    this.hautfarbe = hautfarbe;
  }

  public Geschlecht getGeschlecht() {
    return geschlecht;
  }

  public void setGeschlecht(Geschlecht geschlecht) {
    this.geschlecht = geschlecht;
  }


public int getGeburtsjahr()
{
	return geburtsjahr;
}


public void setGeburtsjahr(int geburtsjahr)
{
	this.geburtsjahr = geburtsjahr;
}


public Monat getGeburtsmonat()
{
	return geburtsmonat;
}


public void setGeburtsmonat(Monat geburtsmonat)
{
	this.geburtsmonat = geburtsmonat;
}


public int getGeburtstag()
{
	return geburtstag;
}


public void setGeburtstag(int geburtstag)
{
	this.geburtstag = geburtstag;
}

  // Ende Methoden
} // end of Person
