package org.dbhaskaran.studentdal.service;

import java.util.List;
import java.util.Optional;

import org.dbhaskaran.studentdal.entities.Student;
import org.dbhaskaran.studentdal.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepo;

	@Override
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public void deleteStudent(Student student) {
		studentRepo.delete(student);

	}

	@Override
	public Student getStudentbyId(long id) {
		Optional<Student> studentopt = studentRepo.findById(id);
		Student stu = null;
		if (studentopt.isPresent()) {
			stu = studentopt.get();
		}
		return stu;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

}
