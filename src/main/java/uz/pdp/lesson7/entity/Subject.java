package uz.pdp.lesson7.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import uz.pdp.lesson7.entity.template.AbsUniqueName;

import javax.persistence.Entity;

@Data
@RequiredArgsConstructor
@Entity
public class Subject extends AbsUniqueName {

}
