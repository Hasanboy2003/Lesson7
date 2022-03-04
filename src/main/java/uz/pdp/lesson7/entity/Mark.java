package uz.pdp.lesson7.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import uz.pdp.lesson7.entity.Student;
import uz.pdp.lesson7.entity.Subject;
import uz.pdp.lesson7.entity.Teacher;
import uz.pdp.lesson7.entity.template.AbsEntity;
import uz.pdp.lesson7.entity.template.AbsId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Mark extends AbsId {

     @Column(nullable = false)
     private int score;

     @Column(nullable = false)
     @CreationTimestamp
     private Timestamp markedDate;

     @ManyToOne
     @OnDelete(action = OnDeleteAction.CASCADE)
     private Student student;

     @ManyToOne
     @OnDelete(action = OnDeleteAction.CASCADE)
     private Subject subject;

     @ManyToOne
     @OnDelete(action = OnDeleteAction.CASCADE)
     private Teacher teacher;
}
