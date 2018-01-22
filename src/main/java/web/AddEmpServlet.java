package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class AddEmpServlet extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType(
				"text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//��ȡԱ����Ϣ
		String ename = request.getParameter("ename");
		String salary = request.getParameter("salary");
		String age = request.getParameter("age");
		System.out.println("ename:" + ename 
				+ " salary:" + salary 
				+ " age:" + age);
		
		//��Ա����Ϣ���뵽���ݿ�
		EmployeeDAO dao = new EmployeeDAO();
		
		Employee e = new Employee();
		e.setEname(ename);
		e.setSalary(Double.parseDouble(salary));
		e.setAge(Integer.parseInt(age));
		try{
			dao.save(e);
			out.println("��ӳɹ�");
		}catch(Exception e1){
			e1.printStackTrace();
			out.println("ϵͳ��æ���Ժ�����");
		}
		
	}
}







