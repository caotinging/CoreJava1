package chapter15.IO.demo7;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JDBCUtils {
	private static Connection con;
	
	private JDBCUtils (){}
	
	static{
		try {
			
			//从配置文件中读取用户名和密码
			//使用类加载器获取配置文件
			InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("student.properties");
			Properties pro = new Properties();
			pro.load(in);
			String driverClass = pro.getProperty("driverClass");
			//注册mysql驱动程序
			Class.forName(driverClass);
			
			String url = pro.getProperty("url");
			String username = pro.getProperty("username");
			String password = pro.getProperty("password");
			//获得与数据库的连接，
			con = DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库连接失败！");
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new RuntimeException("配置文件读取失败！");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("建立连接失败！");
		}
	}
	
	public static Connection getConnection() {
		return con;
	}
	
	public static void close(Connection con, ResultSet rs, Statement stat) {
		try{
			if(con!= null) con.close();
			if(rs!=null) rs.close();
			if(stat!=null) stat.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
