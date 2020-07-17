import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PlanetsPanel extends JPanel {
	private PlanetsData data;
	public PlanetsPanel(PlanetsData data) {
		this.data = data;
	}
	public void setData(PlanetsData data) {
		this.data = data;
	}
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		// Lines
		g.setColor(Color.red);
		g.drawLine(data.getSunX(), data.getSunY(), data.getEarthX(), data.getEarthY());
		g.drawLine(data.getEarthX(), data.getEarthY(), data.getMoonX(), data.getMoonY());
		// MoonTraectory
		g.setColor(Color.green);
		for (int i = 0; i < data.getMoonTraectory().size(); i+=2) {
			g.drawRect(data.getMoonTraectory().get(i), data.getMoonTraectory().get(i + 1), 1, 1);
		}
		// Sun
		g.setColor(Color.yellow);
		g.fillOval(data.getSunX() - 25, data.getSunY() - 25, 50, 50);
		// Data
		g.setFont(new Font("Courier", Font.BOLD, 12));
		g.setColor(Color.red);
		g.drawString(Integer.toString((int)(data.getEarthAngle() * 180 / Math.PI) - 180), 290, 160);
		// Earth
		g.setColor(Color.cyan);
		g.fillOval(data.getEarthX() - 6, data.getEarthY() - 6, 12, 12);
		// Moon
		g.setColor(Color.white);
		g.fillOval(data.getMoonX() - 3, data.getMoonY() - 3, 6, 6);
		
	}
}

