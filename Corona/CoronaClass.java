import java.awt.EventQueue;

public class CoronaClass {

	public static void main(String[] args) {
		
		API api = new API();
		api.testConnection();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display window = new Display();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} // hello
			}
		});

	}

}