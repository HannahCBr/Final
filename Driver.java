import javax.swing.JFrame;

/**
 * 
 */

/**
 * @author Hannah
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SymptomTree internal = new SymptomTree();
		
		//EXTERNAL SYMPTOM LIST
		//INTERNAL SYMPTOM LIST
		
		JFrame frame = new PatientFrame();
		//PatientFrame panel = new PatientFrame();
		
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
