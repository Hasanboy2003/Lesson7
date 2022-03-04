package uz.pdp.lesson7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.lesson7.entity.Groups;
import uz.pdp.lesson7.entity.Teacher;

import java.util.List;

public interface GroupsRepo extends JpaRepository<Groups,Integer> {
    boolean getByName(String name);
}
