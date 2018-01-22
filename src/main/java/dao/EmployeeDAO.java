package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import entity.Employee;
import util.DBUtil;

public class EmployeeDAO {
	/**
	 * 查找所有员工的信息
	 * 
	 *   ResultSet rs = ps.executeQuery..
	 *   while(rs.next()){
	 *   	Employee e = new Employee();
	 *   	e.setEname(rs.getString("ename"));
	 *   	e.setSalary...
	 *   	..
	 *   	list.add(e);
	 *   }
	 */
	public List<Employee> findAll(){
		return null;
	}
	
	public void save(Employee e){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
					"INSERT INTO t_emp "
				+ "VALUES(t_emp_seq.nextval,?,?,?)";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setString(1, e.getEname());
			ps.setDouble(2, e.getSalary());
			ps.setInt(3, e.getAge());
			ps.executeUpdate();
			
		} catch (SQLException e1) {
			/*
			 * step1.记日志(保留现场)
			 */
			e1.printStackTrace();
			/*
			 * step2.查看异常是否能够立即恢复，
			 * 如果不能够恢复（比如数据库服务停止，
			 * 网络中断等，这样的异常我们可以称之为
			 * 系统异常）,提示用户稍后重试。如果能够
			 * 恢复，则立即恢复。
			 */
			throw new RuntimeException(e1);
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
}








