
import java.awt.EventQueue;

public class CoronaClass {

	public static void main(String[] args) {

		cityComparison comparison = new cityComparison();
		comparison.travelSafeDeterminer();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display window = new Display();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}