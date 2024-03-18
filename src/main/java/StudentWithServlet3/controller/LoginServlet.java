package StudentWithServlet3.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import StudentWithServlet3.dao.StudentDao;
import StudentWithServlet3.dto.Student;

public class LoginServlet extends HttpServlet {
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
//		login
//		check whether that email is present in the database or not

		StudentDao dao = new StudentDao();

		List<Student> list = dao.getAllStudents();
        boolean value=false;
		String studentPassword=null;
		
		for(Student student:list) {
			if(email.equals(student.getEmail())) {
				value=true;
				studentPassword=student.getPassword();
				break;
			}
		}
		
		PrintWriter printWriter=resp.getWriter();
		if(value) {
//			value=true;
//			email is present in the database
			if(password.equals(studentPassword)) {
//				login success
				
				resp.sendRedirect("https://www.booking.com/index.html?aid=1980379&label=NW21C2EF");
//				printWriter.print("LOGIN SUCCESS");
				
				RequestDispatcher dispatcher=req.getRequestDispatcher("select.html");
				dispatcher.include(req, resp);
			}else {
//				printWriter.print("Invalid Password");
				RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
				dispatcher.include(req, resp);

			}
			
		}else {
//			value=false
//		printWriter.print("Invalid Email");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
			dispatcher.include(req, resp);

		}
		
		
		
		
		
		
		
		
		
	}
		}
