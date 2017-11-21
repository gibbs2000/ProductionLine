
public class Disk implements Comparable<Disk> {

	int radius;

	public Disk(int r) {
		radius = r;

	}

	@Override
	public int compareTo(Disk o) {
		return this.radius - o.radius;
	}
}
