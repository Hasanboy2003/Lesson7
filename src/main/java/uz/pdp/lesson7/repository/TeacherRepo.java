package uz.pdp.lesson7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.lesson7.entity.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher,Integer> {
}
