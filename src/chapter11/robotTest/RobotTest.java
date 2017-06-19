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
//			ButtonFrame ��һ��ͨ�� �� �� ��������ť�ı䱳����ɫ����
			
			frame.setTitle("ButtonTest");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
		
		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice screen = environment.getDefaultScreenDevice();
		
		try {
			final Robot robot = new Robot(screen);
			/*
			 * Ϊ������Ļ�豸����һ�� Robot ��
			 * ���ݸ� Robot �������ã��� mouseMove �� createScreenCapture�������꽫����ָ����Ļ��ͬ������ϵ�н���
			 */
			
			robot.waitForIdle();
//			�ڴ����굱ǰ�¼������е������¼�֮ǰ��һֱ�ȴ�
			
			new Thread(() -> {
				runTest(robot);
			}).start();
//			ʹ���߳̿�ʼִ�У�Java ��������ø��̵߳� run ����
			
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
//		ģ�¿ո����ѹ
		robot.keyPress(' ');
		robot.keyRelease(' ');
		
//		ģ��TAB����ѹ
		robot.delay(2000);
		//˯��ָ����ʱ�䡣Ϊ�˲����������� InterruptedException ����Ϊ��λ��2�룩
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		robot.keyPress(' ');
		robot.keyRelease(' ');
		
//		ģ��������  BUTTON1_MASK ���  BUTTON2_MASK ������� BUTTON3_MASK �һ�
		robot.delay(2000);
		robot.mouseMove(220, 50);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		
//		������Ļ����ʾ���ɵ�ͼ��
		robot.delay(2000);
//		BufferedImage �����������пɷ���ͼ�����ݻ������� Image
//		createScreenCapture ������������Ļ�ж�ȡ�����ص�ͼ�񡣸�ͼ�񲻰��������
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
