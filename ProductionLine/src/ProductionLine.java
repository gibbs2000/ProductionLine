import java.util.LinkedList;

/**
 * A ProductionLine which has an input queue of Disks that is converted into an
 * output queue of Towers
 * 
 * @author Sean Gibbons
 *
 */
public class ProductionLine {
	private LinkedList<Disk> input;
	private LinkedList<Tower> output;
	private Tower mrRobot;

	/**
	 * Creates a ProductionLine with empty input and output queues and an empty
	 * robot arm
	 */
	public ProductionLine() {
		input = new LinkedList<Disk>();
		output = new LinkedList<Tower>();
		mrRobot = new Tower();
	}

	/**
	 * Adds a given disk to end the input queue
	 * 
	 * @param d
	 *            the Disk to be added to the input queue
	 */
	public void addDisk(Disk d) {
		input.add(d);
	}

	/**
	 * Inverts the "robot arm" and adds its product to the output queue
	 */
	public void unloadRobot() {
		if (!mrRobot.isEmpty()) {
			Tower nextOut = new Tower();
			for (int i = 0; i < mrRobot.size(); i++) {
				nextOut.push(mrRobot.pop());
			}
			output.add(nextOut);
		}
	}

	/**
	 * Processes through the input queue until empty, using the robot arm to stack
	 * the Disks into appropriately sized towers
	 */
	public void process() {
		while (input.peek() != null) {
			mrRobot.push(input.remove());
			System.out.println(mrRobot.peek());
			if (input.peek() != null && input.peek().compareTo(mrRobot.peek()) <= 0) {
				unloadRobot();
			}

		}

		unloadRobot();

	}

	/**
	 * Removes and returns the first Tower in the output queue
	 * 
	 * @return the first Tower in the output queue
	 */
	public Tower removeTower() {
		return output.remove();
	}

	@Override
	public String toString() {
		return "Input: " + input + "\n\n" + "Output: " + output + "\n\n" + "Robot Arm: " + mrRobot;
	}

	public static void main(String[] args) {

		ProductionLine tester = new ProductionLine();
		Disk[] disks = { new Disk(3), new Disk(5), new Disk(3), new Disk(7), new Disk(10) };
		for (int i = 0; i < disks.length; i++) {
			tester.addDisk(disks[i]);
		}

		System.out.println(tester);
		tester.process();
		System.out.println(tester);

	}
}
