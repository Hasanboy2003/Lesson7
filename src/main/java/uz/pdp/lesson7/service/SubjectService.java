package uz.pdp.lesson7.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.lesson7.entity.Subject;
import uz.pdp.lesson7.payload.SubjectDto;
import uz.pdp.lesson7.repository.SubjectRepo;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    SubjectRepo subjectRepo;

    public List<Subject> getAll(){
      return  subjectRepo.findAll();
    }

    public Subject getById(Integer id) {
     return subjectRepo.getById(id);
    }

    public String saveOrEdit(SubjectDto dto) {
        Integer id = dto.getId();
        Subject subject = new Subject();
        if(id!=null){
            subject = subjectRepo.getById(id);
        }
        String name = dto.getName();
        boolean exists = subjectRepo.existsByName(name);
        if(exists){
            return "Subject name you entered already exists!";
        }
        subject.setName(name);
        subjectRepo.save(subject);
        return id!=null?"Subject has been edited":"Subject has been saved!";
    }


    public String delete(Integer id) {
       subjectRepo.deleteById(id);
        return "Subject has been deleted!";
    }
}
