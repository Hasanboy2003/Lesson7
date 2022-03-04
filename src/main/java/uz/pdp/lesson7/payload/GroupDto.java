package uz.pdp.lesson7.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {
    private Integer id;
    private String name;
    private Integer schoolId;
    private List<Integer> subjectIdList;
}
