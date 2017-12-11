
public class Disk implements Comparable<Disk> {
	int radius;

	public Disk(int r) {
		radius = r;
	}

	public Disk() {
		radius = (int)(Math.random()*5)+1;
	}
	
	@Override
	public int compareTo(Disk o) {
		return (int) Math.signum(this.getRadius() - o.getRadius());
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < radius; i++) {
			s += "=";
		}
		return s;

	}

	public int getRadius() {
		return radius;
	}
}
