import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Hannah
 *
 */
public class SymptomTree {
	Node root;
	protected int size;
	protected int total;


	// constructors
	SymptomTree() {
		root = null;
		size = 0;
	}

	// methods
	public void insert(String symptom, int points) { //inserts symptom and value
		Node newNode = new Node(symptom, points);
		if (root == null) {
			root = newNode;
			size++;
			return;
		}
		Node current = root;
		Node parent = null;
		while (true) {
			parent = current;
			if (points < current.points) {
				current = current.left;
				if (current == null) {
					parent.left = newNode;
					size++;
					return;
				}
			} else {
				current = current.right;
				if (current == null) {
					parent.right = newNode;
					size++;
					return;
				}
			}
		}

	}

	public int find(String symptom) { //finds symptom name for severity points
		Node focus = root; //FIX FIND THING TO LOOK AT ALL NODES

		while (focus.symptom.compareTo(symptom) != 0) {
			if (focus.symptom.compareTo(symptom) > 0) {
				focus = focus.left;
			} else {
				focus = focus.right;
			}
			if (focus == null) {
				return 0;
			}
			if (focus.symptom.equals(symptom)) {
				return focus.points;
			}
		}
		return focus.points;
	}
	
	public ArrayList<String> list(Node root) { //lists all symptoms from tree for combobox
		ArrayList<String> string = new ArrayList<String>();
		
		if (root!=null) {
			string.add(root.symptom);
		}
		if (root.left!=null) {
			string.addAll(list(root.left));
		}
		if (root.right!=null) {
			string.addAll(list(root.right));
		}
		
		return string;
	}
	
	public int math(int one, int two, int three) {
		return one+two+three;
	}

	// NODE CLASS
	class Node {
		Node left, right;
		String symptom;
		int points; // severity scale

		Node(String symptom, int points) {
			left = null;
			right = null;
			this.symptom = symptom;
			this.points = points;
		}
	}

}
