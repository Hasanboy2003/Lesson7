package uz.pdp.lesson7.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import uz.pdp.lesson7.entity.template.AbsEntity;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher extends AbsEntity {

    @Column(nullable = false)
    private String lastName;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Subject subject;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private List<Groups> groups;

}
