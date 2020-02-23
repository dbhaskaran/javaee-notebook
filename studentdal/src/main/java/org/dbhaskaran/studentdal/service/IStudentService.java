package org.dbhaskaran.studentdal.service;

import java.util.List;

import org.dbhaskaran.studentdal.entities.Student;

public interface IStudentService {

	Student saveStudent(Student student);

	Student updateStudent(Student student);

	void deleteStudent(Student student);

	Student getStudentbyId(long id);

	List<Student> getAllStudents();
}
