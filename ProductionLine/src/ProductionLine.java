import java.util.LinkedList;

public class ProductionLine {
	private LinkedList<Disk> input;
	private LinkedList<Tower> output;
	private Tower mrRobot;

	public ProductionLine() {
		input = new LinkedList<Disk>();
		output = new LinkedList<Tower>();
		mrRobot = new Tower();
	}

	public void addDisk(Disk d) {
		input.add(d);
	}

	public void unloadRobot() {
		Tower nextOut = new Tower();
		for (int i = 0; i < mrRobot.size(); i++) {
			nextOut.push(mrRobot.pop());
		}
		output.add(nextOut);
	}

	public void process() {
		while (!input.isEmpty()) {
			Disk base = input.remove();
			mrRobot.push(base);
			while (!input.isEmpty()&&(input.peek().compareTo(mrRobot.peek()) <  0)) {
				mrRobot.push(input.pop());
			}
			unloadRobot();
		}
		unloadRobot();
	}

	public Tower removeTower() {
		return output.remove();
	}

	@Override
	public String toString() {
		return "Input: " + input + "\n\n" + "Output: " + output + "\n\n" + "Robot Arm: " + mrRobot;
	}

	public static void main(String[] args) {

		ProductionLine tester = new ProductionLine();
		Disk[] disks = { new Disk(1), new Disk(3), new Disk(5), new Disk(3), new Disk(7), new Disk(1), new Disk(10), new Disk(13) };
		for (int i = 0; i < disks.length; i++) {
			tester.addDisk(disks[i]);
		}

		System.out.println(tester);
		tester.process();
		System.out.println(tester);

	}
}
