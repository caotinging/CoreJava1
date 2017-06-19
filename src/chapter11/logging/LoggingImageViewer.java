package chapter11.logging;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.*;

import javax.swing.*;

/**
 * ��־������
 * @version 1.8 2017/5/15
 * @author caoting
 */

public class LoggingImageViewer {
	public static void main(String[] args) {
		//Ĭ�ϵ���־���ý�������ڻ����INFO�����������Ϣ��¼������̨���û����Ը���Ĭ�ϵ������ļ�  
	    //����û�Ҫʹ���Զ���������ļ�����������ʱ��ʹ���������  
	    //java -Djava.util.logging.config.file=configFile MainClass  
	    //java.util.logging.config.file��ֵΪ��־�����ļ��Ĵ洢λ��, ��configFile��һ��·���ַ��� MainClassΪ����������  
	    //ע�� ��main�����е���System.setProperty("java.util.logging.config.file",file)û���κ�Ӱ�죬
		//��Ϊ��־��������VM���������б���ʼ����������main֮ǰִ��  
	    //�����Ϸ�ʽ�⣬����������java.util.logging.config.classϵͳ��������Ϊĳ��������
		//������ͨ��������ʽ�趨��־����������
		
		if(System.getProperty("java.util.logging.config.class") == null &&
				System.getProperty("java.util.logging.config.file") == null) 
		{
			//���������ַ�ʽ��û�����õ�����£��ڴ������ֶ�����
			try {
				Logger.getLogger("com.horstmann.corejava").setLevel(Level.ALL);
				//�����������־��¼���� �����Ǵ���һ��Loggerʵ�������ü���ALL�������м���ļ�¼����
				//��־��¼�������ò�νṹ��һ�㶼����־��¼������Ϊ����Ӧ�ó����һ��������  
				final int LOG_ROTATION_COUNT = 10;
				Handler handler = new FileHandler("%h/LoggerImageViewer.log", 0, LOG_ROTATION_COUNT);
				
				//��־��������Ĭ������£���־��¼������¼���͵�ConsoleHandler(����̨������)�У�  
                // �����������System.err���У�Ҫ�뽫��־���͵������ط�����Ҫ��������Ĵ�������
				//FileHandler�ǽ���¼���͵�ָ���ļ��Ĵ���������Ϣ����������һ���ļ���һ���ɻع����ļ����ϡ�
				//�ɻع��ļ����е��ļ������ļ���С���лع������ļ�����ͨ����ǰ�ļ������ӱ��0��1��2�ȷ�ʽ���ν��б�ʾ  
                //Ĭ�Ϸ��͵��û���Ŀ¼��javan.log�ļ���,nnΪΨһ��ţ� 
				//��������Ϊ·��Ϊ��%h/LoggingImageViewer.log����ļ���%hΪϵͳ����user.home��ֵ��
				//��ͨ��System.out.println(System.getProperty("user.home") );��ѯ  
                //�˴�������ΪFileHandler(String pattern, int limit, int count)  
				//limit:�ڴ���һ���ļ�֮ǰ����д��һ���ļ��Ľ�������ֽ�����0��ʾ�����ƣ�
				//Ҳ����˵����ĳ���ļ�д��������Ƶ������������ƣ��������һ���ļ�  
                //count:��ѭ�������е���־��¼������1Ϊ��ѭ����ѭ��������ָ��
				//��־�ļ���LoggingImageViewer.log.0,LoggingImageViewer.log.1,
				//LoggingImageViewer.log.2,����ѭ�����е���ʽ���֣�ֻҪ�ļ������˴�С���ƣ�
				//��ɵ��ļ��ͻᱻɾ�����������ļ�������������ͬʱ����һ�����ļ�������Ϊ0  
				
				Logger.getLogger("com.horstmann.corejava").addHandler(handler);
			}
			catch(IOException e) {
				Logger.getLogger("com.horstmann.corejava").log(Level.SEVERE, "Can't create log file handler", e);
//				public void log(Level level, String msg, Object param1) 
//              ��¼����һ�������������Ϣ,�����ǰ���ڸ�������Ϣ������� logger �����õģ�
//              �򴴽���Ӧ�� LogRecord ��ת����������ע������ Handler ����
			}
		}
		
		EventQueue.invokeLater(() -> {
			Handler windowHandler = new WindowHandler();
//			�Զ�����־����������־��¼�����ж�����������籾����FileHandler���Զ���Ĵ�����  
			windowHandler.setLevel(Level.ALL);
			Logger.getLogger("com.horstmann.corejava").addHandler(windowHandler);
			
			JFrame frame = new ImageViewerFrame();
			frame.setTitle("LoggingImageViewer");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			Logger.getLogger("com.horstmann.corejava").fine("Showing frame");
//			public void fine(String msg)��¼һ�� FINE ��Ϣ�� 
//			�����ǰ���� FINE ��Ϣ������� logger �����õģ���ô����������Ϣת����������ע������ Handler ����
			frame.setVisible(true);
		});
	}
}

/**
 * The frame that shows the image
 */
class ImageViewerFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 400;
	
	private JLabel label;
	private static Logger logger = Logger.getLogger("com.horstmann.corejava");
//	��ø�Loggerʵ��������Ϊ��̬����ӵ����� 
	
	public ImageViewerFrame() {
		logger.entering("ImageViewerFrame", "<init>");//<init> ָ��ǰ����������
//		public void entering(String sourceClass, String sourceMethod)��¼һ��������Ŀ�� 
//      ����һ����Ϊ������¼��Ŀ�ı�ݷ�������¼����Ϣ "ENTRY" �� LogRecord����־���� FINER��
//		������ sourceMethod �� sourceClass
		
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenuItem openItem = new JMenuItem("Open");
		fileMenu.add(openItem);
		openItem.addActionListener(new FileOpenListener());
		
		JMenuItem exitItem = new JMenuItem("Exit");
		fileMenu.add(exitItem);
		exitItem.addActionListener(event -> {
			logger.fine("Exiting.");
//			public void fine(String msg)��¼һ�� FINE ��Ϣ�� 
//			�����ǰ���� FINE ��Ϣ������� logger �����õģ���ô����������Ϣת����������ע������ Handler ���� 
//			������msg - �ַ�����Ϣ������Ϣ����еļ���  
			System.exit(0);
		});
		
		label = new JLabel();
		add(label);
		logger.exiting("ImageViewerFrame", "<init>");
//		public void exiting(String sourceClass, String sourceMethod) ��¼һ���������ء� 
//      ����һ����ݷ���������������¼һ�������ķ��ء�
//		��¼������Ϣ "RETURN" �� LogRecord����־���� FINER�������� sourceMethod �� sourceClass
	}
	
	private class FileOpenListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			logger.entering("ImageViewerFrame.FileOpenListener", "actionPerformed", e);
			//��¼һ��������Ŀ������һ�����
			
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new File("."));
			
			chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
				public boolean accept(File f) {
					return f.getName().toLowerCase().endsWith(".gif") || f.isDirectory();
//					isDirectory()���Դ˳���·������ʾ���ļ��Ƿ���һ��Ŀ¼ 
				}
				
				public String getDescription() {
					return "GIF Images";
				}
			});
			
			int r = chooser.showOpenDialog(ImageViewerFrame.this);
			
			if(r == JFileChooser.APPROVE_OPTION) {
				String name = chooser.getSelectedFile().getPath();
				logger.log(Level.FINE, "Reading File {0}", name);
				label.setIcon(new ImageIcon(name));
			}
			else
				logger.fine("File open dialog canceled.");
			logger.exiting("ImageViewerFrame.FileOpenListener", "actionPreformed");
		}
	}
}

/**
 * A handler for displaying log records in a window
 */
class WindowHandler extends StreamHandler {
	private JFrame frame;
	
	public WindowHandler() {
		frame = new JFrame("��־����");
		final JTextArea output = new JTextArea();
		output.setEditable(false);
		frame.setSize(200, 200);
		frame.add(new JScrollPane(output));
		frame.setFocusableWindowState(false);
		frame.setVisible(true);
		
//		����������� ������ڵ�ǰ����������д Formatter ��β���ַ�����ˢ�²��ر�����Ȼ��ʹ���µ�������滻�������
		setOutputStream(new OutputStream() {
			public void write(int b){ }
			
			public void write(byte[] b, int off, int len) {
				output.append(new String(b, off, len));
//				ͨ��ʹ��ƽ̨��Ĭ���ַ�������ָ���� byte �����飬����һ���µ� String��
//				�� String �ĳ������ַ����ĺ�������˿��ܲ����ڸ�������ĳ���
			}
		});
	}
	
	/*
	 * public void publish(LogRecord record)��ʽ�������� LogRecord�� 
	 * StreamHandler ���ȼ���Ƿ���� OutputStream �Լ������� LogRecord �Ƿ��������������־����
	 * ���û����Ĭ�Ϸ��ء�����У���������й����� Filter ������Ƿ�Ӧ�÷����ü�¼��
	 * ���Ӧ�÷���������� Formatter ����ʽ���ü�¼��Ȼ�󽫽��д�뵱ǰ������� 
	 * �������Ҫд����� OutputStream �ĵ�һ�� LogRecord������д�� LogRecord ֮ǰ���Ƚ� Formatter �ġ�ͷ�����ַ���д����
	 */
	public void publish(LogRecord record) {
//		LogRecord ������������־��ܺ͵�����־ Handler ֮�䴫����־����
		
		if(!frame.isVisible()) return ;
		super.publish(record);
		flush();
	}
	/*
	 * Ĭ���������־��Ϣ�������I/O�����У������һ����������־��Ϣ�ᴥ����ջ���Ķ�����
	 * ������Ҫ����publish�������Ա��ڴ��������ÿ����¼֮��ˢ�»�����
	 * 
	 * ��Ȼ��������־���·�����������м���ΪINFO��WARNING��SEVERE����Ϣ������ʾ������̨�ϣ�
	 * �����һ��logger.warning("ImageViewerFrame");��������ʱ������̨���ı��򶼻���ָ���־��¼��
	 * ��ˣ����ֻ���Գ����û����������Ϣ����Ϊ�⼸�����𣬳���Ա��Ҫ����־��¼���趨ΪFINE��һ���ܺõ�ѡ�� 
	 */
}