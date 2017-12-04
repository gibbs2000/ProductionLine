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
			Disk temp = input.pop();
			mrRobot.push(temp);
			while (temp.compareTo(input.peek()) < 0) {
				mrRobot.add(input.pop());
			}
			unloadRobot();
		}
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
		Disk[] disks = { new Disk(1), new Disk(3), new Disk(5), new Disk(3), new Disk(7), new Disk(1) };
		for (Disk d : disks) {
			tester.addDisk(d);
		}

		System.out.println(tester);
		tester.process();
		System.out.println(tester);

	}
}
