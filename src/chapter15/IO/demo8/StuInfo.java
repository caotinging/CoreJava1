package chapter15.IO.demo8;

import java.io.Serializable;

public class StuInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sid;
	private String sname;
	private String ssex;
	private double sscore;
	
	public StuInfo() {}
	
	public StuInfo(int sid, String sname, String ssex, double sscore) {
		
		this.sid = sid;
		this.sname = sname;
		this.ssex = ssex;
		this.sscore = sscore;
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int id) {
		this.sid = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public double getSscore() {
		return sscore;
	}
	public void setSscore(double sscore) {
		this.sscore = sscore;
	}

	public String toString() {
		return "StuInfo [id=" + sid + ", name=" + sname + ", sex=" + ssex
				+ ", score=" + sscore + "]";
	}
	
	@SuppressWarnings("unused")
	private void eat() {
		System.out.println("³Ô·¹£¡");
	}
	public void eat(int i) {
		System.out.println("³Ô·¹"+i);
	}
}	