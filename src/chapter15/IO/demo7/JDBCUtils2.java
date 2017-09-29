package chapter15.IO.demo7;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * JDBC�����ิд
 * @author caoting
 */

public class JDBCUtils2 {
	private static Connection con;
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	static{
		try {
			getConfig();
			//ע������
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("���ݿ�����ʧ�ܣ�");
		}
	}
	
	private static void getConfig() throws Exception {
		//��ȡ�����ļ�
		InputStream in = JDBCUtils2.class.getClassLoader().getResourceAsStream("config2.properties");
		Properties pro = new Properties();
		pro.load(in);
		driver = pro.getProperty("driverClass");
		url = pro.getProperty("url");
		user = pro.getProperty("username");
		password = pro.getProperty("password");
		in.close();
	}
	
	public static Connection getConnection() {
		return con;
	}
}
