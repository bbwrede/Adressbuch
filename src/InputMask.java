import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
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

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
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
	private HintTextField hintTextField;
	private JButton btnSpeichern;
	private JButton btnNewButton;
	private JSeparator separator_3;
	private JButton btnX;
	private JComboBox countries;

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
		
		textField = new HintTextField("Nachname");
		textField.setName("");
		textField.setToolTipText("Nachname");
		textField.setBounds(10, 41, 164, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new HintTextField("Vorname");
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setToolTipText("Vorname");
		textField_1.setName("");
		textField_1.setColumns(10);
		textField_1.setBounds(10, 67, 164, 26);
		contentPane.add(textField_1);
		
		textField_3 = new HintTextField("PLZ / ZIP");
		textField_3.setToolTipText("Postleitzahl bzw. ZIP-Code");
		textField_3.setName("");
		textField_3.setColumns(10);
		textField_3.setBounds(10, 123, 61, 26);
		contentPane.add(textField_3);
		
		textField_4 = new HintTextField("Ort");
		textField_4.setToolTipText("Ort bzw. Stadt");
		textField_4.setName("");
		textField_4.setColumns(10);
		textField_4.setBounds(71, 123, 103, 26);
		contentPane.add(textField_4);
		
		textField_5 = new HintTextField("Strasse");
		textField_5.setToolTipText("Strasse");
		textField_5.setName("");
		textField_5.setColumns(10);
		textField_5.setBounds(10, 149, 131, 26);
		contentPane.add(textField_5);
		
		textField_6 = new HintTextField("Nr.");
		textField_6.setToolTipText("Hausnummer");
		textField_6.setName("");
		textField_6.setColumns(10);
		textField_6.setBounds(142, 149, 32, 26);
		contentPane.add(textField_6);
		
		textField_7 = new HintTextField("Adresszusatz");
		textField_7.setToolTipText("Adresszusatz");
		textField_7.setName("");
		textField_7.setColumns(10);
		textField_7.setBounds(10, 174, 164, 26);
		contentPane.add(textField_7);
		
		textField_8 = new HintTextField("E-Mail");
		textField_8.setToolTipText("E-Mail");
		textField_8.setName("");
		textField_8.setColumns(10);
		textField_8.setBounds(10, 292, 164, 26);
		contentPane.add(textField_8);
		
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
		geschlecht.addItem("M�nnlich");
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
		
		hintTextField = new HintTextField("Telefonnummer");
		hintTextField.setToolTipText("Telefonnummer");
		hintTextField.setName("");
		hintTextField.setColumns(10);
		hintTextField.setBounds(10, 318, 164, 26);
		contentPane.add(hintTextField);
		
		btnSpeichern = new JButton("Speichern");
		btnSpeichern.setBounds(10, 497, 115, 28);
		contentPane.add(btnSpeichern);
		
		btnNewButton = new JButton("Erweitert...");
		btnNewButton.setBounds(10, 441, 164, 28);
		contentPane.add(btnNewButton);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(10, 483, 218, 2);
		contentPane.add(separator_3);
		
		btnX = new JButton("X");
		btnX.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnX.setBounds(130, 497, 44, 28);
		contentPane.add(btnX);
		
		countries = new JComboBox();
		countries.setToolTipText("L\u00E4nder");
		countries.setBounds(10, 200, 164, 26);
		contentPane.add(countries);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{separator, lblNewLabel, textField, textField_1, textField_3, textField_4, textField_5, textField_6, textField_7, textField_8, lblAdressdaten, separator_1}));
		countries.addItem(">> Land <<");
		Countries cn = new Countries();
		String [] temp = cn.getLaender();
		for (int c = 0; c < temp.length; c++)
		{
			countries.addItem(temp[c]);
		}
		
		int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date())); 

		for (int i = year; i > year-120 +1; i--)
		{
			jahr.addItem(Integer.toString(i));
		}
		
		setLocationRelativeTo(pFrame);
		
	}
}
