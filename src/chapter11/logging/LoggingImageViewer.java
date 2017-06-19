package chapter11.logging;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.*;

import javax.swing.*;

/**
 * 日志管理器
 * @version 1.8 2017/5/15
 * @author caoting
 */

public class LoggingImageViewer {
	public static void main(String[] args) {
		//默认的日志配置将级别等于或高于INFO级别的所有信息记录到控制台，用户可以覆盖默认的配置文件  
	    //如果用户要使用自定义的配置文件，则在启动时，使用以下命令：  
	    //java -Djava.util.logging.config.file=configFile MainClass  
	    //java.util.logging.config.file的值为日志配置文件的存储位置, 及configFile是一个路径字符串 MainClass为启动的类名  
	    //注意 在main方法中调用System.setProperty("java.util.logging.config.file",file)没有任何影响，
		//因为日志管理器在VM启动过程中被初始化，它会在main之前执行  
	    //除以上方式外，还可以利用java.util.logging.config.class系统属性设置为某个类名，
		//该类再通过其他方式设定日志管理器属性
		
		if(System.getProperty("java.util.logging.config.class") == null &&
				System.getProperty("java.util.logging.config.file") == null) 
		{
			//当以上两种方式都没有设置的情况下，在代码中手动设置
			try {
				Logger.getLogger("com.horstmann.corejava").setLevel(Level.ALL);
				//创建或检索日志记录器， 这里是创建一个Logger实例并设置级别（ALL开启所有级别的记录），
				//日志记录器名采用层次结构，一般都把日志记录器命名为与主应用程序包一样的名字  
				final int LOG_ROTATION_COUNT = 10;
				Handler handler = new FileHandler("%h/LoggerImageViewer.log", 0, LOG_ROTATION_COUNT);
				
				//日志处理器，默认情况下，日志记录器将记录发送到ConsoleHandler(控制台处理器)中，  
                // 并由它输出到System.err流中，要想将日志发送到其他地方，就要添加其他的处理器，
				//FileHandler是将记录发送到指定文件的处理器将消息发送至单个一般文件或一个可回滚的文件集合。
				//可回滚文件集中的文件依据文件大小进行回滚，久文件名称通过当前文件名附加编号0、1、2等方式依次进行标示  
                //默认发送到用户主目录的javan.log文件中,nn为唯一编号， 
				//这里设置为路径为：%h/LoggingImageViewer.log这个文件，%h为系统属性user.home的值，
				//可通过System.out.println(System.getProperty("user.home") );查询  
                //此处的声明为FileHandler(String pattern, int limit, int count)  
				//limit:在打开另一个文件之前允许写入一个文件的近似最大字节数（0表示无限制）
				//也就是说已向某个文件写入给定限制的数据量（近似）后，则打开另一个文件  
                //count:在循环序列中的日志记录数量，1为不循环，循环序列是指，
				//日志文件以LoggingImageViewer.log.0,LoggingImageViewer.log.1,
				//LoggingImageViewer.log.2,这种循环序列的形式出现，只要文件超出了大小限制，
				//最旧的文件就会被删除，其他的文件将重新命名，同时创建一个新文件，其编号为0  
				
				Logger.getLogger("com.horstmann.corejava").addHandler(handler);
			}
			catch(IOException e) {
				Logger.getLogger("com.horstmann.corejava").log(Level.SEVERE, "Can't create log file handler", e);
//				public void log(Level level, String msg, Object param1) 
//              记录带有一个对象参数的消息,如果当前对于给定的消息级别而言 logger 是启用的，
//              则创建相应的 LogRecord 并转发到所有已注册的输出 Handler 对象
			}
		}
		
		EventQueue.invokeLater(() -> {
			Handler windowHandler = new WindowHandler();
//			自定义日志处理器，日志记录器可有多个处理器，如本例中FileHandler和自定义的处理器  
			windowHandler.setLevel(Level.ALL);
			Logger.getLogger("com.horstmann.corejava").addHandler(windowHandler);
			
			JFrame frame = new ImageViewerFrame();
			frame.setTitle("LoggingImageViewer");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			Logger.getLogger("com.horstmann.corejava").fine("Showing frame");
//			public void fine(String msg)记录一条 FINE 消息。 
//			如果当前对于 FINE 消息级别而言 logger 是启用的，那么将给定的消息转发到所有已注册的输出 Handler 对象
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
//	获得该Logger实例，设置为静态域添加到类中 
	
	public ImageViewerFrame() {
		logger.entering("ImageViewerFrame", "<init>");//<init> 指当前构造器方法
//		public void entering(String sourceClass, String sourceMethod)记录一个方法条目。 
//      这是一个可为方法记录条目的便捷方法。记录带消息 "ENTRY" 的 LogRecord、日志级别 FINER、
//		给定的 sourceMethod 和 sourceClass
		
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
//			public void fine(String msg)记录一条 FINE 消息。 
//			如果当前对于 FINE 消息级别而言 logger 是启用的，那么将给定的消息转发到所有已注册的输出 Handler 对象。 
//			参数：msg - 字符串消息（或消息类别中的键）  
			System.exit(0);
		});
		
		label = new JLabel();
		add(label);
		logger.exiting("ImageViewerFrame", "<init>");
//		public void exiting(String sourceClass, String sourceMethod) 记录一个方法返回。 
//      这是一个便捷方法，可以用来记录一个方法的返回。
//		记录带有消息 "RETURN" 的 LogRecord、日志级别 FINER、给定的 sourceMethod 和 sourceClass
	}
	
	private class FileOpenListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			logger.entering("ImageViewerFrame.FileOpenListener", "actionPerformed", e);
			//记录一个方法条目，带有一组参数
			
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new File("."));
			
			chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
				public boolean accept(File f) {
					return f.getName().toLowerCase().endsWith(".gif") || f.isDirectory();
//					isDirectory()测试此抽象路径名表示的文件是否是一个目录 
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
		frame = new JFrame("日志窗口");
		final JTextArea output = new JTextArea();
		output.setEditable(false);
		frame.setSize(200, 200);
		frame.add(new JScrollPane(output));
		frame.setFocusableWindowState(false);
		frame.setVisible(true);
		
//		更改输出流。 如果存在当前输出流，则编写 Formatter 的尾部字符串，刷新并关闭流。然后使用新的输出流替换该输出流
		setOutputStream(new OutputStream() {
			public void write(int b){ }
			
			public void write(byte[] b, int off, int len) {
				output.append(new String(b, off, len));
//				通过使用平台的默认字符集解码指定的 byte 子数组，构造一个新的 String。
//				新 String 的长度是字符集的函数，因此可能不等于该子数组的长度
			}
		});
	}
	
	/*
	 * public void publish(LogRecord record)格式化并发布 LogRecord。 
	 * StreamHandler 首先检查是否存在 OutputStream 以及给定的 LogRecord 是否具有所需的最低日志级别。
	 * 如果没有则默认返回。如果有，则调用所有关联的 Filter 来检查是否应该发布该记录。
	 * 如果应该发布，则调用 Formatter 来格式化该记录，然后将结果写入当前输出流。 
	 * 如果这是要写入给定 OutputStream 的第一个 LogRecord，则在写入 LogRecord 之前首先将 Formatter 的“头部”字符串写入流
	 */
	public void publish(LogRecord record) {
//		LogRecord 对象用于在日志框架和单个日志 Handler 之间传递日志请求
		
		if(!frame.isVisible()) return ;
		super.publish(record);
		flush();
	}
	/*
	 * 默认情况下日志信息都存放在I/O缓冲中，但如果一条完整的日志信息会触发清空缓冲的动作，
	 * 所以需要覆盖publish方法，以便在处理器获得每个记录之后刷新缓冲区
	 * 
	 * 虽然设置了日志输出路径，但是所有级别为INFO、WARNING、SEVERE的消息都将显示到控制台上，
	 * 例如加一句logger.warning("ImageViewerFrame");程序运行时，控制台和文本框都会出现该日志记录，
	 * 因此，最好只将对程序用户有意义的消息设置为这几个级别，程序员想要的日志记录，设定为FINE是一个很好的选择 
	 */
}