import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class InputMask extends JFrame
{

	private static final long serialVersionUID = 8760893234879572236L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField nachname;
	private JTextField vorname;
	private JTextField plz;
	private JTextField ort;
	private JTextField strasse;
	private JTextField nr;
	private JTextField zusatz;
	private JTextField email;
	private JLabel lblAdressdaten;
	private JSeparator separator_1;
	private JSeparator separator;
	private JSeparator separator_2;
	private JLabel lblPersnlicheDaten;
	private JComboBox geschlecht;
	private JComboBox monat;
	private JComboBox tag;
	private JComboBox jahr;
	private JLabel lblGeburtsdaten;
	private HintTextField telefonnummer;
	private JButton btnSpeichern;
	private JButton btnErweitert;
	private JSeparator separator_3;
	private JButton btnX;
	private JComboBox land;

	/**
	 * Launch the application.
	 */

	public InputMask(JFrame pFrame)
	{
		setAlwaysOnTop(true);
		setTitle("Neuer Kontakt");
		
		setResizable(false);
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) 
		{
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) 
			{
		        if ("Windows".equals(info.getName())) 
		        {
		            try
					{
						UIManager.setLookAndFeel(info.getClassName());
					} catch (ClassNotFoundException e1)
					{
						// TODO Automatisch generierter Erfassungsblock
						e1.printStackTrace();
					} catch (InstantiationException e1)
					{
						// TODO Automatisch generierter Erfassungsblock
						e1.printStackTrace();
					} catch (IllegalAccessException e1)
					{
						// TODO Automatisch generierter Erfassungsblock
						e1.printStackTrace();
					} catch (UnsupportedLookAndFeelException e1)
					{
						// TODO Automatisch generierter Erfassungsblock
						e1.printStackTrace();
					}
		            break;
		        }
			}
		}
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 560);
		contentPane = new JPanel();
		contentPane.setToolTipText("Geschlecht");
		contentPane.setName("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Neu:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 6, 103, 23);
		contentPane.add(lblNewLabel);
		
		nachname = new HintTextField("Nachname");
		nachname.setName("");
		nachname.setToolTipText("Nachname");
		nachname.setBounds(10, 41, 164, 26);
		contentPane.add(nachname);
		nachname.setColumns(10);
		
		vorname = new HintTextField("Vorname");
		vorname.setHorizontalAlignment(SwingConstants.LEFT);
		vorname.setToolTipText("Vorname");
		vorname.setName("");
		vorname.setColumns(10);
		vorname.setBounds(10, 67, 164, 26);
		contentPane.add(vorname);
		
		plz = new HintTextField("PLZ / ZIP");
		plz.setToolTipText("Postleitzahl bzw. ZIP-Code");
		plz.setName("");
		plz.setColumns(10);
		plz.setBounds(10, 123, 61, 26);
		contentPane.add(plz);
		
		ort = new HintTextField("Ort");
		ort.setToolTipText("Ort bzw. Stadt");
		ort.setName("");
		ort.setColumns(10);
		ort.setBounds(71, 123, 103, 26);
		contentPane.add(ort);
		
		strasse = new HintTextField("Strasse");
		strasse.setToolTipText("Strasse");
		strasse.setName("");
		strasse.setColumns(10);
		strasse.setBounds(10, 149, 131, 26);
		contentPane.add(strasse);
		
		nr = new HintTextField("Nr.");
		nr.setToolTipText("Hausnummer");
		nr.setName("");
		nr.setColumns(10);
		nr.setBounds(142, 149, 32, 26);
		contentPane.add(nr);
		
		zusatz = new HintTextField("Adresszusatz");
		zusatz.setToolTipText("Adresszusatz");
		zusatz.setName("");
		zusatz.setColumns(10);
		zusatz.setBounds(10, 174, 164, 26);
		contentPane.add(zusatz);
		
		email = new HintTextField("E-Mail");
		email.setToolTipText("E-Mail");
		email.setName("");
		email.setColumns(10);
		email.setBounds(10, 292, 164, 26);
		contentPane.add(email);
		
		lblAdressdaten = new JLabel("Adressdaten:");
		lblAdressdaten.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAdressdaten.setBounds(14, 105, 214, 16);
		contentPane.add(lblAdressdaten);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(10, 98, 222, 7);
		contentPane.add(separator_1);
		
		separator = new JSeparator();
		separator.setBounds(10, 27, 218, 2);
		contentPane.add(separator);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(10, 238, 222, 7);
		contentPane.add(separator_2);
		
		lblPersnlicheDaten = new JLabel("Pers\u00F6nliche Daten:");
		lblPersnlicheDaten.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPersnlicheDaten.setBounds(15, 246, 204, 16);
		contentPane.add(lblPersnlicheDaten);
		
		geschlecht = new JComboBox();
		geschlecht.setToolTipText("Geschelcht");
		geschlecht.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		geschlecht.setBounds(10, 267, 164, 26);
		contentPane.add(geschlecht);
		geschlecht.addItem(">> Geschlecht <<");
		geschlecht.addItem("Männlich");
		geschlecht.addItem("Weiblich");
		geschlecht.addItem("Sonstiges");
		geschlecht.addItem("Unbekannt");
		
		monat = new JComboBox();
		monat.setToolTipText("Geburtsmonat");
		monat.setBounds(71, 376, 103, 26);
		contentPane.add(monat);
		
		monat.addItem("Monat");
		
		for (int i = 0; i < 12; i++)
		{
			monat.addItem(Person.Monat.values()[i].toString());
		}
		
		tag = new JComboBox();
		tag.setToolTipText("Geburtstag");
		tag.setBounds(10, 376, 61, 26);
		contentPane.add(tag);
		
		tag.addItem("Tag");
		
		for (int i = 1; i < 32; i++)
		{
			tag.addItem(Integer.toString(i));
		}
		
		jahr = new JComboBox();
		jahr.setToolTipText("Geburtsjahr");
		jahr.setBounds(10, 403, 164, 26);
		contentPane.add(jahr);
		
		jahr.addItem("Jahr");
		
		lblGeburtsdaten = new JLabel("Geburtsdaten:");
		lblGeburtsdaten.setBounds(13, 356, 218, 16);
		contentPane.add(lblGeburtsdaten);
		
		telefonnummer = new HintTextField("Telefonnummer");
		telefonnummer.setToolTipText("Telefonnummer");
		telefonnummer.setName("");
		telefonnummer.setColumns(10);
		telefonnummer.setBounds(10, 318, 164, 26);
		contentPane.add(telefonnummer);
		
		btnSpeichern = new JButton("Speichern");
		btnSpeichern.setBounds(10, 497, 115, 28);
		contentPane.add(btnSpeichern);
		
		btnErweitert = new JButton("Erweitert...");
		btnErweitert.setBounds(10, 441, 164, 28);
		contentPane.add(btnErweitert);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(10, 483, 218, 2);
		contentPane.add(separator_3);
		
		btnX = new JButton("X");
		btnX.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnX.setBounds(130, 497, 44, 28);
		contentPane.add(btnX);
		
		land = new JComboBox();
		land.setToolTipText("L\u00E4nder");
		land.setBounds(10, 200, 164, 26);
		contentPane.add(land);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{separator, lblNewLabel, nachname, vorname, plz, ort, strasse, nr, zusatz, email, lblAdressdaten, separator_1}));
		land.addItem(">> Land <<");
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
		
		setLocationRelativeTo(pFrame);
		
	}
	
	
	
	void setActionListeners(ActionListener al)
	{
		btnErweitert.addActionListener(al);
		btnSpeichern.addActionListener(al);
		btnX.addActionListener(al);
	}
	
	Person getNewPerson()
	{
		Person neu = new Person();
		
		neu.setNachname(nachname.getText());
		neu.setVorname(vorname.getText());
		
		//Persönliche Daten
		
		neu.setPostleitzahl(plz.getText());
		neu.setOrt(ort.getText());
		neu.setStrasse(strasse.getText());
		neu.setHausnummer(nr.getText());
		neu.setAdresszusatz(zusatz.getText());
		
		if (!land.getSelectedItem().toString().equals(">> Land <<"))
		{
			neu.setLand(land.getSelectedItem().toString());
		}
		
		if (!geschlecht.getSelectedItem().toString().equals(">> Geschlecht <<"))
		{
			switch (geschlecht.getSelectedItem().toString())
			{
				case "Männlich": neu.setGeschlecht(Person.Geschlecht.MAENNLICH);
				case "Weiblich": neu.setGeschlecht(Person.Geschlecht.WEIBLICH);
				case "Sonstiges": neu.setGeschlecht(Person.Geschlecht.SONSTIGES);
				case "Unbekannt": neu.setGeschlecht(Person.Geschlecht.UNBEKANNT);
			}
		}
		
		neu.setEmail(email.getText());
		neu.setTelefon(telefonnummer.getText());
		//Geburtsdaten
		
		if (!tag.getSelectedItem().toString().equals("Tag")) //Wenn was ausgewählt
		{
			neu.setGeburtstag(Integer.parseInt(tag.getSelectedItem().toString()));
		}
		
		if (!monat.getSelectedItem().toString().equals("Monat")) //Wenn was ausgewählt
		{
			neu.setGeburtsmonat(Person.Monat.valueOf(monat.getSelectedItem().toString()));
		}
		
		if (!jahr.getSelectedItem().toString().equals("Jahr")) //Wenn was ausgewählt
		{
			neu.setGeburtsjahr(Integer.parseInt(jahr.getSelectedItem().toString()));
		}
		
		return neu;
	}
}
