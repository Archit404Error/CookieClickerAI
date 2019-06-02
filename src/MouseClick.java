import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.util.*;

public class MouseClick {

	public static void main(String[] args) {
		BufferedImage current;
		try {
			String s = "y";
			Robot robot = new Robot();
			while (s.equals("y")) {
				current = robot.createScreenCapture(new Rectangle(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
				boolean done = false;
				for (int y = 500; y < 1200; y+= 5) {
					current = robot.createScreenCapture(new Rectangle(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
					for (int x = 2150; x < 2200; x+= 1) {
						int clr = current.getRGB(x, y);
						int red = (clr & 0x00ff0000) >> 16;
						int green = (clr & 0x0000ff00) >> 8;
						int blue = clr & 0x000000ff;
						if (red == 102 && green == 255 && blue == 102) {
							robot.mouseMove(x, y);
							robot.mousePress(InputEvent.BUTTON1_MASK);
							robot.mouseRelease(InputEvent.BUTTON1_MASK);
							y+= 100;
							//done = true;
							break;
						}
						else if(red == 161 && blue == 80 && green == 87) {
							y+= 100;
							break;
						}
						else {
							robot.mouseMove(400, 500);
							robot.mousePress(InputEvent.BUTTON1_MASK);
							robot.mouseRelease(InputEvent.BUTTON1_MASK);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}