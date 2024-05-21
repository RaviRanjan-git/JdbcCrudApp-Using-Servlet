package ravi.dao;

import ravi.dto.Student;

public interface IStudentDao {
	public String addStudent(Student student);

	public Student searchStudent(Integer sid);

	public String updateStudent(Student student);

	public String deleteStudent(Integer sid);
}
