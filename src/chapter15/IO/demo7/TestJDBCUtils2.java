package chapter15.IO.demo7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 1.map中有如下数据(用户名=密码)
	[杜甫=ffg,苏哲=hhs,貂蝉=abcd,王维=333]
	(1)将map中的手机号码取出来打印到控制台上
		* 直接使用map集合的keySet()方法获取所有的key组成的Set集合,并遍历
	(2)判断map中所有的用户名在userinfo表中是否存在存在则输出"该用户已注册",
	如果不存在将该用户名及对应的密码存入到userinfo表中
    (map中的数据不需要修改)
    	* 连接到数据库
    	* 创建表
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
		
//		getTel(con, "李白");
		
		for(String s: set) {
			getTel(con, s);
		}
		
		System.out.println("==================");
		
		for(String s: set) {
			if(isExist(con, s))
				System.out.println("该用户已存在");
			else{
				addUser(con, s, map.get(s));
			}
		}
		
		con.close();
	}
	
	//若用户不存在调用此方法
	public static void addUser(Connection con, String username, String password) throws SQLException {
		String sql = "insert into userinfo (uname,upassword) values (?,?);";
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, username);
		pre.setString(2, password);
		
		int i = pre.executeUpdate();
		if(i > 0) {
			System.out.println("新用户添加成功！");
		}else {
			System.out.println("新用户添加失败！");
		}
	}
	
	//判断用户是否存在，存在则返回真，不存在返回false
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
	
	//获取数据库中对应的电话号码
	public static void getTel(Connection con, String name) throws SQLException {
		String sql = "select utel from userinfo where uname=?;";
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, name);
		
		ResultSet rs = pre.executeQuery();
		//getString之前一定要先next否则会报错Before start of result set
		while(rs.next()){
			String s = rs.getString("utel");
			System.out.println(s);
		}
		
		rs.close();
		pre.close();
	}
	
	public static Map<String, String> getMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("杜甫", "ffg");
		map.put("苏哲", "hhs");
		map.put("貂蝉", "abcd");
		map.put("王维", "333");
		//System.out.println(map);
		
		return map;
	}
}












