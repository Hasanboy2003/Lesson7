package uz.pdp.lesson7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.lesson7.entity.Student;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
