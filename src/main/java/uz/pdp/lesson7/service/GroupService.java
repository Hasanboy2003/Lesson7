package uz.pdp.lesson7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.lesson7.entity.Groups;
import uz.pdp.lesson7.entity.School;
import uz.pdp.lesson7.entity.Subject;
import uz.pdp.lesson7.payload.GroupDto;
import uz.pdp.lesson7.repository.GroupsRepo;
import uz.pdp.lesson7.repository.SchoolRepo;
import uz.pdp.lesson7.repository.SubjectRepo;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    GroupsRepo groupsRepo;

    @Autowired
    SchoolRepo schoolRepo;

    @Autowired
    SubjectRepo subjectRepo;

    public List<Groups> getAll() {
        return groupsRepo.findAll();
    }


    public Groups getById(Integer id) {
      return  groupsRepo.getById(id);
    }

    public String delete(Integer id) {
      groupsRepo.deleteById(id);
     return "Group has been deleted!";
    }

    public String saveOrEdit(GroupDto dto) {
        Integer id = dto.getId();
        Groups group = new Groups();
        if(id!=null){
            group = groupsRepo.getById(id);
        }
        String name = dto.getName();
        boolean exist = groupsRepo.getByName(name);
        if(exist){
            return "Name you entered already exists!";
        }
        group.setName(name);
        School school = schoolRepo.getById(dto.getSchoolId());
        group.setSchool(school);
        List<Subject> subjectList = subjectRepo.findAllById(dto.getSubjectIdList());
        group.setSubjects(subjectList);
        groupsRepo.save(group);
        return id!=null?"Group has been edited!":"Group has been saved!";
    }
}
