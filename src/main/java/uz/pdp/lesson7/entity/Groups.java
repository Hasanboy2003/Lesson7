package uz.pdp.lesson7.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.lesson7.entity.template.AbsUniqueName;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Groups extends AbsUniqueName {

    @ManyToOne(optional = false)
    private School school;


    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Subject> subjects;

}
