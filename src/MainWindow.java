import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class MainWindow {

	private JFrame frame;
	private PlanetsPanel panel;
	private PlanetsData data;
	private Timer timer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		timer = new Timer(20, new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				data.movePlanets();
				panel.setData(data);
				panel.repaint();
			}
		});
		frame = new JFrame();
		frame.setBounds(100, 100, 701, 413);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		data = new PlanetsData();		
		panel = new PlanetsPanel(data);
		panel.setBounds(10, 11, 665, 352);
		frame.getContentPane().add(panel);
		timer.start();
	}

}
