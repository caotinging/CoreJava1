package chapter15.IO.demo8;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/*
 * 连接池的配置
 */

public class JDBCUtils2 {
	private static BasicDataSource dataSource = new BasicDataSource();
	private static String driverClass;
	private static String username;
	private static String password;
	private static String url;
	
	private JDBCUtils2() {}
	
	static {
		getConfig();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setUrl(url);
		dataSource.setInitialSize(5);//初始化时连接池中连接个数
		dataSource.setMaxIdle(3);//最大空闲连接
		dataSource.setMinIdle(1);//最小空闲连接
		dataSource.setMaxActive(5);//最大连接数
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	private static void getConfig() {
		//获取到配置文件
		InputStream in = JDBCUtils2.class.getClassLoader().getResourceAsStream("config2.properties");
		
		Properties pro = new Properties();
		try {
			pro.load(in);
			driverClass = pro.getProperty("driverClass");
			username = pro.getProperty("username");
			password = pro.getProperty("password");
			url = pro.getProperty("url");
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("获取配置文件失败！");
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
