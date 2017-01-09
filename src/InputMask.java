import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Toolkit;

@SuppressWarnings("rawtypes")
public class InputMask extends JFrame
{

	private static final long serialVersionUID = 8760893234879572236L;
	private JPanel contentPane;
	private JPanel main;
	private JLabel label;
	private HintTextField nachname;
	private HintTextField vorname;
	private HintTextField plz;
	private HintTextField ort;
	private HintTextField strasse;
	private HintTextField nr;
	private HintTextField zusatz;
	private HintTextField email;
	private JLabel label_1;
	private JLabel label_2;
	
	private JComboBox monat;
	private JComboBox land;
	private JComboBox jahr;
	private JComboBox tag;
	private JLabel label_3;
	private HintTextField telefonnummer;
	private JButton btnErweitert;
	private JComboBox geschlecht;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_4;
	private JPanel advanced;
	private JLabel lblErweitert;
	private JLabel lblPersnlicheDaten;
	private JComboBox haarfarbe;
	private JButton btnZurück;
	private JSeparator separator_5;
	private JSeparator separator_6;
	private JSeparator separator_7;
	private JComboBox augenfarbe;
	private JSlider gewicht;
	private JLabel lblKg;
	private JSlider groesse;
	private JLabel lblCm;
	private JComboBox hautfarbe;
	private JComboBox religion;
	private HintTextField firma;
	private HintTextField handy;
	private JSeparator separator_3;
	private JButton save;
	private JButton x;
	private JButton btnBild;
	private BufferedImage image;
	private String format;
	private JButton btnImport;
	private JButton btnSpeichern;
	private JButton btnX;
	private JButton btnImport2;
	private boolean removeOnClose = false;

	/**
	 * Launch the application.
	 */

	@SuppressWarnings("unchecked")
	public InputMask(JFrame pFrame)
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(InputMask.class.getResource("/resources/user.png")));
		setAlwaysOnTop(true);
		setTitle("Neuer Kontakt");
		
		setResizable(false);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 238, 530);
		contentPane = new JPanel();
		contentPane.setToolTipText("Geschlecht");
		contentPane.setName("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		advanced = new JPanel();
		advanced.setVisible(false);
		contentPane.setLayout(new CardLayout(0, 0));
		
		
		
		
		
		main = new JPanel();
		contentPane.add(main, "name_806875294871929");
		main.setLayout(null);
		
		label = new JLabel("Neu:");
		label.setBounds(6, 6, 184, 20);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		main.add(label);
		
		nachname = new HintTextField("Nachname");
		nachname.setBounds(6, 58, 203, 28);
		nachname.setToolTipText("Nachname");
		nachname.setName("");
		nachname.setColumns(10);
		main.add(nachname);
		
		vorname = new HintTextField("Vorname");
		vorname.setBounds(6, 30, 203, 28);
		vorname.setToolTipText("Vorname");
		vorname.setName("");
		vorname.setHorizontalAlignment(SwingConstants.LEFT);
		vorname.setColumns(10);
		main.add(vorname);
		
		plz = new HintTextField("PLZ / ZIP");
		plz.setBounds(6, 118, 76, 28);
		plz.setToolTipText("Postleitzahl bzw. ZIP-Code");
		plz.setName("");
		plz.setColumns(10);
		main.add(plz);
		
		ort = new HintTextField("Ort");
		ort.setBounds(82, 118, 127, 28);
		ort.setToolTipText("Ort bzw. Stadt");
		ort.setName("");
		ort.setColumns(10);
		main.add(ort);
		
		strasse = new HintTextField("Strasse");
		strasse.setBounds(6, 145, 158, 28);
		strasse.setToolTipText("Strasse");
		strasse.setName("");
		strasse.setColumns(10);
		main.add(strasse);
		
		nr = new HintTextField("Nr.");
		nr.setBounds(166, 145, 43, 28);
		nr.setToolTipText("Hausnummer");
		nr.setName("");
		nr.setColumns(10);
		main.add(nr);
		
		zusatz = new HintTextField("Adresszusatz");
		zusatz.setBounds(6, 172, 203, 28);
		zusatz.setToolTipText("Adresszusatz");
		zusatz.setName("");
		zusatz.setColumns(10);
		main.add(zusatz);
		
		email = new HintTextField("E-Mail");
		email.setBounds(6, 246, 203, 28);
		email.setToolTipText("E-Mail");
		email.setName("");
		email.setColumns(10);
		main.add(email);
		
		label_1 = new JLabel("Adressdaten:");
		label_1.setBounds(6, 103, 76, 16);
		label_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		main.add(label_1);
		
		label_2 = new JLabel("Pers\u00F6nliche Daten:");
		label_2.setBounds(6, 229, 107, 16);
		label_2.setFont(new Font("SansSerif", Font.BOLD, 12));
		main.add(label_2);
		
		monat = new JComboBox();
		monat.setBounds(66, 350, 143, 26);
		monat.setToolTipText("Geburtsmonat");
		main.add(monat);
		
		land = new JComboBox();
		land.setBounds(6, 199, 203, 26);
		land.setToolTipText("Land");
		main.add(land);
		
		jahr = new JComboBox();
		jahr.setBounds(6, 377, 203, 26);
		jahr.setToolTipText("Geburtsjahr");
		main.add(jahr);
		
		tag = new JComboBox();
		tag.setBounds(6, 350, 60, 26);
		tag.setToolTipText("Geburtstag");
		main.add(tag);
		
		label_3 = new JLabel("Geburtsdaten:");
		label_3.setBounds(6, 335, 78, 16);
		main.add(label_3);
		
		telefonnummer = new HintTextField("Telefonnummer");
		telefonnummer.setBounds(6, 275, 203, 28);
		telefonnummer.setToolTipText("Telefonnummer");
		telefonnummer.setName("");
		telefonnummer.setColumns(10);
		main.add(telefonnummer);
		
		btnErweitert = new JButton("Erweitert...");
		btnErweitert.setBounds(6, 415, 203, 28);
		main.add(btnErweitert);
		
		geschlecht = new JComboBox();
		geschlecht.setBounds(6, 302, 203, 26);
		geschlecht.setToolTipText("Geschlecht");
		main.add(geschlecht);
		
		separator = new JSeparator();
		separator.setBounds(6, 226, 203, 2);
		main.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(6, 98, 203, 2);
		main.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(6, 410, 203, 2);
		main.add(separator_2);
		
		separator_4 = new JSeparator();
		separator_4.setBounds(6, 447, 203, 2);
		main.add(separator_4);
		
		
		monat.addItem("Monat");
		
		tag.addItem("Tag");
		
		land.addItem(">> Land <<");
		
		jahr.addItem("Jahr");
		
		geschlecht.addItem(">> Geschlecht <<");
		
		btnSpeichern = new JButton("Speichern");
		btnSpeichern.setToolTipText("Speichern");
		btnSpeichern.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSpeichern.setBounds(77, 461, 98, 28);
		main.add(btnSpeichern);
		
		btnX = new JButton("X");
		btnX.setToolTipText("Schlie\u00DFen");
		btnX.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnX.setBounds(175, 461, 36, 28);
		main.add(btnX);
		
		btnImport2 = new JButton("Import");
		btnImport2.setToolTipText("Speichern");
		btnImport2.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnImport2.setBounds(6, 461, 72, 28);
		main.add(btnImport2);
		contentPane.add(advanced, "name_806875309807244");
		advanced.setLayout(null);
		
		lblErweitert = new JLabel("Erweitert:");
		lblErweitert.setHorizontalAlignment(SwingConstants.LEFT);
		lblErweitert.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblErweitert.setBounds(6, 9, 203, 20);
		advanced.add(lblErweitert);
		
		lblPersnlicheDaten = new JLabel("Pers\u00F6nliche Daten:");
		lblPersnlicheDaten.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPersnlicheDaten.setBounds(6, 37, 203, 16);
		advanced.add(lblPersnlicheDaten);
		
		haarfarbe = new JComboBox();
		haarfarbe.setToolTipText("Haarfarbe");
		haarfarbe.setBounds(6, 55, 203, 26);
		advanced.add(haarfarbe);
		
		btnZurück = new JButton("Zur\u00FCck...");
		btnZurück.setToolTipText("Zur\u00FCck");
		btnZurück.setBounds(6, 415, 203, 28);
		advanced.add(btnZurück);
		
		separator_5 = new JSeparator();
		separator_5.setBounds(6, 31, 203, 2);
		advanced.add(separator_5);
		
		separator_6 = new JSeparator();
		separator_6.setBounds(6, 410, 203, 2);
		advanced.add(separator_6);
		
		separator_7 = new JSeparator();
		separator_7.setBounds(6, 447, 203, 2);
		advanced.add(separator_7);
		
		augenfarbe = new JComboBox();
		augenfarbe.setToolTipText("Augenfarbe");
		augenfarbe.setBounds(6, 80, 203, 26);
		advanced.add(augenfarbe);
		
		lblKg = new JLabel("Gewicht: 0 kg");
		lblKg.setToolTipText("Gewicht");
		lblKg.setBounds(6, 134, 117, 16);
		advanced.add(lblKg);
		
		gewicht = new JSlider();
		gewicht.setToolTipText("Gewicht");
		gewicht.setPaintTicks(true);
		gewicht.setValue(0);
		gewicht.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) 
			{
				lblKg.setText("Gewicht: "+Integer.toString(gewicht.getValue())+ " kg");
			}
		});
		gewicht.setMaximum(200);
		gewicht.setMinorTickSpacing(5);
		gewicht.setPaintLabels(true);
		gewicht.setMajorTickSpacing(50);
		gewicht.setBounds(6, 152, 200, 42);
		advanced.add(gewicht);
		
		lblCm = new JLabel("Gr\u00F6\u00DFe: 0 cm");
		lblCm.setToolTipText("Gr\u00F6\u00DFe");
		lblCm.setBounds(6, 206, 117, 16);
		advanced.add(lblCm);
		
		groesse = new JSlider();
		groesse.setPaintTicks(true);
		groesse.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) 
			{
				lblCm.setText("Größe: "+Integer.toString(groesse.getValue())+ " cm");
			}
		});
		groesse.setValue(0);
		groesse.setPaintLabels(true);
		groesse.setMinorTickSpacing(5);
		groesse.setMaximum(250);
		groesse.setMajorTickSpacing(50);
		groesse.setBounds(6, 225, 200, 42);
		advanced.add(groesse);
		
		hautfarbe = new JComboBox();
		hautfarbe.setToolTipText("Hautfarbe");
		hautfarbe.setBounds(6, 106, 203, 26);
		advanced.add(hautfarbe);
		
		religion = new JComboBox();
		religion.setToolTipText("Religion");
		religion.setBounds(6, 271, 203, 26);
		advanced.add(religion);
		
		firma = new HintTextField("Firma");
		firma.setToolTipText("Firma");
		firma.setName("");
		firma.setColumns(10);
		firma.setBounds(6, 309, 203, 28);
		advanced.add(firma);
		
		handy = new HintTextField("Handynummer");
		handy.setToolTipText("Handynummer");
		handy.setName("");
		handy.setColumns(10);
		handy.setBounds(6, 340, 203, 28);
		advanced.add(handy);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(6, 302, 203, 2);
		advanced.add(separator_3);
		
		save = new JButton("Speichern");
		save.setFont(new Font("SansSerif", Font.BOLD, 12));
		save.setToolTipText("Speichern");
		save.setBounds(77, 461, 98, 28);
		advanced.add(save);
		
		x = new JButton("X");
		x.setToolTipText("Schlie\u00DFen");
		x.setFont(new Font("SansSerif", Font.BOLD, 12));
		x.setBounds(175, 461, 36, 28);
		advanced.add(x);
		
		for (int i = 0; i < 13; i++)
		{
			monat.addItem(Person.Monat.values()[i].toString());
		}
		
		for (int i = 1; i < 32; i++)
		{
			tag.addItem(Integer.toString(i));
		}
		Countries cn = new Countries();
		String [] temp = cn.getLaender();
		for (int c = 0; c < temp.length; c++)
		{
			land.addItem(temp[c]);
		}
		
		int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date())); 

		for (int i = year; i > year-120 +1; i--)
		{
			jahr.addItem(Integer.toString(i));
		}
		//Combobox Geschlecht
		for (int i = 0; i < 4; i++)
		{
			geschlecht.addItem(Person.Geschlecht.values()[i].toString());
					
		}
		
		hautfarbe.addItem(">> Hautfarbe <<");
		//Combobox Hautfarbe
		for (int i = 0; i < 3; i++)
		{
			hautfarbe.addItem(Person.Hautfarbe.values()[i].toString());
			
		}
		
		augenfarbe.addItem(">> Augenfarbe <<");
		//Combobox Augenfarbe
		for (int i = 0; i < 5; i++)
		{
			augenfarbe.addItem(Person.Augenfarbe.values()[i].toString());
					
		}
		
		haarfarbe.addItem(">> Haarfarbe <<");
		//Combobox Haarfarbe
		for (int i = 0; i < 12; i++)
		{
			haarfarbe.addItem(Person.Haarfarbe.values()[i].toString());
							
		}
		
		religion.addItem(">> Religion <<");
		
		btnBild = new JButton("Bild...");
		btnBild.setToolTipText("Zur\u00FCck");
		btnBild.setBounds(6, 375, 203, 28);
		advanced.add(btnBild);
		
		btnImport = new JButton("Import");
		btnImport.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnImport.setToolTipText("Speichern");
		btnImport.setBounds(6, 461, 72, 28);
		advanced.add(btnImport);
		//Combobox Haarfarbe
		for (int i = 0; i < 6; i++)
		{
			religion.addItem(Person.Religion.values()[i].toString());
							
		}
		
		setLocationRelativeTo(pFrame);
		
	}
	
	
	
	void setActionListeners(ActionListener al)
	{
		btnErweitert.addActionListener(al);
		btnSpeichern.addActionListener(al);
		btnX.addActionListener(al);
		btnZurück.addActionListener(al);
		x.addActionListener(al);
		save.addActionListener(al);
		btnBild.addActionListener(al);
		btnBild.setActionCommand("Bild...");
		btnImport.addActionListener(al);
		btnImport2.addActionListener(al);
	}
	
	Person getNewPerson()
	{
		Person neu = new Person();
		
		neu.setNachname(nachname.getText());
		neu.setVorname(vorname.getText());
		
		//Pers�nliche Daten
		
		neu.setPostleitzahl(plz.getText());
		neu.setOrt(ort.getText());
		neu.setStrasse(strasse.getText());
		neu.setHausnummer(nr.getText());
		neu.setAdresszusatz(zusatz.getText());
		neu.setEmail(email.getText());
		
		if (format != null)
		{
			try
			{
				neu.setBild(IOController.imageToBase64(image, format));
			} catch (IOException e)
			{
				JOptionPane.showMessageDialog(this,
					    "Die Datei konnte nicht geladen werden!",
					    "Fehler beim Speichern der Datei",
					    JOptionPane.ERROR_MESSAGE);
			} catch (IllegalArgumentException e1)
	    	{
				JOptionPane.showMessageDialog(this,
					    "Die Datei konnte nicht geladen werden! \n"
					    + "Das Dateiformat wird nicht unterstützt!",
					    "Fehler beim Speichern der Datei",
					    JOptionPane.ERROR_MESSAGE);
	    	}
		}
		neu.setTelefon(telefonnummer.getText());
		
		neu.setGroesse(groesse.getValue());
		neu.setGewicht(gewicht.getValue());
		
		neu.setFirma(firma.getText());
		neu.setTelefonMobil(handy.getText());
		
		
		//Religion, Geschlecht und Farben
		if (!land.getSelectedItem().toString().equals(">> Land <<"))
		{
			neu.setLand(land.getSelectedItem().toString());
		}
		else neu.setLand("---");
		
		if (!geschlecht.getSelectedItem().toString().equals(">> Geschlecht <<"))
		{
			neu.setGeschlecht(Person.Geschlecht.valueOf(geschlecht.getSelectedItem().toString()));
		}
		
		if (!hautfarbe.getSelectedItem().toString().equals(">> Hautfarbe <<"))
		{
			neu.setHautfarbe(Person.Hautfarbe.valueOf(hautfarbe.getSelectedItem().toString()));
		}
		
		if (!augenfarbe.getSelectedItem().toString().equals(">> Augenfarbe <<"))
		{
			neu.setAugenfarbe(Person.Augenfarbe.valueOf(augenfarbe.getSelectedItem().toString()));
		}
		
		if (!haarfarbe.getSelectedItem().toString().equals(">> Haarfarbe <<"))
		{
			neu.setHaarfarbe(Person.Haarfarbe.valueOf(haarfarbe.getSelectedItem().toString()));
		}
		
		if (!religion.getSelectedItem().toString().equals(">> Religion <<"))
		{
			neu.setReligion(Person.Religion.valueOf(religion.getSelectedItem().toString()));
		}
		
		
		
		
		//Geburtsdaten
		
		if (!tag.getSelectedItem().toString().equals("Tag")) //Wenn was ausgew�hlt
		{
			neu.setGeburtstag(Integer.parseInt(tag.getSelectedItem().toString()));
		}
		
		if (!monat.getSelectedItem().toString().equals("Monat")) //Wenn was ausgew�hlt
		{
			neu.setGeburtsmonat(Person.Monat.valueOf(monat.getSelectedItem().toString()));
		}
		
		if (!jahr.getSelectedItem().toString().equals("Jahr")) //Wenn was ausgew�hlt
		{
			neu.setGeburtsjahr(Integer.parseInt(jahr.getSelectedItem().toString()));
		}
		
		neu.removeEmpty();
		
		return neu;
	}
	
	void setImage(BufferedImage pImage, String pFormat)
	{
		
		image = pImage;
		format = pFormat;
	}
	
	void openAdvanced()
	{
		main.setVisible(false);
		advanced.setVisible(true);
	}
	
	void openMain()
	{
		main.setVisible(true);
		advanced.setVisible(false);
	}
	
	void setImageButton(String pText)
	{
		btnBild.setText(pText);
	}
	
	JFrame getFrame()
	{
		return this;
	}
	
	public void setPanelColor(Container parent, Color bg, Color font)
	{
	    for(Component c : parent.getComponents())
	    {
	        if(c instanceof Container)
	        {
	            if(c instanceof JPanel)
	            {
	                c.setBackground(bg);
	                c.setForeground(font);
	            }
	            
	            if(c instanceof JButton)
	            {
	                c.setBackground(bg);
	                c.setForeground(font);
	            }
	            
	            if(c instanceof JLabel)
	            {
	                c.setForeground(font);
	            }
	            
	            if(c instanceof JSlider)
	            {
	                c.setForeground(font);
	            }
	            
	            setPanelColor((Container)c,bg,font);
	        }
	    }
	}
	
	void setData(Person pPerson)
	{
		vorname.setText(pPerson.getVorname());
		nachname.setText(pPerson.getNachname());
		
		plz.setText(pPerson.getPostleitzahl());
		ort.setText(pPerson.getOrt());
		strasse.setText(pPerson.getStrasse());
		nr.setText(pPerson.getHausnummer());
		zusatz.setText(pPerson.getAdresszusatz());
		
		land.setSelectedItem(pPerson.getLand());
		email.setText(pPerson.getEmail());
		telefonnummer.setText(pPerson.getTelefon());
		if(pPerson.getGeschlecht().toString().equals("unbekannt")) geschlecht.setSelectedItem(">> Geschlecht <<");
		else geschlecht.setSelectedItem(pPerson.getGeschlecht().toString());
		
		tag.setSelectedItem(Integer.toString(pPerson.getGeburtstag()));
		if (pPerson.getGeburtsmonat().toString().equals("unbekannt")) monat.setSelectedItem("Monat");
		else monat.setSelectedItem(pPerson.getGeburtsmonat().toString());
		jahr.setSelectedItem(Integer.toString(pPerson.getGeburtsjahr()));
		
		if(pPerson.getHaarfarbe().toString().equals("unbekannt")) haarfarbe.setSelectedItem(">> Haarfarbe <<");
		else haarfarbe.setSelectedItem(pPerson.getHaarfarbe().toString());
		if(pPerson.getHautfarbe().toString().equals("unbekannt")) hautfarbe.setSelectedItem(">> Hautfarbe <<");
		else hautfarbe.setSelectedItem(pPerson.getHautfarbe().toString());
		if(pPerson.getAugenfarbe().toString().equals("unbekannt")) augenfarbe.setSelectedItem(">> Augenfarbe <<");
		else augenfarbe.setSelectedItem(pPerson.getAugenfarbe().toString());
		
		gewicht.setValue(pPerson.getGewicht());
		groesse.setValue(pPerson.getGroesse());
		
		if(pPerson.getReligion().toString().equals("unbekannt")) religion.setSelectedItem(">> Religion <<");
		else religion.setSelectedItem(pPerson.getReligion().toString());
		
		firma.setText(pPerson.getFirma());
		handy.setText(pPerson.getTelefonMobil());
		
	}
	
	void setMode(String pTitle, boolean pRemoveOnClose)
	{
		label.setText(pTitle);
		setTitle(pTitle);
		removeOnClose = pRemoveOnClose ;
	}
	
	boolean getRemoveOnClose()
	{
		return removeOnClose;
	}
}
