/**
 * Tests the ProductionLine class and related classes
 * 
 * @author Sean Gibbons
 *
 */
public class ProductionLineTester {
	/**
	 * Tests the Disk class
	 */
	public static void diskTest() {
		System.out.println("TESTING THE DISK CLASS");
		Disk[] d = { new Disk(5), new Disk(5), new Disk(4), new Disk() };

		for (int i = 0; i < d.length; i++)
			System.out.println("Disk " + i + ": " + d[i]);

	}

	/**
	 * Tests the Tower class
	 */
	public static void towerTest() {
		System.out.println("TESTING THE TOWER CLASS");

		Tower t = new Tower();
		Disk[] d = { new Disk(5), new Disk(3), new Disk(4), new Disk() };
		for (int i = 0; i < d.length; i++)
			t.add(d[i]);
		System.out.println(t);
	}

	/**
	 * Tests the ProductionLine class
	 */
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

		// Break for output file
		System.out.println();
		System.out.println("******************");
		System.out.println();

		// Tests with an empty Array of Disks
		ProductionLine tires = new ProductionLine();
		Disk[] goodyear = new Disk[5];
		for (int i = 0; i < goodyear.length; i++) {
			donuts.addDisk(goodyear[i]);
		}

		// Tests with Disks of a random radius
		System.out.println("TESTING WITH AN EMPTY ARRAY");
		System.out.println(tires);
		donuts.process();
		System.out.println(tires);

		// Break for output file
		System.out.println();
		System.out.println("******************");
		System.out.println();

		// Tests with Disks in one big Tower
		ProductionLine bagels = new ProductionLine();
		for (int i = 5; i < 10; i++) {
			bagels.addDisk(new Disk(i));
		}

		// Tests with Disks that are in order to make one big Tower
		System.out.println("TESTING WITH DISKS THAT ARE IN ORDER TO MAKE ONE BIG TOWER");
		System.out.println(bagels);
		bagels.process();
		System.out.println(bagels);

		// Break for output file
		System.out.println();
		System.out.println("******************");
		System.out.println();

		// Tests with Disks that are all the same
		ProductionLine cookies = new ProductionLine();
		for (int i = 0; i < 5; i++) {
			cookies.addDisk(new Disk(3));
		}

		// Tests with Disks that are all the same
		System.out.println("TESTING WITH DISKS THAT ARE ALL THE SAME");
		System.out.println(cookies);
		cookies.process();
		System.out.println(cookies);

	}

	public static void main(String[] args) {

		diskTest();

		towerTest();

		productionLineTest();

	}
}
