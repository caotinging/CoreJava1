package chapter11.robotTest;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

/**
 * @version 1.04 2017/5/17
 * @author caoting
 */
public class RobotTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			chapter08.button.ButtonFrame frame = new chapter08.button.ButtonFrame();
//			ButtonFrame 是一个通过 黄 红 蓝三个按钮改变背景颜色的类
			
			frame.setTitle("ButtonTest");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
		
		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice screen = environment.getDefaultScreenDevice();
		
		try {
			final Robot robot = new Robot(screen);
			/*
			 * 为给定屏幕设备创建一个 Robot 。
			 * 传递给 Robot 方法调用（如 mouseMove 和 createScreenCapture）的坐标将在与指定屏幕相同的坐标系中解释
			 */
			
			robot.waitForIdle();
//			在处理完当前事件队列中的所有事件之前，一直等待
			
			new Thread(() -> {
				runTest(robot);
			}).start();
//			使该线程开始执行；Java 虚拟机调用该线程的 run 方法
			
		}
		catch (AWTException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Rubs a sample test procedure
	 * @param robot the robot attached to the screen device
	 */
	public static void runTest(Robot robot) {
//		模仿空格键按压
		robot.keyPress(' ');
		robot.keyRelease(' ');
		
//		模仿TAB键按压
		robot.delay(2000);
		//睡眠指定的时间。为了捕获发生的所有 InterruptedException 毫秒为单位（2秒）
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		robot.keyPress(' ');
		robot.keyRelease(' ');
		
//		模仿鼠标左击  BUTTON1_MASK 左击  BUTTON2_MASK 点击滚轮 BUTTON3_MASK 右击
		robot.delay(2000);
		robot.mouseMove(220, 50);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		
//		捕获屏幕并显示生成的图像
		robot.delay(2000);
//		BufferedImage 子类描述具有可访问图像数据缓冲区的 Image
//		createScreenCapture 创建包含从屏幕中读取的像素的图像。该图像不包括鼠标光标
		BufferedImage image = robot.createScreenCapture(new Rectangle(0, 0, 400, 300));
		
		ImageFrame frame = new ImageFrame(image);
		frame.setVisible(true);
	}
}

class ImageFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private static final int DEFAULT_WIDTH = 450;
	private static final int DEFAULT_HEIGHT = 350;
	
	/**
	 * @param image the image to display
	 */
	public ImageFrame(Image image) {
		setTitle("Capture");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		JLabel label = new JLabel(new ImageIcon(image));
		add(label);
	}
}
