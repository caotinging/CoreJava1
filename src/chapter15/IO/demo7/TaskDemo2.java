package chapter15.IO.demo7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 2.����һ����student�������ѧ������Ϣ,����,�Ա�,����,����.
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
 * @author caoting
 *
 */

public class TaskDemo2 {
	public static void main(String[] args) throws SQLException, IOException {
		Connection con = JDBCUtils2.getConnection();
//		select1(con, "Ů", 80);
//		change1(con, "��%", "��", 100);
//		select2(con, "Ů", 60);
//		avgScore(con);
//		morAvg(con);
		
//		getAllStudent(con);
//		getStudentById(con, 1);
//		deleteStudentById(con, 7);
		
		/*StuInfo student = new StuInfo(7, "����", "Ů", 89.5);
		addStudent(con, student);*/
		
		updateStuById(con, 7);
		
		con.close();
	}
	
	//�������id�޸�ѧԱ����Ϣ  ע��ֻ�����ݿ����в����޸ģ�û���޷��޸�
	public static void updateStuById(Connection con, int id) throws SQLException {
		String sql = "update stuinfo set sscore=99 where sid=?;";
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setInt(1, id);
		int r = pre.executeUpdate();
		
		if(r>0)
			System.out.println("�޸����ݳɹ���");
		else
			System.out.println("�޸�ʧ�ܣ�");
		pre.close();
	}
	
	//�������ѧԱ�ķ���  ע��ֻ�����ݿ���û���в�����ӣ����޷����
	public static void addStudent(Connection con, StuInfo stu) throws SQLException {
		String sql1 = "select sname from stuinfo;";
		PreparedStatement pre1 = con.prepareStatement(sql1);
		ResultSet rs1 = pre1.executeQuery();
		
		while(rs1.next()) {
			if(rs1.getString("sname").equals(stu.getName())) {
				System.out.println("��ѧ���Ѵ��ڣ�");
				rs1.close();pre1.close();
				return;
			}
		}
		rs1.close();pre1.close();
		
		String sql2 = "insert into stuinfo values (?,?,?,?);";
		PreparedStatement pre2 = con.prepareStatement(sql2);
		pre2.setInt(1, stu.getId());
		pre2.setString(2, stu.getName());
		pre2.setString(3, stu.getSex());
		pre2.setDouble(4, stu.getScore());
		int r = pre2.executeUpdate();
		
		if(r>0)
			System.out.println("���ѧ���ɹ���");
		else
			System.out.println("���ʧ�ܣ�");
		pre2.close();
	}
	
	//�������idɾ��ѧ���ķ��� ע��ֻ�����ݿ����в���ɾ����û���޷�ɾ��
	public static void deleteStudentById(Connection con, int id) throws SQLException {
		String sql = "delete from stuinfo where sid=?;";
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setInt(1, id);
		int i = pre.executeUpdate();
		
		if(i>0) 
			System.out.println("ɾ���ɹ���");
		else
			System.out.println("ɾ��ʧ�ܣ�");
		pre.close();
	}
	
	//�������id��ѯѧ���ķ���
	public static StuInfo getStudentById(Connection con, int id) throws SQLException {
		String sql = "select * from stuinfo where sid=?;";
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setInt(1, id);
		
		ResultSet rs = pre.executeQuery();
		StuInfo student = new StuInfo();
		while(rs.next()) {
			student.setId(rs.getInt("sid"));
			student.setName(rs.getString("sname"));
			student.setSex(rs.getString("ssex"));
			student.setScore(rs.getDouble("sscore"));
		}
		System.out.println(student);
		
		rs.close();
		pre.close();
		return student;
	}
	
	//�����ѯ����ѧ���ķ���
	public static List<StuInfo> getAllStudent(Connection con) throws SQLException{
		String sql = "select * from stuinfo;";
		PreparedStatement pre = con.prepareStatement(sql);
		ResultSet rs = pre.executeQuery();
		
		List<StuInfo> list = new ArrayList<StuInfo>();
		while(rs.next()) {
			StuInfo stu = new StuInfo(rs.getInt("sid"), rs.getString("sname"),rs.getString("ssex"),rs.getDouble("sscore"));
			list.add(stu);
			System.out.println(stu);
		}
		rs.close();
		pre.close();
		return list;
	}
	
	/*
	 * ���շ�����С�����˳���ӡ����������ƽ���ֵ�ѧԱ��Ϣ(id-name-sex-score),
	     ��������������ƽ���ֵ�ѧԱ��Ϣ(���շ�����С�����˳��)(id-name-sex-score)
	     д�뵽studentInfo.txt�ļ���(д���ʽ��id-name-sex-score)
	 */
	public static void morAvg(Connection con) throws SQLException, FileNotFoundException {
		String sql = "SELECT * FROM stuinfo WHERE sscore > ( SELECT AVG(sscore) FROM stuinfo ) ORDER BY sscore;";
		PreparedStatement pre = con.prepareStatement(sql);
		ResultSet rs = pre.executeQuery();
		
		List<String> list = new ArrayList<String>();
		while(rs.next()) {
			String s = rs.getInt("sid")+"-"+rs.getString("sname")+"-"+rs.getString("ssex")+"-"+rs.getDouble("sscore");
			System.out.println(s);
			list.add(s);
		}
		
		//ʹ��IO��list�е����ݴ����ļ�
		PrintWriter pw = new PrintWriter(new File("studentInfo.txt"));
		for(String s: list) {
			pw.println(s);
		}
		pw.close();
		rs.close();
		pre.close();
	}
	
	//�ֱ�ͳ��������ͬѧ��ƽ���֣�����Ůͬѧ��ƽ���ּ���ƽ����
	public static void avgScore(Connection con) throws SQLException {
		String sql1 = "select avg(sscore) as 'manAvg' from stuinfo where ssex='��';";
		PreparedStatement pre1 = con.prepareStatement(sql1);
		ResultSet rs1 = pre1.executeQuery();
		
		String sql2 = "select avg(sscore) as 'womanAvg' from stuinfo where ssex='Ů';";
		PreparedStatement pre2 = con.prepareStatement(sql2);
		ResultSet rs2 = pre2.executeQuery();
		
		String sql3 = "select avg(sscore) as 'allAvg' from stuinfo;";
		PreparedStatement pre3 = con.prepareStatement(sql3);
		ResultSet rs3 = pre3.executeQuery();
		
		if(rs1.next())
			System.out.println("��ͬѧ��ƽ����Ϊ��"+rs1.getString("manAvg"));
		if(rs2.next())
			System.out.println("Ůͬѧ��ƽ����Ϊ��"+rs2.getString("womanAvg"));
		if(rs3.next())
			System.out.println("��ƽ����Ϊ��"+rs3.getString("allAvg"));
		
//		PreparedStatement���ܱ�ResuleSet�����ȹر�
		rs1.close();rs2.close();rs3.close();
		pre1.close();pre2.close();pre3.close();
	}
	
	//��ѯ�ɼ�����60��Ů��,��ʾ����,�Ա�,�ɼ�
	public static void select2(Connection con, String sex, double score) throws SQLException {
		String sql = "select sname,ssex,sscore from stuinfo where ssex=? and sscore>?;";
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, sex);
		pre.setDouble(2, score);
		
		ResultSet rs = pre.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString("sname")+"\t"+rs.getString("ssex") +"\t"+rs.getDouble("sscore"));
		}
		rs.close();
		pre.close();
	}
	
	//�����ŵ���ͬѧ�ĵĳɼ���Ϊ100
	public static void change1(Connection con, String fname, String sex, double score) throws SQLException {
		String sql = "update stuinfo set sscore=? where ssex=? and sname like ?;";
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setDouble(1, score);
		pre.setString(2, sex);
		pre.setString(3, fname);
		
		int rs = pre.executeUpdate();
		if(rs != 0)
			System.out.println("���ĳɹ���\t" +rs);
		else
			System.out.println("����ʧ�ܣ�");
		pre.close();
	}
	
	//��ѯŮ�Գɼ�80���ϵ�ѧ������
	public static void select1(Connection con, String sex, double score) throws SQLException {
		String sql = "select COUNT(sid) as 'count'  from stuinfo where ssex=? and sscore>?;";
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, sex);
		pre.setDouble(2, score);
		
		ResultSet rs = pre.executeQuery();
		if(rs.next())
			System.out.println(rs.getInt("count"));
		rs.close();
		pre.close();
	}
}





















