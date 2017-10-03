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
 * 1.map������������(�û���=����)
	[�Ÿ�=ffg,����=hhs,����=abcd,��ά=333]
	(1)��map�е��ֻ�����ȡ������ӡ������̨��
		* ֱ��ʹ��map���ϵ�keySet()������ȡ���е�key��ɵ�Set����,������
	(2)�ж�map�����е��û�����userinfo�����Ƿ���ڴ��������"���û���ע��",
	��������ڽ����û�������Ӧ��������뵽userinfo����
 * @author caoting
 *
 */

public class TaskDemo1 {
	
	private static Connection con = JDBCUtils.getConnection();
	private static Map<String, String> map;
	
	static{
		map = new HashMap<String, String>();
		map.put("�Ÿ�", "ffg");
		map.put("����", "hhs");
		map.put("����", "abcd");
		map.put("��ά", "333");
	}
	
	@Test
	/*
	 * �ж�map�����е��û�����userinfo�����Ƿ���ڴ��������"���û���ע��",
	 * ��������ڽ����û�������Ӧ��������뵽userinfo����
	 */
	public void isExist() throws SQLException {
		QueryRunner qr = new QueryRunner();
		
		String sql1 = "select uid from userinfo where uname=?;";
		String sql2 = "insert into userinfo (uname,upassword) values (?,?);";
		
		for(String s: map.keySet()) {
			Integer r1 = qr.query(con, sql1, new ScalarHandler<Integer>(), s);
			if(r1 != null) {
				System.out.println(r1+"���û��Ѵ��ڣ�");
			}else{
				System.out.println("û�иó�Ա");
				Object[] objs = {s, map.get(s)};
				int r2 = qr.update(con, sql2, objs);
				if(r2>0)
					System.out.println("��ӳɹ���");
				else
					System.out.println("���ʧ�ܣ�");
			}
		}
	}
	
	@Test
	//��map�е��ֻ�����ȡ������ӡ������̨��
	public void getTel() throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "select utel from userinfo where uname=?;";
		for(String s: map.keySet()) {
			String r = qr.query(con, sql, new ScalarHandler<String>(), s);
			if(r!=null)
				System.out.println(r);
			else
				System.out.println("���û������ڣ�");
		}
		DbUtils.closeQuietly(con);
	}
}
