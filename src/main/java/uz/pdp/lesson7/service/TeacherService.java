package uz.pdp.lesson7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.lesson7.entity.Groups;
import uz.pdp.lesson7.entity.Subject;
import uz.pdp.lesson7.entity.Teacher;
import uz.pdp.lesson7.payload.TeacherDto;
import uz.pdp.lesson7.repository.GroupsRepo;
import uz.pdp.lesson7.repository.SubjectRepo;
import uz.pdp.lesson7.repository.TeacherRepo;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherRepo teacherRepo;

    @Autowired
    SubjectRepo subjectRepo;

    @Autowired
    GroupsRepo groupsRepo;

    public List<Teacher> getAll() {
        return teacherRepo.findAll();
    }

    public Teacher getById(Integer id) {
        return  teacherRepo.getById(id);
    }

    public String delete(Integer id) {
      teacherRepo.deleteById(id);
      return "Teacher has been deleted!";
    }

    public String saveOrEdit(TeacherDto dto) {
        Integer id = dto.getId();
        Teacher teacher = new Teacher();
        if(id!=null){
            teacher = teacherRepo.getById(id);
        }
        Subject subject = subjectRepo.getById(dto.getSubjectId());
        List<Groups> groups = groupsRepo.findAllById(dto.getGroupIdList());
        teacher.setGroups(groups);
        teacher.setSubject(subject);
        teacher.setLastName(dto.getLastName());
        teacher.setName(dto.getName());
        teacherRepo.save(teacher);
        return id!=null?"Teacher has been edited!":"Teacher has been saved!";
    }
}
