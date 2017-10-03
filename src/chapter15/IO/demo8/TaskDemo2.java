package chapter15.IO.demo8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

/**
 * 2.һ�����ݿ�stdb,�û���Ϊadmin ����Ϊ123456 �Ѵ���һ����student�������ѧ������Ϣ,����,�Ա�,����,����.
	id(varchar(20))       name(varchar(20))      sex(varchar(20))     score(int(10))
	 1                    ������                 Ů                   80
	 2                    �ۿ�                   ��                   75
	 3                    ��ǿ                   ��                   95
	 4                    ������                 Ů                   55
	 5                    ���㻨                 Ů                   68
	 6                    �˻�                   Ů                   50
	 7                    ����һ                 ��                   32
	(1)��ѯŮ��,�ɼ�80���ϵ�ѧ������
	(2)�����ŵ���ͬѧ�ĵĳɼ���Ϊ100
	(3)��ѯ�ɼ�����60��Ů��,��ʾ����,�Ա�,�ɼ�
	(4)�ֱ�ͳ��������ͬѧ��ƽ���֣�����Ůͬѧ��ƽ���ּ���ƽ����
	(5)���շ�����С�����˳���ӡ����������ƽ���ֵ�ѧԱ��Ϣ(id-name-sex-score),
	     ��������������ƽ���ֵ�ѧԱ��Ϣ(���շ�����С�����˳��)(id-name-sex-score)
	     д�뵽studentInfo.txt�ļ���(д���ʽ��id-name-sex-score)
	(6)�����ѯ����ѧ���ķ���public List<Student> getAllStudent(){}
	(7)�������id��ѯѧ���ķ���public Student getStudentById(String id){}
	(8)�������idɾ��ѧ���ķ���public int deleteStudentById(String id){}//ע��ֻ�����ݿ����в���ɾ����û���޷�ɾ��
	(9)�������ѧԱ�ķ���public int addStudent(){}//ע��ֻ�����ݿ���û���в�����ӣ����޷����
	(10)�������id�޸�ѧԱ����Ϣpublic int updateStudentById(String id){}//ע��ֻ�����ݿ����в����޸ģ�û���޷��޸�
 *  
 */

public class TaskDemo2 {
	private static QueryRunner qr = new QueryRunner(JDBCUtils2.getDataSource());
	
	@Test
	//�������id�޸�ѧԱ����Ϣ
	public void modify1() throws SQLException{
		String sql = "update stuinfo set sscore=100 where sid=?;";
		int r = qr.update(sql, 7);
		System.out.println(r);
	}
	
	@Test
	//�������ѧԱ�ķ���
	public void add1() throws SQLException {
		String sql = "insert into stuinfo values (?,?,?,?);";
		int r = qr.update(sql, new Object[]{7,"����","Ů",99.5});
		System.out.println(r);
	}
	
	@Test
	//�������idɾ��ѧ���ķ���
	public void delete1() throws SQLException {
		String sql = "delete from stuinfo where sid=?;";
		int r = qr.update(sql, 7);
		System.out.println(r);
	}
	
	@Test
	//�������id��ѯѧ���ķ���
	public void select5() throws SQLException {
		String sql = "select * from stuinfo where sid=?;";
		StuInfo stu = qr.query(sql, new BeanHandler<StuInfo>(StuInfo.class), 4);
		System.out.println(stu);
	}
	
	@Test
	//�����ѯ����ѧ���ķ���
	public void select4() throws SQLException {
		String sql = "select * from stuinfo;";
		List<StuInfo> list = qr.query(sql, new BeanListHandler<StuInfo>(
				chapter15.IO.demo8.StuInfo.class));
		
		for(StuInfo stu: list) {
			System.out.println(stu);
		}
	}
	/*
	 * 1��ʹ��DBUtils��ѯ���ݣ����ʹ��ArrayListHandler�ȶ��ܹ�������ȷֵ����ʹ��BeanListHandler ��
	 * 	 BeanHandler��һֱ����null;
		�������1��ʹ��DBUtils1.5�汾����

		ʹbean���ֶ������ݿ��ֶ�����һ�¼��ɣ�����˵��ʹ��ʵ������ֶε�setter��getter����������Ҫ������
		��Ҳ����˵�����ݿ���ֶ����ƣ�
		����Ҫ���bean��˽�г�Ա�����������һ�£�һһ��Ӧ��ֻ���������ܽ��������װ��JavaBean����
	 */
	
	@Test
	/*
	 * ���շ�����С�����˳���ӡ����������ƽ���ֵ�ѧԱ��Ϣ(id-name-sex-score),
	     ��������������ƽ���ֵ�ѧԱ��Ϣ(���շ�����С�����˳��)(id-name-sex-score)
	     д�뵽studentInfo.txt�ļ���(д���ʽ��id-name-sex-score)
	 */
	public void select3() throws SQLException, FileNotFoundException {
		String sql = "select * from stuinfo where sscore>( select avg(sscore) from stuinfo) order by sscore;";
		List<Object[]> list = qr.query(sql, new ArrayListHandler());
		PrintWriter pw = new PrintWriter(new File("D:\\StudentInfo.txt"));
		
		for(Object[] objs: list) {
			String s = objs[0]+"-"+objs[1]+"-"+objs[2]+"-"+objs[3];
			System.out.println(s);
			pw.println(s);
		}
		pw.close();
	}
	
	@Test
	//�ֱ�ͳ��������ͬѧ��ƽ���֣�����Ůͬѧ��ƽ���ּ���ƽ����
	public void count1() throws SQLException {
		String sql1 = "select avg(sscore) as 'sall' from stuinfo;";
		String sql2 = "select avg(sscore) as 'man' from stuinfo where ssex='��';";
		String sql3 = "select avg(sscore) as 'woman' from stuinfo where ssex='Ů';";
		Double l1 = qr.query(sql1, new ScalarHandler<Double>());
		System.out.println(l1);
		Double l2 = qr.query(sql2, new ScalarHandler<Double>());
		System.out.println(l2);
		Double l3 = qr.query(sql3, new ScalarHandler<Double>());
		System.out.println(l3);
	}
	
	@Test
	//��ѯ�ɼ�����60��Ů��,��ʾ����,�Ա�,�ɼ�
	public void select2() throws SQLException {
		String sql = "select sname,ssex,sscore from stuinfo where sscore>60 and ssex='Ů';";
		List<Object[]> arr = qr.query(sql, new ArrayListHandler());
		
		for(Object[] objs: arr){
			for(Object obj: objs) {
				System.out.print(obj+"\t");
			}
			System.out.println();
		}
	}
	
	@Test
	//��ѯŮ��,�ɼ�80���ϵ�ѧ������
	public void select1() throws SQLException {
		String sql = "select count(*) from stuinfo where ssex='Ů' and sscore>80;";
		Integer r = qr.query(sql, new ScalarHandler<Integer>());
		System.out.println(r);
	}
	
	@Test
	//�����ŵ���ͬѧ�ĵĳɼ���Ϊ100
	public void change1() throws SQLException {
		String sql = "update stuinfo set sscore=100 where sname like '��%' and ssex='��';";
		int r = qr.update(sql);
		System.out.println(r);
	}
}
