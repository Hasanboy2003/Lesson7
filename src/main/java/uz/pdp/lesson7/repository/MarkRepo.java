package uz.pdp.lesson7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.lesson7.entity.Mark;

public interface MarkRepo extends JpaRepository<Mark,Integer> {
}
