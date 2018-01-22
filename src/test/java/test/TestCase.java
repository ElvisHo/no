package test;

import java.sql.SQLException;

import org.junit.Test;

import dao.EmployeeDAO;
import entity.Employee;
import util.DBUtil;

public class TestCase {
	
	@Test
	public void test1() throws SQLException{
		System.out.println(
				DBUtil.getConnection());
	}
	
	@Test
	public void test2(){
		EmployeeDAO dao = new EmployeeDAO();
		Employee e = new Employee();
		e.setEname("ะกิย");
		e.setSalary(20000);
		e.setAge(22);
		dao.save(e);
	}
	
	
	
}



