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
			
			//�������ļ��ж�ȡ�û���������
			//ʹ�����������ȡ�����ļ�
			InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("student.properties");
			Properties pro = new Properties();
			pro.load(in);
			String driverClass = pro.getProperty("driverClass");
			//ע��mysql��������
			Class.forName(driverClass);
			
			String url = pro.getProperty("url");
			String username = pro.getProperty("username");
			String password = pro.getProperty("password");
			//��������ݿ�����ӣ�
			con = DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("���ݿ�����ʧ�ܣ�");
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new RuntimeException("�����ļ���ȡʧ�ܣ�");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��������ʧ�ܣ�");
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
