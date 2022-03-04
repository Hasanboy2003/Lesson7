package uz.pdp.lesson7.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {
  private Integer id;
  private String name;
  private String lastName;
  private Integer subjectId;
  private List<Integer> groupIdList;

}
