import java.util.LinkedList;
import java.util.Stack;

/**
 * A Tower represents a Stack of Disks
 * 
 * @author Sean Gibbons
 *
 */
@SuppressWarnings("serial")
public class Tower extends Stack<Disk> {
	/**
	 * Default constructor for Tower, creates an empty Tower
	 */
	public Tower() {
		super();

	}

	@Override
	public String toString() {
		String s = "\nTower:\n";
		for (Disk d : this) {
			s += (d + "\n");
		}
		s += "\n";

		return s;
	}

	/**
	 * Reverses the elements in the Stack
	 */
	public void flip() {
		LinkedList<Disk> reverse = new LinkedList<Disk>();
		while (!this.isEmpty()) {
			reverse.add(this.pop());
		}
		while (!reverse.isEmpty()) {
			this.push(reverse.remove());
		}

	}
}
