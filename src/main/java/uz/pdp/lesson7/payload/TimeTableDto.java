package uz.pdp.lesson7.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.lesson7.entity.Groups;
import uz.pdp.lesson7.entity.Subject;
import uz.pdp.lesson7.entity.Teacher;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeTableDto {
  private Integer id;
  private String name;
    private Integer subjectId;
    private Integer groupId;
    private Integer teacherId;
    private Double durationMinute;
    private Integer OrderNumber;
    private Timestamp startTime;
}
