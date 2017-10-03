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
 * 2.一个数据库stdb,用户名为admin 密码为123456 已存在一个表student中有五个学生的信息,姓名,性别,年龄,分数.
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
 *  
 */

public class TaskDemo2 {
	private static QueryRunner qr = new QueryRunner(JDBCUtils2.getDataSource());
	
	@Test
	//定义根据id修改学员的信息
	public void modify1() throws SQLException{
		String sql = "update stuinfo set sscore=100 where sid=?;";
		int r = qr.update(sql, 7);
		System.out.println(r);
	}
	
	@Test
	//定义添加学员的方法
	public void add1() throws SQLException {
		String sql = "insert into stuinfo values (?,?,?,?);";
		int r = qr.update(sql, new Object[]{7,"貂蝉","女",99.5});
		System.out.println(r);
	}
	
	@Test
	//定义根据id删除学生的方法
	public void delete1() throws SQLException {
		String sql = "delete from stuinfo where sid=?;";
		int r = qr.update(sql, 7);
		System.out.println(r);
	}
	
	@Test
	//定义根据id查询学生的方法
	public void select5() throws SQLException {
		String sql = "select * from stuinfo where sid=?;";
		StuInfo stu = qr.query(sql, new BeanHandler<StuInfo>(StuInfo.class), 4);
		System.out.println(stu);
	}
	
	@Test
	//定义查询所有学生的方法
	public void select4() throws SQLException {
		String sql = "select * from stuinfo;";
		List<StuInfo> list = qr.query(sql, new BeanListHandler<StuInfo>(
				chapter15.IO.demo8.StuInfo.class));
		
		for(StuInfo stu: list) {
			System.out.println(stu);
		}
	}
	/*
	 * 1、使用DBUtils查询数据，如果使用ArrayListHandler等都能够返回正确值，但使用BeanListHandler 和
	 * 	 BeanHandler则一直返回null;
		解决方法1（使用DBUtils1.5版本）：

		使bean的字段与数据库字段名称一致即可，或者说，使该实体类各字段的setter和getter方法的名字要与结果集
		（也可以说是数据库表字段名称，
		但不要求该bean的私有成员与表结果集列名一致）一一对应，只有这样才能将结果集封装成JavaBean对象，
	 */
	
	@Test
	/*
	 * 按照分数从小到大的顺序打印分数大于总平均分的学员信息(id-name-sex-score),
	     并将分数大于总平均分的学员信息(按照分数从小到大的顺序)(id-name-sex-score)
	     写入到studentInfo.txt文件中(写入格式：id-name-sex-score)
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
	//分别统计所有男同学的平均分，所有女同学的平均分及总平均分
	public void count1() throws SQLException {
		String sql1 = "select avg(sscore) as 'sall' from stuinfo;";
		String sql2 = "select avg(sscore) as 'man' from stuinfo where ssex='男';";
		String sql3 = "select avg(sscore) as 'woman' from stuinfo where ssex='女';";
		Double l1 = qr.query(sql1, new ScalarHandler<Double>());
		System.out.println(l1);
		Double l2 = qr.query(sql2, new ScalarHandler<Double>());
		System.out.println(l2);
		Double l3 = qr.query(sql3, new ScalarHandler<Double>());
		System.out.println(l3);
	}
	
	@Test
	//查询成绩大于60的女性,显示姓名,性别,成绩
	public void select2() throws SQLException {
		String sql = "select sname,ssex,sscore from stuinfo where sscore>60 and ssex='女';";
		List<Object[]> arr = qr.query(sql, new ArrayListHandler());
		
		for(Object[] objs: arr){
			for(Object obj: objs) {
				System.out.print(obj+"\t");
			}
			System.out.println();
		}
	}
	
	@Test
	//查询女性,成绩80以上的学生数量
	public void select1() throws SQLException {
		String sql = "select count(*) from stuinfo where ssex='女' and sscore>80;";
		Integer r = qr.query(sql, new ScalarHandler<Integer>());
		System.out.println(r);
	}
	
	@Test
	//将姓张的男同学的的成绩改为100
	public void change1() throws SQLException {
		String sql = "update stuinfo set sscore=100 where sname like '张%' and ssex='男';";
		int r = qr.update(sql);
		System.out.println(r);
	}
}
