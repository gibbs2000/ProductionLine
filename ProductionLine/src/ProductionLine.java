import java.util.ArrayList;

public class ProductionLine {

	
	
	
	
	public static void main(String[] args) {
		Tower t = new Tower();
		ArrayList<Disk> d = new ArrayList<Disk>();
		d.add(new Disk(1));
		d.add(new Disk(3));
		d.add(new Disk(4));
		for (Disk disk : d) {
			t.push(disk);
		}

		System.out.println(t);
		t.invert();
		System.out.println(t);

	}
}
