package chapter05.abstractClasses;


class EmployeeCopy extends Person {
	private double Salary = 0.0;
	
	public EmployeeCopy (String name,double Salary) {
		super(name);
		this.Salary = Salary;
	}

	@Override
	public String getDestricption() {
		// TODO Auto-generated method stub
		return "Employee: \nname = "+this.getName()+" Salary = "+this.Salary;
	}
	public double getSalary () {
		return Salary;
	}

}
