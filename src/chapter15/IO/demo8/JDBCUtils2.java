package chapter15.IO.demo8;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/*
 * ���ӳص�����
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
		dataSource.setInitialSize(5);//��ʼ��ʱ���ӳ������Ӹ���
		dataSource.setMaxIdle(3);//����������
		dataSource.setMinIdle(1);//��С��������
		dataSource.setMaxActive(5);//���������
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	private static void getConfig() {
		//��ȡ�������ļ�
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
			throw new RuntimeException("��ȡ�����ļ�ʧ�ܣ�");
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
