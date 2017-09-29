package chapter15.IO.demo7;
/**
 * 用于保存数据库中student数据表中数据的类
 * @author caoting
 *
 */
public class Student {
	private int id;
	private String sname;
	private int sage;
	private double score;
	private String classroom;
	
	public Student(int id, String sname, int sage, double score,
			String classroom) {
		this.id = id;
		this.sname = sname;
		this.sage = sage;
		this.score = score;
		this.classroom = classroom;
	}
	
	public Student() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getSage() {
		return sage;
	}

	public void setSage(int sage) {
		this.sage = sage;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", sname=" + sname + ", sage=" + sage
				+ ", score=" + score + ", classroom=" + classroom + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((classroom == null) ? 0 : classroom.hashCode());
		result = prime * result + id;
		result = prime * result + sage;
		long temp;
		temp = Double.doubleToLongBits(score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (classroom == null) {
			if (other.classroom != null)
				return false;
		} else if (!classroom.equals(other.classroom))
			return false;
		if (id != other.id)
			return false;
		if (sage != other.sage)
			return false;
		if (Double.doubleToLongBits(score) != Double
				.doubleToLongBits(other.score))
			return false;
		if (sname == null) {
			if (other.sname != null)
				return false;
		} else if (!sname.equals(other.sname))
			return false;
		return true;
	}
}
