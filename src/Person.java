public class Person 
{
  
  public enum Haarfarbe
  {
    Schwarz, Weiß, Braun, Blond, Grün, Blau, Grau, Rot, Gelb, Lila, Orange, unbekannt
  }
  
  public enum Hautfarbe
  {
    Schwarz, Weiß, unbekannt
  }
  
  public enum Augenfarbe
  {
    Braun, Grün, Blau, Grau, unbekannt
  }
  
  public enum Geschlecht
  {
    Männlich, Weiblich, Sonstiges, unbekannt
  }
  
  public enum Religion
  {
    Muslimisch, Katholisch, Evangelisch, Jüdisch, Atheistisch, unbekannt
  }
  
  public enum Monat
  {
    Januar, Februar, März, April, Mai, Juni, Juli, August, September, Oktober, November, Dezember, unbekannt
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
  private Augenfarbe augenfarbe = Augenfarbe.unbekannt;
  private String telefon = "-";
  private String telefonMobil = "-";
  private String nationalitaet = "-";
  private String firma = "-";
  private Religion religion = Religion.unbekannt;
  private Haarfarbe haarfarbe = Haarfarbe.unbekannt;
  private Hautfarbe hautfarbe = Hautfarbe.unbekannt;
  private Geschlecht geschlecht = Geschlecht.unbekannt;
  private int geburtsjahr = 0;
  private Monat geburtsmonat = Monat.unbekannt;
  private int geburtstag = 0;
  // Ende Attribute
  
  // Anfang Methoden
  public String getVorname() 
  {
    return vorname;
  }

  
  public void setVorname(String vorname) 
  {
    this.vorname = vorname;
  }

  
  public String getNachname() 
  {
    return nachname;
  }

  
  public void setNachname(String nachname) 
  {
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

  
  public Augenfarbe getAugenfarbe() {
    return augenfarbe;
  }

  
  public void setAugenfarbe(Augenfarbe augenfarbe) {
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

  
  public Haarfarbe getHaarfarbe() {
    return haarfarbe;
  }

  
  public void setHaarfarbe(Haarfarbe haarfarbe) {
    this.haarfarbe = haarfarbe;
  }

  
  public Hautfarbe getHautfarbe() {
    return hautfarbe;
  }

  public void setHautfarbe(Hautfarbe hautfarbe) {
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
