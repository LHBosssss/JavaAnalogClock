
import java.awt.Color;
import java.awt.Graphics;
import java.time.LocalTime;
import java.awt.Font;
import javax.swing.JFrame;

public class Ve extends JFrame {
	kim dh;

	public static void main(String[] args) {
		new Ve();
	}

	public Ve() {
		this.setTitle("Ve dong ho Analog");
		this.setSize(500, 500);
		this.setBackground(Color.LIGHT_GRAY);
		this.setDefaultCloseOperation(3);
		dh = new kim();
		dh.start();
		this.setVisible(true);
	}

	public void paint(Graphics g) {

		//vemat
		g.setColor(Color.GRAY);
		g.fillOval(50, 50, 400, 400);
		g.setColor(Color.WHITE);
		g.fillOval(60, 60, 380, 380);
		//veso
		for (int i = 0; i < 12; i++){
			double goc;
			goc = i * 30 * Math.PI / 180;
			int x=0,y=0;
			x = 250 - 5 + (int) (180 * Math.sin(goc));
			y = 250 + 5 + (int) (180 * -Math.cos(goc));
			g.setColor(Color.BLUE);
			if (i != 0){
				g.drawString(Integer.toString(i), x, y);
			}
			else {
				g.drawString("12", x, y);
			}
		}
		//ve vach
		for (int i = 0; i < 60; i++) {
			double goc;
			goc = i * 6 * Math.PI / 180;
			int x1, y1, x2, y2;
			x1 = 250 + (int) (187 * Math.sin(goc));
			y1 = 250 + (int) (187 * -Math.cos(goc));
			x2 = 250 + (int) (182 * Math.sin(goc));
			y2 = 250 + (int) (182 * -Math.cos(goc));
			if (i % 5 != 0){
				g.setColor(Color.BLACK);
				g.drawLine(x1, y1, x2, y2);
			}
			
		}

		//vekim
		g.setColor(Color.RED);
		g.drawLine(250, 250, dh.xs1, dh.ys1);
		g.setColor(Color.BLACK);
		g.drawLine(250, 250, dh.xm1, dh.ym1);
		g.drawLine(250, 250, dh.xh1, dh.yh1);
		g.setColor(Color.BLACK);
		g.fillOval(246, 246, 8, 8);
		g.setColor(Color.RED);
		g.fillOval(248, 248, 4, 4);

		//repaint
		try {
			Thread.sleep(1000);
			this.repaint();
		} catch (Exception e) {
		}
	}
}

class kim extends Thread {
//
	int hour, minute, second;
	double rsecond, rminute, rhours;
	int xs1, xm1, xh1, ys1, ym1, yh1;

	public kim() {
            xs1 = 250;
			ys1 = 250 + 180;
			xm1 = 250;
			ym1 = 250 + 140;
			xh1 = 250;
			yh1 = 250 + 90;
        }

	public void run() {
		// lay gio he thong
		while (true) {
			LocalTime now1 = LocalTime.now();
			hour = now1.getHour();
			minute = now1.getMinute();
			second = now1.getSecond();
			// chuyen do sang radian
			rsecond = (second * 6) * (Math.PI) / 180;
			rminute = (minute * 6) * (Math.PI) / 180;
			rhours = ((hour + (minute / 60.0)) * 30) * (Math.PI) / 180;
			// lay toa do sau
			xs1 = 250 + (int) (180 * Math.sin(rsecond));
			ys1 = 250 + (int) (180 * -Math.cos(rsecond));
			xm1 = 250 + (int) (140 * Math.sin(rminute));
			ym1 = 250 + (int) (140 * -Math.cos(rminute));
			xh1 = 250 + (int) (90 * Math.sin(rhours));
			yh1 = 250 + (int) (90 * -Math.cos(rhours));
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}

		}
	}
}
