package komponent2;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.JComboBox;
import java.awt.Font;

public class test_komonentu extends JFrame implements ActionListener {
	private JTextField textField;
	private JCheckBox chckbxTytu = new JCheckBox("Tytuł");
	private JCheckBox chckbxImie = new JCheckBox("Imie");
	private JCheckBox chckbxNazwisko = new JCheckBox("Nazwisko");
	private JCheckBox chckbxNumerTelefonu = new JCheckBox("Numer telefonu");
	private JCheckBox chckbxEmail = new JCheckBox("E-mail"); 
	private JCheckBox chckbxPrzyciskAnuluj = new JCheckBox("Przycisk Anuluj");
	private JCheckBox chckbxPrzyciskDodaj = new JCheckBox("Przycisk Dodaj");
	private JButton btnZmie = new JButton("Zmień");
	private JColorChooser wyb;
	private JButton but1 = new JButton("Nimbus");
	private JButton but2 = new JButton("Windows");
	private JButton but3 = new JButton("Metal");
	private JButton btnKolorTa = new JButton("Kolor tła");
	private static Wizytówka wizytówka = new Wizytówka();
	public test_komonentu() {
		setFont(new Font("Dialog", Font.PLAIN, 18));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,500);
		getContentPane().setLayout(new MigLayout("", "[grow]", "[grow][grow]"));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[grow][][grow][][][]", "[][][]"));
		
		
		chckbxTytu.setSelected(true);
		chckbxTytu.addActionListener(this);
		panel.add(chckbxTytu, "cell 0 0");
		
		
		chckbxImie.setSelected(true);
		chckbxImie.addActionListener(this);
		panel.add(chckbxImie, "cell 1 0");
		
		
		chckbxNazwisko.setSelected(true);
		chckbxNazwisko.addActionListener(this);
		panel.add(chckbxNazwisko, "cell 2 0");
		
		
		chckbxNumerTelefonu.setSelected(true);
		chckbxNumerTelefonu.addActionListener(this);
		panel.add(chckbxNumerTelefonu, "cell 3 0");
		
		
		chckbxEmail.setSelected(true);
		chckbxEmail.addActionListener(this);
		panel.add(chckbxEmail, "cell 4 0");
		
		
		chckbxPrzyciskAnuluj.setSelected(true);
		chckbxPrzyciskAnuluj.addActionListener(this);
		panel.add(chckbxPrzyciskAnuluj, "cell 5 0");
		
		
		chckbxPrzyciskDodaj.setSelected(true);
		chckbxPrzyciskDodaj.addActionListener(this);
		panel.add(chckbxPrzyciskDodaj, "cell 0 1");
		
		JLabel lblZmieTytu = new JLabel("Zmień tytuł: ");
		panel.add(lblZmieTytu, "cell 1 1,alignx trailing");
		
		textField = new JTextField();
		textField.setToolTipText("Wpisz nowy tytuł");
		panel.add(textField, "cell 2 1,growx");
		textField.setColumns(10);
		
		btnZmie.addActionListener(this);
		panel.add(btnZmie, "flowx,cell 3 1");
		btnKolorTa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wizytówka.setBackground(new JColorChooser().showDialog(wizytówka, "wybierz kolor tła", wizytówka.getBackground()));
				
			}
		});
		
		panel.add(btnKolorTa, "cell 3 1");
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, "cell 0 1,grow");
		
		
		panel_1.add(wizytówka);
		
		
	}
	
	public static void main(String[] args) {
		String tab1[]= {"q","w","123456789","@"};
		String tab2[]= {"q","w","56789","@"};
		String tab3[]= {"q","w","123456789","wp.pl"};
		String tab4[]= {"","","",""};
		test_komonentu T = new test_komonentu();
		T.setVisible(true);
		if(test01(tab1[0],tab1[1],tab1[2],tab1[3])) {
			System.out.print("Dane wejściowe: "+tab1[0]+" "+tab1[1]+" "+tab1[2]+" "+tab1[3]+" ");
			System.out.println("TEST 1 ZALICZONY");
		}else{
			System.out.print("Dane wejściowe: "+tab1[0]+" "+tab1[1]+" "+tab1[2]+" "+tab1[3]+" ");
			System.out.println("TEST 1 NIE ZALICZONY");
		}
		
		if(test01(tab2[0],tab2[1],tab2[2],tab2[3])) {
			System.out.print("Dane wejściowe: "+tab2[0]+" "+tab2[1]+" "+tab2[2]+" "+tab2[3]+" ");
			System.out.println("TEST 1 ZALICZONY");
		}else{
			System.out.print("Dane wejściowe: "+tab2[0]+" "+tab2[1]+" "+tab2[2]+" "+tab2[3]+" ");
			System.out.println("TEST 1 NIE ZALICZONY");
		}
		if(test01(tab3[0],tab3[1],tab3[2],tab3[3])) {
			System.out.print("Dane wejściowe: "+tab3[0]+" "+tab3[1]+" "+tab3[2]+" "+tab3[3]+" ");
			System.out.println("TEST 1 ZALICZONY");
		}else{
			System.out.print("Dane wejściowe: "+tab3[0]+" "+tab3[1]+" "+tab3[2]+" "+tab3[3]+" ");
			System.out.println("TEST 1 NIE ZALICZONY");
		}
		if(test01(tab4[0],tab4[1],tab4[2],tab4[3])) {
			System.out.print("Dane wejściowe: "+tab4[0]+" "+tab4[1]+" "+tab4[2]+" "+tab4[3]+" ");
			System.out.println("TEST 1 ZALICZONY");
		}else{
			System.out.print("Dane wejściowe: "+tab4[0]+" "+tab4[1]+" "+tab4[2]+" "+tab4[3]+" ");
			System.out.println("TEST 1 NIE ZALICZONY");
		}
		if(test02(tab1[0],tab1[1],tab1[2],tab1[3])) {
			System.out.print("Dane wejściowe: "+tab1[0]+" "+tab1[1]+" "+tab1[2]+" "+tab1[3]+" ");
			System.out.println("TEST 2 ZALICZONY");//test serializacji
		}else{
			System.out.print("Dane wejściowe: "+tab1[0]+" "+tab1[1]+" "+tab1[2]+" "+tab1[3]+" ");
			System.out.println("TEST 2 NIE ZALICZONY");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object sorce=e.getSource();
		if(sorce==chckbxTytu && !chckbxTytu.isSelected()) {
			wizytówka.getLblDodajKontakt().setVisible(false);
		}else if(sorce==chckbxTytu && chckbxTytu.isSelected()){
			wizytówka.getLblDodajKontakt().setVisible(true);
		}else if (sorce==btnZmie){
			wizytówka.getLblDodajKontakt().setText(this.textField.getText());
		}else if(sorce==chckbxImie && chckbxImie.isSelected()){
			wizytówka.getLblImie().setVisible(true);
			wizytówka.getTxtWpiszImie().setVisible(true);
		}else if(sorce==chckbxImie && !chckbxImie.isSelected()){
			wizytówka.getLblImie().setVisible(false);
			wizytówka.getTxtWpiszImie().setVisible(false);
		}else if(sorce==chckbxNazwisko && chckbxNazwisko.isSelected()){
			wizytówka.getLblNazwisko().setVisible(true);
			wizytówka.getTxtNazwisko().setVisible(true);
		}else if(sorce==chckbxNazwisko && !chckbxNazwisko.isSelected()){
			wizytówka.getLblNazwisko().setVisible(false);
			wizytówka.getTxtNazwisko().setVisible(false);
		}else if(sorce==chckbxNumerTelefonu && chckbxNumerTelefonu.isSelected()){
			wizytówka.getLblNumerTelefonu().setVisible(true);
			wizytówka.getTxtTelefon().setVisible(true);
		}else if(sorce==chckbxNumerTelefonu && !chckbxNumerTelefonu.isSelected()){
			wizytówka.getLblNumerTelefonu().setVisible(false);
			wizytówka.getTxtTelefon().setVisible(false);
		}else if(sorce==chckbxEmail && chckbxEmail.isSelected()){
			wizytówka.getLblEmail().setVisible(true);
			wizytówka.getTxtEmail().setVisible(true);
		}else if(sorce==chckbxEmail && !chckbxEmail.isSelected()){
			wizytówka.getLblEmail().setVisible(false);
			wizytówka.getTxtEmail().setVisible(false);
		}if(sorce==chckbxPrzyciskAnuluj && !chckbxPrzyciskAnuluj.isSelected()) {
			wizytówka.getBtnAnuluj().setVisible(false);
		}else if(sorce==chckbxPrzyciskAnuluj && chckbxPrzyciskAnuluj.isSelected()){
			wizytówka.getBtnAnuluj().setVisible(true);
		}if(sorce==chckbxPrzyciskDodaj && !chckbxPrzyciskDodaj.isSelected()) {
			wizytówka.getBtnDodaj().setVisible(false);
		}else if(sorce==chckbxTytu && chckbxTytu.isSelected()){
			wizytówka.getBtnDodaj().setVisible(true);
		}else {
			System.out.print("Nieznane zródło");
		}
		
		
	}
	
	public static boolean test01(String a,String b,String c,String d) {
		wizytówka.getTxtWpiszImie().setText(a);
		wizytówka.getTxtNazwisko().setText(b);
		wizytówka.getTxtTelefon().setText(c);
		wizytówka.getTxtEmail().setText(d);
		wizytówka.getBtnDodaj().doClick();
			if(wizytówka.getTxtWpiszImie().getText().isEmpty()&& wizytówka.getTxtNazwisko().getText().isEmpty() &&wizytówka.getTxtTelefon().getText().isEmpty() && wizytówka.getTxtEmail().getText().isEmpty()) {
				return true;
			}
			else {
				return false;
			}
		
	}
	public static boolean test02(String a,String b,String c,String d) {
		wizytówka.getTxtWpiszImie().setText(a);
		wizytówka.getTxtNazwisko().setText(b);
		wizytówka.getTxtTelefon().setText(c);
		wizytówka.getTxtEmail().setText(d);
		wizytówka.getBtnAnuluj().doClick();
		List lista2 = new ArrayList<String>();
		try {
			File f = new File("obj.ser");
			FileInputStream fis= new FileInputStream(f);
			ObjectInputStream ois= new ObjectInputStream(fis);
			lista2 = (List) ois.readObject();
			ois.close();
			fis.close();
			if(lista2.get(0).equals(a) && lista2.get(1).equals(b) && lista2.get(3).equals(d) && lista2.get(2).equals(c)){
				
				return true;
			}else {
				return false;
			}
			}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
