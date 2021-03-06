import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
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
	ArrayList<String> array;
	
	JLabel fName = new JLabel("First Name: ");
	JTextField fNameField = new JTextField(10);
	
	JLabel lName = new JLabel("Last Name: ");
	JTextField lNameField = new JTextField(10);
	
	JLabel symptom = new JLabel("Type of symptom(s): ");
	String[] a = {"Choose a symptom type", "External", "Internal"};
	JComboBox exOrIn = new JComboBox(a);
	
	JComboBox<String> internalChoice = new JComboBox<String>();
	JComboBox<String> internalChoice2 = new JComboBox<String>();
	JComboBox<String> internalChoice3 = new JComboBox<String>();
	
	JComboBox<String> externalChoice = new JComboBox<String>();
	JComboBox<String> externalChoice2 = new JComboBox<String>();
	JComboBox<String> externalChoice3 = new JComboBox<String>();
	
	JButton add = new JButton("+");
	
	JButton submit = new JButton("Submit");
	JButton admit = new JButton("Admit Next");
	
	JTextArea patientList = new JTextArea(20, 30);
	JScrollPane scroll = new JScrollPane(patientList);
	JPanel panel = new JPanel();
	
	Patient patient = new Patient();
	SymptomTree external = new SymptomTree();
	SymptomTree internal = new SymptomTree();
	PriorityQueue<Patient> queue = new PriorityQueue<>();
	public PatientFrame() {
		external.insert("1st Degree Burn", 5, 1);external.insert("2nd Degree Burn", 50, 2);external.insert("3rd Degree Burn", 95, 3);external.insert("Animal Bite", 40, 4);external.insert("Broken Bone Protrusion", 75, 5);external.insert("Cyst", 5, 6);external.insert("Joint Dislocation", 15, 7);external.insert("Lost Limb", 100, 8);external.insert("Necrotic Tissue", 90, 9);external.insert("Stab Wound:Critical", 100, 10);external.insert("Stab Wound:Non-critical", 65, 11);
		internal.insert("Dehydration", 30, 1);internal.insert("Dizziness", 25, 2);internal.insert("Fever 101-102", 45, 3);internal.insert("Fever 103-104", 70, 4);internal.insert("Fever 105+", 100, 5);internal.insert("Fluid in Lungs", 75, 6);internal.insert("Headache", 15, 7);internal.insert("Heart Attack", 100, 8);internal.insert("Internal Bleeding", 100, 9);internal.insert("Sore Throat", 10, 10);internal.insert("Stroke", 100, 11);internal.insert("Swollen Lymph Nodes", 25, 12);internal.insert("Vomiting", 30, 13);
		
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
		panel.add(admit);
		admitListener ad = new admitListener();
		admit.addActionListener(ad);
		
		panel.add(patientList);
		add(panel);
	}
	
	class submitListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {	
			int one = 0,two = 0,three = 0;
			if (exOrIn.getSelectedItem() == "Internal") {
				if (internalChoice.getSelectedItem() != null) {
					one = internal.find(internal.root, (String) internalChoice.getSelectedItem());
				}
				if (internalChoice2.isVisible()==true) {
					two = internal.find(internal.root,(String)internalChoice2.getSelectedItem());
				}
				if (internalChoice3.isVisible()==true) {
					three = internal.find(internal.root,(String)internalChoice3.getSelectedItem());
				}
				queue.add(new Patient(internal.math(one, two, three), fNameField.getText(), lNameField.getText()));
			} else {
				if (externalChoice.getSelectedItem() != null) {
					one = external.find(external.root,(String) externalChoice.getSelectedItem());
				}
				if (externalChoice2.isVisible()==true) {
					two = external.find(external.root,(String)externalChoice2.getSelectedItem());
				}
				if (externalChoice3.isVisible()==true) {
					three = external.find(external.root,(String)externalChoice3.getSelectedItem());
				}
				queue.add(new Patient(external.math(one, two, three), fNameField.getText(), lNameField.getText()));
			}
			 //clear patient info for next use
			fNameField.setText("");lNameField.setText("");
			internalChoice.setVisible(false);internalChoice2.setVisible(false);internalChoice3.setVisible(false);
			externalChoice.setVisible(false);externalChoice2.setVisible(false);externalChoice3.setVisible(false);
			limit = 0;
			//END CLEARING	
			patientList.setText(null);
			StringBuilder sb = new StringBuilder();
			Object[] arr = queue.toArray(); //turns queue into array for easy access
			String[] sa = Arrays.stream(arr).map(Object::toString).toArray(String[]::new);//convert again zzz
			for (int i=0;i<arr.length;i++) {
				String temp = sa[i];
				temp = temp.replace("fName=", " "); temp = temp.replace(",", ""); temp = temp.replace("lName=", "");
				sb.append(temp);
				sb.append("\n");
			}
			patientList.insert(sb.toString(), 0); //prints patients onto list (+ADD TIME??)
		}
		
	}
	class admitListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (queue.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No patients to admit");
				return;
			}
			patientList.setText(null);
			queue.poll();
			StringBuilder sb = new StringBuilder();
			Object[] arr = queue.toArray();
			String[] sa = Arrays.stream(arr).map(Object::toString).toArray(String[]::new);
			for (int i=0;i<arr.length;i++) {
				String temp = sa[i];
				temp = temp.replace("fName=", " "); temp = temp.replace(",", ""); temp = temp.replace("lName=", "");
				sb.append(temp);
				sb.append("\n");
			}
			patientList.insert(sb.toString(), 0);
		}
		
	}
	
	class symptomMainListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String list = (String) exOrIn.getSelectedItem();
			if (list == "Internal") {
				array = internal.list(internal.root);
				for (int i=0;i<array.size();i++) {
					internalChoice.addItem(array.get(i));
					internalChoice2.addItem(array.get(i));
					internalChoice3.addItem(array.get(i));
				}
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
