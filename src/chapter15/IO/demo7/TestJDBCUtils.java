package chapter15.IO.demo7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestJDBCUtils {
	public static void main(String[] args) throws SQLException {
		Connection con = JDBCUtils.getConnection();
		//System.out.println(con);
		
		String sql = "SELECT * FROM student;";
		//String sql = "DESC student";
		
		PreparedStatement pstat = con.prepareStatement(sql);
		//获得结果集
		ResultSet rs = pstat.executeQuery();
		
		/*while(rs.next()) {
			System.out.println(rs.getString("type"));
		}*/
		/*while(rs.next()) {
			System.out.println(rs.getString("id")+"\t"+ rs.getString("sname")+"\t"+ rs.getString("sage")
					+"\t"+rs.getString("score")+"\t"+rs.getString("classroom"));
		}*/
		
		//将结果集中的数据保存到student类中
		List<Student> list = new ArrayList<Student>();
		while(rs.next()) {
			Student stu = new Student(rs.getInt("id"), rs.getString("sname"), rs.getInt("sage"),
					rs.getDouble("score"), rs.getString("classroom"));
			list.add(stu);
		}
		//切记关闭
		JDBCUtils.close(con, rs, pstat);
		//遍历list
		for(Student s: list) {
			System.out.println(s);
		}
	}
}
