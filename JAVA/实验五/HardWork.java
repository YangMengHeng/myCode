abstract class Employee {
	public abstract double earnings();
}
class YearWorker extends Employee {
	public double earnings(){
		return 10;
	}	//重写earnings()方法
}
class MonthWorker extends Employee {
	public double earnings(){
		return 1 * 12;
	}		//重写earnings()方法
}
class WeekWorker extends Employee {
	public double earnings(){
		return 0.5 * 48;
	}		//重写earnings()方法
}
class Company {
	Employee[] employees;
	double salaries = 0;
	Company(Employee[] employees) {
		this.employees = employees;
	}
	public double salariesPay() {
		salaries = 0;
		for(Employee e: this.employees)
		{
			this.salaries += e.earnings();
		}		//计算salaries
		return salaries;
	}	
}
public class HardWork {
	public static void main(String[] args) {
		Employee[] employees = new Employee[20];
		for (int i = 0; i < employees.length; i++) {
			if(i%3==0)
				employees[i] = new WeekWorker();
			else if(i%3==1)
				employees[i] = new MonthWorker();
			else if(i%3==2)
				employees[i] = new YearWorker();
		}
		Company company = new Company(employees);
		System.out.println("公司年工资总额:" + company.salariesPay() + "万元");
	}
}
