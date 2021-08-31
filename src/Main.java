import javax.swing.JFrame;

public class Main {
	public static void main(String[]args) {
		MainFrame frame = new MainFrame();
		frame.setSize(900, 1000);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("tic tac toe");
	}
}
