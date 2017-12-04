
public class Disk implements Comparable<Disk> {
	int radius;

	public Disk(int r) {
		radius = r;
	}

	@Override
	public int compareTo(Disk o) {
		return (int) Math.signum(this.getRadius() - o.getRadius());
	}

	@Override
	public String toString() {
		return "Disk of size " + radius;

	}

	public int getRadius() {
		return radius;
	}
}
