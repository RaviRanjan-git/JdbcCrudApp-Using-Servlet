package ravi.servicefactory;

import ravi.service.IStudentService;
import ravi.service.StudentServiceImpl;

public class StudentServiceFactory {
	private StudentServiceFactory() {

	}

	private static IStudentService studentService = null;

	public static IStudentService getStudentService() {
		
		//singleton pattern code
		if (studentService == null) {
			studentService = new StudentServiceImpl();
		}
		return studentService;
	}

}
