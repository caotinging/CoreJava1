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
 * 2.创建一个表student中有五个学生的信息,姓名,性别,年龄,分数.
	id(varchar(20))       name(varchar(20))      sex(varchar(20))     score(int(10))
	 1                    李少荣                 女                   80
	 2                    邵凯                   男                   75
	 3                    周强                   男                   95
	 4                    王晓婷                 女                   55
	 5                    张秀花                 女                   68
	 6                    顾会                   女                   50
	 7                    赵天一                 男                   32
	(1)查询女性,成绩80以上的学生数量
	(2)将姓张的男同学的的成绩改为100
	(3)查询成绩大于60的女性,显示姓名,性别,成绩
	(4)分别统计所有男同学的平均分，所有女同学的平均分及总平均分
	(5)按照分数从小到大的顺序打印分数大于总平均分的学员信息(id-name-sex-score),
	     并将分数大于总平均分的学员信息(按照分数从小到大的顺序)(id-name-sex-score)
	     写入到studentInfo.txt文件中(写入格式：id-name-sex-score)
	(6)定义查询所有学生的方法public List<Student> getAllStudent(){}
	(7)定义根据id查询学生的方法public Student getStudentById(String id){}
	(8)定义根据id删除学生的方法public int deleteStudentById(String id){}//注意只有数据库中有才能删除，没有无法删除
	(9)定义添加学员的方法public int addStudent(){}//注意只有数据库中没有有才能添加，有无法添加
	(10)定义根据id修改学员的信息public int updateStudentById(String id){}//注意只有数据库中有才能修改，没有无法修改
 * @author caoting
 *
 */

public class TaskDemo2 {
	public static void main(String[] args) throws SQLException, IOException {
		Connection con = JDBCUtils2.getConnection();
//		select1(con, "女", 80);
//		change1(con, "张%", "男", 100);
//		select2(con, "女", 60);
//		avgScore(con);
//		morAvg(con);
		
//		getAllStudent(con);
//		getStudentById(con, 1);
//		deleteStudentById(con, 7);
		
		/*StuInfo student = new StuInfo(7, "貂蝉", "女", 89.5);
		addStudent(con, student);*/
		
		updateStuById(con, 7);
		
		con.close();
	}
	
	//定义根据id修改学员的信息  注意只有数据库中有才能修改，没有无法修改
	public static void updateStuById(Connection con, int id) throws SQLException {
		String sql = "update stuinfo set sscore=99 where sid=?;";
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setInt(1, id);
		int r = pre.executeUpdate();
		
		if(r>0)
			System.out.println("修改数据成功！");
		else
			System.out.println("修改失败！");
		pre.close();
	}
	
	//定义添加学员的方法  注意只有数据库中没有有才能添加，有无法添加
	public static void addStudent(Connection con, StuInfo stu) throws SQLException {
		String sql1 = "select sname from stuinfo;";
		PreparedStatement pre1 = con.prepareStatement(sql1);
		ResultSet rs1 = pre1.executeQuery();
		
		while(rs1.next()) {
			if(rs1.getString("sname").equals(stu.getName())) {
				System.out.println("该学生已存在！");
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
			System.out.println("添加学生成功！");
		else
			System.out.println("添加失败！");
		pre2.close();
	}
	
	//定义根据id删除学生的方法 注意只有数据库中有才能删除，没有无法删除
	public static void deleteStudentById(Connection con, int id) throws SQLException {
		String sql = "delete from stuinfo where sid=?;";
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setInt(1, id);
		int i = pre.executeUpdate();
		
		if(i>0) 
			System.out.println("删除成功！");
		else
			System.out.println("删除失败！");
		pre.close();
	}
	
	//定义根据id查询学生的方法
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
	
	//定义查询所有学生的方法
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
	 * 按照分数从小到大的顺序打印分数大于总平均分的学员信息(id-name-sex-score),
	     并将分数大于总平均分的学员信息(按照分数从小到大的顺序)(id-name-sex-score)
	     写入到studentInfo.txt文件中(写入格式：id-name-sex-score)
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
		
		//使用IO将list中的数据存入文件
		PrintWriter pw = new PrintWriter(new File("studentInfo.txt"));
		for(String s: list) {
			pw.println(s);
		}
		pw.close();
		rs.close();
		pre.close();
	}
	
	//分别统计所有男同学的平均分，所有女同学的平均分及总平均分
	public static void avgScore(Connection con) throws SQLException {
		String sql1 = "select avg(sscore) as 'manAvg' from stuinfo where ssex='男';";
		PreparedStatement pre1 = con.prepareStatement(sql1);
		ResultSet rs1 = pre1.executeQuery();
		
		String sql2 = "select avg(sscore) as 'womanAvg' from stuinfo where ssex='女';";
		PreparedStatement pre2 = con.prepareStatement(sql2);
		ResultSet rs2 = pre2.executeQuery();
		
		String sql3 = "select avg(sscore) as 'allAvg' from stuinfo;";
		PreparedStatement pre3 = con.prepareStatement(sql3);
		ResultSet rs3 = pre3.executeQuery();
		
		if(rs1.next())
			System.out.println("男同学的平均分为："+rs1.getString("manAvg"));
		if(rs2.next())
			System.out.println("女同学的平均分为："+rs2.getString("womanAvg"));
		if(rs3.next())
			System.out.println("总平均分为："+rs3.getString("allAvg"));
		
//		PreparedStatement不能比ResuleSet对象先关闭
		rs1.close();rs2.close();rs3.close();
		pre1.close();pre2.close();pre3.close();
	}
	
	//查询成绩大于60的女性,显示姓名,性别,成绩
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
	
	//将姓张的男同学的的成绩改为100
	public static void change1(Connection con, String fname, String sex, double score) throws SQLException {
		String sql = "update stuinfo set sscore=? where ssex=? and sname like ?;";
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setDouble(1, score);
		pre.setString(2, sex);
		pre.setString(3, fname);
		
		int rs = pre.executeUpdate();
		if(rs != 0)
			System.out.println("更改成功！\t" +rs);
		else
			System.out.println("更改失败！");
		pre.close();
	}
	
	//查询女性成绩80以上的学生数量
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





















