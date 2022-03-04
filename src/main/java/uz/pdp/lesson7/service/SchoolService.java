package uz.pdp.lesson7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.lesson7.entity.School;
import uz.pdp.lesson7.payload.SchoolDto;
import uz.pdp.lesson7.repository.SchoolRepo;
import java.util.List;


@Service
public class SchoolService {

    @Autowired
    SchoolRepo schoolRepo;

    public List<School> getAll() {
        return schoolRepo.findAll();
    }

    public School getById(Integer id) {
     return schoolRepo.getById(id);
    }

    public String delete(Integer id) {
        schoolRepo.deleteById(id);
        return "School has been deleted!";
    }

    public String saveOrEdit(SchoolDto dto) {
        Integer id = dto.getId();
        School school = new School();
        if(id!=null){
            school= schoolRepo.getById(id);
        }
        String address = dto.getAddress();
        boolean exists = schoolRepo.existsByAddress(address);
        if(exists){
            return "School Address you entered already exists!";
        }
        school.setName(dto.getName());
        school.setAddress(address);
        schoolRepo.save(school);
        return id!=null?"School has been edited!":"School has been saved!";
    }


}