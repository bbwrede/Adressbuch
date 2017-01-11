import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class CreditsMask extends JFrame
{

	private JPanel contentPane;
	private JLabel label;
	private JLabel lblJbook;
	private JLabel lblErstelltVon;
	private JLabel lblFynnLohse;
	private JLabel lblBastianWrede;
	private JSeparator separator;
	private JLabel lblMitInhaltenVon;
	private JLabel lblMhSoftwareentwicklung;
	private JLabel lblJtattoo;
	private JLabel lblKathrynHuxtabl;
	private JLabel lblSeaglassLookAnd;
	private JLabel lblu;

	public CreditsMask()
	{
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CreditsMask.class.getResource("/resources/list.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(CreditsMask.class.getResource("/resources/logoSmall.png")));
		label.setBounds(64, 24, 100, 100);
		contentPane.add(label);
		
		lblJbook = new JLabel("JBook");
		lblJbook.setHorizontalAlignment(SwingConstants.CENTER);
		lblJbook.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblJbook.setBounds(164, 39, 187, 35);
		contentPane.add(lblJbook);
		
		lblErstelltVon = new JLabel("erstellt von");
		lblErstelltVon.setHorizontalAlignment(SwingConstants.CENTER);
		lblErstelltVon.setBounds(199, 85, 100, 14);
		contentPane.add(lblErstelltVon);
		
		lblFynnLohse = new JLabel("Fynn Lohse");
		lblFynnLohse.setHorizontalAlignment(SwingConstants.CENTER);
		lblFynnLohse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFynnLohse.setBounds(199, 110, 100, 14);
		contentPane.add(lblFynnLohse);
		
		lblBastianWrede = new JLabel("Bastian Wrede");
		lblBastianWrede.setHorizontalAlignment(SwingConstants.CENTER);
		lblBastianWrede.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBastianWrede.setBounds(199, 126, 100, 14);
		contentPane.add(lblBastianWrede);
		
		separator = new JSeparator();
		separator.setBounds(177, 151, 158, 2);
		contentPane.add(separator);
		
		lblMitInhaltenVon = new JLabel("mit Inhalten von");
		lblMitInhaltenVon.setHorizontalAlignment(SwingConstants.CENTER);
		lblMitInhaltenVon.setBounds(199, 156, 100, 14);
		contentPane.add(lblMitInhaltenVon);
		
		lblMhSoftwareentwicklung = new JLabel("MH Software-Entwicklung");
		lblMhSoftwareentwicklung.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMhSoftwareentwicklung.setHorizontalAlignment(SwingConstants.CENTER);
		lblMhSoftwareentwicklung.setBounds(177, 188, 158, 14);
		contentPane.add(lblMhSoftwareentwicklung);
		
		lblJtattoo = new JLabel("JTattoo");
		lblJtattoo.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblJtattoo.setBounds(230, 202, 46, 14);
		contentPane.add(lblJtattoo);
		
		lblKathrynHuxtabl = new JLabel("Kathryn Huxtable");
		lblKathrynHuxtabl.setHorizontalAlignment(SwingConstants.CENTER);
		lblKathrynHuxtabl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKathrynHuxtabl.setBounds(177, 223, 158, 14);
		contentPane.add(lblKathrynHuxtabl);
		
		lblSeaglassLookAnd = new JLabel("Seaglass Look and Feel");
		lblSeaglassLookAnd.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblSeaglassLookAnd.setBounds(199, 237, 121, 14);
		contentPane.add(lblSeaglassLookAnd);
		
		lblu = new JLabel("Copyright © 2017 - Bastian Wrede, Fynn Lohse");
		lblu.setHorizontalAlignment(SwingConstants.CENTER);
		lblu.setForeground(Color.GRAY);
		lblu.setBounds(30, 262, 384, 14);
		contentPane.add(lblu);
		
		setVisible(true);
	}
}
