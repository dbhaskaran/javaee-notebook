package org.dbhaskaran.studentdal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.dbhaskaran.studentdal.entities.Student;
import org.dbhaskaran.studentdal.repos.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentdalApplicationTests {

	@Autowired
	StudentRepository studentRepo;

	@Test
	public void testCreateStudent() {
		Student student = new Student("Harry", "BS", 20000d);
		Student student2 = new Student("Mary", "BS", 19000d);
		studentRepo.save(student);
		studentRepo.save(student2);
	}

	@Test
	public void testFindStudentById() {
		Optional<Student> studentopt = studentRepo.findById(1l);
		if (studentopt.isPresent()) {
			Student stu = studentopt.get();
			assertEquals(stu.getName(), "Harry");
		}
	}

	@Test
	public void testUpdateStudent() {
		Optional<Student> studentopt = studentRepo.findById(1l);
		if (studentopt.isPresent()) {
			Student stu = studentopt.get();
			stu.setFee(25000d);
			studentRepo.save(stu);
		}

		Optional<Student> studentopt2 = studentRepo.findById(1l);
		if (studentopt2.isPresent()) {
			Student stu = studentopt2.get();
			assertEquals(stu.getFee(), 25000d);
		}

	}

	@Test
	public void testDeleteStudent() {
		Optional<Student> studentopt = studentRepo.findById(1l);
		if (studentopt.isPresent()) {
			Student stu = studentopt.get();
			studentRepo.delete(stu);
		}
		assertEquals(studentRepo.count(), 1);
	}

}
