import java.util.Stack;

@SuppressWarnings("serial")
public class Tower extends Stack<Disk> {


	public Tower() {
		super();

	}

	@Override
	public String toString() {
		String s = "\nTower:\n";
		for (Disk d : this) {
			s +=( d + "\n");
		}
		s+="\n";

		return s;
	}
}
