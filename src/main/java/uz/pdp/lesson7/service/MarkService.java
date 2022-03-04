package uz.pdp.lesson7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.lesson7.entity.Mark;
import uz.pdp.lesson7.entity.Student;
import uz.pdp.lesson7.entity.Subject;
import uz.pdp.lesson7.entity.Teacher;
import uz.pdp.lesson7.payload.MarkDto;
import uz.pdp.lesson7.repository.MarkRepo;
import uz.pdp.lesson7.repository.StudentRepo;
import uz.pdp.lesson7.repository.SubjectRepo;
import uz.pdp.lesson7.repository.TeacherRepo;

import java.util.List;

@Service
public class MarkService {
    @Autowired
    MarkRepo markRepo;

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    TeacherRepo teacherRepo;

    @Autowired
    SubjectRepo subjectRepo;

    public List<Mark> getAll() {
    return markRepo.findAll();
    }

    public Mark getById(Integer id) {
    return markRepo.getById(id);
    }

    public String delete(Integer id) {
    markRepo.deleteById(id);
    return "Mark has been deleted!";
     }

    public String saveOrEdit(MarkDto dto) {
        Integer id = dto.getId();
        Mark mark  = new Mark();
        if(id!=null){
            mark = markRepo.getById(id);
        }
        mark.setScore(dto.getScore());
        mark.setMarkedDate(dto.getMarkedDate());
        Subject subject = subjectRepo.getById(dto.getSubjectId());
        Teacher teacher = teacherRepo.getById(dto.getTeacherId());
        Student student = studentRepo.getById(dto.getStudentId());
        mark.setStudent(student);
        mark.setSubject(subject);
        mark.setTeacher(teacher);
        markRepo.save(mark);
        return id!=null?"Mark has been edited!":"Mark has been saved!";
    }
}
