package chapter15.IO.demo8;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

/**
 * 1.map中有如下数据(用户名=密码)
	[杜甫=ffg,苏哲=hhs,貂蝉=abcd,王维=333]
	(1)将map中的手机号码取出来打印到控制台上
		* 直接使用map集合的keySet()方法获取所有的key组成的Set集合,并遍历
	(2)判断map中所有的用户名在userinfo表中是否存在存在则输出"该用户已注册",
	如果不存在将该用户名及对应的密码存入到userinfo表中
 * @author caoting
 *
 */

public class TaskDemo1 {
	
	private static Connection con = JDBCUtils.getConnection();
	private static Map<String, String> map;
	
	static{
		map = new HashMap<String, String>();
		map.put("杜甫", "ffg");
		map.put("苏哲", "hhs");
		map.put("貂蝉", "abcd");
		map.put("王维", "333");
	}
	
	@Test
	/*
	 * 判断map中所有的用户名在userinfo表中是否存在存在则输出"该用户已注册",
	 * 如果不存在将该用户名及对应的密码存入到userinfo表中
	 */
	public void isExist() throws SQLException {
		QueryRunner qr = new QueryRunner();
		
		String sql1 = "select uid from userinfo where uname=?;";
		String sql2 = "insert into userinfo (uname,upassword) values (?,?);";
		
		for(String s: map.keySet()) {
			Integer r1 = qr.query(con, sql1, new ScalarHandler<Integer>(), s);
			if(r1 != null) {
				System.out.println(r1+"该用户已存在！");
			}else{
				System.out.println("没有该成员");
				Object[] objs = {s, map.get(s)};
				int r2 = qr.update(con, sql2, objs);
				if(r2>0)
					System.out.println("添加成功！");
				else
					System.out.println("添加失败！");
			}
		}
	}
	
	@Test
	//将map中的手机号码取出来打印到控制台上
	public void getTel() throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "select utel from userinfo where uname=?;";
		for(String s: map.keySet()) {
			String r = qr.query(con, sql, new ScalarHandler<String>(), s);
			if(r!=null)
				System.out.println(r);
			else
				System.out.println("该用户不存在！");
		}
		DbUtils.closeQuietly(con);
	}
}
