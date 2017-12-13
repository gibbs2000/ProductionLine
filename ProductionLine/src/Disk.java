/**
 * Represents a Disk with a radius which must be a positive integer
 * 
 * @author Sean Gibbons
 *
 */
public class Disk implements Comparable<Disk> {
	int radius;

	/**
	 * Creates a Disk of a given radius
	 * 
	 * @param r
	 *            the radius of the Disk to be created
	 */
	public Disk(int r) {
		if (r <= 0)
			throw new IllegalArgumentException("Radius is too small");
		radius = r;

		// Uses the absolute value of the radius to ensure that a "real" Disk is
		// created, not an impossible inverted Disk or a Disk of size 0
	}

	/**
	 * Creates a Disk of a random radius between 1 and 5
	 */
	public Disk() {
		radius = (int) (Math.random() * 5) + 1;
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

	/**
	 * Returns the radius of the given Disk
	 * 
	 * @return the radius of the given Disk
	 */
	public int getRadius() {
		return radius;
	}
}
