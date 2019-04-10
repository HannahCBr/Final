import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * 
 */

/**
 * @author Hannah
 *
 */
public class PatientFrame extends JFrame{
	int limit = 0;
	int one = 0,two = 0,three = 0;
	ArrayList<String> array;
	
	JLabel fName = new JLabel("First Name: ");
	JTextField fNameField = new JTextField(10);
	
	JLabel lName = new JLabel("Last Name: ");
	JTextField lNameField = new JTextField(10);
	
	JLabel symptom = new JLabel("Type of symptom(s): ");
	String[] a = {"Choose a symptom type", "External", "Internal"};
	JComboBox exOrIn = new JComboBox(a);
	
	//add updateable text area
	
	JComboBox<String> internalChoice = new JComboBox<String>();
	JComboBox<String> internalChoice2 = new JComboBox<String>();
	JComboBox<String> internalChoice3 = new JComboBox<String>();
	
	JComboBox<String> externalChoice = new JComboBox<String>();
	JComboBox<String> externalChoice2 = new JComboBox<String>();
	JComboBox<String> externalChoice3 = new JComboBox<String>();
	
	JButton add = new JButton("+");
	
	JButton submit = new JButton("Submit");
	
	JPanel panel = new JPanel();
	
	SymptomTree external = new SymptomTree();
	public PatientFrame() {
		external.insert("1st Degree Burn", 5);external.insert("2nd Degree Burn", 50);external.insert("3rd Degree Burn", 95);external.insert("Animal Bite", 40);external.insert("Broken Bone Protrusion", 75);external.insert("Cyst", 5);external.insert("Joint Dislocation", 15);external.insert("Lost Limb", 100);external.insert("Necrotic Tissue", 90);external.insert("Stab Wound:Critical", 100);external.insert("Stab Wound:Non-critical", 65);
		
		
		panel.add(fName);
		panel.add(fNameField);
		panel.add(lName);
		panel.add(lNameField);
		
		panel.add(symptom);
		panel.add(exOrIn);
		
		panel.add(internalChoice);panel.add(internalChoice2);panel.add(internalChoice3);
		internalChoice.setVisible(false);internalChoice2.setVisible(false);internalChoice3.setVisible(false);
		panel.add(externalChoice);panel.add(externalChoice2);panel.add(externalChoice3);
		externalChoice.setVisible(false);externalChoice2.setVisible(false);externalChoice3.setVisible(false);
		
		panel.add(add);
		add.setVisible(false);
		addListener a1 = new addListener();
		add.addActionListener(a1);
		
		symptomMainListener s = new symptomMainListener();
		exOrIn.addActionListener(s);
		
		panel.add(submit);
		submitListener sub = new submitListener();
		submit.addActionListener(sub);
		
		add(panel);
	}
	
	class submitListener implements ActionListener{ //FINISH
		@Override
		public void actionPerformed(ActionEvent e) {	
			Patient patient = new Patient();
			patient.setfName(fNameField.getText());
			patient.setlName(lNameField.getText());
			if (exOrIn.getSelectedItem() == "Internal") {
				if (internalChoice.getSelectedItem() != null) {
					patient.setS1((String) internalChoice.getSelectedItem());
				}
				if (internalChoice2.isVisible()==true) {
					patient.setS2((String)internalChoice2.getSelectedItem());
				}
				if (internalChoice3.isVisible()==true) {
					patient.setS3((String)internalChoice3.getSelectedItem());
				}
			} else {
				if (externalChoice.getSelectedItem() != null) {
					patient.setS1((String) externalChoice.getSelectedItem());
					one = external.find((String) externalChoice.getSelectedItem());
				}
				if (externalChoice2.isVisible()==true) {
					patient.setS2((String) externalChoice2.getSelectedItem());
					two = external.find((String)externalChoice2.getSelectedItem());
				}
				if (externalChoice3.isVisible()==true) {
					patient.setS3((String) externalChoice3.getSelectedItem());
					three = external.find((String)externalChoice3.getSelectedItem());
				}
				patient.setTotal(external.math(one, two, three));
				System.out.println(patient.total);
			}
			System.out.println(patient.toString());
			
		}
		
	}
	
	class symptomMainListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String list = (String) exOrIn.getSelectedItem();
			if (list == "Internal") {
				SymptomTree internal = new SymptomTree();
				internalChoice.setVisible(true);
				externalChoice.setVisible(false);
				add.setVisible(true);
			}else if (list == "External") {
				
				array = external.list(external.root);
				for (int i=0;i<array.size();i++) {
					externalChoice.addItem(array.get(i));
					externalChoice2.addItem(array.get(i));
					externalChoice3.addItem(array.get(i));
				}
				externalChoice.setVisible(true);
				internalChoice.setVisible(false);
				add.setVisible(true);
			}
		}
		
	}
	class addListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String choice = (String) exOrIn.getSelectedItem();
			if (choice == "Internal") {
				if (limit == 0) {
					internalChoice2.setVisible(true);
					limit++;
				} else if (limit == 1) {
					internalChoice3.setVisible(true);
				}
			} else if (choice == "External") {
				if (limit == 0) {
					externalChoice2.setVisible(true);
					limit++;
				} else if (limit == 1) {
					externalChoice3.setVisible(true);
				}
			}
			
		}
		
	}
	
}
