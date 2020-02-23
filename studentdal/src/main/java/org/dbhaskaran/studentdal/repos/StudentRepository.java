package org.dbhaskaran.studentdal.repos;

import org.dbhaskaran.studentdal.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
