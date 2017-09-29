package chapter15.IO.demo7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 1.map������������(�û���=����)
	[�Ÿ�=ffg,����=hhs,����=abcd,��ά=333]
	(1)��map�е��ֻ�����ȡ������ӡ������̨��
		* ֱ��ʹ��map���ϵ�keySet()������ȡ���е�key��ɵ�Set����,������
	(2)�ж�map�����е��û�����userinfo�����Ƿ���ڴ��������"���û���ע��",
	��������ڽ����û�������Ӧ��������뵽userinfo����
    (map�е����ݲ���Ҫ�޸�)
    	* ���ӵ����ݿ�
    	* ������
    	drop database stdb;
    	create database stdb;
    	use stdb;
    	create table userinfo(
    		id int(10) primary key auto_increment,
    		username varchar(200),
    		password varchar(200)
    	);
 */

public class TestJDBCUtils2 {
	public static void main(String[] args) throws SQLException {
		
		Connection con = JDBCUtils2.getConnection();
		
		Map<String, String> map = getMap();
		Set<String> set = map.keySet();
		System.out.println(set);
		
//		getTel(con, "���");
		
		for(String s: set) {
			getTel(con, s);
		}
		
		System.out.println("==================");
		
		for(String s: set) {
			if(isExist(con, s))
				System.out.println("���û��Ѵ���");
			else{
				addUser(con, s, map.get(s));
			}
		}
		
		con.close();
	}
	
	//���û������ڵ��ô˷���
	public static void addUser(Connection con, String username, String password) throws SQLException {
		String sql = "insert into userinfo (uname,upassword) values (?,?);";
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, username);
		pre.setString(2, password);
		
		int i = pre.executeUpdate();
		if(i > 0) {
			System.out.println("���û���ӳɹ���");
		}else {
			System.out.println("���û����ʧ�ܣ�");
		}
	}
	
	//�ж��û��Ƿ���ڣ������򷵻��棬�����ڷ���false
	public static boolean isExist(Connection con, String name) throws SQLException {
		String sql = "select uname from userinfo where uname=?;";
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, name);
		
		boolean b = false;
		
		ResultSet rs = pre.executeQuery();
		if(rs.next()) {
			b = true;
		}
		
		rs.close();
		pre.close();
		return b;
	}
	
	//��ȡ���ݿ��ж�Ӧ�ĵ绰����
	public static void getTel(Connection con, String name) throws SQLException {
		String sql = "select utel from userinfo where uname=?;";
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, name);
		
		ResultSet rs = pre.executeQuery();
		//getString֮ǰһ��Ҫ��next����ᱨ��Before start of result set
		while(rs.next()){
			String s = rs.getString("utel");
			System.out.println(s);
		}
		
		rs.close();
		pre.close();
	}
	
	public static Map<String, String> getMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("�Ÿ�", "ffg");
		map.put("����", "hhs");
		map.put("����", "abcd");
		map.put("��ά", "333");
		//System.out.println(map);
		
		return map;
	}
}












