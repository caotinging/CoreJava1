package chapter15.IO.demo8;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
	private static Connection con;
	private static String driverClass;
	private static String username;
	private static String password;
	private static String url;
	
	private JDBCUtils() {}
	
	static {
		getConfig();
		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("�Ҳ������ݿ�����ʵ���࣡");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("���ݿ�����ʧ�ܣ�");
		}
	}
	
	private static void getConfig() {
		//��ȡ�������ļ�
		InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("config2.properties");
		
		Properties pro = new Properties();
		try {
			pro.load(in);
			driverClass = pro.getProperty("driverClass");
			username = pro.getProperty("username");
			password = pro.getProperty("password");
			url = pro.getProperty("url");
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("��ȡ�����ļ�ʧ�ܣ�");
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getConnection() {
		return con;
	}
}