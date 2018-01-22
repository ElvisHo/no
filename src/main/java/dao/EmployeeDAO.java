package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import entity.Employee;
import util.DBUtil;

public class EmployeeDAO {
	/**
	 * ��������Ա������Ϣ
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
			 * step1.����־(�����ֳ�)
			 */
			e1.printStackTrace();
			/*
			 * step2.�鿴�쳣�Ƿ��ܹ������ָ���
			 * ������ܹ��ָ����������ݿ����ֹͣ��
			 * �����жϵȣ��������쳣���ǿ��Գ�֮Ϊ
			 * ϵͳ�쳣��,��ʾ�û��Ժ����ԡ�����ܹ�
			 * �ָ����������ָ���
			 */
			throw new RuntimeException(e1);
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
}








