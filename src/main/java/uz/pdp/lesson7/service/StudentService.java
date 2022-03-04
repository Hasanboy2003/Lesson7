package uz.pdp.lesson7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.lesson7.entity.Groups;
import uz.pdp.lesson7.entity.Student;
import uz.pdp.lesson7.payload.StudentDto;
import uz.pdp.lesson7.repository.GroupsRepo;
import uz.pdp.lesson7.repository.StudentRepo;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    @Autowired
    GroupsRepo groupsRepo;

    public List<Student> getAll() {
     return studentRepo.findAll();
    }

    public Student getById(Integer id) {
        return studentRepo.getById(id);
    }

    public String delete(Integer id) {
        studentRepo.deleteById(id);
        return "Student has been deleted!";
    }

    public String saveOrEdit(StudentDto dto) {
        Integer id = dto.getId();
        Student student = new Student();
        if(id!=null){
            student = studentRepo.getById(id);
        }
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setLastName(dto.getLastName());
        Groups group = groupsRepo.getById(dto.getGroupId());
        student.setGroup(group);
        studentRepo.save(student);
        return id!=null?"Student has been edited!":"Student has been saved!";
    }
}
