package StudentWithServlet3.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import StudentWithServlet3.dao.StudentDao;
import StudentWithServlet3.dto.Student;

public class SingUpServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String address=req.getParameter("address");
		long phone=Long.parseLong(req.getParameter("phone"));
		long addhar=Long.parseLong(req.getParameter("addhar"));
		
		Student  student=new Student();
		student.setAddress(address);
		student.setEmail(email);
		student.setName(name);
		student.setPassword(password);
		student.setPhone(phone);
		student.setAddhar(addhar);
		
		StudentDao dao= new StudentDao();
		dao.saveStudent(student);
		
		
		PrintWriter printWriter=res.getWriter();
        printWriter.print("Yes SignedSuccessfully");
        
    	RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
		dispatcher.forward(req, res);
	}
}
