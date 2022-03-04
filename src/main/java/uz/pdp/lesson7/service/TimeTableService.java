package uz.pdp.lesson7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.lesson7.entity.Groups;
import uz.pdp.lesson7.entity.Subject;
import uz.pdp.lesson7.entity.Teacher;
import uz.pdp.lesson7.entity.TimeTable;
import uz.pdp.lesson7.payload.TimeTableDto;
import uz.pdp.lesson7.repository.GroupsRepo;
import uz.pdp.lesson7.repository.SubjectRepo;
import uz.pdp.lesson7.repository.TeacherRepo;
import uz.pdp.lesson7.repository.TimeTableRepo;

import java.util.List;

@Service
public class TimeTableService {
    @Autowired
    TimeTableRepo timeTableRepo;

    @Autowired
    GroupsRepo groupsRepo;

    @Autowired
    SubjectRepo subjectRepo;

    @Autowired
    TeacherRepo teacherRepo;
    
    public List<TimeTable> getAll() {
     return    timeTableRepo.findAll();
    }


    public TimeTable getById(Integer id) {
       return timeTableRepo.getById(id);
    }

    public String delete(Integer id) {
     timeTableRepo.deleteById(id);
     return "TimeTable has been deleted!";
    }

    public String saveOrEdit(TimeTableDto dto) {
        Integer id = dto.getId();
        TimeTable timeTable = new TimeTable();
        if(id!=null){
            timeTable = timeTableRepo.getById(id);
        }


        Teacher teacher = teacherRepo.getById(dto.getTeacherId());
        Groups groups = groupsRepo.getById(dto.getGroupId());
        Subject subject = subjectRepo.getById(dto.getSubjectId());
        timeTable.setStartTime(dto.getStartTime());
        timeTable.setDurationMinute(dto.getDurationMinute());
        timeTable.setName(dto.getName());
        timeTable.setStartTime(dto.getStartTime());
        timeTable.setOrderNumber(dto.getOrderNumber());
        timeTable.setSubject(subject);
        timeTable.setGroup(groups);
        timeTable.setTeacher(teacher);
        timeTableRepo.save(timeTable);

        return id!=null?"TimeTable has been edited!":"Timetable has been saved!";
    }
}
