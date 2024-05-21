package ravi.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ravi.dto.Student;
import ravi.service.IStudentService;
import ravi.servicefactory.StudentServiceFactory;

@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IStudentService stdService = StudentServiceFactory.getStudentService();

		System.out.println("Request URI :: " + request.getRequestURI());
		System.out.println("Path info   :: " + request.getPathInfo());

		if (request.getRequestURI().endsWith("AddForm")) {
			
			String sage = request.getParameter("sage");
			String sname = request.getParameter("sname");
			String saddr = request.getParameter("saddr");

			Student student = new Student();
			student.setSname(sname);
			student.setSage(Integer.parseInt(sage));
			student.setSaddress(saddr);

			String status = stdService.addStudent(student);
			PrintWriter out = response.getWriter();

			if (status.equals("success")) {
				out.println("<h1 style='color:green; text-align:center;'>REGISTRATION SUCCESFULL</h1>");
			} else {
				out.println("<h1 style='color:green; text-align:center;'>REGISTRATION FAILED</h1>");
			}
			out.close();
		}
		if (request.getRequestURI().endsWith("searchForm")) {
			String sid = request.getParameter("sid");

			Student student = stdService.searchStudent(Integer.parseInt(sid));
			PrintWriter out = response.getWriter();
			if (student != null) {
				out.println("<body>");
				out.println("<br/><br/><br/>");
				out.println("<center>");
				out.println("<table border='1'>");
				out.println("<tr><th>ID</th><td>" + student.getSid() + "</td></tr>");
				out.println("<tr><th>NAME</th><td>" + student.getSname() + "</td></tr>");
				out.println("<tr><th>AGE</th><td>" + student.getSage() + "</td></tr>");
				out.println("<tr><th>ADDRESS</th><td>" + student.getSaddress() + "</td></tr>");
				out.println("</table>");
				out.println("</center>");
				out.println("</body>");
			} else {
				out.println("<h1 style='color:red;text-align:center;'>RECORD NOT AVAILABLE FOR THE GIVEN ID " + sid
						+ "</h1>");
			}
			out.close();
		}
	}
}
