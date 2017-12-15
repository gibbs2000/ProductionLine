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
		try {
			input.add(d);

		} catch (NullPointerException nullDisk) {
			System.out.println("Cannot ask null disk");
		}

	}

	/**
	 * Inverts the "robot arm" and adds its product to the output queue
	 */
	public void unloadRobot() {
		Tower nextOut = new Tower();
		while (!mrRobot.isEmpty()) {
			nextOut.add(mrRobot.pop());

		}
		nextOut.flip();
		output.add(nextOut);
	}

	/**
	 * Processes through the input queue until empty, using the robot arm to stack
	 * the Disks into appropriately sized towers
	 */
	public void process() {
		System.out.println("Processing");
		if (!input.isEmpty())
			mrRobot.push(input.remove());
		while (!input.isEmpty() && mrRobot.peek() != null) {
			if (input.peek().compareTo(mrRobot.peek()) < 0)
				unloadRobot();
			mrRobot.push(input.remove());

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

}
