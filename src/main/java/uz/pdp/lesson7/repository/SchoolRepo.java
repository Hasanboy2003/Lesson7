package uz.pdp.lesson7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.lesson7.entity.School;

public interface SchoolRepo extends JpaRepository<School,Integer>{

    boolean existsByAddress(String address);
}
