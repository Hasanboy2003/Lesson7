package uz.pdp.lesson7.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.lesson7.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public  class  School extends AbsEntity {

      @Column(nullable = false,unique = true)
      private  String address;


}
