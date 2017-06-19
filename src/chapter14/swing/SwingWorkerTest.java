package chapter14.swing;

import java.awt.*;
import java.awt.event.*;

import java.io.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;
import javax.swing.*;
/**
 * 这个类读取文件中的内容显示进度数据 完成后在文本域打印文件内容
 * @date 2017/6/7 9:27
 * @author caoting
 */
public class SwingWorkerTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			JFrame frame = new SwingWorkerFrame();
			frame.setTitle("SwingWorker");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}

/**
 * 菜单栏open选择读取文件 读取过程不可用 cancel取消读取  仅在读取过程中可用
 */
class SwingWorkerFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JFileChooser chooser;
	private JTextArea textArea;
	private JLabel statusLine;
	private JMenuItem openItem;
	private JMenuItem cancelItem;
	private static final int TEXT_ROWS = 20;
	private static final int TEXT_COLUMNS = 60;
	private SwingWorker<StringBuilder, ProgressData> textReader;
//	SwingWorker<T,V>
//	T - 此 SwingWorker 的 doInBackground 和 get 方法返回的结果类型
//	V - 用于保存此 SwingWorker 的 publish 和 process 方法的中间结果的类型

	public SwingWorkerFrame() {
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("D:\\"));
//		点击open菜单栏再调用showOpenDialog方法弹出文件选择器chooser
		
		textArea = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
		add(new JScrollPane(textArea));
		
		statusLine = new JLabel(" ");
		add(statusLine, BorderLayout.SOUTH);
		
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		
		JMenu file = new JMenu("File");
		menu.add(file);
		
		openItem = new JMenuItem("Open", 'O');
		file.add(openItem);
		openItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int result = chooser.showOpenDialog(SwingWorkerFrame.this);
				if(result == JFileChooser.APPROVE_OPTION) {
					textArea.setText("");
					openItem.setEnabled(false);
					textReader = new TextReader(chooser.getSelectedFile());
					textReader.execute();
					cancelItem.setEnabled(true);
				}
			}
		});
		
		cancelItem = new JMenuItem("Cancel", 'C');
		file.add(cancelItem);
		cancelItem.setEnabled(false);
		cancelItem.addActionListener(event -> textReader.cancel(true));
		
		pack();
	}
	
	/**
	 * 保存读取进度数据
	 * @author caoting
	 */
	private class ProgressData {
		public int number;
		public String line;
	}
	
	private class TextReader extends SwingWorker<StringBuilder, ProgressData> {
		private File file;
		private StringBuilder text = new StringBuilder();
		
		public TextReader(File file) {
			this.file = file;
		}
		
		public StringBuilder doInBackground() throws IOException, InterruptedException {
			int lineNumber = 0;
			try(Scanner in = new Scanner(file)) {
				while(in.hasNextLine()) {
					String line = in.nextLine();
					lineNumber++;
					text.append(line);
					text.append("\n");
					ProgressData data = new ProgressData();
					data.number = lineNumber;
					data.line = line;
					publish(data);
					Thread.sleep(1);
				}
			}
			return text;
		}
		
		@Override
		public void process(List<ProgressData> datas) {
			if(isCancelled()) return;
			StringBuilder b = new StringBuilder();
			statusLine.setText("" + datas.get(datas.size()-1).number);
			for(ProgressData data : datas) {
				b.append(data.line);
				b.append("\n");
			}
			textArea.append(b.toString());
		}
		
		@Override
		public void done() {
			try {
				statusLine.setText("Done");
				StringBuilder result = get();
				textArea.setText(result.toString());
			}
			catch(InterruptedException e){}
			catch(ExecutionException e) {
				statusLine.setText(""+e.getCause());
			}
			catch(CancellationException e) {
				//textArea.setText("");
				statusLine.setText("Cancelled");
			}
			openItem.setEnabled(true);
			cancelItem.setEnabled(false);
		}
	}
}
