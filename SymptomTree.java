import java.util.ArrayList;
import java.util.Stack;

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
	public void insert(String symptom, int points, int place) { // WORKING!
		Node newNode = new Node(symptom, points, place);
		if (root == null) {
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while (true) {
			parent = current;
			if (place < current.place) {
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

	public int find(Node node, String symptom) { //finds symptom name for severity points
		if (node == null) {
			return 0;
		}
		while (node.symptom.compareTo(symptom) != 0) {
			if (node.symptom.compareTo(symptom) > 0) {
				node = node.left;
			} else {
				node = node.right;
			}
			if (node.symptom.equals(symptom)) {
				return node.points;
			}
		}
		return node.points;
	}
	
	public int nodeToInt(Node node) {
		return node.points;
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
		int place;
		String symptom;
		int points; // severity scale

		Node(String symptom, int points, int place) {
			left = null;
			right = null;
			this.symptom = symptom;
			this.points = points;
			this.place = place;
		}
	}

}
