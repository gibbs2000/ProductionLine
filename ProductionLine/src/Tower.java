import java.util.ArrayList;
import java.util.Stack;

@SuppressWarnings("serial")
public class Tower extends Stack<Disk> {

	boolean isRegular;

	public Tower() {
		super();
		isRegular = true;

	}

	public void invert() {
		ArrayList<Disk> flipped = new ArrayList<Disk>();
		while (!this.isEmpty()) {
			flipped.add(this.pop());
		}
		for (Disk d : flipped) {
			this.push(d);
		}
		isRegular = !isRegular;

	}
	
}
