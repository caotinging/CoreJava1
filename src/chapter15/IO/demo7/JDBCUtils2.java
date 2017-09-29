package chapter15.IO.demo7;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * JDBC工具类复写
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
			//注册驱动
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("数据库连接失败！");
		}
	}
	
	private static void getConfig() throws Exception {
		//获取配置文件
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
