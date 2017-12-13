
public class ProductionLineTester {
	public static void diskTest() {
		System.out.println("TESTING THE DISK CLASS");
		Disk[] d = { new Disk(5), new Disk(5), new Disk(4), new Disk() };

		for (int i = 0; i < d.length; i++)
			System.out.println("Disk " + i + ": " + d[i]);

	}

	public static void towerTest() {
		System.out.println("TESTING THE TOWER CLASS");

		Tower t = new Tower();
		Disk[] d = { new Disk(5), new Disk(3), new Disk(4), new Disk() };
		for (int i = 0; i < d.length; i++)
			t.add(d[i]);
		System.out.println(t);
	}

	public static void productionLineTest() {
		System.out.println("TESTING THE PRODUCTIONLINE CLASS");

		ProductionLine cans = new ProductionLine();
		Disk[] knownDisks = { new Disk(3), new Disk(5), new Disk(3), new Disk(7), new Disk(10) };
		for (int i = 0; i < knownDisks.length; i++) {
			cans.addDisk(knownDisks[i]);
		}

		System.out.println("TESTING WITH DISKS OF A KNOWN RADIUS");
		System.out.println(cans);
		cans.process();
		System.out.println(cans);

		// Break for output file
		System.out.println();
		System.out.println("******************");
		System.out.println();

		// Tests with Disks of random radii
		ProductionLine donuts = new ProductionLine();
		for (int i = 0; i < 5; i++) {
			donuts.addDisk(new Disk());
		}

		// Tests with Disks of a random radius
		System.out.println("TESTING WITH DISKS WITH A RANDOM RADIUS");
		System.out.println(donuts);
		donuts.process();
		System.out.println(donuts);
	}

	public static void main(String[] args) {

		diskTest();

		towerTest();

		productionLineTest();

	}
}
