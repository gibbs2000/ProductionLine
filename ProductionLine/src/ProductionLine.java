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
			mrRobot.push(input.remove());
			while (!input.isEmpty()&&(input.peek().compareTo(mrRobot.peek()) <=  0)) {
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
		for (int i = 0; i < 5; i++) {
			tester.addDisk(new Disk());
		}

		System.out.println(tester);
		tester.process();
		System.out.println(tester);

	}
}
