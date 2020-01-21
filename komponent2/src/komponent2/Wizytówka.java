package komponent2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.EventSetDescriptor;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;

public class Wizytówka extends JComponent implements Serializable{
	private FileOutputStream fos = null;
	private ObjectOutputStream oos = null;
	public JTextField getTxtImie() {
		return textField;
	}
	public void setTxtImie(JTextField txtImie) {
		this.textField = txtImie;
	}
	public FileOutputStream getFos() {
		return fos;
	}
	public void setFos(FileOutputStream fos) {
		this.fos = fos;
	}
	public ObjectOutputStream getOos() {
		return oos;
	}
	public void setOos(ObjectOutputStream oos) {
		this.oos = oos;
	}
	public void setDane(List<String> dane) {
		this.dane = dane;
	}
	private List<String> dane =new ArrayList<String>();
	private JPanel panel;
	private JLabel label;
	private JLabel label_1;
	private JTextField textField;
	private JLabel label_2;
	private JTextField textField_1;
	private JLabel label_3;
	private JTextField textField_2;
	private JLabel label_4;
	private JTextField textField_3;
	private JButton button;
	private JButton button_1;
	
		Wizytówka(){
		
		
		setSize(300,235);
		setLayout(new MigLayout("", "[grow]", "[225.00,grow]"));
		
		panel = new JPanel();
		add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[88px][][][5px]", "[22px][][][][25px][][]"));
		
		label = new JLabel("Dodaj kontakt");
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(label, "cell 1 1,alignx right,aligny top");
		
		label_1 = new JLabel("Imie");
		panel.add(label_1, "cell 0 2,alignx left,aligny center");
		
		textField = new JTextField(); 
		textField.setToolTipText("wpisz imie");
		textField.setText("");
		textField.setColumns(10);
		panel.add(textField, "cell 2 2,alignx left,aligny top");
		
		label_2 = new JLabel("Nazwisko");
		panel.add(label_2, "cell 0 3,alignx left,aligny center");
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("nazwisko");
		textField_1.setText("");
		textField_1.setColumns(10);
		panel.add(textField_1, "cell 2 3,alignx left,aligny top");
		
		label_3 = new JLabel("Numer telefonu");
		panel.add(label_3, "cell 0 4,alignx left,aligny center");
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("numer telefonu");
		textField_2.setText("");
		textField_2.setColumns(10);
		panel.add(textField_2, "cell 2 4,alignx left,aligny center");
		
		label_4 = new JLabel("E-mail");
		panel.add(label_4, "cell 0 5,alignx left,aligny center");
		
		button = new JButton("Anuluj");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("e-mail");
		textField_3.setText("");
		textField_3.setColumns(10);
		panel.add(textField_3, "cell 2 5,alignx left,aligny center");
		panel.add(button, "cell 0 8,alignx left,aligny top");
		
		button_1 = new JButton("Dodaj");
		panel.add(button_1, "cell 2 8,alignx left,aligny top");
		
		List<String> lista = new ArrayList<String>();
		try {
			File f = new File("obj.ser");
				
				FileInputStream fis= new FileInputStream(f);
				ObjectInputStream ois= new ObjectInputStream(fis);
				lista = (List<String>) ois.readObject();
				ois.close();
				fis.close();
				this.setPola(lista); 
			
			
		}catch (Exception e) {
			try {
				save(false);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//setVisible(true);
			e.printStackTrace();
		}
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
	}
		protected boolean sprawdzam(){
			if(textField.getText().isEmpty() || textField_3.getText().indexOf("@")==-1||textField_2.getText().length()!=9){
				
				return false;
				
			}
			for(int i=0;i<8;i+=1) {
				try {
					int zmienna=Integer.parseInt((String) textField_2.getText().subSequence(i,i+1));
				if(zmienna<0) {
					return false;
				}
				}catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
			
			return true;
			
			
		}
		
		public List<String> getDane(){
			return this.dane;
		}
		public String getDana(int i){
			return  (String) this.dane.get(i);
		}
		private void setDanePol() {
			dane.removeAll(dane);
			dane.add(0, textField.getText());
			dane.add(1, textField_1.getText());
			dane.add(2, textField_2.getText());
			dane.add(3, textField_3.getText());
		}
		void setPola(List<String> dane) {
		
	}
		private void save(boolean ktory) throws FileNotFoundException {
			if(ktory) {
				this.textField.setText("");
				this.textField_1.setText("");
				this.textField_2.setText("");
				this.textField_3.setText("");
			}
				setDanePol();
				try {
					File f= new File("obj.ser");
					this.fos = new FileOutputStream(f);
					this.oos = new ObjectOutputStream(fos);
					oos.writeObject(this.dane);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						oos.close();
						fos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
			
				
			
		}

public JTextField getTxtWpiszImie() {
	return textField;
}
public void setTxtWpiszImie(JTextField txtWpiszImie) {
	this.textField = txtWpiszImie;
}
public JTextField getTxtNazwisko() {
	return textField_1;
}
public void setTxtNazwisko(JTextField txtNazwisko) {
	this.textField_1 = txtNazwisko;
}
public JTextField getTxtTelefon() {
	return textField_2;
}
public void setTxtTelefon(JTextField txtTelefon) {
	this.textField_2 = txtTelefon;
}
public JTextField getTxtEmail() {
	return textField_3;
}
public void setTxtEmail(JTextField txtEmail) {
	this.textField_3 = txtEmail;
}
public JButton getBtnDodaj() {
	return button_1;
}
public void setBtnDodaj(JButton btnDodaj) {
	this.button_1 = btnDodaj;
}
public JButton getBtnAnuluj() {
	return button;
}
public void setBtnAnuluj(JButton btnAnuluj) {
	this.button = btnAnuluj;
}
public JLabel getLblDodajKontakt() {
	return label;
}
public void setLblDodajKontakt(JLabel lblDodajKontakt) {
	this.label = lblDodajKontakt;
}
public JLabel getLblImie() {
	return label_1;
}
public void setLblImie(JLabel lblImie) {
	this.label_1 = lblImie;
}
public JLabel getLblNazwisko() {
	return label_2;
}
public void setLblNazwisko(JLabel lblNazwisko) {
	this.label_2 = lblNazwisko;
}
public JLabel getLblNumerTelefonu() {
	return label_3;
}
public void setLblNumerTelefonu(JLabel lblNumerTelefonu) {
	this.label_3 = lblNumerTelefonu;
}
public JLabel getLblEmail() {
	return label_4;
}
public void setLblEmail(JLabel lblEmail) {
	this.label_4 = lblEmail;
}

public void updateFont(){
	button_1.setFont(this.getFont());
	button.setFont(this.getFont());
	label_1.setFont(this.getFont());
	label_2.setFont(this.getFont());
	label_3.setFont(this.getFont());
	label_4.setFont(this.getFont());
	label.setFont(this.getFont());
}
}