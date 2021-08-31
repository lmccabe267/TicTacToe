import javax.swing.JFrame;


@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	public MainFrame() {
		GamePanel panel = new GamePanel();
		panel.setSize(this.getSize());
		panel.setVisible(true);
		this.add(panel);
		addMouseListener(new MouseChecker(panel));
	}
}
