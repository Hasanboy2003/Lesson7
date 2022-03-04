package uz.pdp.lesson7.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import uz.pdp.lesson7.entity.Groups;
import uz.pdp.lesson7.entity.Subject;
import uz.pdp.lesson7.entity.Teacher;
import uz.pdp.lesson7.entity.template.AbsEntity;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TimeTable extends AbsEntity {

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Subject subject;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Groups group;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Teacher teacher;

    @Column(nullable = false)
    private Double durationMinute;

    @Column(nullable = false)
    private Integer OrderNumber;

    @Column(nullable = false)
    private Timestamp startTime;

}
