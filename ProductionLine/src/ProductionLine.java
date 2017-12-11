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
//		System.out.println("processing" + input);
		while (!input.isEmpty()) {
			mrRobot.push(input.remove());
//			System.out.println("Robot " + mrRobot.peek());
			 while (!input.isEmpty()&&(input.peek().compareTo(mrRobot.peek()) >= 0)) {
			 mrRobot.push(input.remove());
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
		Disk[] disks = { new Disk(3), new Disk(5), new Disk(2), new Disk(4) };
		for (Disk d : disks) {
			tester.addDisk(d);
		}
		// for (int i = 0; i < 5; i++) {
		// tester.addDisk(new Disk());
		// }

		System.out.println(tester);
		tester.process();
		System.out.println("Processeing complete");
		System.out.println(tester);

	}
}
